package be.budget.domain.category;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import be.budget.common.domain.Model;

@Entity
public class Category extends Model {
	
	private String name;
	@Embedded
	private Year year;
	@ManyToOne
	private CategoryGroup group;
	
	public String getName() {
		return name;
	}
	public Year getYear() {
		return year;
	}
	public CategoryGroup getGroup() {
		return group;
	}
	
	

}
