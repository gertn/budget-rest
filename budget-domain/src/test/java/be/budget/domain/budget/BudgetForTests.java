package be.budget.domain.budget;

import org.apache.commons.lang3.RandomStringUtils;
import org.mockito.internal.util.reflection.Whitebox;

public class BudgetForTests {
	
	private static int yearCounter = 2012;
	
	public static Budget createWithDefaults(){
		Budget budget = Budget.of(yearCounter++, 
					"NAME_" + RandomStringUtils.randomAlphabetic(10), 
					"DESC_" + RandomStringUtils.randomAlphabetic(20));
		return budget;
	}
	public static Budget createWithDefaults(Long id){
		Budget budget = createWithDefaults();
		Whitebox.setInternalState(budget, "id", id);
		return budget;
	}

}
