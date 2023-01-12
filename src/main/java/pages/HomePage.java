package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;


public class HomePage {

	WebDriver driver;
	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJar\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void openPage(){
		driver.get("https://freecrm.com/");
	}
	
	public String checkTitle() {
		return driver.getTitle().toString();
	}

	public void clickOnSignUp() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).click();

	}

	public void clickOnContacts() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contact")).click();
	}

	public void clickOnCustomers() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Customers")).click();
	}

	public boolean checkIcon() {
		Boolean b = driver.findElement(By.cssSelector("img[alt='cogmento small logo']")).isDisplayed();
		return b;
	}

	public boolean checkService1Icon() {
		Boolean b = driver.findElement(By.xpath("//i[@class='fa fa-users skrollable skrollable-after']")).isDisplayed();
		return b;
	}

	public String headerText() {
		String text = driver.findElement(By.xpath("//h1[@class='txt-white']")).getText().toString();
		return text;
	}

	public int serviceListCount() {
		List<WebElement> servicesList= driver.findElements(By.xpath("//section[@id='services']/div[1]/div[1]/div"));
		return servicesList.size();
	}

	public String services1Title1() {
		String text = driver.findElement(By.xpath("//h5[contains(text(),'Service')]")).getText().toString();
		return text;
	}

	public String services1Title2() {
		String text = driver.findElement(By.xpath("//h5[contains(text(),'Free CRM Click to Call')]")).getText().toString();
		return text;
	}

	public String services1Desc() {
		String text = driver.findElement(By.xpath("//p[contains(text(),\"Convert leads into accounts faster with the world'\")]")).getText().toString();
		return text;
	}

	public void closeTheBrowser() {
		driver.close();
	}

}
