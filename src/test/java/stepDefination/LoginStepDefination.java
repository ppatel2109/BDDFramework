package stepDefination;

import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;

public class LoginStepDefination {

	LoginPage lp = new LoginPage();

	@Before
	public void setupPage() throws InterruptedException {
		lp.openBrowser();
		lp.openPage();
	}

	@Given("^User is alrady on login page$")
	public void user_is_alrady_on_login_page() throws Throwable {

	}

	@When("^the title of the login page is Cogmento CRM$")
	public void the_title_of_the_login_page_is_Cogmento_CRM() throws Throwable {
		String title = lp.checkTitle();
		String expectedTitle = "Cogmento CRM";
		Assert.assertEquals(expectedTitle, title);
	}


	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {
	    lp.login(username, password);
	}


	@Then("^user clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		lp.clickOnLogin();
	}

	
	@Then("^user check username$")
	public void user_check_username() throws Throwable {
		Assert.assertTrue(lp.checkUserName("Parth Patel"));
	}

	@After
	public void wrapUp() {
		lp.closeTheBrowser();
	}

}
