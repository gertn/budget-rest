package be.budget.domain.budget;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BudgetsTest {

	private Budgets budgets;
	private Budget budget = BudgetForTests.createWithDefaults(1L);
	private Budget budget2 = BudgetForTests.createWithDefaults(2L);

	@Before
	public void setUp() throws Exception {
		budgets = new Budgets();
	}

	@Test
	public void canAddBudget() {
		budgets.addBudget(budget);

		assertThat(budgets.getBudgets()).containsOnly(budget);
	}

	@Test
	public void shouldSetSelectedBudgetWhenAddingAndNoBudgetSelected() {
		assertThat(budgets.getSelectedBudget()).isNull();

		budgets.addBudget(budget);

		assertThat(budgets.getSelectedBudget()).isEqualTo(budget);
	}

	@Test
	public void shouldNotOverrideSelectedBudgetWhenAddingAndAlreadyBudgetSelected() {
		budgets.addBudget(budget);
		assertThat(budgets.getSelectedBudget()).isEqualTo(budget);

		budgets.addBudget(budget2);

		assertThat(budgets.getSelectedBudget()).isEqualTo(budget);
	}

	@Test
	public void shouldBeAbleToSetSelectedBudget() {
		budgets.addBudget(budget);
		budgets.setSelectedBudget(budget);

		assertThat(budgets.getSelectedBudget()).isEqualTo(budget);
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldBeNotAbleToSetSelectedBudgetWhenNotInList() {
		budgets.addBudget(budget);
		budgets.setSelectedBudget(budget2);
	}
	
	@Test(expected=NullPointerException.class)
	public void shouldBeNotAbleToSetSelectedBudgetWhenNull() {
		budgets.setSelectedBudget(null);
	}
	
	@Test(expected=NullPointerException.class)
	public void shouldBeNotAbleToSetSelectedBudgetWhenIdNull() {
		budgets.setSelectedBudget(Budget.of(2012, "name", "description"));
	}

}
