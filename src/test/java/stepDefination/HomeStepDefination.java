package stepDefination;

import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;

public class HomeStepDefination {

	HomePage hp = new HomePage();

	@Before
	public void startMethod() {
		hp.openBrowser();
		hp.openPage();
	}

	@Given("^User is on a Home Page$")
	public void user_is_on_a_Home_Page() throws Throwable {

	}

	@When("^title of the page is Free CRM with Free calling and auto dialing features$")
	public void title_of_the_page_is_Free_CRM_with_Free_calling_and_auto_dialing_features() {
		String title = hp.checkTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}

	@Then("^user checks for header text$")
	public void user_checks_for_header_text() throws Throwable {
		String headerText = hp.headerText();
		String expectedText = "Free CRM Software";
		Assert.assertEquals(expectedText, headerText);
	}

	@Then("^user check for Service title and description$")
	public void user_check_for_Service_title_and_description() throws Throwable {
		String service1Title1 = hp.services1Title1();
		String expectedText = "Service";
		Assert.assertEquals(service1Title1, expectedText);

		String service1Desc = hp.services1Desc();
		String expectedText1 = "Convert leads into accounts faster with the world's #1 CRM software. Grow your customer base, find new ones, and close faster from anywhere. Quickly follow up on leads, identify key contacts, and more. See a comfortable, customizable view of all of the details of sales at the touch of a button. Manage your pipeline and speed up your sales team.";
		Assert.assertEquals(service1Desc, expectedText1);
	}

	@After
	public void wrapUp() {
		hp.closeTheBrowser();
	}

}
