package TestRunners;

import TestBases.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features ={"src/test/java/Features"},
        glue = {"StepDefs","Utilities"},
        tags ="@Device3 and @Android and @SIT",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","Utilities.TestListeners.Listeners"}

)

public class IosRunnerThreeTest extends TestBase {
//
}
