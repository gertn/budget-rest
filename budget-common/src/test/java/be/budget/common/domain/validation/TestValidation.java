package be.budget.common.domain.validation;

import be.budget.common.domain.TestDomainObject;
import be.budget.common.domain.validation.AbstractValidation;

public class TestValidation extends AbstractValidation<TestDomainObject> {

	public TestValidation(TestDomainObject instance, ValidationContext context) {
		super(instance, context);
	}
	
	
}