package be.budget.web.api;

import static org.fest.assertions.Assertions.assertThat;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import be.budget.domain.budget.Budget;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.header.MediaTypes;
import com.sun.jersey.test.framework.JerseyTest;

@Ignore
public class BudgetResourceTest extends JerseyTest {

	public BudgetResourceTest() throws Exception {
		super("be.budget.web.api");
	}

	@Test
	public void shouldBeAbleToDetermineDefaultBudget() {
		
		WebResource webResource = resource();
		
		String wadl = webResource.path("application.wadl").accept(MediaTypes.WADL)
		        .get(String.class);
		
		System.out.println(wadl);
		
		Budget defaultBudget = webResource.path("budgets/default").get(Budget.class);
		
		assertThat(defaultBudget.getName()).isEqualTo("Budget");
		assertThat(defaultBudget.getYear()).isEqualTo(2012);
	}
	
	@Test
	public void shouldBeAbleToGetBudgets() throws JSONException {
		WebResource webResource = resource();
		
		JSONObject responseMsg = new JSONObject(webResource.path("budgets").get(String.class));
		System.out.println(responseMsg);
		
		JSONObject defaultBudget = responseMsg.getJSONObject("defaultBudget");
		
		assertThat(defaultBudget).isNotNull();
		assertThat(defaultBudget.getString("name")).isEqualTo("Budget");
		assertThat(defaultBudget.getInt("year")).isEqualTo(2013);
	}

}
