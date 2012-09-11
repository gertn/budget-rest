package be.budget.common.domain.validation;

import static be.budget.common.domain.CommonAssertions.assertThat;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import be.budget.common.domain.TestDomainObject;


public class AbstractValidatorTest {
	
	private static final String MESSAGE_KEY = "messageKey";
	private TestValidator validator;
	private ValidationContext validationContext;

	@Before
	public void createValidator() {
		validationContext = new ValidationContext();
		validator = new TestValidator(new TestDomainObject(), validationContext);
	}

	@Test
	public void isTrueCanAddMessageToContextWhenExpressionIsFalse() {
		validator.isTrue(false, MESSAGE_KEY);
		assertThat(validationContext).contains(Error.of(MESSAGE_KEY));
	}
	
	@Test
	public void isTrueReturnsFalseWhenExpressionIsFalse() {
		boolean result = validator.isTrue(false, MESSAGE_KEY);
		
		assertThat(result).isFalse();
	}
	
	@Test
	public void isTrueReturnsTrueWhenExpressionIsTrue() {
		boolean result = validator.isTrue(true, MESSAGE_KEY);
		
		assertThat(result).isTrue();
		assertThat(validationContext.hasErrors()).isFalse();
	}
	
	@Test
	public void contextIsResetAfterCheck(){
		validator.isTrue(false, MESSAGE_KEY);
		
		assertThat(validator.getMessageKey()).isNull();
	}

}
