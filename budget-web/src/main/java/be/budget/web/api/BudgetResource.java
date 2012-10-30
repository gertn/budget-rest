package be.budget.web.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sun.jersey.api.Responses;

import be.budget.application.BudgetsService;
import be.budget.domain.budget.Budget;
import be.budget.domain.budget.Budgets;

@Component
@Path("/budgets")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class BudgetResource {
	
	@Autowired
	private BudgetsService budgetService;
	
	@GET @Path("default")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Budget defaultBudget(){
		/*if (true) {
			Errors errors = new Errors().add(new Error("error_key", "10", "40")).add(new Error("error_key2", "30"));
			throw new WebApplicationException(Response
					.status(422).entity(errors)
					.type(MediaType.APPLICATION_JSON).build());
		}*/
		return Budget.of(2012, "Budget", "Budget 2012");
	}
	
	@GET 
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Budgets budgets(){
		return Budgets.ofUsername("test");
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Budget create(Budget budget) {
		return budget;
	}

}
