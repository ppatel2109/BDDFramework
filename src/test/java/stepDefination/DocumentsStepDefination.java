package stepDefination;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DealsPage;
import pages.DocumentsPage;

public class DocumentsStepDefination {

	WebDriver driver;
	DocumentsPage dp = new DocumentsPage();

	@Given("^user opens home Page$")
	public void user_opens_home_Page() throws Throwable {
		dp.openBrowser();
		dp.openLoginPage();
	}

	@When("^home page title is Free CRM$")
	public void home_page_title_is_Free_CRM() throws Throwable {
		dp.getTitle();
	}

	@Then("^user will click login button to login$")
	public void user_will_click_login_button_to_login() throws Throwable {
		dp.userClickLogin();
	}

	@Then("^user will enter username and password$")
	public void user_will_enter_username_and_password(DataTable credentials) throws Throwable {
		for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {
			dp.enterUsernameAndPassword(data.get("username"), data.get("password"));
		}
	}

	@Then("^will click on login button$")
	public void will_click_on_login_button() throws Throwable {
		dp.clickLoginButton();
	}

	@Then("^user is on user home page$")
	public void user_is_on_user_home_page() throws Throwable {
		Thread.sleep(2000);
		Boolean boolean1 = dp.checkUserName("Parth Patel");
		Assert.assertTrue(boolean1);
	}

	@Then("^user opens create new document page$")
	public void user_opens_create_new_document_page() throws Throwable {
		dp.userMoveToNewDocument();
	}

	@Then("^user enters document details$")
	public void user_enters_document_details(DataTable documentData) throws Throwable {

		for (Map<String, String> data : documentData.asMaps(String.class, String.class)) {
			dp.document(data.get("title"), data.get("desc"));
			Thread.sleep(2000);
			dp.userMoveToNewDocument();
		}
	}
	
	@After
	public void wrapUp() {
		dp.closeTheBrowser();
	}

}
