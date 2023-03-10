package com.shell.markethub.crossbusiness.tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.shell.markethub.base.pageobjects.BasePageObject;
import com.shell.markethub.base.util.BaseSetup;
import com.shell.markethub.base.util.BaseTest;
import com.shell.markethub.base.util.config.BaseDataConstants;
import com.shell.markethub.crossbusiness.pageobjects.Error404Page;
import com.shell.markethub.crossbusiness.pageobjects.SearchResultsPage;
import com.shell.markethub.crossbusiness.pageobjects.SectorsPage;
import com.shell.markethub.integration.pageobjects.HomePage;
import com.shell.markethub.integration.pageobjects.LoginPage;
import com.shell.markethub.uam.pageobjects.SearchCustomerUserPage;
/**
 * 
 * @author N.Kumar8@shell.com
 * 
 */
public class CrossBusinessBaseTest extends BaseTest {

	protected LoginPage loginPage;
	protected HomePage homePage;
	protected BaseSetup baseSetup;
	protected SectorsPage sectorsPage;
	protected SearchResultsPage searchResultsPage;
	protected Error404Page error404Page;
	protected SearchCustomerUserPage searchCustomerUserPage; 
	
	@BeforeMethod
	public void setUp(ITestContext context) {
		loadPageObjects();
	}

	/**
	 * @param context
	 * @throws IOException
	 * @description This class will be called immediately after running testng.xml
	 *              and baseSetup beforesuite method will be overridden
	 */
	@Test
	public void beforeSuite(ITestContext context) throws IOException {
		baseSetup = new BaseSetup();
		baseSetup.beforeSuite(context);
	}

	/**
	 * @param driver
	 * @description This method will load all page objects
	 */
	public void loadPageObjects() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		sectorsPage = new SectorsPage(driver);
		searchResultsPage = new SearchResultsPage(driver);
		error404Page = new Error404Page(driver);
		searchCustomerUserPage=new SearchCustomerUserPage(driver);
	}
	
	// Use this method to create a new driver instance
	public WebDriver loadNewInstance(ITestContext context) throws Exception {
		loadPageObjects();
		String deviceName = (String) context.getAttribute("deviceName");
		String appType = (String) context.getAttribute("appType");
		String platformVersion = (String) context.getAttribute("platformVersion");
		String node = (String) context.getAttribute("node");
		WebDriver newInstance = setDriver(appType, node, deviceName, platformVersion);
		newInstance.manage().window().maximize();
		return newInstance;
	}
	
	// Use this method to switch to a driver instance
	public WebDriver switchToInstance(WebDriver driver) throws InterruptedException {
		loadPageObjects();
		this.driver = driver;
		//logger.info(driver.getTitle());
		Thread.sleep(1000);
		return driver;
	}
}
