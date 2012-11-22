package be.budget.domain.budget;

import java.util.Collections;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import be.budget.domain.AbstractEntity;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

@Entity
@Access(AccessType.FIELD)
@XmlRootElement(name = "budgets")
@XmlAccessorType(XmlAccessType.FIELD)
public class Budgets extends AbstractEntity {
	
	public static final String DEFAULT_USERNAME = "DEFAULT";

	public static Budgets create(){
		return new Budgets(DEFAULT_USERNAME);
	}
	
	@Column(unique=true, nullable=false)
	private String username;

	@OneToOne
	private Budget selectedBudget;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="budgets_id")
	private List<Budget> budgets = Lists.newArrayList();

	Budgets() {
	}

	Budgets(String username) {
		this.username = username;
	}

	public void addBudget(Budget budget) {
		if (selectedBudget == null) {
			selectedBudget = budget;
		}
		budgets.add(budget);
	}
	
	public List<Budget> getBudgets() {
		return Collections.unmodifiableList(budgets);
	}

	public Budget getSelectedBudget() {
		return selectedBudget;
	}
	
	public Budget setSelectedBudget(Budget budget) {
		Preconditions.checkNotNull(budget);
		Preconditions.checkNotNull(budget.getId());
		Preconditions.checkArgument(budgets.contains(budget), "budget to set as selected budget is not contained in list of budgets!");
		return this.selectedBudget = budget;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

}
