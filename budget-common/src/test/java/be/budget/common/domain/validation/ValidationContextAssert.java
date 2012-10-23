package be.budget.common.domain.validation;

import static be.budget.common.domain.CommonAssertions.assertThat;

import org.fest.assertions.api.AbstractAssert;

public class ValidationContextAssert extends AbstractAssert<ValidationContextAssert, ValidationContext> {

	public ValidationContextAssert(ValidationContext actual) {
		super(actual, ValidationContextAssert.class);
	}
	
	public ValidationContextAssert contains(Error error) {
		isNotNull();
		assertThat(actual.getErrors()).contains(error);
		return this;
	}
	
	public ValidationContextAssert excludes(Error error) {
		isNotNull();
		assertThat(actual.getErrors()).doesNotContain(error);
		return this;
	}

}
