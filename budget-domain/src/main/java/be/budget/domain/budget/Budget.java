package be.budget.domain.budget;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;

import be.budget.domain.AbstractEntity;

import com.google.common.base.Preconditions;

@Entity
@XmlRootElement(name = "budget")
@XmlAccessorType(XmlAccessType.FIELD)
public class Budget extends AbstractEntity {

	public static Budget of(Integer year, String name,
			String description) {
		return new Budget(year, name, description).createBudget();
	}

	public static enum BudgetState {
		CREATED, READY_FOR_TRANSACTIONS, IN_USE, CLOSED
	}

	@Max(9999)
	@Min(1900)
	private Integer year;
	
	@NotNull
	@Size(min = 4, max = 40)
	private String name;
	
	@Size(max = 255)
	private String description;
	
	@Enumerated(EnumType.STRING)
	private BudgetState state;

	Budget() {
	}

	Budget(Integer year, String name, String description) {
		this.year = year;
		this.name = name;
		this.description = description;
	}

	public BudgetState getState() {
		return state;
	}

	public Integer getYear() {
		return year;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	protected Budget createBudget() {
		Preconditions.checkState(state == null,
				"You cannot call createBudget when state is not null! "
						+ "Current state is: " + state);
		state = BudgetState.CREATED;
		return this;
	}

}