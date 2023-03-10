package com.shell.markethub.base.util.listeners;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

/**
 * WIP
 */
public class RedundantListener implements ITestListener {

    private final String BASE_URL = "http://localhost:3000";

    @Override
    public void onTestStart(ITestResult iTestResult){
        try{
            RemoteWebDriver driver;
            String testName, sessionId;
            driver = (RemoteWebDriver) iTestResult.getTestContext().getAttribute("driver");
            testName = iTestResult.getMethod().getQualifiedName();
            sessionId = driver.getSessionId().toString();

            System.out.println("Started: "+testName);
            System.out.println("Session: "+sessionId);

            JSONObject jsonMap = new JSONObject();
            jsonMap.put("testId", testName);
            jsonMap.put("sessionId", sessionId);

            RestAssured.given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .body(jsonMap.toString())
                    .post(BASE_URL+"/results/start")
                    .then()
                    .statusCode(200)
                    .log().all();
        } catch (Exception e){
            return;
        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        try {
            String testName;
            testName = iTestResult.getMethod().getQualifiedName();

            System.out.println("PASSED: "+testName);

            JSONObject jsonMap = new JSONObject();
            jsonMap.put("testId", testName);
            jsonMap.put("status", "PASS");

            RestAssured.given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .body(jsonMap.toString())
                    .post(BASE_URL+"/results/stop")
                    .then()
                    .statusCode(200)
                    .log().all();
        } catch(Exception e){
            return;
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            String testName, failureReason, screenshotId = "";
            testName = iTestResult.getMethod().getQualifiedName();
            failureReason = iTestResult.getThrowable().getMessage();
            WebDriver driver = (RemoteWebDriver) iTestResult.getTestContext().getAttribute("driver");

            System.out.println("FAILED: "+testName);
            System.out.println(failureReason);

            JSONObject jsonMap = new JSONObject();
            jsonMap.put("testId", testName);
            jsonMap.put("status", "FAIL");
            jsonMap.put("failureReason", failureReason);


            RestAssured.given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .body(jsonMap.toString())
                    .post(BASE_URL+"/results/stop")
                    .then()
                    .statusCode(200)
                    .log().all();
        } catch (Exception e){
            return;
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        try {
            String testName;
            testName = iTestResult.getMethod().getQualifiedName();

            System.out.println("SKIPPED: "+testName);

            JSONObject jsonMap = new JSONObject();
            jsonMap.put("testName", testName);
            jsonMap.put("status", "SKIPPED");

            RestAssured.given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .body(jsonMap.toString())
                    .post(BASE_URL+"/test/stop")
                    .then()
                    .statusCode(200)
                    .log().all();
        } catch (Exception e){
            return;
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        try{
            String testName;
            testName = iTestResult.getMethod().getQualifiedName();

            System.out.println("FWSUCCESS: "+testName);

            JSONObject jsonMap = new JSONObject();
            jsonMap.put("testName", testName);
            jsonMap.put("status", "FWSUCCESS");

            RestAssured.given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .body(jsonMap.toString())
                    .post(BASE_URL+"/test/stop")
                    .then()
                    .statusCode(200)
                    .log().all();
        } catch (Exception e){
            return;
        }
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Test Started");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Test Ended");
    }

    public File attachScreenshot(WebDriver driver) {
        try{
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        } catch (Exception e){
            return null;
        }
    }
}
