package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	static WebDriver driver = Global.getDriver();
	
	
	
	@Then("I validate the login was correct")
	public void iValidateTheLoginWasCorrect() {
		String text = driver.findElement(By.linkText("Logout")).getText();
		Assert.assertTrue(text.equals("Logout"));
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@Then("I validate the login was incorrect")
	public void iValidateTheLoginWasIncorrect() {
		String text = driver.findElement(By.xpath("//html//body//section//div//div//div[1]//div//form//p")).getText();
		Assert.assertTrue(text.equals("Your email or password is incorrect!"));
	}
} 