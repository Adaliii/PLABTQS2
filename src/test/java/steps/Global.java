package steps;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class Global {
	private static WebDriver driver;
	public Global(){
		ChromeOptions options = new ChromeOptions().addArguments("start-maximized").addExtensions(new File("Drivers/extension_5_3_2_0.crx"));
        driver = new ChromeDriver(options);
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
	}
	public static WebDriver getDriver() {
		return driver;
	}
	
}


