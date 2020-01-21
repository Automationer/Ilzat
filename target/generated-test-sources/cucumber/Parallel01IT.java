import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"/Users/yilizatiabudusaimaiti/Desktop/HomeDepot_ExtentReport/src/test/resources/features/CreateAccount_Feature.feature"},
        plugin = {"json:/Users/yilizatiabudusaimaiti/Desktop/HomeDepot_ExtentReport/target/cucumber-parallel/1.json"},
        monochrome = false,
        tags = {},
        glue = {"com.homedepot"})
public class Parallel01IT {
}
