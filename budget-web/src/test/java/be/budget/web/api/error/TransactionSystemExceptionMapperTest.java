package be.budget.web.api.error;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.Set;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.TransactionSystemException;

import com.google.common.collect.Sets;

public class TransactionSystemExceptionMapperTest {

	private TransactionSystemExceptionMapper mapper;
	private ConstraintViolationException constraintViolationException;
	
	@Before
	public void setUp() throws Exception {
		mapper = spy(new TransactionSystemExceptionMapper());
		Set<ConstraintViolation<?>> constraintViolations = Sets.newHashSet();
		constraintViolationException = new ConstraintViolationException(constraintViolations);
	}

	@Test
	public void shouldCallCreateResponseWithErrorsFromConstraintViolationWhenCauseOfRollbackExceptionIsConstraintViolationException() {
		TransactionSystemException transactionSystemException = new TransactionSystemException("test", new RollbackException(constraintViolationException));
		
		mapper.toResponse(transactionSystemException);
		
		verify(mapper).createResponseWithErrorsFromConstraintViolation(constraintViolationException);
	}
	
	@Test
	public void shouldReturnResponseStatusForbiddenWhenCauseNotConstraintViolationException(){
		TransactionSystemException transactionSystemException = new TransactionSystemException("test", new RollbackException("test"));
		
		Response response = mapper.toResponse(transactionSystemException);
		
		assertThat(response.getStatus()).isEqualTo(Status.FORBIDDEN.getStatusCode());
	}
	
}
