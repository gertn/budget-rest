package be.budget.common.domain;

import be.budget.common.domain.validation.ValidationContext;

public class TestDomainObject implements DomainObject {
	private String testString;

	public TestDomainObject withTestString(String testString) {
		this.testString = testString;
		return this;
	}

	public String getTestString() {
		return testString;
	}

	public ValidationContext getValidationContext() {

		return null;
	}
}