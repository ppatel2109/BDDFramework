package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignupPage {

	WebDriver driver;
	
	public void openBrowser() {
		driver = new FirefoxDriver();;
		System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJar\\geckodriver.exe");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void openPage() {
		driver.get("https://freecrm.com/");
	}
	
	public void clickOnSignUp() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).click();

	}
	
	public String emailError() {
		String error = driver.findElement(By.xpath("//li[contains(text(),'Email is required')]")).getText().toString();
		return error;
	}
	
	public void verifyEmail(String email, String number, String country) {
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.xpath("//input[@class='search']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'"+country+"')]")).click();
		driver.findElement(By.id("phone_number")).sendKeys(number);
		
	}
	public void clickOnSignUpBtn() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	
	public String checkTitle() {
		return driver.getTitle().toString();
	}

	public void clickOnSignupBtn() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public int countryCount() {
		driver.findElement(By.xpath("//div[contains(text(),'Canada')]")).click();
		List<WebElement> countryListCount = driver.findElements(By.xpath("//div[@class='menu transition visible']/div"));
		return countryListCount.size();
	}
	public void closeTheBrowser() {
		driver.quit();
	}

}
