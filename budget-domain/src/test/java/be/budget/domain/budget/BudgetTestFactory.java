package be.budget.domain.budget;

import java.util.concurrent.atomic.AtomicLong;

import org.mockito.internal.util.reflection.Whitebox;

public class BudgetTestFactory {
	
	private static AtomicLong atomicLong = new AtomicLong();
	
	public static Budget of(Integer year, String name,
			String description) {
		Budget budget = new Budget(year, name, description).createBudget();
		Whitebox.setInternalState(budget, "id", atomicLong.getAndIncrement());
		return budget;
	}
	
}
