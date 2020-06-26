package test.java.melonsoft.utils;

import org.testng.*;

public class Listener implements
        ISuiteListener,
        ITestListener,
        IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
    }

    @Override
    public void onStart(ISuite iSuite) {
    }

    @Override
    public void onFinish(ISuite iSuite) {
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("test Start : " + iTestResult.getTestClass().getName() +". Test name: "+ iTestResult.getMethod().getConstructorOrMethod().getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("test Success : " + iTestResult.getTestClass().getName() +". Test name: "+ iTestResult.getMethod().getConstructorOrMethod().getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("test failed : " + iTestResult.getTestClass().getName() +". Test name: "+ iTestResult.getMethod().getConstructorOrMethod().getName());
        /*Screenshot screenshot = new Screenshot((WebDriver) iTestResult.getTestContext().getAttribute("driver"));
        screenshot.getScreenshot(iTestResult);*/
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}