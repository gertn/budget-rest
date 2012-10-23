package be.budget.domain.common;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class AmountTest {
	@Test
	public void shouldBeAbleToRoundedHalfEven(){
		assertThat(Amount.of(1.055)).isEqualTo(Amount.of(1.06));
		assertThat(Amount.of(1.025)).isEqualTo(Amount.of(1.02));
		assertThat(Amount.of(1.016)).isEqualTo(Amount.of(1.02));
		assertThat(Amount.of(1.011)).isEqualTo(Amount.of(1.01));
		assertThat(Amount.of(1.010)).isEqualTo(Amount.of(1.01));
	}

	@Test
	public void shouldBeAbleToAdd() {
		Amount result = Amount.of(15.55).add(Amount.of(14.45));
		
		assertThat(result).isEqualTo(Amount.of(30));
	}

}