package be.budget.common.domain.validation;

import be.budget.common.domain.TestDomainObject;
import be.budget.common.domain.validation.AbstractValidator;

public class TestValidator extends AbstractValidator<TestDomainObject> {

	public TestValidator(TestDomainObject instance, ValidationContext context) {
		super(instance, context);
	}
	
	
}