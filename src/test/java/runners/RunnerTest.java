package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"}, 
		monochrome = true, 
		snippets = SnippetType.CAMELCASE, 
		features = "src/test/resources/features/cadastro_conta.feature", 
		glue="steps",
		tags = "not @ignore"
//		tags = "@regression"
//		tags = "@feature"
//		tags = "(@smoke or @fast) and (not ignore)"
		)

public class RunnerTest {

}
