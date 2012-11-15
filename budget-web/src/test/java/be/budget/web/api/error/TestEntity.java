package be.budget.web.api.error;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class TestEntity {
	
	@Min(1900)
	private Integer year = 4;
	
	@Size(min = 4, max = 40)
	private String name = "a";
	
	@NotNull
	private String firstname;
	
	
}
