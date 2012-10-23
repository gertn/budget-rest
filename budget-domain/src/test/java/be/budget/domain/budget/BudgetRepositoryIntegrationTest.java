package be.budget.domain.budget;

import static org.fest.assertions.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	private static final String DESCRIPTION = "testDescription";
	private static final String NAME = "test";
	private static final int YEAR = 2012;

	@Autowired
	BudgetRepository budgetRepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Test
	public void shouldBeAbleToSaveAndFindBudget(){
		Budget budget = Budget.of(YEAR, NAME, DESCRIPTION);
		Budget savedBudget = budgetRepository.save(budget);
		
		assertThat(savedBudget.getId()).isNotNull();
		assertThat(savedBudget.getId()).isGreaterThan(0);
		
		entityManager.flush();
		entityManager.clear();
		
		Budget foundBudget = budgetRepository.findOne(savedBudget.getId());
		
		assertThat(foundBudget.getId()).isEqualTo(savedBudget.getId());
		assertThat(foundBudget.getDescription()).isEqualTo(DESCRIPTION);
		assertThat(foundBudget.getName()).isEqualTo(NAME);
		assertThat(foundBudget.getYear()).isEqualTo(YEAR);
		assertThat(foundBudget.getState()).isEqualTo(Budget.BudgetState.CREATED);
	}
	
}
