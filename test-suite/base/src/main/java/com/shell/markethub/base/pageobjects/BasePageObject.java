package com.shell.markethub.base.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shell.markethub.base.util.Assertions;
import com.shell.markethub.base.util.Driver;
import com.shell.markethub.base.util.config.BaseDataConstants;
import com.shell.markethub.base.util.listeners.BaseListener;

/**
 * 
 * @author n.kumar8@shell.com
 * @description This class is the parent page object which contains the resuable
 *              methods/actions used by all page objects
 */
public class BasePageObject {

	private static Logger logger = LogManager.getLogger(BasePageObject.class);
	protected Assertions assertion;
	public WebDriver driver;
	Properties p = new Properties();
	public static ThreadLocal<ExtentTest> test = BaseListener.getTest();
	// Map for getting column name in test data sheet
	public static Map<String, Integer> getcolumnnumberData = new HashMap<String, Integer>();
	// Map for getting column name in Device data sheet
	public static Map<String, Integer> getcolumnnumberDevice = new HashMap<String, Integer>();
	// Map for getting column OS in Device data sheet
	// Map for getting column name in Device data sheet
	public static Map<String, Integer> getcolumnnumberModule = new HashMap<String, Integer>();

	public BasePageObject() {

	}

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
		assertion = new Assertions();
	}

	public enum SearchOptions {
		SHELL_ORDER_NUMBER, CUSTOMER_PO_NUMBER, DISTRIBUTOR_ORDER_NUMBER,
	}

	public enum SearchOptionsDate {
		CREATED_ON, DELIVERY_BY_DATE
	}

	public enum SpecialitiesOrderTrackerStatus {
		ORDER_REQUESTED("Order Requested"), APPROVED("Approved"), CANCELLED("Cancelled"),
		READY_TO_LOAD("Ready to load");

		private String value;

		SpecialitiesOrderTrackerStatus(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	public enum SpecialitiesOrderTrackerStatusFrench {
		ORDER_REQUESTED("Demandée"), APPROVED("Acceptée"), CANCELLED("Annulé"), READY_TO_LOAD("Prête à charger");

		private String value;

		SpecialitiesOrderTrackerStatusFrench(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	public enum SpecialitiesOrderTrackerStatusGerman {
		ORDER_REQUESTED("Bestellanfrage"), APPROVED("bestätigt"), CANCELLED("storniert"),
		READY_TO_LOAD("Fertig zur Ladung"), IN_TRANSPORT("im Transport");

		private String value;

		SpecialitiesOrderTrackerStatusGerman(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	public enum SpecialitiesOrderDetailsSteps {
		ORDER_REQUESTED("Order Requested"), APPROVED("Approved"), CANCELLED("Cancelled"),
		READY_TO_LOAD("Ready to Load"), OUT_FOR_DELIVERY("Out for delivery"), LAST_STOP("Last Stop"),
		ORDER_CANCELLED("Order Cancelled");

		private String value;

		SpecialitiesOrderDetailsSteps(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	public enum SpecialitiesOrderDetailsStepsFrench {
		ORDER_REQUESTED("Demandée"), APPROVED("Acceptée"), CANCELLED("Annulé"), READY_TO_LOAD("Prête à charger"),
		OUT_FOR_DELIVERY("En livraison"), LAST_STOP("Lieu de livraison"), ORDER_CANCELLED("Commande annulée");

		private String value;

		SpecialitiesOrderDetailsStepsFrench(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	public enum SpecialitiesOrderDetailsStepsThaiPack {

		ORDER_REQUESTED("คําสั่งซื้อ"), APPROVED("อนุมัติ"), Scheduling_in("ผลิตภัณฑ์พร้อมรับ"),
		Delivery_In_The_Process("การรับผลิตภัณฑ์"), Error_UnderReview("เกิดข้อผิดพลาดขึ้น");
		;
		;
		private String value;

		SpecialitiesOrderDetailsStepsThaiPack(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	public enum SpecialitiesOrderDetailsStepsHongKong {
		ORDER_REQUESTED("訂單已提交"), APPROVED("已批准"), Scheduling_in("正在排期"), Delivery_In_The_Process("正在送貨"),
		Terminal("終點站:"), Error_UnderReview("報錯 - 正在審核中"), Order_Cancelled("訂單已取消");

		private String value;

		SpecialitiesOrderDetailsStepsHongKong(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	public enum SpecialitiesOrderDetailsStepsGerman {
		ORDER_REQUESTED("Bestellanfrage"), APPROVED("bestätigt"), CANCELLED("storniert"),
		READY_TO_LOAD("Fertig zur Ladung"), OUT_FOR_DELIVERY("im Transport"), LAST_STOP("Letzter Schritt"),
		ORDER_CANCELLED("Auftrag storniert");

		private String value;

		SpecialitiesOrderDetailsStepsGerman(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	//@Step("Click using java script executor on {element}")
	protected void clickUsingJavaScriptExecutor(WebElement element, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			executor.executeScript("arguments[0].click();", element);
		} catch (WebDriverException e) {
			logger.warn("Failed to click on element " + e.getMessage());
			throw e;
		}
	}

	//@Step("Enter value using java script executor")
	protected void enterValueUsingJavaScriptExecutor(WebElement element, String val, int waitTime) {

		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			executor.executeScript("arguments[0].value = '" + " " + "'", element);
			executor.executeScript("arguments[0].value = '" + val + "'", element);

		} catch (WebDriverException e) {
			logger.warn("Failed to enter valuet " + e.getMessage());
			throw e;
		}
	}

	//@Step("Load the page {url}")
	protected void loadPage(String url) {
		try {
			driver.navigate().to(url);
			logger.info("Navigating to URL " + url);
		} catch (WebDriverException e) {
			logger.warn("Failed to load URL " + e.getMessage());
			throw e;
		}
	}

	protected WebElement verifyFocus() {
		WebElement el = null;
		logger.info("Verifying current focus element");
		try {
			el = driver.switchTo().activeElement();
			el.sendKeys(Keys.TAB);
			el = driver.switchTo().activeElement();
		} catch (WebDriverException e) {
			logger.warn("Failed to focus on current element " + e.getMessage());
			throw e;
		}
		return el;
	}

	//@Step("upload attachement")
	public boolean uploadAttachment(String filePath) throws AWTException, InterruptedException {
		boolean isAttachmentUploaded = false;
		try {
			logger.info("Attaching file....");
			StringSelection stringSelection = new StringSelection(filePath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
			Thread.sleep(2000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(4000);
			logger.info("Attached file successfully");
			isAttachmentUploaded = true;
		} catch (AWTException e) {
			logger.info("Failed to attached file " + e.getMessage());
			throw e;
		} catch (InterruptedException e) {
			logger.info("Failed to attached file " + e.getMessage());
			throw e;
		}
		return isAttachmentUploaded;

	}

	//@Step("Verify web page is loaded ")
	public void verifyPageIsLoaded() {
		int maxTime = 180;
		JavascriptExecutor js = null;
		String state;
		try {
			if (driver instanceof JavascriptExecutor) {
				js = (JavascriptExecutor) driver;
			}
			for (int i = 0; i < maxTime; i++) {
				state = js.executeScript("return document.readyState").toString();
				if (!(state.equals("complete") || state.equals("loaded"))) {
					logger.warn("Page is taking time to load");
					continue;
				} else {
					logger.info("Page is loaded successfully ");
					break;
				}
			}
		} catch (WebDriverException e) {
			logger.warn("Failed to load the page ");
			throw e;
		}
	}
	
	//@Step("Verify web page is loaded within maxTimme Seconds ")
	public boolean verifyPageIsLoadedWithinSecs(int maxTime) {
		boolean flag = false;
		JavascriptExecutor js = null;
		String state;
		try {
			if (driver instanceof JavascriptExecutor) {
				js = (JavascriptExecutor) driver;
			}
			for (int i = 0; i < maxTime; i++) {
				state = js.executeScript("return document.readyState").toString();
				if (!(state.equals("complete") || state.equals("loaded"))) {
					logger.warn("Page is taking time to load");
					continue;
				} else {
					logger.info("Page is loaded successfully.");
					flag = true;
					break;
				}
			}
		} catch (WebDriverException e) {
			logger.warn("Failed to load the page ");
			throw e;
		}
		return flag;
	}

	// @Step("Wait for Clickable element {element}")
	protected void waitForClickableElement(int seconds, WebElement element) {
		logger.info("Waiting for clickable element " + element);
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException e) {
			logger.warn("Could not find the element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Error finding the clickable element " + e.getMessage());
			throw e;
		}
	}

	public void sleep(int milliSeconds) throws InterruptedException {
		Thread.sleep(milliSeconds);
		logger.info("Going to sleep for" + milliSeconds + " milliseconds");
	}

	// Verify element is present
	public boolean isElementPresent(By locator, int timeOutSeconds) {
		boolean isTrue = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			isTrue = true;
		} catch (NoSuchElementException e) {
			logger.warn("Could not find element " + e.getMessage());
			isTrue = false;
		} catch (Exception e) {
			logger.warn("Error finding element " + e.getMessage());
			isTrue = false;
		}
		return isTrue;

	}

	// @Step("Wait and switch to frame {frameName}")
	//@Step("Wait and switch to Iframe")
	protected void waitAndSwitchToIframe(int timeOutSeconds, String frameName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
		} catch (NoSuchElementException e) {
			logger.warn("Could not find element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Error finding the frame and switching to it " + e.getMessage());
			throw e;
		}
	}

	// @Step("Wait and switch to Iframe {element}")
	//@Step("Wait and switch to Iframe")
	protected void waitAndSwitchToIframe(int timeOutSeconds, WebElement element) {
		try {
			logger.info("Switching to Iframe " + element);
			WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
			driver.switchTo().frame(1);

		} catch (NoSuchElementException e) {
			logger.warn("Could not find element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Error finding the frame and switching to it " + e.getMessage());
			throw e;
		}
	}

	protected void waitForValues(Select element) {
		while (element.getOptions().size() <= 1) {
			// Wait action code here
		}
	}

	//@Step("Enter {text}")
	protected void sendKeys(WebElement serviceMessage, String text) throws Exception {
		try {
			logger.info("Setting text " + text + " in element " + serviceMessage);
			serviceMessage.clear();
			serviceMessage.sendKeys(text);
			try {
				test.get().log(Status.INFO, "Entered " + text + " in Editbox");
			} catch (NullPointerException e) {
			}
		} catch (NoSuchElementException e) {
			logger.warn("Failed to send keys " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Failed to send keys " + e.getMessage());
			throw e;
		}
	}

	//@Step("Enter {text}")
	protected void sendData(WebElement element, String text) throws Exception {
		try {
			logger.info("Setting text " + text + " in element " + element);
			element.sendKeys(text);
			try {
				test.get().log(Status.INFO, "Entered " + text + " in Editbox");
			} catch (NullPointerException e) {
			}
		} catch (NoSuchElementException e) {
			logger.warn("Failed to send keys " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Failed to send keys " + e.getMessage());
			throw e;
		}
	}

	// @Step("Wait and switch to Iframe {text}")
	protected void clearTextbox(WebElement element) {
		try {
			logger.info("Clear Text" + " in element " + element);
			element.clear();

		} catch (NoSuchElementException e) {
			logger.warn("Failed to clear text " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Failed to clear Tex " + e.getMessage());
			throw e;
		}
	}

	public void waitForElementToEnable(WebElement element, int numberofcount) {
		int count = 0;
		while (count < numberofcount) {
			try {
				Thread.sleep(2000);
				element.isEnabled();
				break;
			} catch (Throwable e) {
				count++;
			}
		}
	}

	public String clickOnAlert(WebElement element) throws Exception {
		String alertText = null;
		element.click();
		Thread.sleep(4000);
		try {
			WebDriverWait Wait = new WebDriverWait(driver, 120);
			Wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText().trim();
			alert.accept();
		} catch (NoAlertPresentException Ex) {
		} catch (UnhandledAlertException e) {
			try {
				WebDriverWait Wait = new WebDriverWait(this.driver, 120);

				Wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				alertText = alert.getText().trim();
				alert.accept();
			} catch (Exception e1) {

			}
		}
		return alertText;
	}

	public void retryingClick(WebElement element, int timeout) {

		int attempts = 0;
		while (attempts < 2) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
				element.click();
				break;
			} catch (NullPointerException ex) {
				attempts++;
			} catch (StaleElementReferenceException e) {
				element.click();
				attempts++;
			}
		}
	}

	/**
	 * WaitTime.
	 *
	 * @param seconds to wait
	 */
	public void WaitTime(long timeInSeconds) {
		try {
			driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
			logger.info("Wait for " + timeInSeconds + "seconds");
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find element " + e.getMessage());
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
		}
	}

	public boolean verifyColumnsAreSorted(List<WebElement> element) {
		ArrayList<String> unsortedValues = new ArrayList<String>();
		List<WebElement> terminalValues = element;
		for (int i = 0; i < terminalValues.size(); i++) {
			if ((terminalValues.get(i).getText()).isEmpty() == false) {
				unsortedValues.add(terminalValues.get(i).getText());
			}
		}
		List<String> sortedValues = new ArrayList<String>(unsortedValues);
		Collections.sort(sortedValues);
		return sortedValues.equals(unsortedValues);
	}

	public boolean VerifyDateIsInDescendingOrder(List<WebElement> element) throws ParseException {
		ArrayList<String> unsortedValues = new ArrayList<String>();
		List<WebElement> terminalValues = element;
		for (int i = 0; i < terminalValues.size(); i++) {
			if ((terminalValues.get(i).getText()).isEmpty() == false) {
				unsortedValues.add(terminalValues.get(i).getText());
			} else {
			}
		}
		List<String> sortedValues = new ArrayList<String>(unsortedValues);
		Collections.sort(sortedValues, Collections.reverseOrder());
		return sortedValues.equals(unsortedValues);
	}

	//@Step("Click on element {element}")
	protected void click(WebElement element) throws Exception {
		logger.info("Clicking on element " + element);
		try {
			waitForClickableElement(BaseDataConstants.EXPLICIT_TIMEOUT, element);
			element.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(1000);
			try {
				test.get().log(Status.INFO, "clicked on " + element);
			} catch (NullPointerException e) {
			}
		} catch (NoSuchElementException e) {
			// attachScreenshot(driver);
			logger.warn("Failed to click on the element " + e.getMessage());
			throw e;
		} catch (WebDriverException e) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			logger.warn("Element is clicked successfully ");
		} catch (Exception e) {
			logger.warn("Failed to click on the element " + e.getMessage());
			throw e;
		}
	}

	// @Step("Wait For Element visibility {element}")
	protected boolean waitForElementToBeVisible(WebElement element, long timeInSeconds) {
		boolean isTrue = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			isTrue = true;
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find element " + e.getMessage());
			// throw e;
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
			// throw e;
		}
		return isTrue;
	}

	//@Step("verify element is invisible")
	protected boolean isElementInvisibile(By locator, int timeInSeconds) {
		boolean isTrue = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			isTrue = true;
			logger.info("Element is invisible ");
		} catch (NoSuchElementException e) {
			logger.warn("Element is visible " + e.getMessage());
			isTrue = false;
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
			isTrue = false;
		}
		return isTrue;
	}

	//@Step("Wait For Element visibility ")
	// Not throwing exception as it is to verify True/False condition
	protected boolean isElementVisible(WebElement element, int timeInSeconds) {
		boolean isTrue = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			isTrue = true;
			Thread.sleep(2000);
			logger.info("Element is visible ");
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find element " + e.getMessage());
			isTrue = false;
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
			isTrue = false;

		}
		return isTrue;
	}

	//@Step("Wait For Element to be enabled ")
	protected static boolean isElementEnabled(WebElement element, int timeInSeconds) {
		boolean isTrue = false;
		try {
			isTrue = element.isEnabled();
			logger.info("Element is enabled");
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find element " + e.getMessage());
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
		}
		return isTrue;
	}

	// @Step("Wait For Element visibility {locator}")
	protected void waitForElementToBeVisible(By locator, long timeInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
			throw e;
		}
	}

	//@Step("Switch window by title {pageTitle}")
	public void switchWindowByTitle(String pageTitle) {

		try {
			logger.info("Switching to window with title " + pageTitle);
			Set<String> allTabs = driver.getWindowHandles();
			for (String tab : allTabs) {
				driver.switchTo().window(tab);
				if (driver.getTitle().equalsIgnoreCase(pageTitle)) {
					logger.info("Successfully Switched to window with title " + pageTitle);
					break;
				}
			}
		} catch (NoSuchWindowException e) {
			logger.warn("Failed to identify the window with title" + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Failed to identify the window with title" + e.getMessage());
			throw e;
		}

	}

	//@Step("Switch window by title {pageTitle}")
	public void switchWindowByIndex(int index) {

		try {
			logger.info("Switching to window with index " + index);
			ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
			if (!allTabs.isEmpty() && allTabs.size() >= 1) {
				driver.switchTo().window(allTabs.get(index));
				logger.info("Successfully Switched to window with title " + driver.getTitle());
			}
		} catch (NoSuchWindowException e) {
			logger.warn("Failed to identify the window with index" + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Failed to identify the window with index" + e.getMessage());
			throw e;
		}
	}

	/**
	 * This method is to close the current window handler
	 * 
	 * @param
	 * @return
	 */
	public void closeCurrentWindow() {
		driver.switchTo().window(driver.getWindowHandle()).close();
	}

	protected void waitForElementToBeInVisible(WebElement element, long timeInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (NoSuchElementException e) {
			logger.warn("Invisibility check failed." + e.getMessage());
			// throw e;
		} catch (Exception e) {
			logger.warn("Invisibility check failed." + e.getMessage());
			// throw e;
		}
	}

	protected void waitForElementToBeInVisible(By locale, long timeInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locale));
			logger.warn("Expected element is Invisibile");
		} catch (NoSuchElementException e) {
			logger.warn("Invisibility check failed." + e.getMessage());
			// throw e;
		} catch (Exception e) {
			logger.warn("Invisibility check failed." + e.getMessage());
			// throw e;
		}
	}

	// move to particular element in page
	protected void moveToElement(WebElement element) {
		try {
			logger.info("Moving to element" + element);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
		} catch (NoSuchElementException e) {
			logger.warn("Failed to move to element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
			throw e;
		}
	}

	// move to page up using scroll bar
	protected void windowScrollUp() {
		try {
			logger.info("Scroll up the window using  scroll bar");
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250)", "");
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
			throw e;
		}
	}

	// move to page Down using scroll bar
	protected void windowScrollDwn() throws Exception {
		try {
			logger.info("Scroll Down the window using  scroll bar");
			((JavascriptExecutor) this.driver).executeScript("window.scrollBy(0, 250)", "");
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
			throw e;
		}
	}

	// @Step("Find dynamic element {txtReplace}")
	public WebElement findDynamicElement(String element, String txtReplace) {
		WebElement el = null;
		String finallocator = null;

		try {
			finallocator = element.replaceAll("#", txtReplace.trim());
			el = driver.findElement(By.xpath(finallocator));
			logger.info("Dynamic element has been found " + finallocator);
		} catch (Exception e) {
			logger.warn("Error finding dynamic element " + e.getMessage());
			throw e;
		}
		return el;

	}

	// Get Attribute value
	public String getAttributeValue(WebElement element, String attributeName) {
		String val = null;
		logger.info("Get attribute value from element " + element);
		try {
			val = element.getAttribute(attributeName);
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find the element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Failed to get attribute value from the element " + e.getMessage());
			throw e;
		}
		return val;
	}

	// Get css value
	public String getCSSValue(WebElement element, String propertyName) {
		String val = null;
		logger.info("Get CSS value from element " + element);
		try {
			val = element.getCssValue(propertyName);
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find the element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Failed to get CSS value from the element " + e.getMessage());
			throw e;
		}
		return val;
	}

	// Get css value from dynamic element
	public String getCSSValueFromDynamicElement(String element, String txtToReplace, long waitTime,
			String propertyName) {
		String finalLocator;
		String val = null;
		logger.info("Get CSS value from element " + element);
		try {
			finalLocator = element.replaceAll("#", txtToReplace.trim());
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(By.xpath(finalLocator)))));
			val = driver.findElement(By.xpath(finalLocator)).getCssValue(propertyName);
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find the element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Failed to get property vallue from the element " + e.getMessage());
			throw e;
		}
		return val;

	}

	// method press hard enter key
	public void pressEnterKey(WebElement element) {
		try {
			element.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find the element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Failed to press enter key for this element " + e.getMessage());
			throw e;
		}
	}

	// method press hard enter key
	public void pressTabKey(WebElement element) {
		try {
			element.sendKeys(Keys.TAB);
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find the element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Failed to press Tab key for this element " + e.getMessage());
			throw e;
		}
	}

	// @Step("Get text from the element {element}")
	public String getText(WebElement element) {
		String val = null;
		logger.info("Get text from element " + element);
		try {
			waitForElementToBeVisible(element, 10);
			val = element.getText();
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find the element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Failed to get text from the element " + e.getMessage());
			throw e;
		}
		return val;
	}

	// @Step("Get text from the element {element}")
	public String getTextFromDynamicElement(String element, String textToReplace) {
		String val = null;
		logger.info("Get text from dynamic element " + element);
		try {
			WebElement el = findDynamicElement(element, textToReplace);
			val = el.getText();
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find the element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Failed to get text from the element " + e.getMessage());
			throw e;
		}
		return val;
	}

	// @Step("Click on dynamic element {element}")
	public void clickOnDynamicElement(String element, String txtReplace) {
		WebElement el = findDynamicElement(element, txtReplace);
		logger.info("Clicking on element " + element);
		try {
			el.click();
		} catch (NoSuchElementException e) {
			logger.warn("Failed to click on the element " + e.getMessage());
			throw e;
		} catch (WebDriverException e) {
			Actions actions = new Actions(driver);
			actions.moveToElement(el).click().build().perform();
			logger.warn("Element is clicked successfully ");
		} catch (Exception e) {
			logger.warn("Failed to click on the element " + e.getMessage());
			throw e;
		}
	}

	// @Step("Wait For dynamic Element visibility {element}")
	protected boolean waitForDynamicElementToBeVisible(String element, String txtReplace, long timeInSeconds) {
		String finallocator = null;
		boolean isTrue;
		try {
			finallocator = element.replaceAll("#", txtReplace.trim());
			WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(finallocator))));
			logger.info("Element found successfully ");
			isTrue = true;
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find element " + e.getMessage());
			isTrue = false;
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
			isTrue = false;
		}
		return isTrue;
	}

	// @Step("Wait For dynamic Element visibility {element}")
	protected boolean isDynamicElementPresent(String element, String txtReplace, long timeInSeconds) {
		String finallocator = null;
		boolean isTrue;
		try {
			finallocator = element.replaceAll("#", txtReplace.trim());
			WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(finallocator)));
			logger.info("Element found successfully ");
			isTrue = true;
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find element " + e.getMessage());
			isTrue = false;
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
			isTrue = false;
		}
		return isTrue;
	}

	// Get elements size
	public int getSize(List<WebElement> element) {
		int size = 0;
		logger.info("Find size of List elements");
		try {
			size = element.size();
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
			throw e;
		}
		return size;
	}

	//@Step("Select all check boxes")
	protected void selectAllCheckBoxes(List<WebElement> elements) throws Exception {
		try {
			logger.info("Check all check boxes");
			int intCnt = elements.size();
			for (int i = 0; i < intCnt; i++) {
				if (!elements.get(i).isSelected()) {
					this.click(elements.get(i));
				}
			}
		} catch (Exception e) {
			logger.info("Failed to Click Check boxes" + e.getMessage());
			throw e;
		}

	}

	// Click on index element
	public void clickOnListElement(List<WebElement> element, int index) {
		logger.info("Click on row element from List");
		try {
			element.get(index).click();
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
			throw e;
		}

	}

	// Select visibile text
	public void selectVisibleText(WebElement element, String value) {
		logger.info("select list element by visible text");
		try {
			Select select = new Select(element);
			select.selectByVisibleText(value);
		} catch (NoSuchElementException e) {
			logger.warn("Failed to select element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Error selecting the element " + e.getMessage());
			throw e;
		}
	}

	// Select index item from list
	public void selectByIndex(WebElement element, int value) {
		logger.info("select element by index value ");
		try {
			Select select = new Select(element);
			select.selectByIndex(value);
		} catch (NoSuchElementException e) {
			logger.warn("Failed to select element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Error selecting the element " + e.getMessage());
			throw e;
		}
	}
	
	
	public void selectByValue(WebElement element, String value) {
		logger.info("select element by index value ");
		try {
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (NoSuchElementException e) {
			logger.warn("Failed to select element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Error selecting the element " + e.getMessage());
			throw e;
		}
	}

	// Select list item by value
	public void selectListItem(WebElement element, String value, int seconds) {
		logger.info("select list element by value");
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.elementToBeSelected(element));
			List<WebElement> options = element.findElements(By.tagName("option"));
			for (WebElement option : options) {
				if (value.trim().equalsIgnoreCase(option.getText())) {
					option.click();
					break;
				}
			}
		} catch (NoSuchElementException e) {
			logger.warn("Failed to select element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Error selecting the element " + e.getMessage());
			throw e;
		}
	}

	// Get Index of current Item in List
	public int getIndexOfCurrentListItem(WebElement element, String strCurrentItem, int seconds) {
		int index = 0;
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.elementToBeSelected(element));
			List<WebElement> options = element.findElements(By.tagName("option"));
			for (WebElement option : options) {
				if (!(strCurrentItem.trim().equalsIgnoreCase(option.getText())))
					index = index + 1;
				else
					break;
			}
			index = index - 1;

		} catch (NoSuchElementException e) {
			logger.warn("Failed to select element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Error selecting the element " + e.getMessage());
			throw e;
		}
		return index;

	}

	// Get All items from List
	public List<String> getAllItemsFrmList(WebElement element) {
		List<String> temp = new ArrayList<String>();
		int index = 0;
		try {
			List<WebElement> options = element.findElements(By.tagName("option"));
			for (WebElement option : options)
				temp.add(index, option.getText());

		} catch (Exception e) {
			logger.warn("Failed to get list values from List " + e.getMessage());
			throw e;
		}
		return temp;

	}

	// Get Current URL
	public String getCurrentPageURL() {
		String pageTitle = null;
		logger.info("Get Current page URL");
		try {
			this.verifyPageIsLoaded();
			pageTitle = driver.getCurrentUrl();
		} catch (WebDriverException e) {
			logger.warn("Error getting current page URL " + e.getMessage());
			throw e;
		}
		return pageTitle;
	}

	// Get Current page title
	public String getPageTitle() {
		String pageTitle = null;
		logger.info("Get Current page Title");
		try {
			pageTitle = driver.getTitle();
		} catch (WebDriverException e) {
			logger.warn("Error getting current page title " + e.getMessage());
			throw e;
		}
		return pageTitle;
	}

	//@Step("Refresh the page ")
	public void refreshPage() {
		try {
			driver.navigate().refresh();
			logger.info("Page is refreshed successfully ");
		} catch (WebDriverException e) {
			logger.warn("Failed to refresh the page " + e.getMessage());
			throw e;
		}
	}

	//@Step("Navigate back to previous page ")
	public void navigateBackTo() {
		try {
			((JavascriptExecutor) driver).executeScript("javascript: setTimeout(\"history.go(-1)\", 2000)");
			logger.info("Successfully navigated to previous page ");
		} catch (WebDriverException e) {
			driver.navigate().back();
			// logger.warn("Not able to navigate to previous page ");
		} catch (Exception e) {
			logger.warn("Fail to navigate to previous page " + e.getMessage());
			throw e;
		}
	}

	//@Step("Get current window handle ")
	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	//@Step("Switch to current window handle")
	public void switchToWindowHandler(String windowHandler) {
		try {
			driver.switchTo().window(windowHandler);
			Thread.sleep(1000);
		} catch (WebDriverException e) {
			logger.warn("Not able to switch to expected window " + e.getMessage());
			throw e;
		} catch (InterruptedException e) {
			logger.warn("Interrupted exception occurred. " + e.getMessage());
		} catch (Exception e) {
			logger.warn("Not able to switch to expected window " + e.getMessage());
			throw e;
		}
	}

	//@Step("Switch to default content ")
	public void switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			logger.warn("Not able to switch to expected window " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Method to switch to alert
	 * 
	 */
	public String acceptAlert() {
		String alertText = null;
		try {
			logger.warn("switch to alert window ");
			alertText = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (NoAlertPresentException Ex) {
			logger.warn("Not able to switch to expected window " + Ex.getMessage());
		} catch (org.openqa.selenium.UnhandledAlertException ex) {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText().trim();
			alert.accept();
		}
		return alertText;
	}

	public String getTableCellVal(String strXpath, int r, int c) {
		String strText = null;
		try {
			String fullXpath = String.format(strXpath, r, c);
			strText = this.getText(driver.findElement(By.xpath(fullXpath)));
		} catch (Exception e) {
			logger.info("Failed to Click on Table Cell  " + e.getMessage());
		}
		return strText;
	}

	// Validating ascending order
	public boolean isListSorted(List<String> list) {
		boolean sorted = false;
		try {
			List<String> temp = new ArrayList<String>(list);
			Collections.sort(temp);
			sorted = temp.equals(list);
		} catch (Exception e) {
			logger.info("Failed to Sort the list  " + e.getMessage());
		}
		return sorted;
	}

	// Method to convert current date to UTC format
	public String getUTCDateTimeAsString(String dateFormat) {
		String utcTime = null;
		try {
			logger.info("convert Current date to UTC date");
			final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

			utcTime = sdf.format(new Date());
		} catch (Exception e) {
			logger.info("Failed to convert Date to UTC date");

		}
		return utcTime;
	}

	public String getUTCDateTimeAsString(String dateFormat, String strTimeZone) {
		String utcTime = null;
		try {
			logger.info("convert Current date to UTC date");
			final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			sdf.setTimeZone(TimeZone.getTimeZone(strTimeZone));

			utcTime = sdf.format(new Date());
		} catch (Exception e) {
			logger.info("Failed to convert Date to " + strTimeZone + "  date");
		}
		return utcTime;
	}

	//@Step("delete all cookies")
	public void deleteAllCookies() {
		try {
			logger.info("delete all cookies");
			driver.manage().deleteAllCookies();

		} catch (Exception e) {
			logger.info("Failed to delete all cookies");
		}
	}

	//@Step("delete all browser cookies")
	public void deleteAllBrowseCookies() {
		try {
			logger.info("delete all browser cookies");
			driver.manage().deleteAllCookies();
			driver.get("chrome://settings/clearBrowserData");
			driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			logger.info("Failed to delete all cookies");
		}
	}

	// @Step("Get attribute value of Dynamic element")
	protected String getAttributeValueOfDynamicElement(String element, String textToReplace, String attributeName) {
		String strText = null;
		try {
			logger.info("Get Attribute value from Dynamic Element ");
			WebElement el = findDynamicElement(element, textToReplace);
			strText = el.getAttribute(attributeName);
			strText = strText.trim();
		} catch (NoSuchElementException e) {
			logger.warn("Failed to find element " + e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
			throw e;
		}
		return strText;
	}

	// Random alphabetic string
	public String generateRandomString() {
		String strrandom = null;
		try {

			logger.info("generate random String");
			strrandom = RandomStringUtils.randomAlphabetic(10);

		} catch (Exception e) {
			logger.info("Failed to generate random string  " + e.getMessage());
		}
		return strrandom;
	}

	// Random alphabetic string
	public String generateRandomString(int count) {
		String strrandom = null;
		try {

			logger.info("generate random String");
			strrandom = RandomStringUtils.randomAlphabetic(count);

		} catch (Exception e) {
			logger.info("Failed to generate random string  " + e.getMessage());
		}
		return strrandom;
	}

	// Method to delete all cookies
	public void DeleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	// Method to delete cache
	public void DeleteCahe() {
		try {
			Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Method returns a random number within range of numbers
	public static int generateRandomNumber(int min, int max) {
		return (int) (Math.random() * ((max - min) + 1)) + min;
	}

	// This method appends to the number if number length is equals to 1
	public static String getRandomNumberInString(int min, int max) {
		String strNumber = String.valueOf(generateRandomNumber(min, max));
		if (strNumber.length() == 1) {
			strNumber = "0" + strNumber;
		}
		return strNumber;
	}

	// Find dynamic elements(Two elements)
	public WebElement findDynamicElements(String element, String txtReplace, String txtReplace1) {
		WebElement el = null;
		String finallocator = null;
		String finallocator2 = null;

		try {
			finallocator = element.replaceFirst("#", txtReplace.trim());
			finallocator2 = finallocator.replaceFirst("#", txtReplace1.trim());
			el = driver.findElement(By.xpath(finallocator2));
			logger.info("Dynamic element has been found " + finallocator2);
		} catch (Exception e) {
			logger.warn("Error finding dynamic element " + e.getMessage());
			throw e;
		}
		return el;
	}

	// Click on Dynamic elements(Substuites two dynamic elements)
	public void clickOnDynamicElements(String element, String txtReplace, String txtReplace1) {
		WebElement el = findDynamicElements(element, txtReplace, txtReplace1);
		logger.info("Clicking on element " + element);
		try {
			el.click();
		} catch (NoSuchElementException e) {
			logger.warn("Failed to click on the element " + e.getMessage());
			throw e;
		} catch (WebDriverException e) {
			Actions actions = new Actions(driver);
			actions.moveToElement(el).click().build().perform();
			logger.warn("Element is clicked successfully ");
		} catch (Exception e) {
			logger.warn("Failed to click on the element " + e.getMessage());
			throw e;
		}
	}

	// Get All WebElements from List
	public List<WebElement> getWebElementsFrmList(String element) {
		List<WebElement> temp;
		try {
			temp = driver.findElements(By.xpath(element));
		} catch (Exception e) {
			logger.warn("Failed to get list values from List " + e.getMessage());
			throw e;
		}
		return temp;

	}

	public String getDynamicElements(String element, String txtReplace) {
		String finallocator = null;

		try {
			finallocator = element.replaceFirst("#", txtReplace.trim());
			logger.info("Dynamic element has been found " + finallocator);
		} catch (Exception e) {
			logger.warn("Error finding dynamic element " + e.getMessage());
			throw e;
		}
		return finallocator;
	}

	// @Step("Find dynamic elements {txtReplace, txtReplace}")
	public String getDynamicElements(String element, String txtReplace, String txtReplace1) {
		String finallocator = null;
		String finallocator2 = null;

		try {
			finallocator = element.replaceFirst("#", txtReplace.trim());
			finallocator2 = finallocator.replaceFirst("#", txtReplace1.trim());
			logger.info("Dynamic element has been found " + finallocator2);
		} catch (Exception e) {
			logger.warn("Error finding dynamic element " + e.getMessage());
			throw e;
		}
		return finallocator2;
	}

	// move to page up using scroll bar
	protected void windowScrollRight(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
		} catch (Exception e) {
			logger.warn("Error finding the element " + e.getMessage());
			throw e;
		}
	}

	// method to perform double click
	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
		logger.info("Element found, clicking on the element");
	}

	// Reading excel file
	public Sheet readExcel(String filePath, String fileName, String sheetName) throws IOException {
		// Create a object of File class to open xlsx file
		File file = new File(filePath + "/" + fileName);
		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		// Find the file extension by spliting file name in substing and getting
		// only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		// Check condition if the file is xlsx file
		if (fileExtensionName.equals(".xlsx")) {
			// If it is xlsx file then create object of XSSFWorkbook class
			workbook = new XSSFWorkbook(inputStream);
		}
		// Check condition if the file is xls file
		else if (fileExtensionName.equals(".xls")) {
			// If it is xls file then create object of XSSFWorkbook class
			workbook = new HSSFWorkbook(inputStream);
		}
		// Read sheet inside the workbook by its name
		Sheet worksheet = workbook.getSheet(sheetName);
		inputStream.close();
		return worksheet;
	}

	// loading column values to map variable
	public void loadColumnName(Sheet worksheet, String name) {
		// Find number of rows in excel file
		// int rowCount = worksheet.getLastRowNum()-worksheet.getFirstRowNum();
		int colCount = worksheet.getRow(0).getLastCellNum();
		// Loop over all the rows
		Row row = worksheet.getRow(0);
		// Create a loop to print cell values in a row
		for (int j = 0; j < colCount; j++) {
			// Print excel data in console
			if (name.equals("Test")) {
				getcolumnnumberData.put(row.getCell(j).toString(), j);
			} else if (name.equals("Device")) {
				getcolumnnumberDevice.put(row.getCell(j).toString(), j);
			}
		}
	}

	// getting cell value from excel sheets
	public Object getCellValue(Sheet worksheet, String workbookName, String colName, int rowNum) {
		int colnum;
		Object returnval = null;
		// System.out.println("inside get cell value");
		if (workbookName.equals("Test")) {
			// System.out.println("inside workbook" + workbookName);
			// System.out.println(getcolumnnumberData.get(colName));
			colnum = getcolumnnumberData.get(colName);
			// System.out.println(colnum);
			Row row = worksheet.getRow(rowNum);

			returnval = row.getCell(colnum);

			// System.out.println(rowNum+" "+colnum);

			// System.out.println(returnval);
		} else if (workbookName.equals("Device")) {
			colnum = getcolumnnumberDevice.get(colName);
			Row row = worksheet.getRow(rowNum);
			returnval = row.getCell(colnum);
		} else if (workbookName.equals("Module")) {
			colnum = Integer.parseInt(colName);
			Row row = worksheet.getRow(rowNum);
			returnval = row.getCell(colnum);
		}
		return returnval;
	}

	// getting cell value from excel sheets
	public Object getCellValue(String colName, int rowNum, String moduleName) throws Exception {
		Object returnval = null;
		Sheet excelSheetTest;
		try {
			excelSheetTest = readExcel(System.getProperty("user.dir") + BaseDataConstants.TEST_DATA_ROOT_PATH,
					"testdata.xlsx", moduleName);
			loadColumnName(excelSheetTest, "Test");
			returnval = getCellValue(excelSheetTest, "Test", colName, rowNum);
			return returnval;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Getting Row number of excel sheet
	public int getRowNumber(String testname, String moduleName) throws Exception {
		Sheet excelSheetTest;
		int returnval, rowcount;
		try {
			excelSheetTest = readExcel(System.getProperty("user.dir") + BaseDataConstants.TEST_DATA_ROOT_PATH,
					"testdata.xlsx", moduleName);
			loadColumnName(excelSheetTest, "Test");
			rowcount = excelSheetTest.getLastRowNum();
			for (int i = 1; i < rowcount + 1; i++) {
				String temp = getCellValue(excelSheetTest, "Test", "TC_Name", i).toString();
				if (temp.equalsIgnoreCase(testname)) {
					returnval = i;
					return returnval;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Method to read OR
	public Properties getObjectRepository(String path) throws IOException {
		// Read object repository file
		InputStream stream = new FileInputStream(new File(path));
		// load all objects
		p.load(stream);
		return p;
	}

	// method to fetch url in the browser
	public void getURL(String value) throws Exception {
		driver.get(value);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			test.get().log(Status.INFO, "Navigated to " + value);
		} catch (NullPointerException e) {
		}
	}

	// method for copying file from one location to another location
	public void copyFileFromOneLocToAnotherLoc(String sourceLoc, String destinationLoc) throws Exception {
		File source = new File(sourceLoc);
		File dest = new File(destinationLoc);
		try {
			FileUtils.copyDirectory(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// method to verify element is displayed or not
	public Boolean isDisplayed(WebElement element) throws Exception {
		return isElementVisible(element, BaseDataConstants.EXPLICIT_TIMEOUT);
	}

	// method to generate random characters
	public String generateRandomCharacters() throws Exception {
		int length = 4;
		boolean useLetters = false;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString;
	}

	// method to get month based on index value.
	public String getMonth(int no) throws Exception {
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		Calendar cal = Calendar.getInstance();
		return (monthName[cal.get(Calendar.MONTH) - no]);
	}

	// method to get Current date
	public String getCurrentDate() throws Exception {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		return (Integer.toString(calendar.get(Calendar.DATE) - 0));
	}

	// method to get Previous date
	public String getPreviousDaytDate() throws Exception {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		return (Integer.toString(calendar.get(Calendar.DATE) - 1));
	}

	public String getNextDaytDate() throws Exception {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		return (Integer.toString(calendar.get(Calendar.DATE) + 1));
	}

	/**
	 * @author fasiulla.d@shell.com
	 * @param days Format, +/- Day
	 * @throws Exception
	 */
	public String getDateFromParameter(String format, int days) throws Exception {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		date = calendar.getTime();
		String generatedDate = new SimpleDateFormat(format).format(date);
		return generatedDate.toString();
	}

	// method to create new file
	public void createNewFile(String path) throws IOException {
		File file = new File(path);
		file.createNewFile();
	}

	// method to create environment file in allure-results folder
	public void setEnvironment(String path, String propertyValue, String propertyName) throws Exception {
		FileOutputStream fileOutputStream = new FileOutputStream(path + "\\environment.properties");
		p.setProperty(propertyValue, propertyName);
		p.store(fileOutputStream, null);
		fileOutputStream.close();
	}

	// method to convert string list to list
	public List<String> convertTestdataListStringToList(String listString) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(listString, new TypeReference<List<String>>() {
		});
	}

	/*
	 * // method to click using sikuli public void clickUsingSikuli(String
	 * imagePath) throws Exception { Pattern object = new Pattern(imagePath);
	 * screen.wait(object, 10); screen.click(object); }
	 */

	// method to verify the element is not null
	public Boolean isElementNotNull(WebElement element) throws Exception {
		if (element.getText().toString() != null) {
			return true;
		} else {
			return false;
		}
	}

	// method to get current date, month and year
	public String getCurrentDateMonthYear() throws Exception {
		Date date = new Date();
		return new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(date);
	}

	// method to verify the downloaded file is in downloads folder
	public boolean downloadFile(String fileName) {
		Boolean flag = false;
		String home = System.getProperty("user.home");
		File dir = new File(home + "/Downloads");
		String[] files = dir.list();
		if (files.length == 0) {

		} else {
			for (String file : files) {
				if (file.startsWith(fileName)) {
					flag = true;
				}
			}
		}
		return flag;
	}

	// method to delete the downloaded file from downloads folder
	public boolean deleteFile(String fileName) throws Exception {
		Boolean flag = false;
		String home = System.getProperty("user.home");
		File dir = new File(home + "/Downloads");
		File[] files = dir.listFiles();
		if (files.length == 0) {

		} else {
			for (File file : files) {
				if (file.getName().startsWith(fileName)) {
					file.delete();
					flag = true;
				}
			}
		}
		return flag;
	}

	// method to get all dropdown values from the dropdown
	public List<WebElement> getAllSelectOptions(WebElement element) throws Exception {
		Select select = new Select(element);
		return select.getOptions();
	}

	// method to get array list after splitting commas
	public ArrayList<String> getArrayListAfterSplittingCommas(String list) throws Exception {
		ArrayList<String> list1 = new ArrayList<String>();
		String[] a = list.split(",");
		for (int i = 0; i < a.length; i++) {
			list1.add(a[i]);
		}
		return list1;
	}

	// method to click an element from clickable dropdown
	public void clickOnElementFromClickableDropdown(List<WebElement> element, String name) throws Exception {
		for (WebElement element1 : element) {
			if (element1.getText().equals(name)) {
				element1.click();
				break;
			}
		}
	}

	// method to verify the element is selected or checked or not
	public Boolean isSelected(WebElement element) throws Exception {
		return element.isSelected();
	}

	public synchronized void writeDTMUserConfigurations(String data, String userName) {
		try {
			if (System.getenv("COMPUTERNAME").startsWith("ZEW")) // VM name starts with "ZEW"
				return;
			String DIR_PATH = System.getProperty("user.dir") + BaseDataConstants.DTM_USER_CONFIG_STORE_PATH;
			String FILE_PATH = DIR_PATH + userName + ".json";
			File directory = new File(DIR_PATH);
			if (!directory.exists() && !directory.mkdir())
				throw new IOException("Directory Creation Failed");
			FileOutputStream fos = new FileOutputStream(FILE_PATH);
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeBytes(data.trim());
			dos.close();
			fos.close();
		} catch (IOException er) {
			logger.warn("Failed to Create User Data File");
			logger.warn(er.getMessage());
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
	}

	public int generateRandomNumber(int range) throws Exception {
		Random random = new Random();
		return random.nextInt(range);
	}

	public boolean verifyDateFormat(String format, String date) {
		System.out.println(date);
		String pattern;
		switch (format) {
		case "dd.mm.yyyy":
			pattern = "[0-3]{1}[0-9]{1}\\.{1}(0[1-9]{1}|1[012]{1})\\.[0-9]{4}";
			return date.matches(pattern);
		case "dd/mm/yyyy":
			pattern = "[0-3]{1}[0-9]{1}\\/{1}(0[1-9]{1}|1[012]{1})\\/[0-9]{4}";
			return date.matches(pattern);
		case "dd-mm-yyyy":
			pattern = "[0-3]{1}[0-9]{1}\\-{1}(0[1-9]{1}|1[012]{1})\\-[0-9]{4}";
			return date.matches(pattern);
		case "mm/dd/yyyy":
			pattern = "(0[1-9]{1}|1[012]{1})\\/[0-3]{1}[0-9]{1}\\/{1}[0-9]{4}";
			return date.matches(pattern);
		case "yyyy/mm/dd":
			pattern = "[0-9]{4}\\/(0[1-9]{1}|1[012]{1})\\/{1}[0-3]{1}[0-9]{1}";
			return date.matches(pattern);
		case "yyyy-mm-dd":
			pattern = "[0-9]{4}\\-(0[1-9]{1}|1[012]{1})\\-{1}[0-3]{1}[0-9]{1}";
			return date.matches(pattern);
		default:
			return false;
		}
	}

	public void rightClick(WebElement element) throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(element).contextClick(element).build().perform();
	}

	public String getDigitalData(String name) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String getScript = "var data = digitalData ; return data." + name + ";";
		return js.executeScript(getScript).toString();

	}

	public String getOrderStatus(String name) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String getScript = "var data = digitalData ; return data." + name + ";";
		return js.executeScript(getScript).toString();

	}

	public String getSatelliteData(String name) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String getScript = "var data = _satellite.getVar(" + name + "); return data;";
		return js.executeScript(getScript).toString();
	}

	public void closeMedalliaPopup(WebElement medalliaPopup) throws Exception {
		waitForClickableElement(BaseDataConstants.IMPLICIT_TIMEOUT, medalliaPopup);
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("" + "document.getElementById(\"kampyleFormContainer\").remove();\n"
				+ "document.getElementsByTagName('body')[0].style['overflow']='scroll';");
	}

	public boolean isPrinterElementDisplayed(WebElement element) {
		boolean bIsElementDisplayed = false;
		try {
			if (element.isDisplayed()) {
				bIsElementDisplayed = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bIsElementDisplayed;
	}

	public Boolean isEnabled(WebElement element) throws Exception {
		Boolean isEnabled = false;
		Thread.sleep(1500);
		try {
			isEnabled = element.isEnabled();
		} catch (NoSuchElementException e) {
		}
		return isEnabled;
	}
	
	public String getColor(WebElement element) throws Exception {
		return element.getCssValue("color");
	}
	
	public StringBuilder readTextFile(String fileName) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		String home = System.getProperty("user.home");
		File dir = new File(home + "/Downloads");
		String[] files = dir.list();
		if (files.length == 0) {

		} else {
			for (String file : files) {
				if (file.startsWith(fileName)) {		
					try {
					      File myObj = new File(dir+"\\"+fileName);
					      Scanner myReader = new Scanner(myObj);
					      while (myReader.hasNextLine()) {
					    	  stringBuilder.append(myReader.nextLine());
					        //logger.info(data);
					      }
					      myReader.close();
					    } catch (FileNotFoundException e) {
					    	logger.error("Exception occured while reading text file");
					      e.printStackTrace();
					    }
				}
			}
		}
		return stringBuilder;
	}
	
	public void closePrintWindow() throws Exception {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
}
