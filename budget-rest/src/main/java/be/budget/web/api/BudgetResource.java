package be.budget.web.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.budget.application.BudgetsService;
import be.budget.domain.budget.Budget;

@Component
@Path("/budgets")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class BudgetResource {
	
	@Autowired
	private BudgetsService budgetService;
	
	@GET 
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Budget> findAll(){
		return budgetService.findAll();
	}
	
	@GET @Path("{id : \\d+}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Budget findOne(@PathParam("id") Long id){
		return budgetService.findOne(id);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Budget create(Budget budget) {
		return budgetService.add(budget);
	}
	
	@PUT @Path("{id : \\d+}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Budget update(Budget budget) {
		return budgetService.save(budget);
	}
	
	@PUT @Path("/default/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Budget defaultBudget(Budget budget) {
		return budgetService.setDefaultBudget(budget);
	}
	
	@GET @Path("/default")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Budget defaultBudget() {
		return budgetService.getDefaultBudget();
	}

}
