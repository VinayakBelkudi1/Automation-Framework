package listners;


import org.testng.*;

import base.BaseTest;
import utils.ScreenShotUtil;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class TestListner implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("===== Test Suite Started: " + context.getName() + " =====");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("===== Test Suite Finished: " + context.getName() + " =====");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("---- Test Started: " + result.getName() + " ----");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✔ Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("❌ Test Failed: " + result.getName());

        // Get driver from test class
        WebDriver driver = BaseTest.Driver;
       

        // Take screenshot
       
           
				try {
					ScreenShotUtil.takeScreenshot(driver, result.getName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
        }
    

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠ Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not usually used
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }
}

