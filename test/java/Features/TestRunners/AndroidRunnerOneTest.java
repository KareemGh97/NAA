package TestRunners;
import TestBases.TestBase;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
      features ={"src/test/java/Features"},
       glue = {"StepDefs","Utilities"},
        tags = "@Smoke and @Android and @UAT and not @unleashFeatureDisabled and not @not_on_UAT_yet",
//        tags = "(@Gold or @MutualFund or @SavingPotProduct or @Documents or @AccountFinder or @Signin or @nera or @DebitCard or @Passcode) and @Android and @UAT and not @needsOnboarding and not @unleashFeatureDisabled and not @not_on_UAT_yet",
       plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
               "json:target/CucumberResults.json",//XRAY
               "Utilities.TestListeners.Listeners"
               }

)
public class AndroidRunnerOneTest extends TestBase {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}