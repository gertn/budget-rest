package be.budget.domain.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Embeddable
public class Amount {

	public static Amount zero() {
		Amount amount = new Amount();
		amount.setValue(BigDecimal.ZERO);
		return amount;
	}

	public static Amount of(double amount) {
		Amount result = new Amount();
		result.setValue(BigDecimal.valueOf(amount));
		return result;
	}

	private BigDecimal value;

	public void setValue(BigDecimal value) {
		this.value = rounded(value);
	}

	public Amount add(Amount amount) {
		Amount result = new Amount();
		result.value = rounded(this.value.add(amount.value));
		return result;
	}

	private BigDecimal rounded(BigDecimal aNumber) {
		return aNumber.setScale(2, RoundingMode.HALF_EVEN);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(value).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Amount other = (Amount) obj;
		return new EqualsBuilder().append(value, other.value).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("value", value).build();

	}

}
