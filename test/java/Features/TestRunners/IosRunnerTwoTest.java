package TestRunners;
import TestBases.TestBase;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
      features ={"src/test/java/Features"},
       glue = {"StepDefs","Utilities"},
        tags ="@Passcode122 and @iOS and @SitSmoke",
       plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","Utilities.TestListeners.Listeners"}

)
public class IosRunnerTwoTest extends TestBase {

}
