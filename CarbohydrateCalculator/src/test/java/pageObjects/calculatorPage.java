package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import StepDefinition.CalculatorStepsDefinition;
import io.cucumber.core.logging.Logger;

public class calculatorPage {

	// WebDriver driver;
	By txt_age = By.id("cage");
	By male_gender = By.xpath("//label[@for='csex1']/span[1]");
	By female_gender = By.xpath("//label[@for='csex2']/span[1]");
	By txt_height = By.id("cheightmeter");
	By txt_weight = By.id("ckg");
	By button_clear = By.xpath("//input[@value = 'Clear']");
	By button_submit = By.xpath("//input[@value = 'Calculate']");
	By span_result = By.xpath("//h2[@class = 'h2result']");
	By dd_activity = By.id("cactivity");
	By txt_Error = By.xpath("//div[@id='content']/div[3]");

	public void enterInputs(String age, String gender, String height, String weight, String activity) {

		try {
			CalculatorStepsDefinition.driver.findElement(button_clear).click();
			CalculatorStepsDefinition.driver.findElement(txt_age).sendKeys(age);
			if (gender == "Female")
				CalculatorStepsDefinition.driver.findElement(female_gender).click();
			else
				CalculatorStepsDefinition.driver.findElement(male_gender).click();
			CalculatorStepsDefinition.driver.findElement(txt_height).sendKeys(height);
			CalculatorStepsDefinition.driver.findElement(txt_weight).sendKeys(weight);
			Select dropdown = new Select(CalculatorStepsDefinition.driver.findElement(dd_activity));
			dropdown.selectByContainsVisibleText(activity);
		} catch (NoSuchElementException e) {

			Assert.fail("Element not found");
		}
	}

	public void clickOnSubmit() {
		try {

			CalculatorStepsDefinition.driver.findElement(button_submit).click();
		} catch (NoSuchElementException e) {
			// System.out.println("Result not calculated");
			Assert.fail("Element not found");
		}
	}

	public void checkIfResultIsSeen() {
		try {
			WebDriverWait wait = new WebDriverWait(CalculatorStepsDefinition.driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(span_result));
		} catch (NoSuchElementException e) {
			// System.out.println("Result not calculated");
			Assert.fail("Result not calculated");
		}
	}

	public void checkIfErrorIsSeen(String error) {
		try {
			boolean found = false;
			List<WebElement> ele = CalculatorStepsDefinition.driver.findElement(txt_Error)
					.findElements(By.tagName("div"));
			for (WebElement e : ele)
				if (e.getText().equals(error))
					found = true;

			Assert.assertTrue(found);
		} catch (Exception e) {
			// System.out.println("Result not calculated");
			Assert.fail("Error not seen");
		}
	}
}
