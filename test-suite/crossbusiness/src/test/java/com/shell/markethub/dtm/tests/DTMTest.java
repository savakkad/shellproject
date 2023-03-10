package com.shell.markethub.dtm.tests;

import org.apache.logging.log4j.*;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.shell.markethub.base.util.config.BaseDataConstants;
import com.shell.markethub.crossbusiness.tests.CrossBusinessBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
 

public class DTMTest extends CrossBusinessBaseTest{
	
	private static final Logger logger = LogManager.getLogger(DTMTest.class);

	@BeforeMethod
	public void setUp(ITestContext context) {
		super.setUp(context);
	}

	@Feature("Cross Business - DTM")
	@Test(groups = "regression")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Home, Section, Language, Status, Username, Password, Country, ID, Persona, Role, Company Name, Company ID, COB, LOB, Operation Unit Digital Data")
	public void DTM_TC01_Verify_Digital_Data_For_Retail_User_With_Single_Role_And_On_Home_Page(ITestContext context)
			throws Exception {
		String name = testData.get("name").toString();
		String status = testData.get("status").toString();
		String language = testData.get("language").toString();
		String section = testData.get("section").toString();
		String userName = testData.get("userName").toString();
		String password = testData.get("password").toString();
		String homeName = testData.get("homeName").toString();
		String homeSection = testData.get("homeSection").toString();
		String country = testData.get("country").toString();
		String homeLanguage = testData.get("homeLanguage").toString();
		String userID = testData.get("userID").toString();
		String userStatus = testData.get("userStatus").toString();
		String userPersona = testData.get("userPersona").toString();
		String userRole = testData.get("userRole").toString();
		String companyName = testData.get("companyName").toString();
		String companyID = testData.get("companyID").toString();
		String COB = testData.get("COB").toString();
		String LOB = testData.get("LOB").toString();
		String operationUnit = testData.get("operationUnit").toString();
		
		
		loginPage.getMarketHubHomePage(BaseDataConstants.MARKETHUB_AUT_URL);
		assertEquals(loginPage.verifyLoginPageDigitalData(), name, "Verify Name Digital Data");
		assertEquals(loginPage.verifySectionDigitalData(), section, "Verify Section Digital Data");
		assertEquals(loginPage.verifyLanguageDigitalData(), language, "Verify Language Digital Data");
		assertEquals(loginPage.verifyStatusDigitalData(), status, "Verify Status Digital Data");
		loginPage.loginMarketHub(userName, password);
		logger.info("Logged in");
		
		assertEquals(homePage.verifyNameDigitalData(), homeName, "Verify Name Digital Data");
		assertEquals(homePage.verifySectionDigitalData(), homeSection, "Verify Section Digital Data");
		assertEquals(homePage.verifyCountryDigitalData(), country, "Verify Country Digital Data");
		assertEquals(homePage.verifyLanguageDigitalData(), homeLanguage, "Verify Language Digital Data");
		assertEquals(homePage.verifyUserIDDigitalData(), userID, "Verify User ID Digital Data");
		assertEquals(homePage.verifyUserStatusDigitalData(), userStatus, "Verify User Status Digital Data");
		assertEquals(homePage.verifyUserPersonaDigitalData(), userPersona, "Verify User Persona Digital Data");
		assertEquals(homePage.verifyUserRole1DigitalData(), userRole, "Verify User Role Digital Data");
		assertEquals(homePage.verifyCompanyNameDigitalData(), companyName, "Verify Company Name Digital Data");
		assertEquals(homePage.verifyCompanyIDDigitalData(), "00"+companyID, "Verify Company ID Digital Data");
		assertEquals(homePage.verifyCOBDigitalData(), COB, "Verify COB Digital Data");
		assertEquals(homePage.verifyLOBDigitalData(), LOB, "Verify LOB Digital Data");
		assertEquals(homePage.verifyOperationUnitDigitalData(), operationUnit, "Verify Name Digital Data");
		assertAll();
	}
	
