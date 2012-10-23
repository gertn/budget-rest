package be.budget.common.domain;

import org.fest.assertions.api.Assertions;

import be.budget.common.domain.validation.ValidationContext;
import be.budget.common.domain.validation.ValidationContextAssert;

public class CommonAssertions extends Assertions {
	
	public static ValidationContextAssert assertThat(ValidationContext actual) {
		return new ValidationContextAssert(actual);
	}

	protected CommonAssertions() {
	}

}
