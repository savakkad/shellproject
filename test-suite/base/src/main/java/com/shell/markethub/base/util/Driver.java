package com.shell.markethub.base.util;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shell.markethub.base.pageobjects.BasePageObject;
import com.shell.markethub.base.util.config.BaseDataConstants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author N.Kumar8
 * @description This class will initiate driver instance
 * @retun driver
 */
public class Driver {

	public WebDriver driver;
	private static Logger logger = LogManager.getLogger(Driver.class);
	private DesiredCapabilities capabilities;
	protected BasePageObject basePageObject;
	private static final Proxy proxy = new Proxy();

	@SuppressWarnings("deprecation")
	public WebDriver setDriver(String appType, String node, String deviceName, String platformVersion)
			throws Exception {
		try {
			switch (appType) {
			case "firefox":
				System.setProperty("webdriver.gecko.driver",
						BaseDataConstants.PROJECT_ROOT_LOCATION + BaseDataConstants.GECKO_DRIVER_PATH);
				capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				driver = new FirefoxDriver(capabilities);
				driver.manage().window().maximize();
				break;

			case "chrome": {
				capabilities = DesiredCapabilities.chrome();
				setProxyServerInBrowserCapabilities(capabilities);
				System.setProperty("webdriver.chrome.driver",
						BaseDataConstants.PROJECT_ROOT_LOCATION + BaseDataConstants.CHROME_DRIVER_PATH);
				ChromeOptions options = new ChromeOptions();
				/*
				 * options.addArguments("enable-automation");
				 * options.addArguments("--headless");
				 * options.addArguments("--window-size=1920,1080");
				 * options.addArguments("--no-sandbox");
				 * options.addArguments("--disable-extensions");
				 */
				options.addArguments("--dns-prefetch-disable");
				options.addArguments("--disable-gpu");
				options.addArguments("--user-agent=shell-automated-test");
				// options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.content_settings.exceptions.clipboard", getClipBoardSettingsMap(1));
				prefs.put("safebrowsing.enabled", "false");
				prefs.put("download.prompt_for_download", "false");
				options.setExperimentalOption("prefs", prefs);
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				break;
			}
			case "ie":
				capabilities = DesiredCapabilities.internetExplorer();
				System.setProperty("webdriver.ie.driver",
						BaseDataConstants.PROJECT_ROOT_LOCATION + BaseDataConstants.IEXPLORER_DRIVER_PATH);
				capabilities.setCapability("ignoreZoomSetting", true);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				capabilities.setCapability("requireWindowFocus", true);
				driver = new InternetExplorerDriver(capabilities);
				driver.manage().window().maximize();
				break;

			case "edge":
				System.setProperty("webdriver.edge.driver",
						BaseDataConstants.PROJECT_ROOT_LOCATION + BaseDataConstants.EDGE_DRIVER_PATH);
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				break;

			case "mobileChrome":
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("deviceName", deviceName);
				capabilities.setCapability("platformVersion", platformVersion);
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("automationName", "UiAutomator2");
				capabilities.setCapability("browserName", "chrome");
				capabilities.setCapability("fullReset", "false");
				capabilities.setCapability("noReset", "true");
				System.setProperty("webdriver.chrome.driver",
						BaseDataConstants.PROJECT_ROOT_LOCATION + BaseDataConstants.CHROME_DRIVER_PATH);
				driver = new AndroidDriver<MobileElement>(new URL("http://" + node + "/wd/hub"), capabilities);
				break;

			case "mobileSafari":
				DesiredCapabilities capabilities1 = new DesiredCapabilities();
				capabilities1.setCapability("deviceName", deviceName);
				capabilities1.setCapability("platformName", "iOS");
				capabilities1.setCapability("platformVersion", platformVersion);
				capabilities1.setCapability("browserName", "Safari");
				// capabilities1.setCapability("udid", deviceName);
				capabilities1.setCapability("fullReset", "false");
				capabilities1.setCapability("noReset", "true");
				driver = new IOSDriver(new URL("http://" + node + "/wd/hub"), capabilities1);
				break;

			case "chromeRemote":
				DesiredCapabilities capabilities4 = new DesiredCapabilities();
				System.setProperty("webdriver.chrome.driver",
						BaseDataConstants.PROJECT_ROOT_LOCATION + BaseDataConstants.CHROME_DRIVER_PATH);
				capabilities4.setCapability("browserName", "chrome");
				setProxyServerInBrowserCapabilities(capabilities4);
				driver = new RemoteWebDriver(new URL("http://" + node + "/wd/hub"), capabilities4);
				driver.manage().window().maximize();
				break;

			case "ieRemote":
				DesiredCapabilities capabilities5 = new DesiredCapabilities();
				System.setProperty("webdriver.ie.driver",
						BaseDataConstants.PROJECT_ROOT_LOCATION + BaseDataConstants.IEXPLORER_DRIVER_PATH);
				capabilities5.setCapability("browserName", "internetexplorer");
				setProxyServerInBrowserCapabilities(capabilities5);
				driver = new RemoteWebDriver(new URL("http://" + node + "/wd/hub"), capabilities5);
				break;

			case "chromium": {
				capabilities = DesiredCapabilities.chrome();
				setProxyServerInBrowserCapabilities(capabilities);
				System.setProperty("webdriver.chrome.driver",
						BaseDataConstants.PROJECT_ROOT_LOCATION + BaseDataConstants.CHROME_DRIVER_PATH);
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.content_settings.exceptions.clipboard", getClipBoardSettingsMap(1));
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-features=RendererCodeIntegrity");
				// Keep Chromium installation in directory
				options.setBinary("C:\\Apps\\chrome-win\\chrome.exe");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				break;
			}
			case "chromeClearCacheCookies": {
				capabilities = DesiredCapabilities.chrome();
				setProxyServerInBrowserCapabilities(capabilities);
				System.setProperty("webdriver.chrome.driver",
						BaseDataConstants.PROJECT_ROOT_LOCATION + BaseDataConstants.CHROME_DRIVER_PATH);
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.content_settings.exceptions.clipboard", getClipBoardSettingsMap(1));
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);
				driver.manage().deleteAllCookies();
				driver.get("chrome://settings/clearBrowserData");
				driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
				driver.manage().window().maximize();
				break;

			}
			case "localChromeRemote": {
				
				System.setProperty("webdriver.chrome.driver",
						BaseDataConstants.PROJECT_ROOT_LOCATION + BaseDataConstants.CHROME_DRIVER_PATH);
				capabilities = DesiredCapabilities.chrome();
				setProxyServerInBrowserCapabilities(capabilities);
				ChromeOptions options = new ChromeOptions();
				
				  options.addArguments("enable-automation");
				  options.addArguments("--headless");
				  options.addArguments("--window-size=1920,1080");
				  options.addArguments("--no-sandbox");
				  options.addArguments("--disable-extensions");
				  options.addArguments("--disable-dev-shm-usage");
				 
				options.addArguments("--dns-prefetch-disable");
				options.addArguments("--disable-gpu");
				options.addArguments("--user-agent=shell-automated-test");
				// options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.content_settings.exceptions.clipboard", getClipBoardSettingsMap(1));
				prefs.put("safebrowsing.enabled", "false");
				prefs.put("download.prompt_for_download", "false");
				options.setExperimentalOption("prefs", prefs);
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new RemoteWebDriver(new URL("http://" + node + "/wd/hub"), capabilities);
				driver.manage().window().maximize();
				
				/*
				System.setProperty("webdriver.gecko.driver",
						BaseDataConstants.PROJECT_ROOT_LOCATION + BaseDataConstants.GECKO_DRIVER_PATH);
				capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				setProxyServerInBrowserCapabilities(capabilities);
				*/
				/*
				System.setProperty("webdriver.chrome.driver",
						BaseDataConstants.PROJECT_ROOT_LOCATION + BaseDataConstants.CHROME_DRIVER_PATH);
				DesiredCapabilities capabilities6 = new DesiredCapabilities();
				capabilities6.setCapability("browserName", "chrome");
				setProxyServerInBrowserCapabilities(capabilities6);
				driver = new RemoteWebDriver(new URL("http://" + node + "/wd/hub"), capabilities6);
				driver.manage().window().maximize();
				*/
				break;
			}
			case "api":
				return null;
			}

		} catch (Exception e) {
			logger.info("Error launching Browser--" + e.getMessage());
		} finally {
			basePageObject = PageFactory.initElements(driver, BasePageObject.class);
		}
		return driver;
	}

	/**
	 * @param input as 1 to allow/ input as 2 to dismiss
	 * @throws Exception
	 * @author fasiulla.d@shell.com
	 * @story
	 */
	private Map getClipBoardSettingsMap(int settingValue) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<>();
		map.put("last_modified", String.valueOf(System.currentTimeMillis()));
		map.put("setting", settingValue);
		Map<String, Object> cbPreference = new HashMap<>();
		cbPreference.put("[*.],*", map);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(cbPreference);
		logger.info("clipboardSettingJson: " + json);
		return cbPreference;
	}

	private void setProxyServerInBrowserCapabilities(final DesiredCapabilities capabilities) {
		final Proxy proxy = new Proxy();
		proxy.setProxyType(Proxy.ProxyType.MANUAL);
		proxy.setHttpProxy("proxy-eu.shell.com:8080");
		proxy.setSslProxy("proxy-eu.shell.com:8080");
		capabilities.setCapability("proxy", proxy);
	}

}
