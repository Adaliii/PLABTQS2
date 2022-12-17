import io.cucumber.testng.AbstractTestNGCucumberTests; 
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/carrito.feature", glue="steps")
public class CarritoTest extends AbstractTestNGCucumberTests {
	
}