	@Feature("Cross Business - DTM")
	@Test(groups = "regression")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Home, Section, Language, Status, Username, Password, Country, ID, Persona, Role, Company Name, Company ID, COB, LOB, Operation Unit Digital Data")
	public void DTM_TC02_Verify_Digital_Data_For_Distributor_User_With_Multiple_Roles_And_On_Home_Page(ITestContext context)
			throws Exception {
		String name = testData.get("name").toString();
		String status = testData.get("status").toString();
		String language = testData.get("language").toString();
		String section = testData.get("section").toString();
		String userName = testData.get("userName").toString();
		String password = testData.get("password").toString();
		String homeName = testData.get("homeName").toString();
		String homeSection = testData.get("homeSection").toString();
		String country = testData.get("country").toString();
		String homeLanguage = testData.get("homeLanguage").toString();
		String userID = testData.get("userID").toString();
		String userStatus = testData.get("userStatus").toString();
		String userPersona = testData.get("userPersona").toString();
		String userRole1 = testData.get("userRole1").toString();
		String userRole2 = testData.get("userRole2").toString();
		String companyName = testData.get("companyName").toString();
		String companyID = testData.get("companyID").toString();
		String COB = testData.get("COB").toString();
		String LOB = testData.get("LOB").toString();
		String operationUnit = testData.get("operationUnit").toString();
		
		loginPage.getMarketHubHomePage(BaseDataConstants.MARKETHUB_AUT_URL);
		assertEquals(loginPage.verifyLoginPageDigitalData(), name, "Verify Name Digital Data");
		assertEquals(loginPage.verifySectionDigitalData(), section, "Verify Section Digital Data");
		assertEquals(loginPage.verifyLanguageDigitalData(), language, "Verify Language Digital Data");
		assertEquals(loginPage.verifyStatusDigitalData(), status, "Verify Status Digital Data");
		loginPage.loginMarketHub(userName, password);
		
		assertEquals(homePage.verifyNameDigitalData(), homeName, "Verify Name Digital Data");
		assertEquals(homePage.verifySectionDigitalData(), homeSection, "Verify Section Digital Data");
		assertEquals(homePage.verifyCountryDigitalData(), country, "Verify Country Digital Data");
		assertEquals(homePage.verifyLanguageDigitalData(), homeLanguage, "Verify Language Digital Data");
		assertEquals(homePage.verifyUserIDDigitalData(), userID, "Verify User ID Digital Data");
		assertEquals(homePage.verifyUserStatusDigitalData(), userStatus, "Verify User Status Digital Data");
		assertEquals(homePage.verifyUserPersonaDigitalData(), userPersona, "Verify User Persona Digital Data");
		assertEquals(homePage.verifyUserRole1DigitalData(), userRole1, "Verify User Role Digital Data");
		assertEquals(homePage.verifyUserRole2DigitalData(), userRole2, "Verify User Role Digital Data");
		assertEquals(homePage.verifyCompanyNameDigitalData(), companyName, "Verify Company Name Digital Data");
		assertEquals(homePage.verifyCompanyIDDigitalData(), "00"+companyID, "Verify Company ID Digital Data");
		assertEquals(homePage.verifyCOBDigitalData(), COB, "Verify COB Digital Data");
		assertEquals(homePage.verifyLOBDigitalData(), LOB, "Verify LOB Digital Data");
		assertEquals(homePage.verifyOperationUnitDigitalData(), operationUnit, "Verify Name Digital Data");
		assertAll();
	}
	
