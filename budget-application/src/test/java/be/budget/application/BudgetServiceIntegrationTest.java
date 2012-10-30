package be.budget.application;

import static org.fest.assertions.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import be.budget.domain.budget.Budgets;
import be.budget.infrastructure.test.DBSeeder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:META-INF/spring/domain/application-context.xml",
    "classpath:META-INF/spring/infrastructure/datasource-testContext.xml",
    "classpath:META-INF/spring/application/application-context.xml"
})
@Transactional
public class BudgetServiceIntegrationTest {
	
	@Autowired
	private BudgetsService budgetsService;
	@Autowired
	private DBSeeder dbSeeder;
	
	@Test
	public void shouldBeAbleToSaveBudgets(){
		Budgets budgets = Budgets.ofUsername("username");
		
		Budgets savedBudgets = budgetsService.save(budgets);
		
		assertThat(savedBudgets.getId()).isNotNull();
	}
	
	@Test
	public void shouldBeAbleToGetBudgets() {
		dbSeeder.seedData(Budgets.ofUsername(BudgetsService.DEFAULT_USERNAME));
		
		Budgets budgets = budgetsService.get();
		
		assertThat(budgets).isNotNull();
	}

}
