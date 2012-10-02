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


@Entity
@XmlRootElement(name="budgetCategories")
@XmlAccessorType(XmlAccessType.FIELD)
public class BudgetCategories extends AbstractEntity {
	
	@OneToMany(fetch= FetchType.EAGER)
	private List<Category> incomeCategories;
	@OneToMany(fetch= FetchType.EAGER)
	private List<Category> expenseCategories;


	public List<Category> getIncomeCategories() {
		return incomeCategories;
	}

	public List<Category> getExpenseCategories() {
		return expenseCategories;
	}
	
}