	@Feature("Cross Business - DTM")
	@Test(groups = "regression")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Home, Section, Language, Status, Username, Password, Country, ID, Persona, Role, Company Name, Company ID, COB, LOB, Operation Unit Digital Data")
	public void DTM_TC03_Verify_Digital_Data_For_Marine_User_With_Single_Role_And_On_Home_Page(ITestContext context)
			throws Exception {
		String name = testData.get("name").toString();
		String status = testData.get("status").toString();
		String language = testData.get("language").toString();
		String section = testData.get("section").toString();
		String userName = testData.get("userName").toString();
		String password = testData.get("password").toString();
		String homeName = testData.get("homeName").toString();
		String homeSection = testData.get("homeSection").toString();
		String country = testData.get("country").toString();
		String homeLanguage = testData.get("homeLanguage").toString();
		String userID = testData.get("userID").toString();
		String userStatus = testData.get("userStatus").toString();
		String userPersona = testData.get("userPersona").toString();
		String userRole = testData.get("userRole").toString();
		String companyName = testData.get("companyName").toString();
		String companyID = testData.get("companyID").toString();
		String COB = testData.get("COB").toString();
		String LOB = testData.get("LOB").toString();
		String operationUnit = testData.get("operationUnit").toString();
		
		loginPage.getMarketHubHomePage(BaseDataConstants.MARKETHUB_AUT_URL);
		assertEquals(loginPage.verifyLoginPageDigitalData(), name, "Verify Name Digital Data");
		assertEquals(loginPage.verifySectionDigitalData(), section, "Verify Section Digital Data");
		assertEquals(loginPage.verifyLanguageDigitalData(), language, "Verify Language Digital Data");
		assertEquals(loginPage.verifyStatusDigitalData(), status, "Verify Status Digital Data");
		loginPage.loginMarketHub(userName, password);
		
		assertEquals(homePage.verifyNameDigitalData(), homeName, "Verify Name Digital Data");
		assertEquals(homePage.verifySectionDigitalData(), homeSection, "Verify Section Digital Data");
		assertEquals(homePage.verifyCountryDigitalData(), country, "Verify Country Digital Data");
		assertEquals(homePage.verifyLanguageDigitalData(), homeLanguage, "Verify Language Digital Data");
		assertEquals(homePage.verifyUserIDDigitalData(), userID, "Verify User ID Digital Data");
		assertEquals(homePage.verifyUserStatusDigitalData(), userStatus, "Verify User Status Digital Data");
		assertEquals(homePage.verifyUserPersonaDigitalData(), userPersona, "Verify User Persona Digital Data");
		assertEquals(homePage.verifyUserRole1DigitalData(), userRole, "Verify User Role Digital Data");
		assertEquals(homePage.verifyCompanyNameDigitalData(), companyName, "Verify Company Name Digital Data");
		assertEquals(homePage.verifyCompanyIDDigitalData(), "00"+companyID, "Verify Company ID Digital Data");
		assertEquals(homePage.verifyCOBDigitalData(), COB, "Verify COB Digital Data");
		assertEquals(homePage.verifyLOBDigitalData(), LOB, "Verify LOB Digital Data");
		assertEquals(homePage.verifyOperationUnitDigitalData(), operationUnit, "Verify Name Digital Data");
		assertAll();
	}
	
