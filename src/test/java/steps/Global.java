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


public final class Global {
	private static WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--incognito"));
	private Global() {
		ChromeOptions options = new ChromeOptions();
    	options.addArguments("--incognito");
        System.setProperty("webdriver.gecko.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
	}
	public static WebDriver getDriver() {
		return driver;
	}
	
	
}
