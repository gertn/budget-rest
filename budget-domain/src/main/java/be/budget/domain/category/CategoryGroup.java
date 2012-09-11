package be.budget.domain.category;

import javax.persistence.Entity;

import be.budget.common.domain.Model;

@Entity
public class CategoryGroup extends Model {
	
	private String name;
	
	public String getName() {
		return name;
	}
	
}
