package be.budget.common.domain.validation;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class ValidationContext implements Serializable {
	
	private List<Error> errors = Lists.newArrayList();
	
	public List<Error> getErrors() {
		return Collections.unmodifiableList(errors);
	}
	
	public boolean addError(Error error) {
		return errors.add(error);
	}
	
	public boolean hasErrors(){
		return !errors.isEmpty();
	}

}
