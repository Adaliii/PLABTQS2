package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class HomeSteps {

	public static WebDriver driver = Global.getDriver();
	
	@And("the user puts their email address")
	public void theUserAddsEmail() {
		//driver.findElement(By.partialLinkText("subscribe_email")).click();
		driver.findElement(By.id("susbscribe_email")).sendKeys("NoSoyUnBot@Bot.Cat");
	}
	
	@And("the user puts their name")
	public void theUserAddsName() {
		//driver.findElement(By.partialLinkText("subscribe_email")).click();
		driver.findElement(By.id("susbscribe_email")).sendKeys("Carl");
	}
	
	@And("the user clicks the arrow button")
	public void theUserClicksArrowButton() {
		driver.findElement(By.id("subscribe")).click();
	}
	
	@Then("the website shows that user has been successfully subscribed")
	public void thewebsiteShowsUserSubscribedSuccesfully() {
		Assert.assertTrue(driver.findElement(By.id("success-subscribe")).isEnabled());
	}
	
	@Then("the website does not subscribe the user")
	public void thewebsiteShowsIncorrectFormat() {
		Assert.assertTrue(driver.findElement(By.id("success-subscribe")).isEnabled());
	}

    @And("the user clicks the logout button")
    public void userLogsOut() {
    	driver.findElement(By.linkText("Logout")).click();
    }
    
    @Then("the user is in the signup or login page")
    public void userNotLoggedIn() {
    	//String page = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/h2")).getText();
    	//Assert.assertTrue(page.contains("Login"));
    	Assert.assertTrue(!driver.findElements(By.partialLinkText("Login")).isEmpty());
    }
}
