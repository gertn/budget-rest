package be.budget.web.api.error;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class ConstraintViolationExceptionMapper extends AbstractConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConstraintViolationExceptionMapper.class);

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		LOGGER.info("ConstraintViolationException" , exception);
		return createResponseWithErrorsFromConstraintViolation(exception);
	}

}
