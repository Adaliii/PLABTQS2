package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProducteInfoSteps {
	
	public static WebDriver driver = Global.getDriver();
	
	@Given("the user enters the website")
	public void theUserIsInIndexPage() {
		driver.navigate().to("https://automationexercise.com/");
	}
	
	@When("the user clicks ViewProduct of the first product")
	public void theUserViewsFirstProduct() { 
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a")).click();
	}
	
	@Then("the user is in the product information page")
	public void verifyProductInfoShows() {
		Assert.assertTrue(driver.findElement(By.className("product-information")).isDisplayed());
	}
	
	@When("the user adds product to cart")
	public void addToCart() {
		driver.findElement(By.className("cart")).click();
	}
	
	
	
	@When("the user clicks the button submit")
	public void userSubmitsButton() {
		driver.findElement(By.id("button-review")).click();
	}
	
	@Then("verify that the website gets the review")
	public void websiteGetsReview() {
		Assert.assertTrue(driver.findElement(By.id("review-section")).isEnabled());
	}
	
	@Then("checks the item is in the cart")
	public void theItemIsInTheCart() {
		driver.navigate().to("https://automationexercise.com/view_cart");
		String quantity = driver.findElement(By.cssSelector(".disabled")).getText();
		Assert.assertTrue(quantity.equals("1"));
		driver.findElement(By.className("cart_quantity_delete")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
}
