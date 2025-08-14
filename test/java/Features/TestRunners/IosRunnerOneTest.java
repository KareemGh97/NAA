package TestRunners;
import TestBases.TestBase;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
      features ={"src/test/java/Features"},
       glue = {"StepDefs","Utilities"},
        tags ="@iOS and @SIT and @Smoke",
//        tags ="@iOS and @UATSmoke ",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "json:target/CucumberResults.json",//XRAY
                "Utilities.TestListeners.Listeners"}

)
public class IosRunnerOneTest extends TestBase {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
