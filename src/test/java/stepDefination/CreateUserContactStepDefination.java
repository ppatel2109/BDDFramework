package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CreateUserContactPage;

public class CreateUserContactStepDefination {
	
	WebDriver driver;
	CreateUserContactPage cp = new CreateUserContactPage();
	
	@Given("^user is on index Page$")
	public void user_is_on_index_Page(){
	   cp.openBrowser();
	   cp.openLoginPage();
	}

	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM(){
	   cp.getTitle();
	}


	@Then("^user should click login button$")
	public void user_should_click_login_button(){
		cp.userClickLogin();
	    
	}

	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\" in login page$")
	public void user_enters_and_in_login_page(String username, String password){
		cp.enterUsernameAndPassword(username, password);
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button(){
	    cp.clickLoginButton();
	}

	@Then("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable{
		Thread.sleep(2000);
		Boolean boolean1 = cp.checkUserName("Parth Patel");
		Assert.assertTrue(boolean1);
	}

	@Then("^user move to new contact page$")
	public void user_move_to_new_contact_page(){
		
		cp.userMoveToNewContact();
	}

	
	@Then("^user enters contact details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_Contact_Details(String firstname, String lastname, String position){
		cp.userEnterContactDetails(firstname, lastname, position);
	}

	@After
	public void wrapUp(){
	    cp.closeTheBrowser();
	}

}
