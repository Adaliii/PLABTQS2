package steps;

import org.openqa.selenium.By; 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterTestSteps {
    
    static WebDriver driver;
    
    @Given("the user is in the login or signup page")
    public void theUserIsInTheLoginOrSignupPage() {
        System.setProperty("webdriver.gecko.driver", "Drivers/chromedriver.exe");
        driver = Global.getDriver();
        driver.navigate().to("https://automationexercise.com");
        driver.findElement(By.partialLinkText("Signup")).click();
    }
    
    @When("the user puts his name")
    public void theUserPutsHisName() {
    	driver.findElement(By.name("name")).sendKeys("Mister");;
    }
    
    @When("the user puts his email address")
    public void theUserPutsHisEmailAddress() {
    	driver.findElement(By.xpath("//html//body//div[3]//div//form//input[3]")).sendKeys("hahahaha@gmail.com");
    }
    
    @When("the user clicks the signup button")
    public void theUserClicksTheSignUpButton() {
    	driver.findElement(By.xpath("//html//body//div[3]//div//form//button")).click();
    }
    
    @When("the user selects male gender")
    public void theUserSelectsMaleGender() {
    	driver.findElement(By.id("id_gender1")).click();
    }
    /*
    @When("the user selects something {string} {string}")
    public void theUserSelectsSomething(String id, String value) {
    	Select var = new Select(driver.findElement(By.id(id)));
    	var.selectByVisibleText(value);
    }
 */
    @When("the user clicks button account")
    public void theUserClicksButtonAccount(){
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,200)", "");
    	driver.findElement(By.xpath("//button")).click();
    }
    
    @Then("I validate account is created")
    public void iValidateTheOutcomes() {
    	String text = driver.findElement(By.xpath("//b")).getText();
    	Assert.assertTrue(text.equals("ACCOUNT CREATED!"));
    	driver.navigate().to("https://automationexercise.com");
    	driver.findElement(By.linkText("Logout")).click();
    	}
    
    @Then("the website shows mail is used")
    public void theMailIsUsed() {
    	String text = driver.findElement(By.cssSelector("p:nth-child(5)")).getText();
    	Assert.assertTrue(text.equals("Email Address already exist!"));
    }
    /*
    @When("the user enters data {string} {string}")
    public void theUserEntersData(String id, String value) {
    	driver.findElement(By.id(id)).sendKeys(value);
    }
    */
    
    
    
}