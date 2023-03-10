package com.shell.markethub.base.util.listeners;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.util.Base64;
import org.apache.logging.log4j.*;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;
import com.shell.markethub.base.pageobjects.BasePageObject;
import com.shell.markethub.base.util.config.BaseDataConstants;
import com.shell.markethub.base.util.extentreports.ExtentManager;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.maven.AllureReportMojo;


/**
 * @author N.Kumar8@shell.com
 * @description extent report will be configured and instance will be created,
 * result will be updated based on the test results
 */
public class BaseListener implements ITestListener {
	//Extent Report Declarations
	private static ExtentReports extent = ExtentManager.createInstance("Extent Reports");
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private WebDriver driver;
    private static Logger logger = LogManager.getLogger(BaseListener.class);
    protected BasePageObject basePageObject = new BasePageObject();
 
    public static ThreadLocal<ExtentTest> getTest() {
    	return test;
    }
    
    @Override
    public synchronized void onStart(ITestContext context) {
        extent = ExtentManager.addReporterName(context.getSuite().getName());
        extent.setSystemInfo("User Name : ", System.getProperty("user.name"));
        extent.setSystemInfo("OS Name : ", System.getProperty("os.name"));
        try {
			FileUtils.cleanDirectory(new File(System.getProperty("user.dir")+"\\allure-results"));
			basePageObject.createNewFile(System.getProperty("user.dir")+"\\allure-results\\environment.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
 
    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.flush();
        try {
			basePageObject.copyFileFromOneLocToAnotherLoc(System.getProperty("user.dir")+ "\\allure-results", System.getProperty("user.dir")+"\\target\\testreport\\allure-results");
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
 
    @Override
    public synchronized void onTestStart(ITestResult result) {
    	logger.info("======================================");
    	logger.info(result.getMethod().getMethodName() +" Execution Started");
    	logger.info("======================================");
    	String testEnvironment = (String) result.getTestContext().getAttribute("testEnvironment");
        extent.setSystemInfo(result.getMethod().getMethodName(), testEnvironment);
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        String category = (String)result.getTestContext().getAttribute("appType");
        extentTest.assignCategory(category);
        test.set(extentTest);
    }
 
    @Override
    public synchronized void onTestSuccess(ITestResult result) {	
    	logger.info("=====================================");
    	logger.info(result.getMethod().getMethodName() +" Execution Ended");
    	logger.info("=====================================");
        String methodName=result.getMethod().getMethodName();
        //driver = (WebDriver) result.getTestContext().getAttribute("driver");
        //takeScreenShot(driver, methodName);
        try {
        	test.get().log(Status.PASS, methodName+" Passed");
			//test.get().addScreenCaptureFromPath(System.getProperty("user.dir") + "\\target\\testreport\\screenshots\\" + methodName + ".png");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
 
    @Override
    public synchronized void onTestFailure(ITestResult result) {
    	logger.info("=====================================");
    	logger.info(result.getMethod().getMethodName() +" Execution Ended");
    	logger.info("=====================================");
        test.get().fail(result.getThrowable());
        String methodName=result.getMethod().getMethodName();
        String appType = (String)result.getTestContext().getAttribute("appType");
        driver = (WebDriver) result.getTestContext().getAttribute("driver");
        try {
        	test.get().log(Status.FAIL, methodName+" Failed");
        	test.get().addScreenCaptureFromBase64String(takeScreenShot(driver, appType, methodName), methodName);
        	//test.get().addScreenCaptureFromPath(System.getProperty("user.dir") + "\\target\\testreport\\screenshots\\" + appType+ " "+ methodName + ".png");	
			//attachScreenshot(driver, appType, methodName);
			if(driver != null)
        	Allure.addAttachment(appType, new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
 
    @Override
    public synchronized void onTestSkipped(ITestResult result) {
    	logger.info(result.getMethod().getMethodName() +" skipped");
        test.get().skip(result.getThrowable());
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
       
    }
    
	// The below method will save the screen shot
	/*File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	 * try { FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +
	 * "\\target\\testreport\\screenshots\\" + appType + " " + methodName +
	 * ".png")); } catch (IOException e) { e.printStackTrace(); }
	 */
	public static String takeScreenShot(WebDriver driver, String appType, String methodName) {
		// If driver has quit or has not been initialized, return an empty image
		if (driver == null)
			return "data:image/png;base64,";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(scrFile);
			byte[] bytes = new byte[(int) scrFile.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			logger.info("IO Exception while saving screenshot");
			e.printStackTrace();
		}
		return "data:image/png;base64," + encodedBase64;
	}
    
	@Attachment(value = "{appType}",  type = "image/png")
    public byte[] attachScreenshot(WebDriver driver, String appType, String methodName) throws Exception {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
