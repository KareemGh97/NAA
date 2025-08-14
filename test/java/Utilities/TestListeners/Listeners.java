package Utilities.TestListeners;

import Utilities.Jira.BugComponents;
import Utilities.Reports.ExtentManager;
import Utilities.TestListeners.retest.RetryAnalyzer;
import Utilities.commonClasses.AppConstants;
import TestBases.TestBase;

import Utilities.media.RecordScreenVideo;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.MediaEntityBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static TestBases.DriverManager.getAppiumDriver;
import static TestBases.DriverManager.quitDriver;
import static Utilities.BrowserStack.BrowserStackDeviceFetcher.updateSessionReason;
import static Utilities.DeviceManager.LocalDeviceManager.selectedLocalDevice;
import static Utilities.ParallelExecution.ParallelDelayManager.addDelayBuffer;
import static Utilities.Xray.XrayIntegration.executionKey;
import static Utilities.Xray.XrayIntegration.uploadResultsToXray;
import static Utilities.media.CaptureScreenShot.captureScreenshotOnFailure;
import static io.cucumber.plugin.event.Status.FAILED;

public class Listeners extends TestBase implements EventListener {

    private final Map<String, ExtentTest> featureNodes = new ConcurrentHashMap<>();

    private final Map<String, ExtentTest> scenarioTests = new ConcurrentHashMap<>();
    private final Map<String, List<String>> scenarioSteps = new ConcurrentHashMap<>();
    public static final Map<String, String> logFailedSessions = new ConcurrentHashMap<>();
    public static ThreadLocal<Scenario> currentScenario = new ThreadLocal<>();

