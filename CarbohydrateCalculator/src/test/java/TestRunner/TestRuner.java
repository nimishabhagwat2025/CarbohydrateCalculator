package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features= {"src/test/resources/Features"} , glue = {"StepDefinition","Hooks"},plugin = {"pretty","html:target/CalculatorReport.html"})


public class TestRuner extends AbstractTestNGCucumberTests{

}
