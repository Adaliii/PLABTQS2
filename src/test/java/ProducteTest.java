import io.cucumber.testng.AbstractTestNGCucumberTests;  
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/producte.feature", glue="steps")
public class ProducteTest extends AbstractTestNGCucumberTests{

	
}
