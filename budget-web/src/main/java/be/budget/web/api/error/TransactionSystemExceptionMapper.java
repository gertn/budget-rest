package be.budget.web.api.error;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.metadata.ConstraintDescriptor;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.TransactionSystemException;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

//TODO: test + refactor ExceptionMappers
@Provider
public class TransactionSystemExceptionMapper implements ExceptionMapper<TransactionSystemException> {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionSystemExceptionMapper.class);

	static final int UNPROCESSABLE_ENTITY_STATUS = 422;
	
	private static final Set<String> EXCLUDED_KEYS = Sets.newHashSet("groups", "message", "payload");

	@Override
	public Response toResponse(TransactionSystemException exception) {
		LOGGER.info("TransactionSystemException" , exception);
		Errors errors = new Errors();
		if(exception.getCause() != null && exception.getCause().getCause() instanceof ConstraintViolationException){
			for (ConstraintViolation<?> violation :  ((ConstraintViolationException) exception.getCause().getCause()).getConstraintViolations()) {
				errors.add(new Error(violation.getMessageTemplate(), violation.getPropertyPath().toString(), extractAttributes(violation)));
			}
			
			return Response
					.status(UNPROCESSABLE_ENTITY_STATUS).entity(errors)
					.type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.FORBIDDEN).build();
	}

	private List<Attribute> extractAttributes(ConstraintViolation<?> violation) {
		List<Attribute> attributes = Lists.newArrayList();
		
		ConstraintDescriptor<?> constraintDescriptor = violation.getConstraintDescriptor();
		Map<String, Object> attributesMap = constraintDescriptor.getAttributes();
		
		for (Entry<String, Object> entry : attributesMap.entrySet()) {
			if(!EXCLUDED_KEYS.contains(entry.getKey())){
				attributes.add(new Attribute(entry.getKey(), String.valueOf(entry.getValue())));
			}
		}
		return attributes;
	}

}
