package be.budget.web.api;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.FIELD)
public class Error {
	
	private String messageKey;
	
	@XmlElement
	private List<String> attributes;
	
	Error() {
	}

	public Error(String messageKey, String... attributes) {
		super();
		this.messageKey = messageKey;
		this.attributes = Arrays.asList(attributes);
	}

	public String getMessageKey() {
		return messageKey;
	}

	public List<String> getAttributes() {
		return attributes;
	}
	
	
}