	@Feature("Cross Business - DTM")
	@Test(groups = "regression")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Home, Section, Language, Status, Username, Password, Country, ID, Persona, Role, Company Name, Company ID, COB, LOB, Operation Unit Digital Data")
	public void DTM_TC04_Verify_Digital_Data_For_Distributor_User_With_Single_Role_And_On_Sectors_Page(ITestContext context)
			throws Exception {
		String userName = testData.get("userName").toString();
		String password = testData.get("password").toString();
		String name = testData.get("name").toString();
		String section = testData.get("section").toString();
		String country = testData.get("country").toString();
		String language = testData.get("language").toString();
		String userID = testData.get("userID").toString();
		String userStatus = testData.get("userStatus").toString();
		String userPersona = testData.get("userPersona").toString();
		String userRole1 = testData.get("userRole1").toString();
		String userRole2 = testData.get("userRole2").toString();
		String companyName = testData.get("companyName").toString();
		String companyID = testData.get("companyID").toString();
		String COB = testData.get("COB").toString();
		String LOB = testData.get("LOB").toString();
		String sectorsURL = testData.get("sectorsURL").toString();
		String operationUnit = testData.get("operationUnit").toString();
		
		loginPage.getMarketHubHomePage(BaseDataConstants.MARKETHUB_AUT_URL);
		loginPage.loginMarketHub(userName, password);
		homePage.goToURL(sectorsURL);
		
		assertEquals(sectorsPage.verifyNameDigitalData(), name, "Verify Name Digital Data");
		assertEquals(sectorsPage.verifySectionDigitalData(), section, "Verify Section Digital Data");
		assertEquals(sectorsPage.verifyCountryDigitalData(), country, "Verify Country Digital Data");
		assertEquals(sectorsPage.verifyLanguageDigitalData(), language, "Verify Language Digital Data");
		assertEquals(sectorsPage.verifyUserIDDigitalData(), userID, "Verify User ID Digital Data");
		assertEquals(sectorsPage.verifyUserStatusDigitalData(), userStatus, "Verify User Status Digital Data");
		assertEquals(sectorsPage.verifyUserPersonaDigitalData(), userPersona, "Verify User Persona Digital Data");
		assertEquals(sectorsPage.verifyUserRole1DigitalData(), userRole1, "Verify User Role Digital Data");
		assertEquals(sectorsPage.verifyUserRole2DigitalData(), userRole2, "Verify User Role Digital Data");
		assertEquals(sectorsPage.verifyCompanyNameDigitalData(), companyName, "Verify Company Name Digital Data");
		assertEquals(sectorsPage.verifyCompanyIDDigitalData(), "00"+companyID, "Verify Company ID Digital Data");
		assertEquals(sectorsPage.verifyCOBDigitalData(), COB, "Verify COB Digital Data");
		assertEquals(sectorsPage.verifyLOBDigitalData(), LOB, "Verify LOB Digital Data");
		assertEquals(sectorsPage.verifyOperationUnitDigitalData(), operationUnit, "Verify Name Digital Data");
		assertAll();
	}
	
	@Feature("Cross Business - DTM")
	@Test(groups = "regression")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Page Term, Page Type, Page Result Digital Data")
	public void DTM_TC05_Verify_Digital_Data_On_Search_Results_Page(ITestContext context)
			throws Exception {
		String userName = testData.get("userName").toString();
		String password = testData.get("password").toString();
		String searchTerm = testData.get("searchTerm").toString();
		String searchResult = testData.get("searchResult").toString();
		String searchType = testData.get("searchType").toString();
		String productName = testData.get("productName").toString();
		
		loginPage.getMarketHubHomePage(BaseDataConstants.MARKETHUB_AUT_URL);
		loginPage.loginMarketHub(userName, password);
		homePage.enterSearch(productName);
		homePage.clickOnSearchButton();
				
		assertEquals(searchResultsPage.verifyAEMSearchTermDigitalData(), searchTerm, "Verify Search Term Digital Data");
		assertEquals(searchResultsPage.verifyAEMSearchResultDigitalData(), searchResult, "Verify Search Result Digital Data");
		assertEquals(searchResultsPage.verifyAEMSearchTypeDigitalData(), searchType, "Verify Search Type Digital Data");
		assertAll();
	}

