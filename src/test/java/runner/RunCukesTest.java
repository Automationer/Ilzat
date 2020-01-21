package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"
                , "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/myReport.html"}
        , monochrome = true
        , features = "src/test/resources/features"
        , glue = {"com.homedepot"}
        , tags = "@SmokeTest"
)
public abstract class RunCukesTest {

    public abstract void hello();

}
