package jsmart.logging;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener extends ExtentITestListenerClassAdapter implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Logger log = LoggerFactory.getLogger(getSuiteNameWithTestCounts(result.getTestContext(), 0, 0 ,0));
        log.info(result.getMethod().getMethodName() + " starting");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logger log = LoggerFactory.getLogger(getSuiteNameWithTestCounts(result.getTestContext(), 1, 0 , 0));
        log.info(result.getMethod().getMethodName() + " successful");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logger log = LoggerFactory.getLogger(getSuiteNameWithTestCounts(result.getTestContext(), 0, 1, 0));
        log.error(result.getMethod().getMethodName() + " failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logger log = LoggerFactory.getLogger(getSuiteNameWithTestCounts(result.getTestContext(), 0, 0, 1));
        log.info(result.getMethod().getMethodName() + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Logger log = LoggerFactory.getLogger(getSuiteNameWithTestCounts(result.getTestContext(), 1, 0, 0));
        log.info(result.getMethod().getMethodName() + " failed, but within success percentage");
    }

    private String getSuiteNameWithTestCounts(ITestContext context, int passed, int failed, int skipped) {
        String suiteName = context.getName().toUpperCase();
        int totalTests = context.getAllTestMethods().length;
        int passedTests = context.getPassedTests().size() + passed;
        int failedTests = context.getFailedTests().size() + failed;
        int skippedTests = context.getSkippedTests().size() + skipped;
        return "SUITE " + suiteName + " (" + totalTests + "/" + passedTests + "/" + failedTests + "/" + skippedTests + ")";
        //SUITE suiteName (Total/Passed/Failed/Skipped)
    }

    @Override
    public void onStart(ITestContext context) {
        Logger log = LoggerFactory.getLogger(getSuiteNameWithTestCounts(context, 0, 0 , 0));
        log.info("Starting");
    }

    @Override
    public void onFinish(ITestContext context) {
        Logger log = LoggerFactory.getLogger(getSuiteNameWithTestCounts(context, 0, 0 , 0));
        log.info("Finished");
    }

}