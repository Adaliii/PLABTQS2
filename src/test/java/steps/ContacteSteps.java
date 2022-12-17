package steps;

import org.openqa.selenium.By; 
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContacteSteps {
	
	public static WebDriver driver = Global.getDriver();
	
	@Given("the user enters the Contact us page")
	public void theUserIsInTheContactPage() {
		driver.findElement(By.linkText("Contact us")).click();
	}
	
	@When("the user clicks the submit button")
	public void theUserClicksTheSubmitButton() {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
    	//js.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.name("submit")).click();
		driver.switchTo().alert().accept();
	}
	
	@Then("I validate the form was submitted")
	public void iValidateTheFormWasSubmitted() {
		Assert.assertTrue(driver.findElement(By.className("alert-success")).getText().equals("Success! Your details have been submitted successfully."));
	}
}
