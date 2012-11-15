package be.budget.web.api.error;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.Lists;

@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.FIELD)
public class Error {
	private String messageKey;
	private String property;
	
	private List<Attribute> attributes;
	
	Error(){
	}

	public Error(String messageKey, String property) {
		super();
		this.messageKey = messageKey;
		this.property = property;
		this.attributes = Lists.newArrayList();
	}
	
	public Error(String messageKey, String property, List<Attribute> attributes) {
		super();
		this.messageKey = messageKey;
		this.property = property;
		this.attributes = attributes;
	}

	public String getMessageKey() {
		return messageKey;
	}
	
	public String getProperty() {
		return property;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
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
