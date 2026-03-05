package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class TestListener extends BaseTest implements ITestListener {
	public void onTestFailure(ITestResult result) {
		ScreenshotUtil.captureScreenshot(driver, result.getName());
	}
}
