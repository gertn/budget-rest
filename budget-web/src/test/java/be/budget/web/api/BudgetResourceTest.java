package be.budget.web.api;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;

import be.budget.application.BudgetsService;
import be.budget.domain.budget.Budget;
import be.budget.domain.budget.BudgetForTests;
import be.budget.web.infrastructure.SpringAwareGrizzlyWebTestContainerFactory;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.sun.jersey.test.framework.spi.container.TestContainerException;
import com.sun.jersey.test.framework.spi.container.TestContainerFactory;

public class BudgetResourceTest extends JerseyTest {
	
	@Autowired
	private BudgetsService budgetsService;

	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder("be.budget.web.api")
				.contextParam("contextConfigLocation",
						"classpath:META-INF/spring/web/application-context.xml, " +
						"classpath:META-INF/spring/domain/application-context.xml, " +
						"classpath:META-INF/spring/infrastructure/datasource-testContext.xml, " +
						"classpath:META-INF/spring/application/application-context.xml")
				.servletClass(SpringServlet.class)
				.contextPath("test")
				.contextListenerClass(ContextLoaderListener.class)
				.requestListenerClass(RequestContextListener.class).build();
	}
	
	protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
		return new SpringAwareGrizzlyWebTestContainerFactory(this);
	}

	@Test
	public void shouldBeAbleToFindAll() throws Exception {
		Budget budget1 = budgetsService.add(BudgetForTests.createWithDefaults());
		Budget budget2 = budgetsService.add(BudgetForTests.createWithDefaults());
		
		WebResource webResource = resource();
		
		GenericType<List<Budget>> genericType = new GenericType<List<Budget>>(){};

		List<Budget> allFound = webResource.path("budgets").get(genericType);
		assertThat(allFound).containsExactly(budget1, budget2);
	}

	@Test
	public void shouldBeAbleToFindById() throws JSONException {
		Budget budget = budgetsService.save(BudgetForTests.createWithDefaults());
		
		WebResource webResource = resource();

		Budget foundBudget = webResource.path("budgets/" + String.valueOf(budget.getId())).get(Budget.class);

		assertBudget(foundBudget, budget);
		
	}
	
	@Test
	public void shouldBeAbleToUpdateBudget() {
		Budget budget = budgetsService.save(BudgetForTests.createWithDefaults());
		budget.setDescription(budget.getDescription() + "A");
		
		WebResource webResource = resource();
		
		Budget updatedBudget = webResource.path("budgets/").put(Budget.class, budget);
		
		assertBudget(updatedBudget, budget);
		
	}
	
	@Test
	public void shouldBeAbleToCreateBudget() {
		Budget budget = BudgetForTests.createWithDefaults();
		
		WebResource webResource = resource();
		
		Budget createdBudget = webResource.path("budgets/").post(Budget.class, budget);
		
		assertCreatedBudget(createdBudget, budget);
		
	}

	private void assertCreatedBudget(Budget actual, Budget expected) {
		assertThat(actual).isNotNull();
		assertThat(actual.getName()).isEqualTo(expected.getName());
		assertThat(actual.getDescription()).isEqualTo(expected.getDescription());
		assertThat(actual.getYear()).isEqualTo(expected.getYear());
		assertThat(actual.getId()).isNotNull();
	}

	private void assertBudget(Budget actual, Budget expected) {
		assertThat(actual).isNotNull();
		assertThat(actual.getId()).isEqualTo(expected.getId());
		assertCreatedBudget(actual, expected);
	}

}
