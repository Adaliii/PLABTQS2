package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {

	public static WebDriver driver = Global.getDriver();
	
	@When("the user clicks the checkout button")
	public void theUserClicksTheCheckoutButton() {
		driver.findElement(By.linkText("Proceed To Checkout")).click();
	}
	
	@When("the user clicks the place order button")
	public void theUserClicksThePlaceOrderButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,1000)", "");
    	driver.findElement(By.className("form-control")).sendKeys("This is a test comment and it is as useless as the subject Requisits de Software");
    	driver.findElement(By.linkText("Place Order")).click();
	}
	
	@When("the user clicks the pay and confirm order button")
	public void theUserClicksThePayAndConfirmOrderButton() {
		driver.findElement(By.id("submit")).click();
	}
	
	@Then("order placed appears")
	public void orderPlacedAppears() throws InterruptedException {
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//body//section//b")).getText();
    	Assert.assertTrue(text.equals("ORDER PLACED!"));
    	driver.findElement(By.linkText("Logout")).click();
    	
	}
}