package be.budget.web.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.budget.application.BudgetService;
import be.budget.domain.budget.Budget;
import be.budget.domain.budget.Budgets;

@Component
@Path("/budgets")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class BudgetResource {
	
	@Autowired
	private BudgetService budgetService;
	
	@GET @Path("default")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Budget defaultBudget(){
		return Budget.createNewBudget(2012, "Budget");
	}
	
	@GET 
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Budgets budgets(){
		List<Budget> findAll = budgetService.findAll();
		return new Budgets(findAll.get(0));
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Budget create(Budget budget) {
		return budgetService.create(budget);
	}

}
