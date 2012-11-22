package be.budget.domain.budget;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class BudgetTest {

	@Test
	public void createShouldSetStateToCreated() {
		Budget budget = Budget.of(2012, "name", "description").setStateToCreated();
		
		assertThat(budget.getState()).isEqualTo(Budget.BudgetState.CREATED);
	}
	
	@Test(expected=IllegalStateException.class)
	public void cannotSetStateToCreatedWhenStateIsNotNull(){
		Budget budget = new Budget();
		budget.setStateToCreated();
		
		
		assertThat(budget.getState()).isEqualTo(Budget.BudgetState.CREATED);
		budget.setStateToCreated();
	}

}
