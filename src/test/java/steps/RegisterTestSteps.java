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
    
    @Given("the user is in the home page")
    public void theUserIsInTheIndexPage() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--incognito");
        System.setProperty("webdriver.gecko.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://automationexercise.com");
    }
    
    @When("the user clicks the signup or login button")
    public void theUserClicksTheSignUpOrLoginOption() {
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
    @When("the user enters personal data")
    public void theUserEntersPersonalData() {
    	driver.findElement(By.id("id_gender1")).click();
    	driver.findElement(By.id("password")).sendKeys("contrasenya");
    	Select dia = new Select(driver.findElement(By.id("days")));
    	dia.selectByVisibleText("17");
    	Select mes = new Select(driver.findElement(By.id("months")));
    	mes.selectByVisibleText("January");
    	Select any = new Select(driver.findElement(By.id("years")));
    	any.selectByVisibleText("2003");
    	driver.findElement(By.id("first_name")).sendKeys("Juan");
    	driver.findElement(By.id("last_name")).sendKeys("Garcia");
    	driver.findElement(By.id("address1")).sendKeys("Carrer Tus Muertos A Caballo numero 13");
    	Select pais = new Select(driver.findElement(By.id("country")));
    	pais.selectByVisibleText("Israel");
    	driver.findElement(By.id("state")).sendKeys("nose");
    	driver.findElement(By.id("city")).sendKeys("Haifa");
    	driver.findElement(By.id("zipcode")).sendKeys("12345");
    	driver.findElement(By.id("mobile_number")).sendKeys("123456789");
    }
    /*
    @When("the user selects male gender")
    public void theUserSelectsMaleGender() {
    	driver.findElement(By.id("id_gender1")).click();
    }

    @When("the user inserts a password")
    public void theUserInsertsPassword() {
    	//password
    	driver.findElement(By.id("password")).sendKeys("contrasenya");
    }
    
    @When("the user selects date of birth")
    public void theUserSelectsDateOfBirth() {
    	Select dia = new Select(driver.findElement(By.id("days")));
    	dia.selectByVisibleText("17");
    	Select mes = new Select(driver.findElement(By.id("months")));
    	mes.selectByVisibleText("January");
    	Select any = new Select(driver.findElement(By.id("years")));
    	any.selectByVisibleText("2003");
    }
    
    @When("the user enters first name")
    public void theUserEntersFirstName() {
    	driver.findElement(By.id("first_name")).sendKeys("Juan");
    }
    @When("the user enters last name")
    public void theUserEntersLastName() {
    	driver.findElement(By.id("last_name")).sendKeys("Garcia");
    }
    
    @When("the user enters address")
    public void theUserEntersAddress() {
    	driver.findElement(By.id("address1")).sendKeys("Carrer Tus Muertos A Caballo numero 13");
    }
    
    @When("the user selects country")
    public void theUserSelectsCountry() {
    	Select pais = new Select(driver.findElement(By.id("country")));
    	pais.selectByVisibleText("Israel");
    }
    
    @When("the user enters state")
    public void theUserEntersState() {
    	driver.findElement(By.id("state")).sendKeys("nose");
    }
    
    @When("the user enters city")
    public void theUserEntersCity() {
    	driver.findElement(By.id("city")).sendKeys("Haifa");
    }
    
    @When("the user enters zipcode")
    public void theUserEntersZipcode() {
    	driver.findElement(By.id("zipcode")).sendKeys("12345");
    }
    
    @When("the user enters mobile number")
    public void theUserEntersMobileNumber(){
    	driver.findElement(By.id("mobile_number")).sendKeys("123456789");
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
    	driver.findElement(By.xpath("//body//section//div//div//div//div//a")).click();
    	//driver.findElement(By.xpath("//body//div//div//div//div[2]//div//ul//li[5]//a")).click();
    }
    
    @Then("the website shows mail is used")
    public void theMailIsUsed() {
    	String text = driver.findElement(By.cssSelector("p:nth-child(5)")).getText();
    	Assert.assertTrue(text.equals("Email Address already exist!"));
    }
   
    @After
    public void closeDriver() {
    	driver.close();
    }
    
}