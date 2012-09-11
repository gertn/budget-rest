package be.budget.domain.budget;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import be.budget.domain.AbstractEntity;
import be.budget.domain.category.Category;

import com.google.common.base.Preconditions;

@Entity
@XmlRootElement(name="budget")
@XmlAccessorType(XmlAccessType.FIELD)
//@ValidBudget
public class Budget extends AbstractEntity {
	
	public static Budget createNewBudget(Integer year, String name) {
		return new Budget(year, name);
	}
	
	public static enum BudgetState {
		CREATED, READY_FOR_TRANSACTIONS, IN_USE, CLOSED
	}
	
	private Integer year;
	private String name;
	@OneToMany(fetch= FetchType.EAGER)
	private List<Category> incomeCategories;
	@OneToMany(fetch= FetchType.EAGER)
	private List<Category> expenseCategories;
	private BudgetState state;
	
	Budget() {
	}
	
	Budget(Integer year, String name) {
		this.year = year;
		this.name = name;
	}
	
	void createBudget() {
		Preconditions.checkState(state == null, "you cannot call createBudget when state is not null");
		state = BudgetState.CREATED;
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

	public List<Category> getIncomeCategories() {
		return incomeCategories;
	}

	public List<Category> getExpenseCategories() {
		return expenseCategories;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
