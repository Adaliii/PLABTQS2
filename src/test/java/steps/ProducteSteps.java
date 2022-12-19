package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProducteSteps {
	public static WebDriver driver = Global.getDriver();
	
	@When("the user enters {string} in the search bar")
	public void theUserEntersProductInTheSearchBar(String product) {
		driver.findElement(By.id("search_product")).sendKeys(product);
	}
	
	@When("the user clicks the search button")
	public void theUserClicksTheSearchButton() {
		driver.findElement(By.id("submit_search")).click();
	}
	
	@When("the user selects the {string} and the {string}")
	public void theUserSelectsTheCategoryAndTheType(String cat, String tp) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.xpath(cat)).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(tp)).click();
		Thread.sleep(500);
	}
	
	@When("the user adds blue top to the cart")
	public void theUseraddsBlueTopToTheCart() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)", "");
		driver.findElement(By.className("add-to-cart")).click();
	}
	
	@When("the user goes to the cart page")
	public void theUserGoesToTheCartPage() {
		driver.findElement(By.partialLinkText("Cart")).click();
	}
	
	@When("the user selects the {string} brand")
	public void theUserSelectsTheBrand(String brand) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,650)", "");
    	driver.findElement(By.xpath(brand)).click();
	}
	@Then("the product list appears")
    public void theProductListAppears() {
        String title = driver.findElement(By.className("features_items")).getText();
        Assert.assertTrue(title.contains("SEARCHED PRODUCTS"));
    }
	
	@Then("the products from {string} appear")
	public void theProductsFromFilterAppear(String filter) {
		String title = driver.findElement(By.className("features_items")).getText();
        Assert.assertTrue(title.contains(filter));
	}
	
	@Then("there is a blue top in the cart")
	public void thereIsAProductInTheCart() {
		String productName = driver.findElement(By.linkText("Blue Top")).getText();
		Assert.assertTrue(productName.equals("Blue Top"));
		driver.findElement(By.className("cart_quantity_delete")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
}
