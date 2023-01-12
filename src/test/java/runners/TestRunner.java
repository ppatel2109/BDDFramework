package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\QA\\Selenium_Workspace\\BDDFramework\\src\\test\\java\\feature\\login.feature"},//the path of the feature files
		glue = {"stepDefination"},//step Definition Package Name
				format= {"pretty","html:test-output"},
		dryRun = false,
		monochrome = true,
		strict = true
		)


public class TestRunner {
	
	

}
