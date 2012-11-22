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
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConstraintViolationExceptionMapper.class);

	static final int UNPROCESSABLE_ENTITY_STATUS = 422;
	
	private static final Set<String> EXCLUDED_KEYS = Sets.newHashSet("groups", "message", "payload");

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		LOGGER.info("ConstraintViolationException" , exception);
		Errors errors = new Errors();
		for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
			errors.add(new Error(violation.getMessageTemplate(), violation.getPropertyPath().toString(), extractAttributes(violation)));
		}
		return Response
				.status(UNPROCESSABLE_ENTITY_STATUS).entity(errors)
				.type(MediaType.APPLICATION_JSON).build();
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
