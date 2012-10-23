package be.budget.domain.budget;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BudgetsTest {

	private Budgets budgets;
	private Budget budget = BudgetTestFactory.of(2012, "name", "description");
	private Budget budget2 = BudgetTestFactory
			.of(2013, "name2", "description2");

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

}
