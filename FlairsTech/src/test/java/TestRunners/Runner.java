package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/AddNewUser.feature", // Path to feature files
        glue = "gui.steps", // Package containing step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class Runner {
}
