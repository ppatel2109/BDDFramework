package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUserContactPage {


	WebDriver driver;
	
	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJar\\geckodriver.exe");
		driver = new FirefoxDriver(); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void openLoginPage() {
		driver.get("https://freecrm.com/");
	}
	
	public String getTitle() {
		String actualTitle = driver.getTitle();
		 System.out.println(actualTitle);
		//Assert.assertEquals("Free CRM with Free calling and auto dialing features", actualTitle);
		return actualTitle;
	}

	
	public void userClickLogin() {
		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		   
	}
	
	public void enterUsernameAndPassword(String a, String b) {
		driver.findElement(By.name("email")).sendKeys(a);
		driver.findElement(By.name("password")).sendKeys(b);
	}
	
	public void clickLoginButton() {
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
	}
	
	public Boolean checkUserName(String name) {
		
		Boolean boolean1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]")).isDisplayed();
		return boolean1;
	}
	
	public void userMoveToNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Contacts')]"))).build().perform();
		driver.findElement(By.xpath("//div[@id='main-nav']//div[3]//button/i")).click();
		}
	
	public void userEnterContactDetails(String p, String q, String r) {
		driver.findElement(By.name("first_name")).sendKeys(p);
		driver.findElement(By.name("last_name")).sendKeys(q);
		driver.findElement(By.name("position")).sendKeys(r);
		driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
	}
	
	public void closeTheBrowser() {
		driver.quit();
	}
}
