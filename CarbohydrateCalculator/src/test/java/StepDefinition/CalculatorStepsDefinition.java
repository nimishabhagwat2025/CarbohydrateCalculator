package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.calculatorPage;

public class CalculatorStepsDefinition {

	public static WebDriver driver;
	calculatorPage calcPage;

	@Given("User is on Carbohydrate Calculator")
	public void user_is_on_carbohydrate_calculator() {
		// Write code here that turns the phrase above into concrete actions
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.calculator.net/carbohydrate-calculator.html");
		calcPage = new calculatorPage();
	}

	@When("the user enters the fields {string} {string} {string} {string} {string}")
	public void the_user_enters_the_fields_female_sedentary_little_or_no_exercise(String age, String gender,
			String height, String weight, String activity) {
		// Write code here that turns the phrase above into concrete actions

		calcPage.enterInputs(age, gender, height, weight, activity);
	}

	@Then("the result is calculated correctly")
	public void the_result_is_calculated_correctly() {
		calcPage.checkIfResultIsSeen();
	}

	@When("the user clicks on Submit")
	public void the_user_clicks_on_submit() {
		// Write code here that turns the phrase above into concrete actions
		calcPage.clickOnSubmit();
	}

	@Then("the correct {string} should be seen")
	public void the_correct_should_be_seen(String error) {
		// Write code here that turns the phrase above into concrete actions
		calcPage.checkIfErrorIsSeen(error);
	}

}