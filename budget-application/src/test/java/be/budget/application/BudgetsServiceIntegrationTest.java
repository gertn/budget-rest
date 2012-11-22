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
import be.budget.domain.budget.Budget.BudgetState;
import be.budget.domain.budget.BudgetForTests;
import be.budget.domain.budget.Budgets;
import be.budget.domain.budget.BudgetsRepository;
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
	private BudgetsRepository budgetsRepository;
	@Autowired
	private DBSeeder dbSeeder;
	private Budget budget1;
	private Budget budget2;
	private Budgets budgets;
	
	@Before
	public void setUp() {
		budget1 = BudgetForTests.createWithDefaults();
		budget2 = BudgetForTests.createWithDefaults();
		budgets= Budgets.create();
		budgets.addBudget(budget1);
	}
	
	@Test
	public void shouldBeAbleToAddBudgetToExistingBudgets(){
		dbSeeder.seedData(budget1, budgets);
		
		Budget savedBudget = budgetsService.add(budget2);
		
		assertThat(savedBudget).isNotNull();
		assertThat(savedBudget.getId()).isNotNull();
		assertThat(savedBudget.getId()).isGreaterThan(0);
		assertThat(savedBudget.getId()).isEqualTo(budget2.getId());
		assertThat(savedBudget.getState()).isEqualTo(BudgetState.CREATED);
	}
	
	@Test
	public void shouldBeAbleToAddBudgetToNonExistingBudgets(){
		Budgets foundBudgets = budgetsRepository.findByUsername(Budgets.DEFAULT_USERNAME);
		assertThat(foundBudgets).isNull();
		
		Budget savedBudget = budgetsService.add(budget2);
		
		assertThat(savedBudget).isNotNull();
		assertThat(savedBudget.getId()).isNotNull();
		assertThat(savedBudget.getId()).isGreaterThan(0);
		assertThat(savedBudget.getId()).isEqualTo(budget2.getId());
		assertThat(savedBudget.getState()).isEqualTo(BudgetState.CREATED);
		
		foundBudgets = budgetsRepository.findByUsername(Budgets.DEFAULT_USERNAME);
		assertThat(foundBudgets).isNotNull();
		assertThat(foundBudgets.getSelectedBudget()).isEqualTo(budget2);
	}
	
	@Test
	public void shouldBeAbleToSaveBudget() {
		dbSeeder.seedData(budget1, budgets);
		
		String description = "updated description";
		budget1.setDescription(description);
		
		Budget actualSavedBudget = budgetsService.save(budget1);
		
		assertThat(actualSavedBudget.getDescription()).isEqualTo(description);
	}
	
	@Test
	public void shouldBeAbleToFindOne() {
		dbSeeder.seedData(budget1);
		
		Budget foundBudget = budgetsService.findOne(budget1.getId());
		
		assertThat(foundBudget).isNotNull();
	}
	
	@Test
	public void shouldBeAbleToFindAll() {
		budgets.addBudget(budget2);
		dbSeeder.seedData(budget1, budget2, budgets);
		
		List<Budget> allBudgets = budgetsService.findAll();
		
		assertThat(allBudgets).containsOnly(budget1, budget2);
	}
	
	@Test
	public void shouldBeAbleToGetDefaultBudget(){
		dbSeeder.seedData(budget1, budgets);
		
		Budget defaultBudget = budgetsService.getDefaultBudget();
		
		assertThat(defaultBudget).isEqualTo(budget1);
	}
	
	@Test
	public void shouldBeAbleToGetDefaultBudget_NullWhenNoBudgets(){
		
		Budget defaultBudget = budgetsService.getDefaultBudget();
		
		assertThat(defaultBudget).isNull();
	}
	
	@Test
	public void shouldBeAbleToSetDefaultBudget() {
		budgets.addBudget(budget2);
		dbSeeder.seedData(budget2, budget1, budgets);
		
		Budget defaultBudget = budgetsService.setDefaultBudget(budget2);
		
		assertThat(defaultBudget).isEqualTo(budget2);
	}

}
