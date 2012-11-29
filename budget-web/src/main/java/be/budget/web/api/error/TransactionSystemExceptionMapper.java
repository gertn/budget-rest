package be.budget.web.api.error;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionSystemException;

@Provider
public class TransactionSystemExceptionMapper extends AbstractConstraintViolationExceptionMapper implements ExceptionMapper<TransactionSystemException> {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionSystemExceptionMapper.class);

	@Override
	public Response toResponse(TransactionSystemException exception) {
		LOGGER.info("TransactionSystemException" , exception);
		if(exception.getCause() != null && exception.getCause().getCause() instanceof ConstraintViolationException){
			ConstraintViolationException constraintViolationException = (ConstraintViolationException) exception.getCause().getCause();
			return createResponseWithErrorsFromConstraintViolationException(constraintViolationException);
		}
		return Response.status(Status.FORBIDDEN).build();
	}

}
