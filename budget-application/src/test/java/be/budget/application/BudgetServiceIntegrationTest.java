package be.budget.application;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import be.budget.domain.budget.Budget;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:META-INF/spring/domain/application-context.xml",
    "classpath:META-INF/spring/application/datasource-testContext.xml",
    "classpath:META-INF/spring/application/application-context.xml"
})
@Transactional
public class BudgetServiceIntegrationTest {
	
	@Autowired
	private BudgetService budgetService;

	@Test
	public void shouldBeAbleToCreateBudgets(){
		/*Budget entity = Budget.of(2012, "test", "testDescription");
		Budget savedBudget = budgetService.create(entity);
		
		assertThat(savedBudget.getId()).isNotNull();*/
		fail("implement me");
	}

}
