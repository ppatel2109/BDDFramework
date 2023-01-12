package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DocumentsPage {
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
	
	public void enterUsernameAndPassword(String email, String password) {
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
	}
	
	public Boolean checkUserName(String name) {
		
		Boolean boolean1 = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]")).isDisplayed();
		return boolean1;
	}
	
	public void userMoveToNewDocument() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Deal')]"))).build().perform();
		driver.findElement(By.xpath("//div[@id='main-nav']//div[9]//button/i")).click();
		}
	
	public void document(String title, String desc) {
		driver.findElement(By.name("title")).sendKeys(title);
		driver.findElement(By.xpath("//textarea[@autocomplete='new-password']")).sendKeys(desc);
		driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
	}

	public void closeTheBrowser() {
		driver.quit();
	}
}