	@Feature("Cross Business - DTM")
	@Test(groups = "regression")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Error, Error Code, Error URL Digital Data On 404 Error Page")
	public void DTM_TC06_Verify_Digital_Data_On_404_Error_Page(ITestContext context)
			throws Exception {
		String userName = testData.get("userName").toString();
		String password = testData.get("password").toString();
		String name = testData.get("name").toString();
		String section = testData.get("section").toString();
		String country = testData.get("country").toString();
		String language = testData.get("language").toString();
		String userID = testData.get("userID").toString();
		String userStatus = testData.get("userStatus").toString();
		String userPersona = testData.get("userPersona").toString();
		String userRole1 = testData.get("userRole1").toString();
		String companyName = testData.get("companyName").toString();
		String companyID = testData.get("companyID").toString();
		String COB = testData.get("COB").toString();
		String LOB = testData.get("LOB").toString();
		String operationUnit = testData.get("operationUnit").toString();
		String Error404URL = testData.get("Error404URL").toString();
		String pageError = testData.get("pageError").toString();
		String pageErrorCode = testData.get("pageErrorCode").toString();
		String pageErrorURL = testData.get("pageErrorURL").toString();
		
		loginPage.getMarketHubHomePage(BaseDataConstants.MARKETHUB_AUT_URL);
		loginPage.loginMarketHub(userName, password);
		homePage.goToURL(Error404URL);
		
		//assertEquals(error404Page.verifyNameDigitalData(), name, "Verify Name Digital Data");
		//assertEquals(error404Page.verifySectionDigitalData(), section, "Verify Section Digital Data");
		//assertEquals(error404Page.verifyCountryDigitalData(), country, "Verify Country Digital Data");
		//assertEquals(error404Page.verifyLanguageDigitalData(), language, "Verify Language Digital Data");
		assertEquals(error404Page.verifyUserIDDigitalData(), userID, "Verify User ID Digital Data");
		assertEquals(error404Page.verifyUserStatusDigitalData(), userStatus, "Verify User Status Digital Data");
		assertEquals(error404Page.verifyUserPersonaDigitalData(), userPersona, "Verify User Persona Digital Data");
		assertEquals(error404Page.verifyUserRole1DigitalData(), userRole1, "Verify User Role Digital Data");
		assertEquals(error404Page.verifyCompanyNameDigitalData(), companyName, "Verify Company Name Digital Data");
		assertEquals(error404Page.verifyCompanyIDDigitalData(), "00"+companyID, "Verify Company ID Digital Data");
		assertEquals(error404Page.verifyCOBDigitalData(), COB, "Verify COB Digital Data");
		//assertEquals(error404Page.verifyLOBDigitalData(), LOB, "Verify LOB Digital Data");
		//assertEquals(error404Page.verifyOperationUnitDigitalData(), operationUnit, "Verify Name Digital Data");
		assertEquals(error404Page.verifyPageErrorDigitalData(), pageError, "Verify Page Error Digital Data");
		assertEquals(error404Page.verifyPageErrorCodeDigitalData(), pageErrorCode, "Verify Page Error Code Digital Data");
		assertEquals(error404Page.verifyPageErrorURLDigitalData(), pageErrorURL, "Verify Page Error URL Digital Data");
		assertAll();
	}
	
