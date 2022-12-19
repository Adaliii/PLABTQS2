package steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By; 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {
    
    static WebDriver driver = Global.getDriver();

    @When("the user puts his name")
    public void theUserPutsHisName() {
    	driver.findElement(By.name("name")).sendKeys("Mister");;
    }
    
    @When("the user puts his email address")
    public void theUserPutsHisEmailAddress() {
    	driver.findElement(By.xpath("//html//body//div[3]//div//form//input[3]")).sendKeys("NoSoyUnBot@Bot.Cat");
    }
    
    @When("the user clicks the signup button")
    public void theUserClicksTheSignUpButton() {
    	driver.findElement(By.xpath("//html//body//div[3]//div//form//button")).click();
    }
    
    @When("the user selects male gender")
    public void theUserSelectsMaleGender() {
    	driver.findElement(By.id("id_gender1")).click();
    }
    
	@When("the user clicks button account")
    public void theUserClicksButtonAccount(){
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,200)", "");
    	driver.findElement(By.xpath("//button")).click();
    }
    
    @When("the user deletes account")
    public void theUserDeletesAccount() {
    	driver.findElement(By.linkText("Delete Account")).click();
    }
    
    @Then("I validate account is created")
    public void iValidateTheOutcomes() {
    	String text = driver.findElement(By.xpath("//b")).getText();
    	Assert.assertTrue(text.equals("ACCOUNT CREATED!"));
    	}
    
    @Then("the website shows mail is used")
    public void theMailIsUsed() {
    	String text = driver.findElement(By.cssSelector("p:nth-child(5)")).getText();
    	Assert.assertTrue(text.equals("Email Address already exist!"));
    }
    
    @Then("I validate account has been deleted")
    public void iValidateAccountIsDeleted() throws InterruptedException {
    	Thread.sleep(1000);
    	driver.switchTo().defaultContent();
    	String text = driver.findElement(By.xpath("//b")).getText();
    	System.out.println(text);
    	Assert.assertTrue(text.equals("ACCOUNT DELETED!"));
    }
        
}