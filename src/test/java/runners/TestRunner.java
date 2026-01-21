package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //1. Specify the path to the feature files
        features = "src/test/java/features",
        // 2. Where is your Java code (Step Definitions)?
        // Provide the package name where your Java methods are located
        glue = {"step_definitions"},
        //3. Optional: Specify tags to filter which scenarios to run
        //EXAMPLE: tags = "@login",
        // 3. How should the output look?
        // "pretty" makes the console output readable; "json" creates reports.
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        //5. Optional: Makes the console output more readable (removes unreadable characters)
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
