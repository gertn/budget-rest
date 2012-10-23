package be.budget.common.domain.variable.constraints;

public class Required implements Constraint {
	
	private static final Required INSTANCE = new Required();
	
	public static final Required instance() {
		return INSTANCE;
	}

}
