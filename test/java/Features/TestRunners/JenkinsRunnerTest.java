package TestRunners;
import TestBases.TestBase;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


@CucumberOptions(
      features ={"src/test/java/Features"},
       glue = {"StepDefs","Utilities"},
        tags ="@default",//"@Android and @SIT and @SitSmoke and @Signin",
       plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
               "json:target/CucumberResults.json",//XRAY
               "Utilities.TestListeners.Listeners"
      }

)
public class JenkinsRunnerTest extends TestBase {


    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


    public  String runtimeTags; // Default tags

    @Parameters({"environment", "platformName", "executionCycle", "featureNameTag"})
    public JenkinsRunnerTest(String environment, String platformName, String executionCycle, String featureNameTag) {
        // Validate required parameters
        TestBase.executionCycle=executionCycle;
        if (isNullOrEmpty(environment) || isNullOrEmpty(platformName) || isNullOrEmpty(executionCycle)) {
            throw new IllegalArgumentException("Required parameters are missing: environment, platformName, or executionCycle.");
        }

        // Construct tags based on executionCycle
        if (executionCycle.equalsIgnoreCase("Feature")) {
            if (isNullOrEmpty(featureNameTag)) {
                throw new IllegalArgumentException("Feature name tag is required when executionCycle is 'Feature'.");
            }
            runtimeTags = String.format("@%s and @%s and @%s", environment.toUpperCase(), platformName, featureNameTag);

        } else {
            runtimeTags = String.format("@%s and @%s and @%s", environment.toUpperCase(), platformName, executionCycle);

        }

        // Set runtime tags as a system property


        System.setProperty("cucumber.filter.tags", runtimeTags);

        // Log the constructed runtime tags
        System.out.printf("Cucumber runtime tags set: %s%n", runtimeTags);
    }


    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }


}