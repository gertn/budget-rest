package be.budget.web.api;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Lists;

@XmlRootElement(name = "errorr")
@XmlAccessorType(XmlAccessType.FIELD)
public class Errors {
	
	private List<Error> errors = Lists.newArrayList();
	
	public Errors add(Error error){
		this.errors.add(error);
		return this;
	}

}
