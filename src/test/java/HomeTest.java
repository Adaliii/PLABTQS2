import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/home.feature",  glue="steps")
public class HomeTest extends AbstractTestNGCucumberTests {
	
	
}