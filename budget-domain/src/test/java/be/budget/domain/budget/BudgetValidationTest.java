package be.budget.domain.budget;

import static be.budget.domain.budget.ConstraintViolationAssert.assertThat;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.BeforeClass;
import org.junit.Test;

public class BudgetValidationTest {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void nameIsRequired() {
		String nullName = null;
		Budget budget = Budget.of(2012, nullName, "description");

		Set<ConstraintViolation<Budget>> constraintViolations = validator
				.validate(budget);

		assertThat(constraintViolations).hasSize(1);
		ConstraintViolation<Budget> violation = constraintViolations.iterator()
				.next();
		assertThat(violation)
				.hasPathName("name")
				.hasMessageTemplate(
						"{javax.validation.constraints.NotNull.message}")
				.isNotNullViolation();
	}

	@Test
	public void nameIsTooShort() {
		String name = RandomStringUtils.randomAlphabetic(3);
		Budget budget = Budget.of(2012, name, "description");

		Set<ConstraintViolation<Budget>> constraintViolations = validator
				.validate(budget);

		assertThat(constraintViolations).hasSize(1);
		ConstraintViolation<Budget> violation = constraintViolations.iterator()
				.next();
		assertThat(violation)
				.hasPathName("name")
				.hasMessageTemplate(
						"{javax.validation.constraints.Size.message}")
				.isSizeViolation(4, 40);
	}

	@Test
	public void nameIsTooLong() {
		String name = RandomStringUtils.randomAlphabetic(41);
		Budget budget = Budget.of(2012, name, "description");

		Set<ConstraintViolation<Budget>> constraintViolations = validator
				.validate(budget);

		assertThat(constraintViolations).hasSize(1);
		ConstraintViolation<Budget> violation = constraintViolations.iterator()
				.next();
		assertThat(violation)
				.hasPathName("name")
				.hasMessageTemplate(
						"{javax.validation.constraints.Size.message}")
				.isSizeViolation(4, 40);
	}

	@Test
	public void descriptionIsTooLong() {
		String descriptionTooLong = RandomStringUtils.randomAlphabetic(256);

		Budget budget = Budget.of(2012, "name",
				descriptionTooLong);

		Set<ConstraintViolation<Budget>> constraintViolations = validator
				.validate(budget);

		assertThat(constraintViolations).hasSize(1);
		ConstraintViolation<Budget> violation = constraintViolations.iterator()
				.next();
		assertThat(violation)
				.hasPathName("description")
				.hasMessageTemplate(
						"{javax.validation.constraints.Size.message}")
				.isSizeViolation(0, 255);
	}

	@Test
	public void yearIsTooBig() {
		Integer yearTooBig = 9999 + 1;

		Budget budget = Budget.of(yearTooBig, "name",
				"description");

		Set<ConstraintViolation<Budget>> constraintViolations = validator
				.validate(budget);

		assertThat(constraintViolations).hasSize(1);
		ConstraintViolation<Budget> violation = constraintViolations.iterator()
				.next();
		assertThat(violation)
				.hasPathName("year")
				.hasMessageTemplate(
						"{javax.validation.constraints.Max.message}")
				.isMaxViolation(9999);
	}

	@Test
	public void yearIsTooSmall() {
		Integer yearTooSmall = 1900 - 1;

		Budget budget = Budget.of(yearTooSmall, "name",
				"description");

		Set<ConstraintViolation<Budget>> constraintViolations = validator
				.validate(budget);

		assertThat(constraintViolations).hasSize(1);
		ConstraintViolation<Budget> violation = constraintViolations.iterator()
				.next();
		assertThat(violation)
				.hasPathName("year")
				.hasMessageTemplate(
						"{javax.validation.constraints.Min.message}")
				.isMinViolation(1900);
	}

	@Test
	public void budgetIsValid() {
		String name = RandomStringUtils.randomAlphabetic(40);
		Budget budget = Budget.of(2012, name, "description");

		Set<ConstraintViolation<Budget>> constraintViolations = validator
				.validate(budget);

		assertThat(constraintViolations).isEmpty();
	}

}
