package be.budget.domain.budget;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import be.budget.domain.AbstractEntity;

@Entity
@XmlRootElement(name = "budgets")
public class Budgets extends AbstractEntity {

	@OneToOne
	private Budget defaultBudget;

	public Budgets(Budget defaultBudget) {
		this.defaultBudget = defaultBudget;
	}

	@SuppressWarnings("unused")
	private Budgets() {
	}

	public Budget getDefaultBudget() {
		return defaultBudget;
	}
	
	public void setDefaultBudget(Budget defaultBudget) {
		this.defaultBudget = defaultBudget;
	}

}