    BugComponents bugComponents;

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        publisher.registerHandlerFor(TestStepStarted.class, this::onTestStepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::onTestStepFinished);
        publisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);
        publisher.registerHandlerFor(TestRunFinished.class, this::onTestRunFinished);
    }

    private void onTestCaseStarted(TestCaseStarted event) {
        TestCase testCase = event.getTestCase();
        String scenarioId = getScenarioId(testCase);
        String featureName = extractFeatureName(testCase.getUri());

        ExtentReports extent = ExtentManager.getExtentReports();

        // Get or create the parent feature node
        ExtentTest parentTestNode = featureNodes.get(featureName);
        if (parentTestNode == null) {
            parentTestNode = extent.createTest("Feature: " + featureName);
            featureNodes.put(featureName, parentTestNode);
        }

        // Create the scenario node
        ExtentTest scenarioTest = parentTestNode.createNode("Scenario: " + testCase.getName());
        scenarioTests.put(scenarioId, scenarioTest);
        scenarioSteps.put(scenarioId, new ArrayList<>());
    }

    private void onTestStepStarted(TestStepStarted event) {
        TestCase testCase = event.getTestCase();
        String scenarioId = getScenarioId(testCase);
        ExtentTest scenarioTest = scenarioTests.get(scenarioId);
        if (scenarioTest == null) return;

        TestStep testStep = event.getTestStep();
        if (testStep instanceof PickleStepTestStep) {
            PickleStepTestStep pickleStep = (PickleStepTestStep) testStep;
            String keyword = pickleStep.getStep().getKeyword();
            String stepText = pickleStep.getStep().getText();
            scenarioSteps.get(scenarioId).add(String.format("<li class='step-node'><strong>%s</strong>%s</li>", keyword, stepText));
        }
    }

    private void onTestStepFinished(TestStepFinished event) {
        TestCase testCase = event.getTestCase();
        TestStep testStep = event.getTestStep();

        if (!(testStep instanceof PickleStepTestStep)) return;

        String scenarioId = getScenarioId(testCase);
        List<String> steps = scenarioSteps.get(scenarioId);
        if (steps == null || steps.isEmpty()) return;

        Result result = event.getResult();
        String statusMessage = switch (result.getStatus()) {
            case PASSED -> "🟢";
            case FAILED -> "️🔴";
            case SKIPPED -> "️🟡";
            default -> "";
        };

        int lastIndex = steps.size() - 1;
        String currentStepHtml = steps.get(lastIndex)
                .replace("<li class='step-node'>", "")
                .replace("</li>", "");

        String errorMessageHtml = "";
        if (result.getStatus() == Status.FAILED && result.getError() != null) {
            errorMessageHtml = "<br/><pre style='background:#f8d7da; border-left:3px solid #c00; padding:10px; margin-top:5px;'>"
                    + result.getError().getMessage() + "</pre>";
        }

        String updatedStepHtml = String.format(
                "<li class='step-node' style='background-color:%s; margin:0; padding:5px; list-style:none;'>"
                        + "%s <span style='float:right; font-weight:bold;'>%s</span>%s</li>",
                getColorForStatus(result.getStatus()),
                currentStepHtml,
                statusMessage,
                errorMessageHtml
        );

        steps.set(lastIndex, updatedStepHtml);
    }

    private void onTestCaseFinished(TestCaseFinished event) {

        TestCase testCase = event.getTestCase();
        String scenarioId = getScenarioId(testCase);
        ExtentTest scenarioTest = scenarioTests.get(scenarioId);
        if (scenarioTest == null) return;

        List<String> steps = scenarioSteps.get(scenarioId);
        String scenarioName = testCase.getName();
        String scenarioUri = testCase.getUri().toString();
        int scenarioLine = testCase.getLocation().getLine();
        List<String> scenarioTags = new ArrayList<>(testCase.getTags());

        StringBuilder scenarioInfoBuilder = new StringBuilder();
        scenarioInfoBuilder.append("<div style='margin-bottom:1px;'>")
                .append("<h3 style='color:#2E86C1;'>Scenario: ").append(scenarioName).append("</h3>")
                .append("<p><strong>Location:</strong> ").append(scenarioUri).append(":").append(scenarioLine).append("</p>");
        if (!scenarioTags.isEmpty()) {
            scenarioInfoBuilder.append("<p><strong>Tags:</strong> ").append(String.join(", ", scenarioTags)).append("</p>");
        }
        scenarioInfoBuilder.append("<ul class='child' style='padding:0; margin:0;'>")
                .append(String.join("", steps))
                .append("</ul></div>");

        scenarioTest.info(scenarioInfoBuilder.toString());

        if (!RetryAnalyzer.skippedScenarios.isEmpty() && RetryAnalyzer.skippedScenarios.contains(testCase.getName())) {
            scenarioTest.skip("<span style='color:orange;font-weight:bold;'>Scenario Skipped by RetryAnalyzer</span>");
            RetryAnalyzer.skippedScenarios.remove(testCase.getName());

        } else {
            switch (event.getResult().getStatus()) {
                case PASSED -> {
                    scenarioTest.pass("<span style='color:green;font-weight:bold;'>Scenario Passed</span>");
                    try {
                        scenarioTest.info(MediaEntityBuilder.createScreenCaptureFromBase64String(failedScreenshot.get(scenarioId)).build());
                    } catch (Exception ignored) {
                    }
                }
                case FAILED -> {
                    scenarioTest.fail("<span style='color:red;font-weight:bold;'>Scenario Failed</span>");
                    try {
                        scenarioTest.info(MediaEntityBuilder.createScreenCaptureFromBase64String(failedScreenshot.get(scenarioId)).build());
                    } catch (Exception ignored) {
                    }
                }
                case SKIPPED -> {
                    scenarioTests.remove(scenarioId);
                    scenarioSteps.remove(scenarioId);
                    return;
                }
                default -> scenarioTest.info("Scenario finished with status: " + event.getResult().getStatus());
            }
        }

        scenarioTests.remove(scenarioId);
        scenarioSteps.remove(scenarioId);

        if (isScenarioFail(event)) {
            if (TestBase.deployment.equalsIgnoreCase("cloud")) {
                String newReason = "{\"status\": \"failed\", \"reason\": \"" + event.getResult().getError().toString()
                        .replaceAll("[\\r\\n]", "").replace("\"", "\\\"") + "\"}";
                updateSessionReason(logFailedSessions.get(testCase.getUri() + ":" + testCase.getLocation().getLine()), newReason);
            }

            if (isJiraEnable(event) && JiraDefectCreation) {
                bugComponents = new BugComponents();
                bugComponents.createBugOnJira(event);
            } else {
                System.out.println("Scenario passed or doesn't contain @jiraIntegration Annotation");
            }
        }
    }

    private void onTestRunFinished(TestRunFinished event) {
        ExtentManager.getExtentReports().flush();
        ExtentManager.openReportAfterExecution();
        if (UploadExecutionResult) {
            System.out.println("Uploading test results to Xray...");
            uploadResultsToXray();
            AppConstants.xrayExecutionId = executionKey;
        }

    }

    @Before
    public void before(Scenario scenario) {
        scenarioId.set(scenario.getUri() + ":" + scenario.getLine());
        currentScenario.set(scenario);
        try {
            Random random = new Random();
            addDelayBuffer(random.nextInt(9999));
            String featureName = FilenameUtils.getBaseName(scenario.getUri().toString());
            startMobileApp(scenario.getName(), featureName);

            if (deployment.equalsIgnoreCase("local")) {
                RecordScreenVideo.startRecording();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void after(Scenario scenario) {
        if (TestBase.deployment.equalsIgnoreCase("local")) {
            String path = scenario.getUri().toString();
            int startIndex = path.indexOf("Features");
            int endIndex = path.lastIndexOf('.');
            String featurePath = (startIndex != -1 && endIndex != -1 && endIndex > startIndex)
                    ? path.substring(startIndex, endIndex)
                    : path;
            String screenshotPath = captureScreenshotOnFailure(featurePath, scenario.getName());
            failedScreenshot.put(scenarioId.get(), screenshotPath);

            RecordScreenVideo.stopRecording(featurePath, scenario.getName());
            selectedLocalDevice.get().setInUse(false);
            selectedLocalDevice.remove();
        } else {
            final JavascriptExecutor jse = getAppiumDriver();
            if (scenario.isFailed()) {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"oops!\"}}");
                logFailedSessions.put(scenario.getUri() + ":" + scenario.getLine(), getAppiumDriver().getSessionId().toString());
            } else {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Well Done!\"}}");
            }
        }
        quitDriver();
        scenarioId.remove(); // remove the id of the scenario
    }

    private String getScenarioId(TestCase testCase) {
        return testCase.getUri() + ":" + testCase.getLocation().getLine();
    }

    public boolean isJiraEnable(TestCaseFinished event) {
        return event.getTestCase().getTags().contains("@JiraIntegration");
    }

    public boolean isScenarioFail(TestCaseFinished event) {
        return event.getResult().getStatus().is(FAILED);
    }

    public static boolean isBugTagged() {
        Collection<String> tags = currentScenario.get().getSourceTagNames();
        return tags.stream().anyMatch(tag -> tag.toLowerCase().startsWith("@bug"));
    }

    public static String getColorForStatus(Status status) {
        return switch (status) {
            case PASSED -> "#d4edda";
            case FAILED -> "#f8d7da";
            case SKIPPED -> "#fff3cd";
            default -> "#d1ecf1";
        };
    }

    private String extractFeatureName(URI uri) {
        String path = uri.getPath();
        return path.substring(path.lastIndexOf('/') + 1).replace(".feature", "");
    }
}
