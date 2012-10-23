package be.budget.common.domain.variable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class StringVariable extends Variable<String, StringVariable> {

	public StringVariable() {
		super(StringVariable.class);
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
