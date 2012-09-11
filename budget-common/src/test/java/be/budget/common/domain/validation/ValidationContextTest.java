package be.budget.common.domain.validation;

import static be.budget.common.domain.CommonAssertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ValidationContextTest {
	
	private ValidationContext context;

	@Before
	public void createContext(){
		context = new ValidationContext();
	}

	@Test
	public void canDetermineHasErrors() {
		assertThat(context.hasErrors()).isFalse();
		
		context.addError(Error.of("key"));
		
		assertThat(context.hasErrors()).isTrue();
	}

}
