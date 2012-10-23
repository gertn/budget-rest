package be.budget.domain.budget;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.metadata.ConstraintDescriptor;

import org.fest.assertions.api.AbstractAssert;
import org.fest.assertions.api.Assertions;

public class ConstraintViolationAssert extends
		AbstractAssert<ConstraintViolationAssert, ConstraintViolation<?>> {

	protected ConstraintViolationAssert(ConstraintViolation<?> actual) {
		super(actual, ConstraintViolationAssert.class);
	}

	public static ConstraintViolationAssert assertThat(
			ConstraintViolation<?> actual) {
		return new ConstraintViolationAssert(actual);
	}

	public ConstraintViolationAssert hasMessageTemplate(String messageTemplate) {
		isNotNull();
		Assertions
				.assertThat(actual.getMessageTemplate())
				.overridingErrorMessage(
						"Expected messageTemplate to be <%s> but was <%s>",
						messageTemplate, actual.getMessageTemplate())
				.isEqualTo(messageTemplate);
		return this;
	}

	public ConstraintViolationAssert hasPathName(String pathName) {
		isNotNull();
		Assertions
				.assertThat(actual.getPropertyPath().toString())
				.overridingErrorMessage(
						"Expected pathName to be <%s> but was <%s>", pathName,
						actual.getPropertyPath().toString())
				.isEqualTo(pathName);
		return this;
	}

	public ConstraintViolationAssert isSizeViolation(int min, int max) {
		isNotNull();
		ConstraintDescriptor<?> constraintDescriptor = assertAnnotationInstanceOf(Size.class);
		Size annotation = (Size) constraintDescriptor.getAnnotation();
		Assertions
				.assertThat(annotation.min())
				.overridingErrorMessage(
						"Expected Size.min() to be <%s> but was <%s>", min,
						annotation.min()).isEqualTo(min);
		Assertions
				.assertThat(annotation.max())
				.overridingErrorMessage(
						"Expected Size.max() to be <%s> but was <%s>", max,
						annotation.max()).isEqualTo(max);
		return this;
	}

	private ConstraintDescriptor<?> assertAnnotationInstanceOf(
			Class<?> annotationClass) {
		ConstraintDescriptor<?> constraintDescriptor = actual
				.getConstraintDescriptor();
		Assertions
				.assertThat(constraintDescriptor.getAnnotation())
				.overridingErrorMessage(
						"Expected annotationType to be <%s> but was <%s>",
						annotationClass, constraintDescriptor.getAnnotation())
				.isInstanceOf(annotationClass);
		return constraintDescriptor;
	}

	public ConstraintViolationAssert isNotNullViolation() {
		isNotNull();
		assertAnnotationInstanceOf(NotNull.class);
		return this;
	}

	public ConstraintViolationAssert isMaxViolation(long max) {
		isNotNull();
		ConstraintDescriptor<?> constraintDescriptor = assertAnnotationInstanceOf(Max.class);
		Max annotation = (Max) constraintDescriptor.getAnnotation();
		Assertions
				.assertThat(annotation.value())
				.overridingErrorMessage(
						"Expected Max.value() to be <%s> but was <%s>", max,
						annotation.value()).isEqualTo(max);
		return this;

	}

	public ConstraintViolationAssert isMinViolation(long min) {
		isNotNull();
		ConstraintDescriptor<?> constraintDescriptor = assertAnnotationInstanceOf(Min.class);
		Min annotation = (Min) constraintDescriptor.getAnnotation();
		Assertions
				.assertThat(annotation.value())
				.overridingErrorMessage(
						"Expected Min.value() to be <%s> but was <%s>", min,
						annotation.value()).isEqualTo(min);
		return this;

	}

}
