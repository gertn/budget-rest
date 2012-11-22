package be.budget.domain.budget;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

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
public class BudgetRepositoryIntegrationTest {
	
	@Autowired
	private BudgetRepository budgetsRepository;
	@Autowired
	private DBSeeder dbSeeder;
	
	private Budget budget1;
	private Budget budget2;
	
	@Before
	public void setUp(){
		budget1 = BudgetForTests.createWithDefaults().setStateToCreated();
		budget2 = BudgetForTests.createWithDefaults().setStateToCreated();
	}
	
	@Test
	public void shouldBeAbleToSaveBudgets(){
		Budget savedBudget = budgetsRepository.save(budget1);
		
		assertThat(savedBudget.getId()).isNotNull();
		assertThat(savedBudget.getId()).isGreaterThan(0);
	}
	
	@Test
	public void shouldBeAbleToFindAll(){
		dbSeeder.seedData(budget1, budget2);
		
		List<Budget> budgetList = budgetsRepository.findAll();
		
		assertThat(budgetList).containsOnly(budget1, budget2);
	}
	
	@Test
	public void shouldBeAbleToFindAll_EmptyList(){
		List<Budget> budgetList = budgetsRepository.findAll();
		
		assertThat(budgetList).isEmpty();
	}
	
	@Test
	public void shouldBeAbleToFindOne(){
		dbSeeder.seedData(budget1);
		
		Budget foundBudget = budgetsRepository.findOne(budget1.getId());
		
		assertThat(foundBudget).isNotNull();
		assertThat(foundBudget.getId()).isEqualTo(budget1.getId());
		assertThat(foundBudget.getName()).isEqualTo(budget1.getName());
		assertThat(foundBudget.getDescription()).isEqualTo(budget1.getDescription());
		assertThat(foundBudget.getYear()).isEqualTo(budget1.getYear());
		assertThat(foundBudget.getState()).isEqualTo(BudgetState.CREATED);
		
	}
	
}
