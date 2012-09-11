package be.budget.common.domain.builder;

import be.budget.common.domain.DomainObject;

public class AbstractBuilder<T extends DomainObject, B extends AbstractBuilder<T, B>> {
	
	private T instance;
	
	public T build() {
		return instance;
	}

}
