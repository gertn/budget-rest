package be.budget.common.domain.variable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class ImmutableVariable<T, S>  extends Variable<T, S>  {

	public ImmutableVariable(Class<S> selfType) {
		super(selfType);
	}

	public ImmutableVariable(Class<S> selfType, T defaultValue) {
		super(selfType, defaultValue);
	}
	
	public void setValue(T value) {
		throw new UnsupportedOperationException("You cannot call setValue on ImmutableVariable");
	}
	
	@Override
	public boolean isMutable() {
		return false;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
