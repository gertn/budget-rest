package be.budget.domain.budget;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class BudgetTest {

	@Test
	public void createBudgetShouldSetStateToCreated() {
		Budget budget = new Budget();
		assertThat(budget.getState()).isNull();
		
		budget.createBudget();
		
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
