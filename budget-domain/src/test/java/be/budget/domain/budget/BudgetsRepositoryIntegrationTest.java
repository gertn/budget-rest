package be.budget.domain.budget;

import static org.fest.assertions.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import be.budget.infrastructure.test.DBSeeder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:META-INF/spring/domain/application-context.xml",
    "classpath:META-INF/spring/infrastructure/datasource-testContext.xml"
})
@Transactional
public class BudgetsRepositoryIntegrationTest {
	
	private static final String DESCRIPTION = "testDescription";
	private static final String NAME = "test";
	private static final int YEAR = 2012;

	@Autowired
	private BudgetsRepository budgetsRepository;
	@Autowired
	private DBSeeder dbSeeder;
	private Budgets budgets;
	private Budget budget;
	private String username;
	
	@Before
	public void setUp(){
		username = "gnu";
		budgets = Budgets.ofUsername(username);
		budget = Budget.of(YEAR, NAME, DESCRIPTION);
		budgets.addBudget(budget);
	}
	
	@Test
	public void shouldBeAbleToSaveBudgets(){
		
		Budgets savedBudgets = budgetsRepository.save(budgets);
		
		assertThat(savedBudgets.getId()).isNotNull();
		assertThat(savedBudgets.getId()).isGreaterThan(0);
		
		assertThat(savedBudgets.getSelectedBudget().getId()).isNotNull();
		assertThat(savedBudgets.getSelectedBudget().getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void shouldBeAbleToFindBudgetsByUsername(){
		dbSeeder.seedData(budgets);
		
		Budgets foundBudgets = budgetsRepository.findByUsername(username);
		
		assertThat(foundBudgets.getId()).isEqualTo(budgets.getId());
		
		Budget foundBudget = foundBudgets.getSelectedBudget();
		
		assertThat(foundBudget.getDescription()).isEqualTo(DESCRIPTION);
		assertThat(foundBudget.getName()).isEqualTo(NAME);
		assertThat(foundBudget.getYear()).isEqualTo(YEAR);
		assertThat(foundBudget.getState()).isEqualTo(Budget.BudgetState.CREATED);
		
		assertThat(foundBudgets.getBudgets()).containsOnly(foundBudget);
	}
	
}
