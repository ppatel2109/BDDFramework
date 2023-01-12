package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	WebDriver driver = new FirefoxDriver();
	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJar\\geckodriver.exe");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void openPage() {
		driver.get("https://ui.freecrm.com/");
	}
	
	public String checkTitle() {
		return driver.getTitle().toString();
	}

	public void login(String username, String pwd) {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		
	}
	
	public Boolean checkUserName(String name) {
		return driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]")).isDisplayed();
	}
	
	public void clickOnLogin() {
		driver.findElement(By.xpath("//div[contains(@class,\"submit button\")]")).click();
	}

	public void closeTheBrowser() {
		driver.quit();
	}


}
