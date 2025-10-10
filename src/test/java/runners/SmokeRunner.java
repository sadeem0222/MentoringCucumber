package runners;




import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        tags = "@smoke",
        dryRun = false,
        plugin = {
                "html:target/reports/html-reports/cucumber.html",
                "json:target/reports/json-reports/cucumber.json",
                "junit:target/reports/xml-reports/cucumber.xml",
                "pretty",
                "rerun:target/failedScenarios.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // For Spark report
        }

)
public class SmokeRunner {
}