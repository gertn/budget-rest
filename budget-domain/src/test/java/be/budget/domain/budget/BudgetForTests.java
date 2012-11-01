package be.budget.domain.budget;

import org.apache.commons.lang3.RandomStringUtils;

public class BudgetForTests {
	
	private static int yearCounter = 2012;
	
	public static Budget createWithDefaults(){
		return Budget.of(yearCounter++, 
					"NAME_" + RandomStringUtils.randomAlphabetic(10), 
					"DESC_" + RandomStringUtils.randomAlphabetic(20));
	}

}
