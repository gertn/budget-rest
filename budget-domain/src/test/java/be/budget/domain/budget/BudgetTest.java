package be.budget.domain.budget;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class BudgetTest {

	@Test
	public void createNewBudgetShouldSetStateToCreated() {
		Budget budget = Budget.of(2012, "name", "description");
		
		assertThat(budget.getState()).isEqualTo(Budget.BudgetState.CREATED);
	}
	
	@Test(expected=IllegalStateException.class)
	public void cannotCallCreateBudgetWhenStateIsNotNull(){
		Budget budget = new Budget();
		budget.createBudget();
		
		
		assertThat(budget.getState()).isEqualTo(Budget.BudgetState.CREATED);
		budget.createBudget();
	}

}
