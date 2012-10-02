package be.budget.domain.budget;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import be.budget.domain.AbstractEntity;

import com.google.common.base.Preconditions;

@Entity
@XmlRootElement(name="budget")
@XmlAccessorType(XmlAccessType.FIELD)
public class Budget extends AbstractEntity {

	public static Budget createNewBudget(Integer year, String name) {
		return new Budget(year, name);
	}

	public static enum BudgetState {
		CREATED, READY_FOR_TRANSACTIONS, IN_USE, CLOSED
	}

	private Integer year;
	private String name;
	private BudgetState state;

	
	Budget() {
	}
	
	Budget(Integer year, String name) {
		this.year = year;
		this.name = name;
	}
	
	public BudgetState getState() {
		return state;
	}

	public Integer getYear() {
		return year;
	}

	public String getName() {
		return name;
	}

	protected void createBudget() {
		Preconditions.checkState(state == null, 
					"You cannot call createBudget when state is not null! " +
					"Current state is: " + state);
		state = BudgetState.CREATED;
	}

}