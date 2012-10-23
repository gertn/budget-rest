package be.budget.common.domain.validation;

import be.budget.common.domain.DomainObject;

public abstract class AbstractValidation<T extends DomainObject> {
	
	@SuppressWarnings("unused")
	private final T instance;
	private final ValidationContext context;
	
	private String messageKey;
	
	public AbstractValidation(T instance, ValidationContext context) {
		this.instance = instance;
		this.context = context;
	}

	public boolean isTrue(boolean expression, String messageKey) {
		this.messageKey = messageKey;
		return check(expression);
	}

	boolean check(boolean expression) {
		try {
			if (!expression) {
				context.addError(Error.of(messageKey));
			}
			return expression;
		} finally  {
			reset();
		}
	}
	
	String getMessageKey() {
		return messageKey;
	}

	private void reset() {
		messageKey = null;
	}

}
