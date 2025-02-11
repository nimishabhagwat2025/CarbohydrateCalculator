package Hooks;

import StepDefinition.CalculatorStepsDefinition;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CalculatorHooks {

	@After
	public void tearDown() {
		if (CalculatorStepsDefinition.driver != null) {
			// captureReport(scenario, driver);
			CalculatorStepsDefinition.driver.quit();
		}
	}

}
