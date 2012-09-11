package be.budget.common.domain.validation;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Error {
	
	public static Error of(String key, String... variables) {
		return new Error(key, variables);
	}

    private final String key;
    private final String[] variables;

    private Error(String key, String... variables) {
        this.key = key;
        this.variables = variables;
    }

	public String getKey() {
		return key;
	}

	public String[] getVariables() {
		return variables;
	}
    
    @Override
    public String toString() {
    	return ReflectionToStringBuilder.toString(this);
    }
    
    @Override
    public int hashCode() {
    	return HashCodeBuilder.reflectionHashCode(this);
    }
    
    @Override
    public boolean equals(Object obj) {
    	return EqualsBuilder.reflectionEquals(this, obj);
    }

}
