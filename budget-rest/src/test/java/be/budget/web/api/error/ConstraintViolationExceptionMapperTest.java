package be.budget.web.api.error;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;

public class ConstraintViolationExceptionMapperTest {

	private ConstraintViolationExceptionMapper mapper;
	private ConstraintViolationException constraintViolationException;
	
	@Before
	public void setUp() throws Exception {
		mapper = spy(new ConstraintViolationExceptionMapper());
		Set<ConstraintViolation<?>> constraintViolations = Sets.newHashSet();
		constraintViolationException = new ConstraintViolationException(constraintViolations);
	}

	@Test
	public void shouldCallCreateResponseWithErrorsFromConstraintViolation() {
		mapper.toResponse(constraintViolationException);
		
		verify(mapper).createResponseWithErrorsFromConstraintViolationException(constraintViolationException);
	}
	
}
