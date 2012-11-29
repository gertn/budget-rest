package be.budget.web.api.error;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class AbstractConstraintViolationExceptionMapperTest {

	private AbstractConstraintViolationExceptionMapper mapper;
	private ConstraintViolationException constraintViolationException;

	private static Validator validator;

	@BeforeClass
	public static void setUpValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Before
	public void setUp() throws Exception {
		mapper = new AbstractConstraintViolationExceptionMapper() {
		};
		Set<ConstraintViolation<?>> constraintViolations = Sets.newHashSet();
		constraintViolationException = new ConstraintViolationException(
				constraintViolations);
	}

	@Test
	public void shouldBeAbleToSetStatusToUnprocessableEntity() {
		Response response = mapper
				.createResponseWithErrorsFromConstraintViolationException(constraintViolationException);

		assertThat(response.getStatus()).isEqualTo(
				ConstraintViolationExceptionMapper.UNPROCESSABLE_ENTITY_STATUS);
	}

	@Test
	public void shouldBeAbleToSetContentTypeToApplicationJson() {
		Response response = mapper
				.createResponseWithErrorsFromConstraintViolationException(constraintViolationException);

		assertThat(response.getMetadata().containsKey(contentType()));
		assertThat(response.getMetadata().get(contentType()).get(0)).isEqualTo(
				MediaType.APPLICATION_JSON_TYPE);
	}

	@Test
	public void shouldBeAbleToMapErrors() {
		Set<ConstraintViolation<TestEntity>> contraintViolations = validator
				.validate(new TestEntity());
		constraintViolationException.getConstraintViolations().addAll(
				contraintViolations);
		Response response = mapper
				.createResponseWithErrorsFromConstraintViolationException(constraintViolationException);

		assertThat(response.getEntity()).isInstanceOf(Errors.class);
		Errors errors = (Errors) response.getEntity();

		assertThat(errors.getErrors()).contains(
				new Error("{javax.validation.constraints.NotNull.message}",
						"firstname"),
				new Error("{javax.validation.constraints.Size.message}",
						"name", Lists.newArrayList(new Attribute("min", "4"),
								new Attribute("max", "40"))),
				new Error("{javax.validation.constraints.Min.message}", "year",
						Lists.newArrayList(new Attribute("value", "1900"))));
	}

	private String contentType() {
		return "Content-Type";
	}

}
