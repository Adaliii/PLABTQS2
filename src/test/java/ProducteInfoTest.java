import io.cucumber.testng.AbstractTestNGCucumberTests;  
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/producteInfo.feature", glue="steps")
public class ProducteInfoTest extends AbstractTestNGCucumberTests{
	
}
