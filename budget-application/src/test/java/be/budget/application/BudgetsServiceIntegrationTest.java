package be.budget.application;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import be.budget.domain.budget.Budget;
import be.budget.domain.budget.BudgetForTests;
import be.budget.infrastructure.test.DBSeeder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:META-INF/spring/domain/application-context.xml",
    "classpath:META-INF/spring/infrastructure/datasource-testContext.xml",
    "classpath:META-INF/spring/application/application-context.xml"
})
@Transactional
public class BudgetsServiceIntegrationTest {
	
	@Autowired
	private BudgetsService budgetsService;
	@Autowired
	private DBSeeder dbSeeder;
	private Budget budget1;
	private Budget budget2;
	
	@Before
	public void setUp() {
		budget1 = BudgetForTests.createWithDefaults();
		budget2 = BudgetForTests.createWithDefaults();
		dbSeeder.seedData(budget1);
	}
	
	@Test
	public void shouldBeAbleToSaveNewBudget(){
		
		Budget savedBudget = budgetsService.save(budget2);
		
		assertThat(savedBudget).isNotNull();
		assertThat(savedBudget.getId()).isNotNull();
		assertThat(savedBudget.getId()).isGreaterThan(0);
		assertThat(savedBudget.getId()).isEqualTo(budget2.getId());
	}
	
	@Test
	public void shouldBeAbleToUpdateBudget() {
		String description = "updated description";
		budget1.setDescription(description);
		
		Budget savedBudget = budgetsService.save(budget1);
		
		assertThat(savedBudget.getDescription()).isEqualTo(description);
	}
	
	@Test
	public void shouldBeAbleToFindOne() {
		
		Budget foundBudget = budgetsService.findOne(budget1.getId());
		
		assertThat(foundBudget).isNotNull();
	}
	
	@Test
	public void shouldBeAbleToFindAll() {
		dbSeeder.seedData(budget2);
		
		List<Budget> allBudgets = budgetsService.findAll();
		
		assertThat(allBudgets).containsOnly(budget1, budget2);
	}

}
