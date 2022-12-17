import io.cucumber.testng.AbstractTestNGCucumberTests;  
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/product.feature", glue="steps", tags="@AddItemToCart")
public class ProductTest extends AbstractTestNGCucumberTests{

	
}
