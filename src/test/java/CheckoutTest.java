import io.cucumber.testng.AbstractTestNGCucumberTests; 
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/checkout.feature", glue="steps", tags="@DoCheckout")
public class CheckoutTest extends AbstractTestNGCucumberTests {
	
}