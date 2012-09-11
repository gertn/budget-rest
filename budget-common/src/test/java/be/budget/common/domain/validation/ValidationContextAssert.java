package be.budget.common.domain.validation;

import static be.budget.common.domain.CommonAssertions.assertThat;

import org.fest.assertions.GenericAssert;

public class ValidationContextAssert extends GenericAssert<ValidationContextAssert, ValidationContext> {

	public ValidationContextAssert(ValidationContext actual) {
		super(ValidationContextAssert.class, actual);
	}
	
	public ValidationContextAssert contains(Error error) {
		isNotNull();
		assertThat(actual.getErrors()).contains(error);
		return this;
	}
	
	public ValidationContextAssert excludes(Error error) {
		isNotNull();
		assertThat(actual.getErrors()).excludes(error);
		return this;
	}

}
