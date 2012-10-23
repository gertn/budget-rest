package be.budget.common.domain.variable.constraints;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


public class SizeConstraint implements Constraint {
	
	private int min = 0;
	private int max = Integer.MAX_VALUE;
	
	public int getMin() {
		return min;
	}
	
	public int getMax() {
		return max;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(31, 1)
			.append(min)
			.append(max)
			.build();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SizeConstraint other = (SizeConstraint) obj;
		return new EqualsBuilder()
			.append(min, other.min)
			.append(max, other.max)
			.isEquals();
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
