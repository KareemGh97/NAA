package Utilities.TestListeners.retest;

import TestBases.TestBase;
import Utilities.TestListeners.Listeners;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static Utilities.TestListeners.Listeners.currentScenario;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 1 ; // Define how many times you want to retry the failed test
    public static Set<String> skippedScenarios = ConcurrentHashMap.newKeySet();

    @Override
    public boolean retry(ITestResult result) {
        boolean shouldRetry = retryCount < maxRetryCount && !Listeners.isBugTagged();
        if (shouldRetry) {
            retryCount++;
            TestBase.retry =  retryCount + " -retry- ";
            skippedScenarios.add(currentScenario.get().getName());
        }
        currentScenario.remove();
        return shouldRetry;
    }
}