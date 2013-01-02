package be.budget.web.api.error;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Lists;

@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.FIELD)
public class Errors {
	
	@XmlElement
	private List<Error> errors = Lists.newArrayList();
	
	public Errors add(Error error){
		this.errors.add(error);
		return this;
	}
	
	public List<Error> getErrors() {
		return Collections.unmodifiableList(errors);
	}

}
