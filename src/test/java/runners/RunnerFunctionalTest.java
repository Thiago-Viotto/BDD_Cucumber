package runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"}, 
		monochrome = true, 
		snippets = SnippetType.CAMELCASE, 
		features = "src/test/resources/features/", 
		glue="steps",
		tags = "@movimentacao",
		dryRun = false
//		tags = "@regression"
//		tags = "@feature"
//		tags = "(@smoke or @fast) and (not ignore)"
		)

public class RunnerFunctionalTest {
	public WebDriver driver;
	
	public RunnerFunctionalTest() {
		driver = new ChromeDriver();
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
