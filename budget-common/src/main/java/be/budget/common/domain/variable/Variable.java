package be.budget.common.domain.variable;

import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import be.budget.common.domain.variable.constraints.Constraint;
import be.budget.common.domain.variable.constraints.Required;

import com.google.common.collect.Sets;

public abstract class Variable<T, S> {

	private T value;
	protected final S myself;
	private String name;
	private Set<Constraint> constraints = Sets.newHashSet();

	public Variable(Class<S> selfType) {
		myself = selfType.cast(this);
	}

	public Variable(Class<S> selfType, T defaultValue) {
		this.value = defaultValue;
		myself = selfType.cast(this);
	}

	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public S name(String name) {
		this.name = name;
		return myself;
	}
	
	public S required() {
		this.constraints.add(Required.instance());
		return myself;
	}

	public boolean isMutable() {
		return false;
	}
	
	protected boolean addConstraint(Constraint constraint){
		return this.constraints.add(constraint);
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(15, 17)
			.append(value)
			.append(name)
			.build();
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
		Variable<?, ?> other = (Variable<?, ?>) obj;
		return new EqualsBuilder()
				.append(value, other.value)
				.append(name, other.name).isEquals();
  }

}
