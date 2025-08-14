package TestRunners;
import TestBases.TestBase;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
      features ={"src/test/java/Features"},
       glue = {"StepDefs","Utilities"},
        tags ="@SavingPotProduct and @Android",
       plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","Utilities.TestListeners.Listeners"}

)
public class AndroidRunnerTwoTest extends TestBase {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
