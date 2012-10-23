package be.budget.domain.budget;

import java.util.Collections;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.google.common.collect.Lists;

import be.budget.domain.AbstractEntity;

@Entity
@Access(AccessType.FIELD)
public class Budgets extends AbstractEntity {

	@OneToOne
	private Budget selectedBudget;

	@OneToMany
	private List<Budget> budgets = Lists.newArrayList();

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

	public void setSelectedBudget(Budget budget) {
		if (!budgets.contains(budget)) {
			throw new IllegalArgumentException(
					"budget to set as selected budget is not contained in list of budgets!");
		}
		this.selectedBudget = budget;
	}

}
