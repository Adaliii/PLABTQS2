package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.When;

public class GlobalSteps {
	public static WebDriver driver = Global.getDriver();
	
	
	@When("the user selects some value by id {string} {string}")
    public void theUserSelectsSomething(String id, String value) {
    	Select var = new Select(driver.findElement(By.id(id)));
    	var.selectByVisibleText(value);
    }
	
	@When("the user enters data by id {string} {string}")
    public void theUserEntersData(String id, String value) {
    	driver.findElement(By.id(id)).sendKeys(value);
    }
}
