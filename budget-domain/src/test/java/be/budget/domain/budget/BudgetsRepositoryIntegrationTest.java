package be.budget.domain.budget;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import be.budget.domain.budget.Budget.BudgetState;
import be.budget.infrastructure.test.DBSeeder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:META-INF/spring/domain/application-context.xml",
    "classpath:META-INF/spring/infrastructure/datasource-testContext.xml"
})
@Transactional
public class BudgetsRepositoryIntegrationTest {
	
	@Autowired
	private BudgetsRepository budgetsRepository;
	@Autowired
	private DBSeeder dbSeeder;
	
	private Budget budget1;
	private Budget budget2;
	private Budgets budgets1;
	
	@Before
	public void setUp(){
		budget1 = BudgetForTests.createWithDefaults().setStateToCreated();
		budget2 = BudgetForTests.createWithDefaults().setStateToCreated();
		budgets1 = Budgets.create();
		budgets1.addBudget(budget1);
		budgets1.addBudget(budget2);
	}
	
	@Test
	public void shouldBeAbleToSaveBudgets(){
		Budgets savedBudgets = budgetsRepository.save(budgets1);
		
		assertThat(savedBudgets.getId()).isNotNull();
		assertThat(savedBudgets.getId()).isGreaterThan(0);
	}
	
	@Test
	public void shouldBeAbleToFindByUsername(){
		dbSeeder.seedData(budget1, budget2, budgets1);
		
		Budgets budgets = budgetsRepository.findByUsername(Budgets.DEFAULT_USERNAME);
		
		assertThat(budgets.getBudgets()).containsOnly(budget1, budget2);
		assertBudget(budgets.getSelectedBudget(), budget1);
		assertBudget(budgets.getBudgets().get(0), budget1);
		assertBudget(budgets.getBudgets().get(1), budget2);
	}
	
	private void assertBudget(Budget actual, Budget expected){
		assertThat(actual).isNotNull();
		assertThat(actual.getId()).isEqualTo(expected.getId());
		assertThat(actual.getName()).isEqualTo(expected.getName());
		assertThat(actual.getDescription()).isEqualTo(expected.getDescription());
		assertThat(actual.getYear()).isEqualTo(expected.getYear());
		assertThat(actual.getState()).isEqualTo(BudgetState.CREATED);
	}
	
}
