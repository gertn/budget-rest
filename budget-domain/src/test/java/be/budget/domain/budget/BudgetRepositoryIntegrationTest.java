package be.budget.domain.budget;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:META-INF/spring/domain/application-context.xml",
    "classpath:META-INF/spring/domain/datasource-testContext.xml"
})
@Transactional
public class BudgetRepositoryIntegrationTest {
	
	@Autowired
	BudgetRepository budgetRepository;
	
	@Test
	public void shouldBeAbleToSaveBudget(){
		Budget entity = Budget.createNewBudget(2012, "test");
		Budget savedBudget = budgetRepository.save(entity);
		
		assertThat(savedBudget.getId()).isNotNull();
		assertThat(savedBudget.getId()).isGreaterThan(0);
	}

}
