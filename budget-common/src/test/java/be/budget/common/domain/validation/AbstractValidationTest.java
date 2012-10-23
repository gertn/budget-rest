package be.budget.common.domain.validation;

import static be.budget.common.domain.CommonAssertions.assertThat;
import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import be.budget.common.domain.TestDomainObject;


public class AbstractValidationTest {
	
	private static final String MESSAGE_KEY = "messageKey";
	private TestValidation validation;
	private ValidationContext validationContext;

	@Before
	public void createValidation() {
		validationContext = new ValidationContext();
		validation = new TestValidation(new TestDomainObject(), validationContext);
	}

	@Test
	public void isTrueCanAddMessageToContextWhenExpressionIsFalse() {
		validation.isTrue(false, MESSAGE_KEY);
		assertThat(validationContext).contains(Error.of(MESSAGE_KEY));
	}
	
	@Test
	public void isTrueReturnsFalseWhenExpressionIsFalse() {
		boolean result = validation.isTrue(false, MESSAGE_KEY);
		
		assertThat(result).isFalse();
	}
	
	@Test
	public void isTrueReturnsTrueWhenExpressionIsTrue() {
		boolean result = validation.isTrue(true, MESSAGE_KEY);
		
		assertThat(result).isTrue();
		assertThat(validationContext.hasErrors()).isFalse();
	}
	
	@Test
	public void contextIsResetAfterCheck(){
		validation.isTrue(false, MESSAGE_KEY);
		
		assertThat(validation.getMessageKey()).isNull();
	}

}
