package steps;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GlobalSteps {
	public static Global g = new Global();
	public static WebDriver driver = g.getDriver();
	
	@Given("the user is in the index page")
    public void theUserIsInTheIndex() throws InterruptedException {
		Thread.sleep(2000);
        driver.navigate().to("https://automationexercise.com");
    }
	
	@Given("the user enters the signup or login page")
	public void theUserEntersTheSignupOrLoginPage() {
		driver.findElement(By.partialLinkText("Signup")).click();
	}
	
	@Given("the user is logged in")
	public void theUserIsLoggedIn() {
		driver.findElement(By.partialLinkText("Signup")).click();
		driver.findElement(By.xpath("//html//body//div[1]//div//form//input[2]")).sendKeys("NoSoyUnBot@Bot.Cat");
		driver.findElement(By.name("password")).sendKeys("123456789");
		driver.findElement(By.tagName("button")).click();
	}
	
	@Given("the user enters the products page")
	public void theUserEntersTheProductsPage() {
		driver.findElement(By.partialLinkText("Products")).click();
	}
	
	@When("the user selects some value by id {string} {string}")
    public void theUserSelectsSomething(String id, String value) {
    	Select var = new Select(driver.findElement(By.id(id)));
    	var.selectByVisibleText(value);
    }
	
	@When("the user enters data by xpath {string} {string}")
    public void theUserEntersDataByXpath(String xpath, String value) {
    	driver.findElement(By.xpath(xpath)).sendKeys(value);
    }
	
	@When("the user enters data by id {string} {string}")
    public void theUserEntersDataById(String id, String value) {
    	driver.findElement(By.id(id)).sendKeys(value);
    }
	
	@When("the user returns to home page")
	public void theUserReturnToHomePage() {
		driver.navigate().to("https://automationexercise.com");
	}
	
	@When("the user enters data by name {string} {string}")
	public void theUserEntersDataByName(String name, String value) {
		driver.findElement(By.name(name)).sendKeys(value);
	}
	
	@AfterAll
	public static void closeDriver() {
		driver.quit();
	}
	
	
}