	@Feature("Cross Business - DTM")
	@Test(groups = "regression")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Error, Error Code, Error URL Digital Data On 403 Error Page")
	public void DTM_TC07_Verify_Digital_Data_On_403_Error_Page(ITestContext context)
			throws Exception {
		String userName = testData.get("userName").toString();
		String password = testData.get("password").toString();
		String name = testData.get("name").toString();
		String section = testData.get("section").toString();
		String country = testData.get("country").toString();
		String language = testData.get("language").toString();
		String userID = testData.get("userID").toString();
		String userStatus = testData.get("userStatus").toString();
		String userPersona = testData.get("userPersona").toString();
		String userRole1 = testData.get("userRole1").toString();
		String companyName = testData.get("companyName").toString();
		String companyID = testData.get("companyID").toString();
		String COB = testData.get("COB").toString();
		String LOB = testData.get("LOB").toString();
		String operationUnit = testData.get("operationUnit").toString();
		String Error403URL = testData.get("Error403URL").toString();
		String pageError = testData.get("pageError").toString();
		String pageErrorCode = testData.get("pageErrorCode").toString();
		String pageErrorURL = testData.get("pageErrorURL").toString();
		
		loginPage.getMarketHubHomePage(BaseDataConstants.MARKETHUB_AUT_URL);
		loginPage.loginMarketHub(userName, password);
		homePage.goToURL(Error403URL);
		
		//assertEquals(error404Page.verifyNameDigitalData(), name, "Verify Name Digital Data");
		//assertEquals(error404Page.verifySectionDigitalData(), section, "Verify Section Digital Data");
		//assertEquals(error404Page.verifyCountryDigitalData(), country, "Verify Country Digital Data");
		//assertEquals(error404Page.verifyLanguageDigitalData(), language, "Verify Language Digital Data");
		assertEquals(error404Page.verifyUserIDDigitalData(), userID, "Verify User ID Digital Data");
		assertEquals(error404Page.verifyUserStatusDigitalData(), userStatus, "Verify User Status Digital Data");
		assertEquals(error404Page.verifyUserPersonaDigitalData(), userPersona, "Verify User Persona Digital Data");
		assertEquals(error404Page.verifyUserRole1DigitalData(), userRole1, "Verify User Role Digital Data");
		assertEquals(error404Page.verifyCompanyNameDigitalData(), companyName, "Verify Company Name Digital Data");
		assertEquals(error404Page.verifyCompanyIDDigitalData(), "00"+companyID, "Verify Company ID Digital Data");
		assertEquals(error404Page.verifyCOBDigitalData(), COB, "Verify COB Digital Data");
		//assertEquals(error404Page.verifyLOBDigitalData(), LOB, "Verify LOB Digital Data");
		//assertEquals(error404Page.verifyOperationUnitDigitalData(), operationUnit, "Verify Name Digital Data");
		assertEquals(error404Page.verifyPageErrorDigitalData(), pageError, "Verify Page Error Digital Data");
		assertEquals(error404Page.verifyPageErrorCodeDigitalData(), pageErrorCode, "Verify Page Error Code Digital Data");
		assertEquals(error404Page.verifyPageErrorURLDigitalData(), pageErrorURL, "Verify Page Error URL Digital Data");
		assertAll();
	}
	@Feature("Cross Business - DTM")
	@Test(groups = "Sanity")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Page Term, Page Type, Page Result Digital Data")
	public void DTM_TC08_Verify_Digital_Data_On_Search_Results_Global(ITestContext context)
			throws Exception {
		String userName = testData.get("userName").toString();
		String password = testData.get("password").toString();
		String searchTerm = testData.get("searchTerm").toString();
		String searchResult = testData.get("searchResult").toString();
		String searchType = testData.get("searchType").toString();
		String productName = testData.get("productName").toString();
		String userID = testData.get("userID").toString();
		
		loginPage.getMarketHubHomePage(BaseDataConstants.MARKETHUB_AUT_URL);
		loginPage.loginMarketHub(userName, password);
	
		homePage.clickOnManageProfileIcon();
		searchCustomerUserPage.enterUserName(userID);
		searchCustomerUserPage.clickSearchButton();
		assertTrue(searchCustomerUserPage.verifyUserListTablePresent(), "Verify User List Table");
		searchCustomerUserPage.clickOnUserListCheckBox1();
		searchCustomerUserPage.clickOnImpersonateButton();
		
		homePage.enterSearch(productName);
		homePage.clickOnSearchButton();
				
		assertEquals(searchResultsPage.verifyAEMSearchTermDigitalData(), searchTerm, "Verify Search Term Digital Data");
		assertEquals(searchResultsPage.verifyAEMSearchResultDigitalData(), searchResult, "Verify Search Result Digital Data");
		assertEquals(searchResultsPage.verifyAEMSearchTypeDigitalData(), searchType, "Verify Search Type Digital Data");
		assertAll();
	}
	@Feature("Cross Business - DTM")
	@Test(groups = "sanity")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Page Term, Page Type, Page Result Digital Data")
	public void DTM_TC09_Verify_Digital_Data_On_Search_Results_On_Document_Page(ITestContext context)
			throws Exception {
		String userName = testData.get("userName").toString();
		String password = testData.get("password").toString();
		String searchTerm = testData.get("searchTerm").toString();
		String searchResult = testData.get("searchResult").toString();
		String searchType = testData.get("searchType").toString();
		String productName = testData.get("productName").toString();
		String userID=testData.get("userID").toString();
		String url=testData.get("url").toString();
		
		loginPage.getMarketHubHomePage(BaseDataConstants.MARKETHUB_AUT_URL);
		loginPage.loginMarketHub(userName, password);
	
		homePage.clickOnManageProfileIcon();
					
		searchCustomerUserPage.enterUserName(userID);
		searchCustomerUserPage.clickSearchButton();

		searchCustomerUserPage.clickOnUserListCheckBox1();
		searchCustomerUserPage.clickOnImpersonateButton();

		homePage.goToUrl(url);
		
		homePage.enterDocumentSearch(productName);
		homePage.clickOnDocumentSearchIcon();
				
		assertEquals(searchResultsPage.verifyAEMSearchTermDigitalData(), searchTerm, "Verify Search Term Digital Data");
	//	assertEquals(searchResultsPage.verifyAEMSearchResultDigitalData(), searchResult, "Verify Search Result Digital Data");
		assertEquals(searchResultsPage.verifyAEMSearchTypeDigitalData(), searchType, "Verify Search Type Digital Data");
		assertAll();
	}
	@Feature("Cross Business - DTM")
	@Test(groups = "sanity")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Home, Section, Language, Status, Username, Password, Country, ID, Persona, Role, Company Name, Company ID, COB, LOB, Operation Unit Digital Data")
	public void DTM_TC10_Verify_Digital_Data_For_Retail_User_With_Single_Role_And_On_Home_Page(ITestContext context)
			throws Exception {
		String name = testData.get("name").toString();
		String status = testData.get("status").toString();
		String language = testData.get("language").toString();
		String section = testData.get("section").toString();
		String userName = testData.get("userName").toString();
		String password = testData.get("password").toString();
		String homeName = testData.get("homeName").toString();
		String homeSection = testData.get("homeSection").toString();
		String country = testData.get("country").toString();
		String homeLanguage = testData.get("homeLanguage").toString();
		String userID = testData.get("userID").toString();
		String userStatus = testData.get("userStatus").toString();
		String userPersona = testData.get("userPersona").toString();
		String userRole = testData.get("userRole").toString();
		String companyName = testData.get("companyName").toString();
		String companyID = testData.get("companyID").toString();
		String COB = testData.get("COB").toString();
		String LOB = testData.get("LOB").toString();
		String operationUnit = testData.get("operationUnit").toString();
		String prodUser=testData.get("prodUser").toString();
		
		
		loginPage.getMarketHubHomePage(BaseDataConstants.MARKETHUB_AUT_URL);
		loginPage.loginMarketHub(userName, password);

		homePage.clickOnManageProfileIcon();
				
		searchCustomerUserPage.enterUserName(prodUser);
		searchCustomerUserPage.clickSearchButton();
		
		searchCustomerUserPage.clickOnUserListCheckBox1();
		searchCustomerUserPage.clickOnImpersonateButton();
		
		assertEquals(homePage.verifyNameDigitalData(), homeName, "Verify Name Digital Data");
		assertEquals(homePage.verifySectionDigitalData(), homeSection, "Verify Section Digital Data");
		assertEquals(homePage.verifyCountryDigitalData(), country, "Verify Country Digital Data");
		assertEquals(homePage.verifyLanguageDigitalData(), homeLanguage, "Verify Language Digital Data");
		assertEquals(homePage.verifyUserIDDigitalData(), userID, "Verify User ID Digital Data");
		assertEquals(homePage.verifyUserStatusDigitalData(), userStatus, "Verify User Status Digital Data");
		assertEquals(homePage.verifyUserPersonaDigitalData(), userPersona, "Verify User Persona Digital Data");
		assertEquals(homePage.verifyUserRole1DigitalData(), userRole, "Verify User Role Digital Data");
		assertEquals(homePage.verifyCompanyNameDigitalData(), companyName, "Verify Company Name Digital Data");
		assertEquals(homePage.verifyCompanyIDDigitalData(), "00"+companyID, "Verify Company ID Digital Data");
		assertEquals(homePage.verifyCOBDigitalData(), COB, "Verify COB Digital Data");
		assertEquals(homePage.verifyLOBDigitalData(), LOB, "Verify LOB Digital Data");
		assertEquals(homePage.verifyOperationUnitDigitalData(), operationUnit, "Verify Name Digital Data");
		assertAll();
	}
}
