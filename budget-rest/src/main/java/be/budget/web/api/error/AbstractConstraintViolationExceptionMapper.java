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

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public abstract class AbstractConstraintViolationExceptionMapper {
	
	static final Set<String> EXCLUDED_KEYS = Sets.newHashSet("groups", "message", "payload");
	static final int UNPROCESSABLE_ENTITY_STATUS = 422;

	protected Response createResponseWithErrorsFromConstraintViolationException(
			ConstraintViolationException exception) {
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