import io.cucumber.testng.AbstractTestNGCucumberTests; 
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/contacte.feature", glue="steps")
public class ContacteTest extends AbstractTestNGCucumberTests {
	
}