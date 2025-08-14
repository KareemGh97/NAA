package TestRunners;

import TestBases.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features ={"src/test/java/Features"},
        glue = {"StepDefs","Utilities"},
        tags ="@SignIn and @Android and @SitSmoke and @Device3",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","Utilities.TestListeners.Listeners"})

public class AndroidRunnerThreeTest extends TestBase {

}
