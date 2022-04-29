package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src/test/java/Feature",
		glue="StepDefinationfile",
		tags="@Regression",
		plugin="pretty",
		monochrome=true,
		dryRun=false
		      )




public class Runner 
{

	
	
	
}
