package stepDefination;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CreateUserContactPage;
import pages.DealsPage;

public class DealsStepDefination {

	WebDriver driver;
	DealsPage dp = new DealsPage();
	
	@Given("^user is on home Page$")
	public void user_is_on_home_Page() throws Throwable {
		dp.openBrowser();
		dp.openLoginPage();
	}

	@When("^title of home page is Free CRM$")
	public void title_of_home_page_is_Free_CRM() throws Throwable {
		dp.getTitle();

	}

	@Then("^user will click login button$")
	public void user_will_click_login_button() throws Throwable {
		dp.userClickLogin();
	}

	@Then("^user enters username and password to login$")
	public void user_enters_username_and_password_to_login(DataTable credentials) throws Throwable {
		List<List<String>> data = credentials.raw();
		dp.enterUsernameAndPassword(data.get(0).get(0), data.get(0).get(1));
	}

	@Then("^user clicks on login button to login$")
	public void user_clicks_on_login_button_to_login() throws Throwable {
		dp.clickLoginButton();
	}

	@Then("^user is on user homepage$")
	public void user_is_on_user_homepage() throws Throwable {
		Thread.sleep(2000);
		Boolean boolean1 = dp.checkUserName("Parth Patel");
		Assert.assertTrue(boolean1);
	}

	@Then("^user move to new deal page$")
	public void user_move_to_new_deal_page() throws Throwable {
		dp.userMoveToNewDeal();
	}

	@Then("^user enters deal details$")
	public void user_enters_deal_details(DataTable details) throws Throwable {
		List<List<String>> data = details.raw();
		dp.deal(data.get(0).get(0), data.get(0).get(1), data.get(0).get(2));
	
	}

}
