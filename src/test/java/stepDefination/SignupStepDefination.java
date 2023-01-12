package stepDefination;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.SignupPage;

public class SignupStepDefination {
	
	SignupPage sp = new SignupPage();

	
	@Given("^User is already on a signup page$")
	public void user_is_already_on_a_signup_page() throws Throwable {
		sp.openBrowser();
		sp.openPage();
		sp.clickOnSignUp();
	}

	@When("^title of the page is Cogmento CRM$")
	public void title_of_the_page_is_Cogmento_CRM() throws Throwable {
	    String title = sp.checkTitle();
	    Assert.assertEquals("Cogmento CRM", title);
	}

	@Then("^user check error$")
	public void user_check_error() throws Throwable {
		sp.clickOnSignupBtn();
		Assert.assertEquals(sp.emailError(), "[[Email is required]]");
		
	}
	
	@Then("^user enters details$")
	public void user_enters_details() throws Throwable {
	    //	sp.verifyEmail("ancandcn@email.com", "5487776545", "India");
	}


	@Then("^user clicks on signup button$")
	public void user_clicks_on_signup_button() throws Throwable {
	    sp.clickOnSignupBtn();
	}
	
	@After
	public void wrapUp() {
		sp.closeTheBrowser();
	}
}
