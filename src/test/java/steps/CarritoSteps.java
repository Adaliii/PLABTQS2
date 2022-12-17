package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoSteps {

	public static WebDriver driver = Global.getDriver();
	
	
	@Given("the user enters the cart page")
	public void theUserEntersTheCartPage() {
		driver.findElement(By.partialLinkText("Cart")).click();
	}
	
	@Given("the user has added an item to the cart")
	public void theUserHasAddedAnItemToTheCart() {
		driver.findElement(By.partialLinkText("Products")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.className("add-to-cart")).click();
		
	}
	@When("the user clicks the here button")
	public void theUserClicksTheHereButton() {
		driver.findElement(By.xpath("//span//a")).click();
	}
	@When("the quantity of the product is {string}")
	public void theQuantityOfTheProductIsNumber(String q) {
		String quantity = driver.findElement(By.cssSelector(".disabled")).getText();
		Assert.assertTrue(q.equals(quantity));
		driver.findElement(By.className("cart_quantity_delete")).click();
		/*driver.navigate().to("https://automationexercise.com");
		*/driver.findElement(By.linkText("Logout")).click();
	
	}
	@When("the user erases the product")
	public void theUserErasesTheProduct() {
		driver.findElement(By.className("cart_quantity_delete")).click();
	}
	
	@Then("the cart is empty")
	public void theCartIsEmpty() throws InterruptedException {
		Thread.sleep(1000);
		String state = driver.findElement(By.xpath("//span[@id='empty_cart']/p/b")).getText();
		Assert.assertTrue(state.contains("Cart is empty!"));
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@Then("the user is redirected to the products page")
	public void theUserIsRedirectedToTheProductsPage() {
		String title = driver.findElement(By.className("features_items")).getText();
		Assert.assertTrue(title.contains("ALL PRODUCTS"));
	}
	
	
}
