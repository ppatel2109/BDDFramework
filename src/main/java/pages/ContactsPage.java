package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	WebDriver driver = new FirefoxDriver();

	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJar\\geckodriver.exe");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}

	public void openPage() {
		driver.get("https://freecrm.com/");
	}

	public String checkTitle() {
		String title = driver.getTitle().toString();
		System.out.println(title);
		return title;
	}

	public String checkCopyrightText() {
		String copyrightText = driver.findElement(By.xpath("//p[contains(text(),'©')]")).getText().toString();
		System.out.println(copyrightText);
		return copyrightText;
	}

	public String checkContactDetails() {
		String contactText = driver.findElement(By.xpath("//section[@id='third']")).getText().toString();
		System.out.println(contactText);
		return contactText;
	}

	public void closeTheBrowser() {
		driver.quit();
	}

}
