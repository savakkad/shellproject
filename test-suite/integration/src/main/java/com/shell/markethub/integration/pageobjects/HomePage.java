package com.shell.markethub.integration.pageobjects;

import static io.qameta.allure.Allure.step;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shell.markethub.base.util.config.BaseDataConstants;

public class HomePage extends IntegrationBasePageObject {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private static Logger logger = LogManager.getLogger(HomePage.class);
	@FindBy(xpath = "//span[@class='icon-home']")
	WebElement homeButton;
	@FindBy(css = "li.user.defaultNavigationOptions > a")
	WebElement myProfileIcon;
	@FindBy(xpath = "//a[contains(@href,'myprofile')]")
	WebElement myProfileLink;
	@FindBy(className = "manageUsericon")
	WebElement manageUserIcon;
	@FindBy(xpath = "//li[@class='floatL maskLabel']")
	WebElement youAreImpersonatingText;
	@FindBy(xpath = "//li[@class='menu original']//span[@class='icon-menu']")
	WebElement allTab;
	@FindBy(xpath = "(//a[contains(@href,'rackprice')])[2]")
	WebElement rackPricesLink;
	@FindBy(xpath = "(//a[contains(@href,'bol')])[2]")
	WebElement bolsLink;
	@FindBy(xpath = "(//a[contains(@href,'nextgenstorefront/?site=estore.shell')])[2]")
	WebElement orderManagementLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Carrier Driver Last Lift')]")
	WebElement carrierDriverLastLiftLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Contract Prices')]")
	WebElement contractPricesLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Terminal Wait Time')]")
	WebElement terminalWaitTimeLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Allocations')]")
	WebElement allocationsLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Invoiced Volumes')]")
	WebElement invoicedVolumsLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'*Supply Workspace')]")
	WebElement supplyWorkspaceLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Where And What Can I Lift')]")
	WebElement whereAndWhatCanILiftLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Site List')]")
	WebElement siteListLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Incentives Volume')]")
	WebElement incentivesVolumeLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Carrier Maintenance')]")
	WebElement carrierMaintenanceLink;
	@FindBy(xpath = "(//ul[@class='menuList'])[6]/li[1]")
	WebElement requestCarrierSetUpLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Contract Recapture')]")
	WebElement contractRecaptureLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'*Performance Workspace')]")
	WebElement performanceWorkspaceLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Digital Content A-Z')]")
	WebElement digitalContentLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'*Finance Workspace')]")
	WebElement financeWorkspaceLink;
	@FindBy(xpath = "//span[contains(text(),'Marine Lighthouse')]")
	WebElement marineLightHouseButton;
	@FindBy(xpath = "//span[contains(text(),'Shell Aviation MarketHub')]")
	WebElement shellAviationMarkethubButton;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Book Request')]")
	WebElement bookRequestLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Request Fuel')]")
	WebElement requestFuelLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Fuel Request History')]")
	WebElement fuelRequestHistoryLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Contracts')]")
	WebElement contractsLink;
	@FindBy(xpath = "(//div[@class='menuDropDown']//a[contains(text(),'Contracts')])[2]")
	WebElement contractsLinkNew;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Prices')]")
	WebElement pricesLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Maps')]")
	WebElement mapsLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'DFOA Workspace')]")
	WebElement dfoaWorkspaceLink;
	@FindBy(xpath = "//li[@class='menu original']//b[contains(text(),'Tümü')]")
	WebElement turkeyuserMenu;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Yönetimi')]")
	WebElement ordermanagmentlink;
	@FindBy(xpath = "//input[@id='userid']")
	WebElement enterusername;
	@FindBy(xpath = "//h1[.='Fuel Request History']")
	WebElement verifyFuelRequestHistory;
	@FindBy(xpath = "(//input[@name='box1'])[1]")
	WebElement clickOnCheckbox;
	@FindBy(xpath = "//dt[.='Bulk Fuel Request ID :']")
	WebElement verifyBulkFuelRequestIdLabel;
	@FindBy(xpath = "//button[.='Update']")
	WebElement clickOnUpdateButton;
    @FindBy(xpath = "(//button[.='Update Request'] )[1]")
	WebElement clickOnUpdateRequestButton;
	@FindBy(xpath = "(//th[@aria-label='Bulk FuelRequestID: activate to sort column ascending'])[1]")
	WebElement verifyBulkFuelRequestIDInFRH;
	@FindBy(xpath = "//dt[.='Bulk Fuel Request ID :']")
	WebElement verifyBulkFuelRequestIDInFRDetailsPage;
	@FindBy(xpath = "//button[@id='searchRegisteredUser']")
	WebElement clickonsearch;
	@FindBy(xpath = "//button[@id='impersonateButton']")
	WebElement clcik_Impersonate;
	@FindBy(xpath = "//*[@id='exitImpersonationForm']/button")
	WebElement exit_Impersonate;
	@FindBy(xpath = "//*[@id='sticky_navigation']/div/ul/li[1]")
	WebElement verifyImpersanating;
	@FindBy(xpath = "//li[@class='menu original']//b[contains(text(),'Menu')]")
	WebElement polandmenu;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Zarządzanie zamówieniami ')]")
	WebElement ordermanagementpoland;
	@FindBy(xpath = "//div[@class='menuDropDown']//div//a[contains(text(),'Order Management')]")
	WebElement ordermanagementfromnotificationpage;
	@FindBy(xpath = "//a[contains(text(),'Profilim')]")
	WebElement myprofileturkey;
	@FindBy(xpath = "//a[contains(text(),'Mój profil')]")
	WebElement myfprolepoland;
	@FindBy(xpath = "//a[contains(text(),'Oturumu Kapat')]")
	WebElement logoutforturkeyuser;
	@FindBy(xpath = "//a[@id='hybrislogout']")
	WebElement logout;
	@FindBy(xpath = "(//a[@href='/apps/utils/logout'])[1]")
	WebElement dfoalogout;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'DFOA Workspace')]")
	WebElement clickOnDWorkspcefrmAllMenu;
	@FindBy(xpath = "//a[@class='myprofile']")
	WebElement aMyprofileIcon;
	@FindBy(xpath = "//*[@id='logoutForm']/a")
	WebElement DFOALogout;
	@FindBy(xpath = "//li[@class='menu original']//b[contains(text(),'Tümü')]")
	WebElement allMenuTurkeyCountry;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Yönetimi')]")
	WebElement orderManagmentLink;
	@FindBy(xpath = "//div[@class='checkbox']//input[@id='checkbox1']")
	WebElement selectcheckbox;
	@FindBy(xpath = "//*[@id='exitImpersonationForm']/button")
	WebElement exitImpersonateButton;
	@FindBy(xpath = "//li[@class='menu original']//b[contains(text(),'Menu')]")
	WebElement allMenuPolandCountry;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Zarządzanie zamówieniami ')]")
	WebElement orderManagementForPolandCountryLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//div//a[contains(text(),'Order Management')]")
	WebElement orderManagment;
	@FindBy(xpath = "//a[contains(text(),'Profilim')]")
	WebElement myProfileTurkeyCountry;
	@FindBy(xpath = "//a[contains(text(),'Mój profil')]")
	WebElement myfprofilePoland;
	@FindBy(xpath = "//a[contains(text(),'Oturumu Kapat')]")
	WebElement logOutForTurkeyCountry;
	@FindBy(xpath = "//a[@id='hybrislogout']")
	WebElement homePageLogout;
	@FindBy(xpath = "//a[@class='myprofile']")
	WebElement DfoaMyprofileIcon;
	@FindBy(xpath = "(//a[contains(@href,'nextgenstorefront/reports/salesreport')])[2]")
	WebElement valueVolumeReportLink;
	@FindBy(xpath = "//*[@id='popMenuItem']")
	WebElement allMenuTab;
	@FindBy(xpath = "//*[@id='drop_menu_links10']/li[2]/a")
	WebElement orderManagementLinkOfAccountSummary;
	@FindBy(xpath = "(//a[contains(@href,'nextgenstorefront/docCopies/showDocumentSearchPage?')])[2]")
	WebElement documentCopiesLink;
	@FindBy(xpath = "(//a[contains(@href,'nextgenstorefront/financeWorkSpace/showFinanceWorkSpace?')])[2]")
	WebElement financialsLink;
	@FindBy(xpath = "(//a[contains(@href,'nextgenstorefront/vmi/site?menuParam=View_Stock_Value')])[2]")
	WebElement vmiStockAndDeliveriesLink;
	@FindBy(xpath = "(//a[contains(@href,'nextgenstorefront/vmi/siteEvents?menuParam=Site_Events')])[2]")
	WebElement vmiSiteEventsLink;
	@FindBy(xpath = "(//a[contains(@href,'nextgenstorefront/reports/pmtdr?')])[2]")
	WebElement pmtdrReportLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Order Status')]")
	WebElement orderStatusLabel;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Status zamówienia')]")
	WebElement orderStatusPolishLabel;
	@FindBy(xpath = "//span[contains(text(),'View Shipments')]")
	WebElement viewShipMentTab;
	@FindBy(xpath = "//a[@onclick='showProductCheckerOverlay();']")
	WebElement availabilityCheckerLink;
	@FindBy(xpath = "//div[@id='productChecker']//h2")
	WebElement productAvailablityCheckerHeader;
	@FindBy(xpath = "//*[@class='deliveryLocationSearch']//input")
	WebElement deliveryLocation;
	@FindBy(xpath = "//div[contains(@class,'deliveryLocationSearch')]//li[1]")
	WebElement firstSuggestionLink;
	@FindBy(xpath = "//section[@id='product-availability']//input")
	WebElement productCodeInputBox;
	@FindBy(xpath = "//input[@id='selectContract']")
	WebElement selectContract;
	@FindBy(xpath = "//section[@id='product-availability']//input[@id='qtyinput']")
	WebElement productAvailabilityQuantity;
	@FindBy(xpath = "//section[@id='product-availability']//button")
	WebElement checkAvailabilityButton;
	@FindBy(xpath = "//*[contains(@class,'shell-icon-drum')]")
	WebElement quantityIcon;
	@FindBy(xpath = "//form[@id='productDetailsForm']//button")
	WebElement startOrderingWithThisItemButton;
	@FindBy(xpath = "//a[@href='/nextgenstorefront/content/ordertemplatelist']")
	WebElement viewAllTemplate;
	@FindBy(xpath = "//div[@data-set='order-template']//button")
	WebElement createATemplateButton;
	@FindBy(xpath = "//b[contains(text(),'Home')]")
	WebElement homepage;
	@FindBy(xpath = "//div[@class='col-3 col-tablet-8 col-keep-right']//div[3]//section[1]")
	WebElement safetySpotlight;
	@FindBy(xpath = "//h2[contains(text(),'Safety Spotlight')]")
	WebElement safetySpotlightText;
	@FindBy(xpath = "//a[contains(text(),'Korem (FAST)')]")
	WebElement koremSSO;
	@FindBy(xpath = "//span[@class='icon icon-close mfp-close']")
	WebElement closePopIcon;
	@FindBy(xpath = "//tr[11]/td[2]")
	WebElement pageName;
	@FindBy(xpath = "//td[contains(text(),'Korem FAST SSO Link')]")
	WebElement koremSSOName;
	@FindBy(xpath = "//button[@id='customerUserPersonalDetailsNext']")
	WebElement profileNextButton;
	@FindBy(xpath = "//table[@id='testTable']/tbody/tr")
	List<WebElement> tableData;
	@FindBy(xpath = "//div[@class='formRow formRowInlineBlock soldToComp']/div/select/option")
	List<WebElement> allocationSoldTo;
	@FindBy(xpath = "//a[@title='Shell Aviation MarketHub']")
	WebElement shellAviationMarketHubTab;
	@FindBy(xpath = "(//a[@href='/content/nextgen/ehub/pricing.html'])[2]")
	WebElement priceViewLink;
	@FindBy(xpath = "//*[@class='menuDropDown']//h2[contains(text(),' Automation Testing')]/following-sibling::ul//a[contains(text(),'Automated Test')]")
	WebElement automatedTestLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'test1')]")
	WebElement automatedTestLinkUSF;
	@FindBy(xpath = "//input[@placeholder= 'Search'and @type= 'search']")
	WebElement searchEditbox;
	@FindBy(xpath = "//div[@class= 'inputHolder']/button")
	WebElement searchButton;
	@FindBy(xpath = "//*[@id='searchbox']")
	WebElement DCSearchBox;
	@FindBy(xpath = "//*[@id='searchbox']/following-sibling::button")
	WebElement DCSearchIcon;
	@FindBy(xpath = "//div[@class='menuDropDown']//div//a[contains(text(),'Accounting Docs')]")
	WebElement accountingDocsLink;
	@FindBy(xpath = "(//a[contains(@href, '/content/nextgen/shell/global/en/gcaviation/fm/portal/home/operations/submit pre-fuel figures.html')])[2]")
	WebElement submitPre_FuelFiguresLink;
	@FindBy(xpath = "//h1[contains(text(),'Welcome to Aviation MarketHub,')]")
	WebElement welComeMessageForAirPortOpsUser;
	@FindBy(xpath = "//h1[contains(.,'Shell')]")
	WebElement shellLogo;
	@FindBy(xpath = "//li[@class='menu original']//b[contains(.,'All')]")
	WebElement allMenu;
	@FindBy(xpath = "//*[@class=\"icon-help\"]")
	WebElement helpAndSupportIcon;
	@FindBy(xpath = "//div[@class='subnav mobileDropDown']//a[contains(text(),'Help and Support')]")
	WebElement helpAndSupportPage;
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchInputBox;
	@FindBy(xpath = "//span[@class='icon-search']")
	WebElement searchIcon;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Product Families')]")
	WebElement productFamilies;
	@FindBy(xpath = "//a[contains(text(),'Profil Saya')]")
	WebElement indoMyProfile;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Order Management')]")
	WebElement orderManagemetLink;
	@FindBy(xpath = "//button[@id='impersonationExitButton']")
	WebElement exit_ImpersonateButton;
	@FindBy(xpath = "//div[@id='pageWrapper']//div[@id='grid']//h1")
	WebElement orderManagementWorkspaceTitle;
	@FindBy(xpath = "//div[@id='pageWrapper']/div")
	WebElement pageDisconnect;
	@FindBy(xpath = "//div[@class='userLinks']//li[3]//a[1]")
	WebElement iACETraining;
	@FindBy(xpath = "//div[@class='parbase basecomponent primaryNavPar compNavHeader']//div[3]//section[1]//div[2]//a[1]")
	WebElement loginToiACE;
	@FindBy(xpath = "//div[@id='kampyleFormContainer']")
	WebElement medalliaPopup;
	@FindBy(xpath = "(//a[contains(@href, '/content/nextgen/DVRs.html')])[2]")
	WebElement dvrLink;
	@FindBy(xpath = "//a[@id='pi_tracking_opt_in_yes']")
	WebElement yesLinkOnCookiesBanner;
	@FindBy(xpath = "//span[@class='icon-notifications']")
	WebElement notificationIcon;
	@FindBy(xpath = "//a[@class='tertiaryLink subscriptionlnk']")
	WebElement subscriptionLink;
	@FindBy(xpath = " //a[@class='tertiaryLink ssolink']")
	WebElement comprice;
	@FindBy(xpath = " //a[contains(text(),'Allocations')]")
	WebElement homePageAllocations;
	@FindBy(xpath = " (//a[contains(text(),'Allocations')])[2]")
	WebElement homePageQuickLinkAllocations;
	@FindBy(xpath = "//a[@class='tertiaryLink ssolink']")
	WebElement homePageSSOLinkAllocation;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Order Status')]")
	WebElement orderStatusLink;
	@FindBy(xpath = "//a[contains(@href, '/content/nextgen/shell/global/en/marine/channel/portal/home.html')]")
	WebElement marineTab;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'ติดตามสถานะคำสั่งซื้อ')]")
	WebElement orderStatusThailandLabel;
	@FindBy(xpath = "//*[@id='pi_tracking_opt_in_div']")
	WebElement cookiesInfo;
	@FindBy(xpath = "//*[@id='pi_tracking_opt_in_yes']")
	WebElement chooseYes;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'*Supply Workspace')]")
	WebElement supplyWorkSpaceLink;
	@FindBy(xpath = " //span[contains(text(), 'Set Preferences')]/parent::a")
	WebElement setPreferences;
	@FindBy(xpath = "//li[@class='menu original']//div[@class='colbars']//h2[contains(text(),'Supply & Logistics')]/following::ul//a[@href='/content/nextgen/shell/us/en_us/ws/fuels/portal/home/workspaces/rackprice.html']")
	WebElement rackPricesLinks;
	@FindBy(xpath = "//li[@class='menu original']//div[@class='colbars']//h2[contains(text(),'Supply & Logistics')]/following::ul//a[@href='/content/nextgen/shell/us/en_us/ws/fuels/portal/home/workspaces/driverHistory.html']")
	WebElement CarrierDriverLiftLink;
	@FindBy(xpath = "//li[@class='menu original']//div[@class='colbars']//h2[contains(text(),'Supply & Logistics')]/following::ul//a[@href='/content/nextgen/shell/us/en_us/ws/fuels/portal/home/workspaces/allocation.html']")
	WebElement allocationLink;
	@FindBy(xpath = "//li[@class='menu original']//div[@class='colbars']//h2[contains(text(),'Supply & Logistics')]/following::ul//a[@href='/content/nextgen/shell/us/en_us/ws/fuels/portal/home/workspaces/bol.html']")
	WebElement bolsLinks;
	@FindBy(xpath = "//li[@class='menu original']//div[@class='colbars']//h2[contains(text(),'Supply & Logistics')]/following::ul//a[@href='/content/nextgen/shell/us/en_us/ws/fuels/portal/home/workspaces/contractprice.html']")
	WebElement contractPrices;
	@FindBy(xpath = "//a[contains(text(),'Manage Users')]")
	WebElement manageUserLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Fuel Prices')]")
	WebElement fuelPriceLink;
	@FindBy(xpath = "//b[contains(text(),'首頁')]")
	WebElement hkHomeTitle;
	@FindBy(xpath = " (//b[contains(text(),'全部')])[2]")
	WebElement hkAllMenu;
	@FindBy(xpath = "//a[@href='/apps/utils/thirdparty.webcams?target=01']")
	WebElement sproutLoudCoOpLink;
	@FindBy(xpath = "//*[@id='continue-to-site-with-soldto']")
	WebElement continueButton;
	@FindBy(xpath = "//iframe[@id='fancybox-frame']")
	WebElement iframe;
	@FindBy(xpath = "//input[@id='row-1-checked']")
	WebElement multipleSolds;
	@FindBy(xpath = "//iframe[@id='fancybox-frame']")
	WebElement iFrame;
	@FindBy(xpath = "//a[@href='/apps/utils/thirdparty.rdm?target=98']")
	WebElement insightsReportingLink;
	@FindBy(xpath = "//a[contains(text(),'Results Driven Mktg (Loyalty)')]")
	WebElement resultsDrivenMktgLoyaltyLink;
	@FindBy(xpath = "//a[@href='/apps/utils/thirdparty.rdm?target=99']")
	WebElement eMVDeployCenterLink;
	@FindBy(xpath = "//a[contains(text(),'Korem (FAST)')]")
	WebElement koremFastLink;
	@FindBy(xpath = "//a[contains(text(),'ipsos (Mystery Shops)')]")
	WebElement mysteryShopsLink;
	@FindBy(xpath = "//a[contains(text(),'Ipsos (Mystery Shops)')]")
	WebElement mysteryShopsLink1;
	@FindBy(xpath = "//a[contains(text(),'Pointsmith (POP Materials)')]")
	WebElement pointsmithPOPMaterialsLink;
	@FindBy(xpath = "//a[contains(text(),'TopTech (Allocations)')]")
	WebElement topTechAllocationsLink;
	@FindBy(xpath = "//a[contains(text(),'Community Pump (RDM)')]")
	WebElement communityPumpRDMLink;
	@FindBy(xpath = "//h1[contains(text(),'Sold To Selection')]")
	WebElement soldToSelectionHeader;
	@FindBy(xpath = "//input[@id='row-3-checked']")
	WebElement selectSoldTo3;
	@FindBy(xpath = "//input[@id='row-0-checked']")
	WebElement multipleSolds1;
	@FindBy(xpath = "//input[@id='row-1-checked']")
	WebElement selectSolds1;
	@FindBy(xpath = "//input[@id='row-2-checked']")
	WebElement selectSolds2;
	@FindBy(xpath = "//a[@href='/content/nextgen/shell/us/en_us/ws/fuels/portal/home/accountmanagement/viewEmailList.html']")
	WebElement viewEmailsLink;
	@FindBy(xpath = "//a[contains(text(),'Wholesaler Programs webpage')]")
	WebElement wholesaleProgramUrl;
	@FindBy(xpath = "//a[@href='/apps/utils/thirdparty.rdm?target=96']")
	WebElement fuelRewardsLink;
	@FindBy(xpath = "(//div[@class='col']//a[contains(text(),'Delivery Ticket')])[2]")
	WebElement deliveryTicketLink;
	@FindBy(xpath = "//a[@href='/apps/utils/thirdparty.comprice']")
	WebElement compriceSSOLink;
	@FindBy(xpath = "//*[@id='continue-to-site']")
	WebElement continueButton1;
	@FindBy(xpath = "//h1[contains(text(),'Royal Dutch Shell plc Legal Disclaimer')]")
	WebElement royalDutchShellHeader;
	@FindBy(xpath = "//*[@class='first']")
	WebElement placeAnOrder;
	@FindBy(xpath = "(//*[@class=\"subnav mobileDropDown\"])[2]")
	WebElement navigateHelpAndSupportButton;
	@FindBy(xpath = "//*[@class=\"message\"]")
	WebElement agentOfflineBlock;
	@FindBy(xpath = "//td[.='UGL']")
	WebElement clickOnRowInHistoryPage;
	@FindBy(xpath = "//button[.='Back to Bulk Request History Page']")
	WebElement verifyBacktoBulkRequestHistoryPageButton;
	@FindBy(xpath = "//button[.='Cancel Request']")
	WebElement verifyCancelRequestButton;
	@FindBy(xpath = "//button[.='Download']")
	WebElement verifyDownloadButton;
	@FindBy(xpath = "//button[.='Edit Fuel Request']")
	WebElement verifyEditFuelRequestButton;
	@FindBy(xpath = "//button[.='Edit Fuel Request']")
	WebElement clickOnEditFuelRequestButton;
	@FindBy(xpath = "//div[.='Bulk Fuel request ID ']")
	WebElement verifyBulkFuelRequestID;
	@FindBy(xpath = "//div[.='Fuel request ID ']")
	WebElement verifyFuelRequestID;
	@FindBy(xpath = "//button[.='Download']")
	WebElement clickOnDownloadButton;
	@FindBy(xpath = "//button[.='Back to Bulk Request History Page']")
	WebElement clickOnBacktoBulkRequestHistoryPageButton;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Bulk Fuel Request Upload ')]")
	WebElement bulkFuelRequestUploadLink;
	@FindBy(xpath = "//*[@title='Bulk Fuel Request Upload']")
	WebElement bulkFuelRequestUploadButton;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Bulk Fuel Request History ')]")
	WebElement bulkFuelRequestHistoryLink;
	@FindBy(xpath = "//span [.='Bulk Fuel Request History ']")
	WebElement bulkFuelRequestHistoryButton;	
	@FindBy(xpath = "//span[@id='download']")
	WebElement downloadHereLink;
	@FindBy(xpath = "//span[@id='reference-data']")
	WebElement referenceDataLink;
	@FindBy(xpath = "//th [.='IATA']")
	WebElement iATAName;
	@FindBy(xpath = "//label [@for='bulk-file-upload']")
	WebElement selectAndUploadFile;
	@FindBy(xpath = "//a [@title='Global IATA List']")
	WebElement globalIataList;
	@FindBy(xpath = "//th [.='Apron Name']")
	WebElement apronName;
	@FindBy(xpath = "//th [.='Product Name']")
	WebElement productName;
	@FindBy(xpath = "//th [.='Country Name']")
	WebElement globalCountryName;
	@FindBy(xpath = "//th [.='IATA']")
	WebElement globalIATAName;
	@FindBy(xpath = "//th [.='Airport Name']")
	WebElement globalAirportName;
	@FindBy(xpath = "//div[.='Search by']")
	WebElement searchByBar;
	@FindBy(xpath = "//i [@class='shell-icon-remove-circle']")
	WebElement crossIcon;
	@FindBy(xpath = "//h5[.='BU_Test_Template1.xlsx']")
	WebElement nameOfTheFile;
	@FindBy(xpath = "//input[@class='red-highlight flatpickr-input active']")
	WebElement clickOnDatetOfArrivalButton;
	@FindBy(xpath = "//h1 [.='Only files with a maximum of 30 rows are allowed.']")
	WebElement errorMsgWithMoreRows;
	@FindBy(xpath = "//h1 [.='Upload Failed. The file is empty.']")
	WebElement errorMsgWithEmptyTemplate;
	@FindBy(xpath = "//i [@class='shell-icon-remove-circle']")
	WebElement deleteCrossIcon;
	@FindBy(xpath = "//label [@for='bulk-file-upload']")
	WebElement selectAndUploadFile1;
	@FindBy(xpath = "//h1 [.='Upload Failed. Only files with a .xlsx extension are allowed.']")
	WebElement errorMsgNotInExcelFile;
	@FindBy(xpath = "//span [.='Next']")
	WebElement selectOnNextButton;
	@FindBy(xpath = "//span [.='Submit All']")
	WebElement clickSubmitAllButton;
	@FindBy(xpath = "(//span [.='Edit'])[1]")
	WebElement clickOnEditInStatusButton;
	@FindBy(xpath = "//div[@class='view-prices has-margin-top-0 has-margin-bottom-6']")
	WebElement infoMsg;
	@FindBy(xpath = "//a[.='page']")
    WebElement clickOnPageLink;
	@FindBy(xpath = "//div[@class='error-message-component']")
	WebElement verifyApronNameErrorMessage;
	@FindBy(xpath = "//div[@class='error-message-component']")
	WebElement emptyApronNameErrorMessage;
	@FindBy(xpath = "//div[@class='error-message-component']")
	WebElement emptyAircraftRegistrationNumErrorMessage;
	@FindBy(xpath = "//div[@class='error-message-component']")
	WebElement wrongAircraftRegistrationNumErrorMessage;	
	@FindBy(xpath = "//div[@class='error-message-component']")
	WebElement wrongFlightNumErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement wrongOriginErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement emptyOriginErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement wrongNextDestinationErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement emptyNextDestinationErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement wrongIataInNextDestinationErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement emptyIataInNextDestinationErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement wrongSecondNextDestinationErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement wrongSecondIataNextDestinationErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement wrongThirdNextDestinationErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement wrongThirdIataNextDestinationErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement wrongFinalDestinationErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement emptyFinalDestinationErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement emptySecondNextDestinationErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement enterSecondNextDestinationErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement emptyThirdNextDestinationErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement enterThirdNextDestinationErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement wrongFinalDestinationIataErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement emptyFinalDestinationIataErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement arrivalDateAndTimeInWrongFormatErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement arrivalDateAndTimeInEmptyFormatErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[2]")
	WebElement departureDateAndTimeInWrongFormatErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[2]")
	WebElement departureDateAndTimeInEmptyFormatErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[3]")
	WebElement emptyOperatorsNameErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[2]")
	WebElement wrongProductNameErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[2]")
	WebElement emptyProductNameErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[2]")
	WebElement wrongVolumeErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[2]")
	WebElement emptyVolumeAndCaptainsRequestErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[2]")
	WebElement wrongUnitErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[2]")
	WebElement emptyUnitErrorMessage;
	@FindBy(xpath = "//span[.='Request Fuel']")
	WebElement clickOnRequestFuelButton;
	@FindBy(xpath = "//span[.='Update Fuel Request']")
	WebElement clickOnUpdateFuelRequestButton;
	@FindBy(xpath = "//button[.='Back to Workspace']")
	WebElement clickOnBackToWorkspaceButton;
	@FindBy(xpath = "//button[.='Back to Bulk Upload Page']")
	WebElement clickOnBackToBulkUploadPageButton;
	@FindBy(xpath = "//th[.='Status']")
	WebElement verifyStatusInTable;
	@FindBy(xpath = "//span[.='New']")
	WebElement verifyStatusAsNewInTable;
	@FindBy(xpath = "(//span[.='Edit'])[1]")
	WebElement verifyStatusAsEditInTable;
	@FindBy(xpath = "(//span[.='Failed'])[1]")
	WebElement verifyStatusAsFailedInTable;
	@FindBy(xpath = "//div[@class='column is-1 is-1-mobile offset-contract-column']")
	WebElement clickOnContractFRButton;
	@FindBy(xpath = "//th[.='Bulk Fuel Request ID']")
	WebElement verifyBulkFuelRequestIDInTable;
	@FindBy(xpath = "//button[.='Proceed']")
	WebElement clickOnProceedButton;
	@FindBy(xpath = " //span[.='AeroJet']")
	WebElement clickOnProductAeroJetButton;
	@FindBy(xpath = "//div[@class='error-box']")
	WebElement errorMsgForDate_Time;
	@FindBy(xpath = "//div[@class='error-message-component']")
	WebElement iATAAirportCodeErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[1]")
	WebElement dateOfArrivalErrorMessage;
	@FindBy(xpath = "(//div[@class='error-message-component'])[2]")
	WebElement dateOfDepartureErrorMessage;
	@FindBy(xpath = "//input [@id='select-all-requests']")
	WebElement clickOnSelectAllCheckBox;
	@FindBy(xpath = "//th [.='IATA']")
	WebElement iATAInTable;
	@FindBy(xpath = "//th [.='Apron Name']")
	WebElement apronNameInTable;
	@FindBy(xpath = "//th [.='Aircraft Registration']")
	WebElement aircraftRegistrationInTable;
	@FindBy(xpath = "//th [.='Flight Number']")
	WebElement flightNumberInTable;
	@FindBy(xpath = "//th [.='Origin']")
	WebElement originInTable;
	@FindBy(xpath = "//th [.='Next Destination']")
	WebElement nextDestinationTable;
	@FindBy(xpath = "//th [.='Next Destination IATA']")
	WebElement nextDestinationIATATable;
	@FindBy(xpath = "//th [.='2nd Destination']")
	WebElement verify2ndDestinationInTable;
	@FindBy(xpath = "//th [.='2nd Destination IATA']")
	WebElement verify2ndDestinationIATAInTable;
	@FindBy(xpath = "//th [.='3rd Destination']")
	WebElement verify3rdDestinationInTable;
	@FindBy(xpath = "//th [.='3rd Destination IATA']")
	WebElement verify3rdDestinationIATAInTable;
	@FindBy(xpath = "//th [.='Final Destination']")
	WebElement verifyFinalDestinationInTable;
	@FindBy(xpath = "//th [.='Final Destination IATA']")
	WebElement verifyFinalDestinationIATAInTable;	
	@FindBy(xpath = "//th [.='Arrival Date & Time']")
	WebElement verifyArrivalDateAndTimeInTable;	
	@FindBy(xpath = "//th [.='Departure Date & Time']")
	WebElement verifyDepartureDateAndTimeInTable;	
	@FindBy(xpath = "//th [.='Operator To be Fuelled']")
	WebElement verifyOperatorTobeFuelledInTable;	
	@FindBy(xpath = "//th [.='Product']")
	WebElement verifyProductInTable;		
	@FindBy(xpath = "//th [.='Volume']")
	WebElement verifyVolumeInTable;	
	@FindBy(xpath = "//th [.='Captain's Request']")
	WebElement verifyCaptainsRequestInTable;		
	@FindBy(xpath = "//th [.='Unit (L/UGL)']")
	WebElement verifyUnitL_UGLInTable;	
	@FindBy(xpath = "//th [.='Contract ID']")
	WebElement verifyContractIDInTable;	
	@FindBy(xpath = "//span[.='Edit']")
	WebElement editButton;
	@FindBy(xpath = "//span[.='Delete']")
	WebElement deleteButton;
	@FindBy(xpath = "//span[.='Cancel Upload']")
	WebElement cancelUploadButton;
	@FindBy(xpath = "//span[.='Submit All']")
	WebElement submitAllButton;
	@FindBy(xpath = "//input [@id='select-all-requests']")
	WebElement selectOnDeSelecrAllCheckBox;
	@FindBy(xpath = "//span[.='Edit']")
	WebElement editButtonEnable;
	@FindBy(xpath = "//span[.='Delete']")
	WebElement deleteButtonEnable;
	@FindBy(xpath = "//input [@id='1']")
	WebElement selectOnOneCheckBox;
	@FindBy(xpath = "//input [@id='2']")
	WebElement selectOnTwoCheckBox;
	@FindBy(xpath = "//span[.='Edit']")
	WebElement selectOnEditButton;
	@FindBy(xpath = "//span[.='Save']")
	WebElement selectOnSaveButton;
	@FindBy(xpath = "//span[.='Cancel Edit']")
	WebElement selectOnCancelEditButton;
	@FindBy(xpath = "//span[.='Delete']")
	WebElement deleteButtonDisable;
	@FindBy(xpath = "//span[.='Delete']")
	WebElement clickOnDeleteButton;
	@FindBy(xpath = "//button[.='No']")
	WebElement clickOnDeleteNoButton;
	@FindBy(xpath = "//button[.='Yes']")
	WebElement clickOnDeleteYesButton;
	@FindBy(xpath = "//button[.='Yes']")
	WebElement clickOnCancelUploadYesButton;
	@FindBy(xpath = "//button[.='No']")
	WebElement clickOnCancelUploadNoButton;
	@FindBy(xpath = "//*[@class=\"tncPolicy\"]")
	WebElement tncPolicyText;
	@FindBy(xpath = "//*[@class=\"tncLink\"]")
	WebElement tncLinkText;
	@FindBy(xpath = "(//*[@class=\"links\"]/li/a)[1]")
	WebElement termsAndConditionsLink;
	@FindBy(xpath = "(//*[@class=\"links\"]/li/a)[2]")
	WebElement privacyPolicyLink;
	@FindBy(xpath = "(//*[@class=\"links\"]/li/a)[3]")
	WebElement cookiePolicyLink;
	
	String nameDigitalData = "page.name";
	String sectionDigitalData = "page.section";
	String countryDigitalData = "page.country";
	String languageDigitalData = "page.language";
	String userIDDigitalData = "user.id";
	String userStatusDigitalData = "user.status";
	String userPersonaDigitalData = "user.persona";
	String userRole1DigitalData = "user.role[0]";
	String userRole2DigitalData = "user.role[1]";
	String companyNameDigitalData = "user.companyName";
	String companyIDDigitalData = "user.companyId";
	String COBDigitalData = "user.cob[0]";
	String LOBDigitalData = "user.lineOfBusiness";
	String operationUnitDigitalData = "user.operationUnit";
	
	@FindBy(xpath = "//a[@class='icon-alone']/span[@class='icon-user-empty']")
	WebElement profileIcon;
	@FindBy(xpath = "//*[@class=\"ui-dialog-content ui-widget-content\"]")
	WebElement termsAndConditionsDialogBox;
	@FindBy(xpath = "//*[@id=\"gtc-checkbox\"]")
	WebElement termsAndConditionsTickBox;
	@FindBy(xpath = "//*[@id=\"gtc-accept-button\"]")
	WebElement clickOnAcceptButton;
	
	//log4j vulnerability Popup
	
	@FindBy(xpath = "//*[@id='alert-popup-homescreen']//button[@value='accept']")
	WebElement clickOnOKButton;
	@FindBy(xpath = "//*[@id='alert-popup-homescreen']")
	WebElement log4jVullnerabilityNotificationBox;
		
	// Canada Users
	
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Manage Notifications')]")
	WebElement manageNotificationsLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//div[@class='menuSelection']//a[contains(text(),'Fuels')]")
	WebElement fuelsLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//div[@class='menuSelection']//a[contains(text(),'Carburants')]")
	WebElement carburantsLink;
	@FindBy(xpath = "//div[@class='menuDropDown']//a[contains(text(),'Gérer les Notifications')]")
	WebElement gererLesNotificationsLink;
	// ----------------------------------------------------------------------------------------------
		@FindBy(xpath = "(//input[@class='red-highlight flatpickr-input'])[1]")
		WebElement dateofArrivalField;
		
		@FindBy(xpath = "//label[text()='Date of arrival']")
		WebElement dateOfArrivalHeader;
		@FindBy(xpath = "//div[@class='field column arrival-time undefined']/label[text()='UTC Time']")
		WebElement utcTimeHeader_Arrival;
		@FindBy(xpath = "//*[@class='Dropdown-root arrival-time']/div/div[1]")
		WebElement utcTimeFieldValue_Arrival;
		@FindBy(xpath = "//label[text()='Date of departure']")
		WebElement dateOfDepartureHeader;
		@FindBy(xpath = "//div[@class='field column departure-time undefined']/label[text()='UTC Time']")
		WebElement utcTimeHeader_Departure;
		@FindBy(xpath = "//*[@class='Dropdown-root departure-time']/div/div[1]")
		WebElement utcTimeFieldValue_Departure;
		@FindBy(xpath = "//label[text()='Name of Operator to be fuelled']")
		WebElement nameOfOperatorHeader;
		@FindBy(xpath = "//div[@class='field column name-of-operator is-6']//input")
		WebElement nameOfOperatorInputBox;

		// date input box
		@FindBy(css = ".arrival-date-box .flatpickr-input")
		WebElement arrivalDateInputBox;
		@FindBy(css = ".departure-date-box .flatpickr-input")
		WebElement departureDateInputBox;

		// --------ArrivalCalender--------
		@FindBy(xpath = "(//select[@class='flatpickr-monthDropdown-months'])[1]")
		WebElement arrivalMonthButton;
		@FindBy(xpath = "(//select[@class='flatpickr-monthDropdown-months'])[1]//option")
		List<WebElement> listArrivalMonths;
		@FindBy(xpath = "(//input[@class='numInput cur-year'])[1]")
		WebElement arrivalYearInputBox;
		@FindBy(xpath = "(//span[@class='arrowUp'])[1]")
		WebElement arrivalYearUpArrowButton;
		@FindBy(xpath = "(//span[@class='flatpickr-day selected'])[1]")
		WebElement arrivalSelectedDateButton;
		@FindBy(xpath = "(//div[@class='flatpickr-weekdays'])[1]//span")
		List<WebElement> listWeekDaysArrival;

		// ------Departure Calender-----
		@FindBy(xpath = "(//select[@class='flatpickr-monthDropdown-months'])[2]")
		WebElement departureMonthButton;
		@FindBy(xpath = "(//select[@class='flatpickr-monthDropdown-months'])[2]//option")
		List<WebElement> listDepartureMonths;
		@FindBy(xpath = "(//input[@class='numInput cur-year'])[2]")
		WebElement departureYearInputBox;
		@FindBy(xpath = "(//span[@class='arrowUp'])[2]")
		WebElement departureYearUpArrowButton;
		@FindBy(xpath = "(//span[@class='flatpickr-day selected'])[1]")
		WebElement departureSelectedDateButton;
		@FindBy(xpath = "(//div[@class='flatpickr-weekdays'])[2]//span")
		List<WebElement> listWeekDaysDeparture;

		// ------
//		@FindBy(xpath = "//*[@id=\"aviation-root\"]/div[2]/div[1]/div/div/div[2]/div[4]/div[1]/input")
//		WebElement dateofArrivalField;
		@FindBy(xpath = "(//input[@class='red-highlight flatpickr-input'])[1]")
		WebElement dateofDepartureField;
		@FindBy(xpath = "(//span[@class='flatpickr-next-month'])[1]")
		WebElement nextMonthFlickerArrival;
		@FindBy(xpath = "(//span[@class='flatpickr-day today'])[1]")
		WebElement withinDayFlickerArrival;
		@FindBy(xpath = "(//span[@class='flatpickr-day '])[3]")
		WebElement nextDayFlickerArrival;
		@FindBy(xpath = "(//span[@class='flatpickr-day '])[7]")
		WebElement nexDayFlickerDeparture;
		@FindBy(xpath = "(//span[@class='flatpickr-next-month'])[2]")
		WebElement nextMonthFlickerDeparture;
		@FindBy(xpath = "//div[@class='Dropdown-root arrival-time']")
		WebElement btnUtcTime_Arrival;
		@FindBy(xpath = "//div[@class='Dropdown-root arrival-time is-open']//div[@class='Dropdown-menu']/div")
		List<WebElement> listUtcTime_Arrival;
		@FindBy(xpath = "//div[@class='Dropdown-root departure-time']")
		WebElement btnUtcTime_Departure;
		@FindBy(xpath = "//div[@class='Dropdown-root departure-time is-open']//div[@class='Dropdown-menu']/div")
		List<WebElement> listUtcTime_Departure;
		@FindBy(xpath = "//div[@class='departure-date-time-details']//div[@class='error-box dateTime-errorbox']")
		WebElement errMsg_DepartureDatetTimeShouldNotBeforeArrivalDateTime;
		@FindBy(xpath = "//div[@class='arrival-date-time-details']//div[@class='error-box dateTime-errorbox']")
		WebElement errMSg_ArrivalDateTimebeforeCurrentDateTime;
		@FindBy(xpath = "(//i[@class='shell-icon-calendar'])[1]")
		WebElement arrivalDateIcon;
		@FindBy(xpath = "(//*[div[contains(@class,'is-block-desktop')]]//button[contains(@class, 'is-large-btn')])[1]")
		WebElement previousButton1;
		@FindBy(xpath = "(//*[div[contains(@class,'is-block-desktop')]]//button[contains(@class, 'is-large-btn')])[2]")
		WebElement cancelButton1;
		@FindBy(xpath = "//button[@class='button is-red-btn shell-btn-primary']")
		WebElement cancelOnPopUp;
		@FindBy(xpath = "(//div[@class='popup-header header-red'])[1]")
		WebElement cancelRequestPopUpTitle;
		@FindBy(xpath = "(//*[div[contains(@class,'is-block-desktop')]]//button[contains(@class, 'is-large-btn')])[3]")
		WebElement nextButton1;
	    @FindBy(xpath = "//span[contains(@class,'selected')]")
	    WebElement arrivalDateSelected;
	    @FindBy(xpath = "//div[@class='dayContainer']/span[@class='flatpickr-day flatpickr-disabled']")
		List<WebElement> listInactiveDate;
	
	public void clickOnSproutLoudCoOpLink() throws Exception {
		click(sproutLoudCoOpLink);
	}
	
	public void clickOnCompriceSSOLink() throws Exception {
		click(compriceSSOLink);
	}
	
	public boolean veriyfIFrame() throws Exception {
		return isElementVisible(iFrame, BaseDataConstants.EXPLICIT_TIMEOUT);

	}

	public void switchToIFrame() throws InterruptedException {
		Thread.sleep(4000);
		WebElement iFrame = driver.findElement(By.xpath("//iframe[@id='fancybox-frame']"));
		driver.switchTo().frame(iFrame);
	}

	public boolean verifyContinueButton() throws Exception {
		return isDisplayed(continueButton);
	}
	
	public void clickOnContinueButton() throws Exception {
		click(continueButton);
	}
	
	public void clickOnContinueButton1() throws Exception {
		click(continueButton1);
	}
	
	public boolean verifyRoyalDutchHeaderMessage() throws Exception {
		return isDisplayed(royalDutchShellHeader);
	}
	
	public void selectSolds() throws Exception {
		click(multipleSolds1);
	}
	
	public String getSproutloudLinkText() throws Exception {
		return sproutLoudCoOpLink.getText().toString();
	}
	
	public boolean verifySproutLoudCoOpLink() throws Exception {
		return isDisplayed(sproutLoudCoOpLink);
	}
	
	public boolean verifyCompriceSSOLink() throws Exception {
		return isDisplayed(compriceSSOLink);
	}
	
	public boolean verifySoldToSelectionHeader() throws Exception {
		return isDisplayed(soldToSelectionHeader);
	}
	
	public boolean verifySingleSoldToSelected() throws Exception {
		boolean flag = false;
		click(selectSolds2);
		if(!selectSolds1.isSelected()==true) {
			flag = true;
			System.out.println("flag::"+flag);
		}else {
			flag = false;
			System.out.println("flag::"+flag);
		}
		click(multipleSolds1);
		return flag;
	}

	public void waitForTermsAndConditionEnabled() throws Exception {
		while(!tncPolicyText.isDisplayed()) {
			Thread.sleep(3000);
			}
	}

	public void switchToExternalTab() throws InterruptedException {
		Thread.sleep(3000);
		switchWindowByTitle("Shell Loyalty");
	}
	
	public boolean verifyinsightsReportingLink() throws Exception {
		Thread.sleep(2000);
		return isDisplayed(insightsReportingLink);
	}

	public boolean verifyLoyaltyLink() throws Exception {
		return isDisplayed(resultsDrivenMktgLoyaltyLink);
	}

	public boolean verifyEMVDeployCenterLinkLink() throws Exception {
		return isDisplayed(eMVDeployCenterLink);
	}
	
	public boolean verifyFuelRewardsLink() throws Exception {
		return isDisplayed(fuelRewardsLink);
	}

	public boolean verifmysteryShopsLinkLink() throws Exception {
		return isDisplayed(mysteryShopsLink);
	}
	
	public boolean verifmysteryShopsLinkLink1() throws Exception {
		return isDisplayed(mysteryShopsLink1);
	}

	public boolean verifypointsmithPOPMaterialsLinkLink() throws Exception {
		return isDisplayed(pointsmithPOPMaterialsLink);
	}

	public boolean verifyTopTechAllocationsLink() throws Exception {
		return isDisplayed(topTechAllocationsLink);
	}
	
	public boolean verifycommunityPumpRDMLink() throws Exception {
		return isDisplayed(communityPumpRDMLink);
	}

	public boolean verifykoremFastLinkLink() throws Exception {
		return isDisplayed(koremFastLink);
	}
	
	public void clickOnEmvDeployCenterlink() throws Exception {
		Thread.sleep(2000);
		click(eMVDeployCenterLink);
	}
	
	public boolean verifyResultsDrivenMktgLoyaltyLink() throws Exception {
		return isDisplayed(resultsDrivenMktgLoyaltyLink);
	}

	public void clickOnresultsDrivenMktgLoyaltyLink() throws Exception {
		click(resultsDrivenMktgLoyaltyLink);
	}
	
	public void clickOnFuelRewardsLink() throws Exception {
		click(fuelRewardsLink);
	}

	public void clickOnkoremFastLink() throws Exception {
		click(koremFastLink);
	}

	public void clickOninsightsReportingLink() throws Exception {
		click(insightsReportingLink);
	}

	public void clickOnMVDeployCenterLink() throws Exception {
		click(eMVDeployCenterLink);
	}

	public void clickOnmysteryShopsLink() throws Exception {
		Thread.sleep(5000);
		click(mysteryShopsLink);
	}
	
	public void clickOnmysteryShopsLink1() throws Exception {
		Thread.sleep(5000);
		click(mysteryShopsLink1);
	}

	public void clickOnpointsmithPOPMaterialsLink() throws Exception {
		click(pointsmithPOPMaterialsLink);
	}

	public void clickOntopTechAllocationsLink() throws Exception {
		click(topTechAllocationsLink);
	}

	public void clickOncommunityPumpRDMLink() throws Exception {
		click(communityPumpRDMLink);
	}


	public String verifyAllMenuName() throws Exception {
		return getText(hkAllMenu);
	}

	public String verifyHomeIconName() throws Exception {
		return getText(hkHomeTitle);
	}

	public void clickOnNewManageUserLink() throws Exception {
		click(manageUserLink);
	}

	public void clickOnContractPrices() throws Exception {
		click(contractPrices);
	}

	public void clickOnBolsLink() throws Exception {
		click(bolsLinks);
	}

	public void clickOnAllocationLink() throws Exception {
		click(allocationLink);
	}

	public void clickOnCarrierDriverLiftLink() throws Exception {
		click(CarrierDriverLiftLink);
	}

	public void clickOnRackPricesLinks() throws Exception {
		click(rackPricesLinks);
	}
	
	public void clickOnViewEmailsLinks() throws Exception {
		click(viewEmailsLink);
	}
	
	public boolean verifyViewEmailsLink() throws Exception {
		return isDisplayed(viewEmailsLink);
	}
	
	public void clickOnSetPrefereneces() throws Exception {
		//clickOnYesLinkOnCookiesBanner();
		if (isElementVisible(log4jVullnerabilityNotificationBox, BaseDataConstants.IMPLICIT_TIMEOUT)) {
			clickOnLog4jVulnerabilityOKButton();
			}
		waitForClickableElement(BaseDataConstants.EXPLICIT_TIMEOUT, setPreferences);
		clickUsingJavaScriptExecutor(setPreferences, BaseDataConstants.EXPLICIT_TIMEOUT);
	}

	public boolean verifySupplyWorkspace() throws Exception {
		return isDisplayed(supplyWorkSpaceLink);
	}

	public boolean verifyAndHandelCookies() throws Exception {
		if (cookiesInfo.isDisplayed()) {
			click(chooseYes);
			return true;

		} else {
			return false;

		}
	}

	public void clickOnThaiLandOrderStatusLink() throws Exception {
		click(orderStatusThailandLabel);
	}

	public boolean verifyMarineTab() throws Exception {
		return !isDisplayed(marineTab);
	}

	public boolean verifyOrderStatus() throws Exception {
		return isDisplayed(orderStatusLink);
	}

	public boolean verifyVMISiteEvents() throws Exception {
		return isDisplayed(vmiSiteEventsLink);
	}

	public boolean verifyVMIStockAndDeliveries() throws Exception {
		return isDisplayed(vmiStockAndDeliveriesLink);
	}

	public boolean verifyFinancials() throws Exception {
		return isDisplayed(financialsLink);
	}

	public boolean verifyDocumentCopies() throws Exception {
		return isDisplayed(documentCopiesLink);
	}

	public void clickOnHomePageAllocations() throws Exception {
		click(homePageAllocations);
		Thread.sleep(4000);
	}

	public void clickOnHomePageQuickLinkAllocations() throws Exception {
		click(homePageQuickLinkAllocations);
		Thread.sleep(4000);
	}

	public boolean verifyHomePageSSOLinkAllocations() throws Exception {
		waitForElementToBeVisible(homeButton, BaseDataConstants.IMPLICIT_TIMEOUT);
		return isDisplayed(homePageSSOLinkAllocation);
	}

	public void clickOnHomePageComprice() throws Exception {
		click(comprice);
		Thread.sleep(4000);
	}

	public String verifyDVRLink() throws Exception {
		return getText(dvrLink);
	}

	public void clickOnAllMenuDVRLink() throws Exception {
		click(dvrLink);
	}

	public boolean verifySSOLoginToiACE() throws Exception {
		return isDisplayed(loginToiACE);
	}

	public void clickOnIACETrainingTab() throws Exception {
		Thread.sleep(5000);
		click(iACETraining);
	}

	public boolean verifyIACETrainingTab() throws Exception {
		return isDisplayed(iACETraining);
	}

	public boolean verifyPageDisconnect() throws Exception {
		return isDisplayed(pageDisconnect);
	}

	public void goToUrl(String url) throws InterruptedException {
		driver.navigate().to(url);
		Thread.sleep(2000);

	}

	public String verifyOrderManagementWorkspaceTitle() throws Exception {
		return getText(orderManagementWorkspaceTitle);
	}

	public void clickOnExit_From_Impersonate() throws Exception {
		//clickOnYesLinkOnCookiesBanner();
		waitForClickableElement(BaseDataConstants.EXPLICIT_TIMEOUT, exit_ImpersonateButton);
		click(exit_ImpersonateButton);
	}

	public boolean verifyOrderManagemet() throws Exception {
		return isDisplayed(orderManagemetLink);
	}

	public String verifyOrderManagemetLink() throws Exception {
		return getText(orderManagemetLink);
	}

	public void clickOnIndoMyProfile() throws Exception {
		click(indoMyProfile);
	}

	public String verifyProductFamilitesLink() throws Exception {
		return getText(productFamilies);
	}

	public void clickOnUserLogOut() throws Exception {
		click(logout);
	}

	public void clickOnSearchIcon() throws Exception {
		clickUsingJavaScriptExecutor(searchIcon,BaseDataConstants.EXPLICIT_TIMEOUT);
	}

	public void enterInputToSearch(String searchText) throws Exception {
		sendKeys(searchInputBox, searchText);
	}

	public void clickOnHelpAndSupportLink() throws Exception {
		click(helpAndSupportPage);
	}

	public String verifyHelpAndSupportPageTitle() throws Exception {
		return getText(helpAndSupportPage);
	}

	public void clickOnHelpAndSupportIcon() throws Exception {
		click(helpAndSupportIcon);
	}
	public void clickOnHelpAndSupportsLink() throws Exception {
		click(navigateHelpAndSupportButton);
	}

	public boolean verifyHelpAndSupportIcon() throws Exception {
		return isDisplayed(helpAndSupportIcon);
	}

	public boolean verifyAllMenuOnHomePage() throws Exception {
		return isDisplayed(allMenu);
	}

	public boolean verifyShellLogoOnHomePage() throws Exception {
		return isDisplayed(shellLogo);
	}

	public void clickOnSubmitPre_FuelFiguresLink() throws Exception {
		click(submitPre_FuelFiguresLink);
	}

	public String getWelComeMessageForAirPortOpsUser() throws Exception {
		return getText(welComeMessageForAirPortOpsUser);
	}
	
	public void clickOnPriceViewLink() throws Exception {
		click(priceViewLink);
	}

	public boolean verifyPriceViewLink() throws Exception {
		return isDisplayed(priceViewLink);
	}

	public void clickOnShellAviationMarketHubTab() throws Exception {
		Thread.sleep(5000);
		click(shellAviationMarketHubTab);
		Thread.sleep(5000);
	}

	public List getAccountsNumber() {
		ArrayList li = new ArrayList<>();
		for (int i = 1; i <= tableData.size(); i++) {
			logger.info("Data::"+(driver.findElement(By.xpath("//table[@id='testTable']/tbody/tr[" + i + "]/td[1]"))).getText().toString());
			WebElement accountNumber = driver.findElement(By.xpath("//table[@id='testTable']/tbody/tr[" + i + "]/td[1]"));
			WebElement accountStatus = driver.findElement(By.xpath("//table[@id='testTable']/tbody/tr[" + i + "]/td[6]"));
			if(!accountStatus.getText().toString().equalsIgnoreCase("true")) {
				li.add(accountNumber.getText().toString().substring(2));
			}else {
			}
		}
		return li;
	}

	public void clickOnProfileNextButton() throws Exception {
		click(profileNextButton);
	}

	public String verifyKoremSSOLink() {
		return getText(koremSSOName);
	}

	public String verifyPageName() {
		return getText(pageName);
	}

	public void clickOnCloseIcon() throws Exception {
		click(closePopIcon);
	}

	public void clickOnKoremSSOLink() throws Exception {
		click(koremSSO);

	}

	public String verifySafetySpotLight() {
		// WebElement Image = driver.findElement(By.xpath("//img[@border='0']"));
		// Used points class to get x and y coordinates of element.
		Point classname = safetySpotlight.getLocation();
		int xcordi = classname.getX();
		int ycordi = classname.getY();

		return getText(safetySpotlightText);
	}

	public void clickOnHomeIcon() throws Exception {
		click(homepage);

	}

	public void clickOnCreateATemplateButton() throws Exception {
		click(createATemplateButton);
	}

	public void clickOnViewAllTemplateLink() throws Exception {
		click(viewAllTemplate);
	}

	public void clickOnstartOrderingWithThisItemButton() throws Exception {
		click(startOrderingWithThisItemButton);
	}

	public void clickOnViewShipMentTab() throws Exception {
		click(viewShipMentTab);
	}

	public boolean verifyQuantityIconIsDisplayed() throws Exception {
		return isDisplayed(quantityIcon);
	}

	public void clickOnCheckAvailabilityButton() throws Exception {
		click(checkAvailabilityButton);
	}

	public void clickOnContractcheckBox() throws Exception {
		click(selectContract);
	}

	public void enterProductCodeInputBox(String productCode) throws Exception {
		sendKeys(productCodeInputBox, productCode);
	}

	public void clickOnFirstSuggestionLink() throws Exception {
		click(firstSuggestionLink);
	}

	public void enterDeliveryLocation(String deliveryLocationArgument) throws Exception {
		sendData(deliveryLocation, deliveryLocationArgument);
	}

	public String getProductAvailablityCheckerHeader() throws Exception {
		return getText(productAvailablityCheckerHeader);
	}

	public void clickOnAvailabilityCheckerLink() throws Exception {
		click(availabilityCheckerLink);
	}

	public void clickOnDfoaMyProfileIcon() throws Exception {
		click(DfoaMyprofileIcon);

	}

	public void enterProductAvailabilityQuantity(String quantity) throws Exception {
		sendKeys(productAvailabilityQuantity, quantity);
	}

	public void pressTabKeyOnProductAvailabilityQuantity() throws Exception {
		pressTabKey(productAvailabilityQuantity);
	}

	public void clickOnOrderStatusLink() throws Exception {
		waitForElementToBeVisible(orderStatusLabel, BaseDataConstants.IMPLICIT_TIMEOUT);
		click(orderStatusLabel);
	}

	public void clickOnPolishOrderStatusLink() throws Exception {
		click(orderStatusPolishLabel);
	}

	public boolean getVerifyOrderStatusLink() throws Exception {
		waitForElementToBeVisible(orderStatusLabel, BaseDataConstants.IMPLICIT_TIMEOUT);
		return isDisplayed(orderStatusLabel);
	}

	public void clickOnOrderManagementLinkOfAccountSummary() throws Exception {
		click(orderManagementLinkOfAccountSummary);
	}

	public void clickOnDfoaWorkspaceLink() throws Exception {
		click(dfoaWorkspaceLink);
	}

	public void clickOnHomeButton() throws Exception {
		click(homeButton);
	}

	public void clickOnMyProfileIcon() throws Exception {
		//clickOnYesLinkOnCookiesBanner();
		if (isElementVisible(log4jVullnerabilityNotificationBox, BaseDataConstants.IMPLICIT_TIMEOUT)) {
			clickOnLog4jVulnerabilityOKButton();
			}
		waitForClickableElement(BaseDataConstants.EXPLICIT_TIMEOUT, myProfileIcon);
		clickUsingJavaScriptExecutor(myProfileIcon, BaseDataConstants.EXPLICIT_TIMEOUT);
	}

	public void clickOnMyProfileLink() throws Exception {
		waitForClickableElement(BaseDataConstants.EXPLICIT_TIMEOUT, myProfileLink);
		//click(myProfileLink);
		clickUsingJavaScriptExecutor(myProfileLink, BaseDataConstants.EXPLICIT_TIMEOUT);

	}

	public void clickOnManageProfileIcon() throws Exception {
		//clickOnYesLinkOnCookiesBanner();
		if (isElementVisible(log4jVullnerabilityNotificationBox, BaseDataConstants.IMPLICIT_TIMEOUT)) {
			clickOnLog4jVulnerabilityOKButton();
			}
		waitForClickableElement(BaseDataConstants.EXPLICIT_TIMEOUT, manageUserIcon);
		clickUsingJavaScriptExecutor(manageUserIcon, BaseDataConstants.EXPLICIT_TIMEOUT);
	}

	public String verifyYouAreImpersonatingText() throws Exception {
		waitForElementToBeVisible(youAreImpersonatingText, BaseDataConstants.EXPLICIT_TIMEOUT);
		return getText(youAreImpersonatingText).trim();
	}

	public void clickOnAllTab() throws Exception {
		
		/*
		 * if (isElementVisible(termsAndConditionsDialogBox,
		 * BaseDataConstants.IMPLICIT_TIMEOUT)) { clickOnTermsAndConditions(); } if
		 * (isElementVisible(log4jVullnerabilityNotificationBox,
		 * BaseDataConstants.IMPLICIT_TIMEOUT)) { clickOnLog4jVulnerabilityOKButton(); }
		 * Thread.sleep(5000);
		 */
		waitForElementToBeVisible(allTab, BaseDataConstants.IMPLICIT_TIMEOUT);
		waitForClickableElement(BaseDataConstants.IMPLICIT_TIMEOUT, allTab);
		click(allTab);
	}
	
	public void clickOnAllTab2() throws Exception {
		
		if (isElementVisible(termsAndConditionsDialogBox, BaseDataConstants.IMPLICIT_TIMEOUT)) {
		clickOnTermsAndConditions();
		} 
		Thread.sleep(10000);	
		waitForElementToBeVisible(allTab, BaseDataConstants.IMPLICIT_TIMEOUT);
		waitForClickableElement(BaseDataConstants.IMPLICIT_TIMEOUT, allTab);
		click(allTab);
	}
	
	public void clickOnTermsAndConditions() throws Exception {
		click(termsAndConditionsTickBox);
		click(clickOnAcceptButton);
	}
	
	public void clickOnLog4jVulnerabilityOKButton() throws Exception {
		//click(termsAndConditionsTickBox);
		click(clickOnOKButton);
	}
	

	public boolean verifyRackPricesLink() throws Exception {
		return isDisplayed(rackPricesLink);
	}

	public void clickOnRackPricesLink() throws Exception {
		click(rackPricesLink);
	}

	public boolean verifyBOLsLink() throws Exception {
		return isDisplayed(bolsLink);
	}

	public void clickOnBOLsLink() throws Exception {
		click(bolsLink);
	}

	public void clickOnOrderManagementLink() throws Exception {
		waitForElementToBeVisible(orderManagementLink, BaseDataConstants.EXPLICIT_TIMEOUT);
		click(orderManagementLink);
	}

	public void clickOnAccountSummaryAllMenu() throws Exception {
		click(allMenuTab);
	}

	public boolean verifyCarrierDriverLastLiftLink() throws Exception {
		return isDisplayed(carrierDriverLastLiftLink);
	}

	public void clickOnCarrierDriverLastLiftLink() throws Exception {
		click(carrierDriverLastLiftLink);
	}

	public void clickOnContractPricesLink() throws Exception {
		click(contractPricesLink);
	}

	public boolean verifyTerminalWaitTimeLink() throws Exception {
		return isDisplayed(terminalWaitTimeLink);
	}

	public void clickOnTerminalWaitTimeLink() throws Exception {
		click(terminalWaitTimeLink);
	}

	public boolean verifyAllocationsLink() throws Exception {
		return isDisplayed(allocationsLink);
	}

	public void clickOnAllocationsLink() throws Exception {
		click(allocationsLink);
	}

	public boolean verifyInvoicedVolumsLink() throws Exception {
		return isDisplayed(invoicedVolumsLink);
	}

	public void clickOnInvoicedVolumsLink() throws Exception {
		click(invoicedVolumsLink);
	}

	public void clickOnSupplyWorkspaceLink() throws Exception {
		click(supplyWorkspaceLink);
	}

	public boolean verifyWhereAndWhatCanILiftLink() throws Exception {
		return isDisplayed(whereAndWhatCanILiftLink);
	}

	public void clickOnWhereAndWhatCanILiftLink() throws Exception {
		click(whereAndWhatCanILiftLink);
	}

	public boolean verifySiteListLink() throws Exception {
		return isDisplayed(siteListLink);
	}

	public void clickOnSiteListLink() throws Exception {
		click(siteListLink);
	}

	public boolean verifyVolumesEntryLink() throws Exception {
		return isDisplayed(incentivesVolumeLink);
	}

	public void clickOnIncentivesVolumesLink() throws Exception {
		click(incentivesVolumeLink);
	}

	public boolean verifyCarrierMaintenanceLink() throws Exception {
		return isDisplayed(carrierMaintenanceLink);
	}

	public void clickOnCarrierMaintenanceLink() throws Exception {
		click(carrierMaintenanceLink);
	}

	public void clickOnRequestCarrierSetUpLink() throws Exception {
		click(requestCarrierSetUpLink);
	}

	public boolean verifyContractRecaptureLink() throws Exception {
		return isDisplayed(contractRecaptureLink);
	}

	public void clickOnContractRecaptureLink() throws Exception {
		click(contractRecaptureLink);
	}

	public String verifyPerformanceWorkspaceLink() throws Exception {
		return getText(performanceWorkspaceLink);
	}

	public boolean verifyPerformanceWorkspace() throws Exception {
		return isDisplayed(performanceWorkspaceLink);
	}

	public void clickOnPerformanceWorkspaceLink() throws Exception {
		click(performanceWorkspaceLink);
		sleep(5000);
	}

	public void clickOnDigitalContentLink() throws Exception {
		click(digitalContentLink);
	}

	public boolean verifyFinanceWorkspace() throws Exception {
		return isDisplayed(financeWorkspaceLink);
	}

	public void clickOnFinanceWorkspaceLink() throws Exception {
		click(financeWorkspaceLink);
	}

	public boolean verifyMarineLightHouseButton() throws Exception {
		return isDisplayed(marineLightHouseButton);
	}

	public void clickOnMarineLightHouseButton() throws Exception {
		Thread.sleep(2000);
		click(marineLightHouseButton);
	}

	public void clickOnShellAviationMarkethubButton() throws Exception {
		click(shellAviationMarkethubButton);
	}

	public void clickOnBookRequestLink() throws Exception {
		click(bookRequestLink);
	}

	public void clickOnRequestFuelLink() throws Exception {
		click(requestFuelLink);
	}

	public void clickOnFuelRequestHistoryLink() throws Exception {
		Thread.sleep(5000);
		click(fuelRequestHistoryLink);
		Thread.sleep(5000);
	}
	
	public boolean verifyFuelRequestHistory() throws Exception {
		return isDisplayed(verifyFuelRequestHistory);
	}
	
	public boolean verifyBulkFuelRequestIDInFRH() throws Exception {
		return isDisplayed(verifyBulkFuelRequestIDInFRH);
	}
	
	public boolean verifyBulkFuelRequestIDInFRDetailsPage() throws Exception {
		return isDisplayed(verifyBulkFuelRequestIDInFRDetailsPage);
	}
	
	public void clickOnContractsLink() throws Exception {
		click(contractsLink);
	}

	public void clickOnCheckbox() throws Exception {
		Thread.sleep(5000);
		click(clickOnCheckbox);
		Thread.sleep(5000);
	}
	
	public void getBulkFuelRequestIdLabel() throws Exception {
		Thread.sleep(5000);
		click(verifyBulkFuelRequestIdLabel);
		Thread.sleep(5000);
	}
	
	public void clickOnUpdateButton() throws Exception {
		click(clickOnUpdateButton);
	}
	
	public void clickOnUpdateRequestButton() throws Exception {
		click(clickOnUpdateRequestButton);
	}
	
	
	public void clickOnContractsNewLink() throws Exception {
		click(contractsLinkNew);
	}

	public void clickOnMapsLink() throws Exception {
		click(mapsLink);
	}

	public void clickOnFuelPriceLink() throws Exception {
		click(fuelPriceLink);
	}

	public void clickOnPricesLink() throws Exception {
		click(pricesLink);
	}

	public void clickOnLogout() throws Exception {
		click(DFOALogout);
	}

	public void ClickOnMyprofileIcon() throws Exception {
		click(aMyprofileIcon);
	}

	public void clickonDFOAFrmAllMenu() throws Exception {
		click(clickOnDWorkspcefrmAllMenu);
	}

	public void clickonDFoALogout() throws Exception {
		click(dfoalogout);
	}

	public void clickonlogoutforturkeyuser() throws Exception {
		click(logoutforturkeyuser);
	}

	public void clickonpolandmyprofile() throws Exception {
		click(myfprolepoland);
	}

	public void clickOnMyprofileturkeyuser() throws Exception {
		click(myprofileturkey);
	}

	public void clickordermanagementfromNotificaitonpage() throws Exception {
		click(ordermanagementfromnotificationpage);
	}

	public void clickOnOrderManagementPoland() throws Exception {
		click(ordermanagementpoland);
	}

	public void clickOnMenuForPoland() throws Exception {
		click(polandmenu);
	}

	public String verifyImpersnateMessage() {
		return getText(verifyImpersanating);
	}

	public void exit_Impersonate() throws Exception {
		click(exit_Impersonate);
	}

	public void Impersonateuser() throws Exception {
		click(clcik_Impersonate);
	}

	public void clickonsearchuser() throws Exception {
		click(clickonsearch);
	}

	public void inputuser(String user) throws Exception {
		sendKeys(enterusername, user);
	}

	public void clickOnOrderManagementLinkTurkeyuser() throws Exception {
		click(ordermanagmentlink);
	}

	public void clickOnAllMenuForTurkey() throws Exception {
		click(turkeyuserMenu);
	}

	public void clickOnLogoutLink() throws Exception {
		click(homePageLogout);
	}

	public void clickOnlogOutLinkForTurkeyCountry() throws Exception {
		click(logOutForTurkeyCountry);
	}

	public void clickOnMyProfileLinkForPolandCountry() throws Exception {
		click(myfprofilePoland);
	}

	public void clickOnMyprofileForTurkeyCountry() throws Exception {
		click(myProfileTurkeyCountry);
	}

	public void clickOnOrdermanagementForTurkeyCountry() throws Exception {
		click(orderManagment);
	}

	public void clickOnOrderManagementLinkForPoland() throws Exception {
		click(orderManagementForPolandCountryLink);
	}

	public void clickOnAllMenuForPolandCountry() throws Exception {
		click(allMenuPolandCountry);
	}

	public void clickOnExitFromImpersonattion() throws Exception {
		click(exitImpersonateButton);
	}

	public void clickoncheckbox() throws Exception {
		click(selectcheckbox);
	}

	public void clickOnOrderManagementLinkForTurkeyCountry() throws Exception {
		click(orderManagmentLink);
	}

	public void clickOnAllMenuTurkeyCountry() throws Exception {
		click(allMenuTurkeyCountry);
	}

	public void clickonValueVolumeReportLink() throws Exception {
		waitForElementToBeVisible(valueVolumeReportLink, 100);
		click(valueVolumeReportLink);
	}

	public String getOrderManagementLinkText() throws Exception {
		return getText(orderManagementLink);
	}

	public void clickOnDocumentCopiesLink() throws Exception {
		click(documentCopiesLink);
	}

	public String getDocCopiesLinkText() throws Exception {
		return getText(documentCopiesLink);
	}

	public void clickOnFinancialsLink() throws Exception {
		waitForElementToBeVisible(financialsLink, BaseDataConstants.IMPLICIT_TIMEOUT);
		click(financialsLink);
	}

	public String getFinancialsLinkText() throws Exception {
		return getText(financialsLink);
	}

	public void clickOnVMIStockAndDeliveriesLink() throws Exception {
		click(vmiStockAndDeliveriesLink);
	}

	public String getVMIStockAndDeliveriesLinkText() throws Exception {
		return getText(vmiStockAndDeliveriesLink);
	}

	public void clickOnVMISiteEventsLink() throws Exception {
		click(vmiSiteEventsLink);
	}

	public String getVMISiteEventsLinkText() throws Exception {
		return getText(vmiSiteEventsLink);
	}

	public void clickOnPMTDRReportLink() throws Exception {
		click(pmtdrReportLink);
	}

	public String getPMTDRReportLinkText() throws Exception {
		return getText(pmtdrReportLink);
	}

	public void clickOnOrderManagementForPoland() throws Exception {
		click(orderManagment);
	}

	public String getValueVolumeReportLinkText() throws Exception {
		return getText(valueVolumeReportLink);
	}

	public boolean verifyPMTDRReportLinks() throws Exception {
		return !isDisplayed(pmtdrReportLink);
	}

	public Boolean verifyValueVolumeReportLink() throws Exception {
		return isElementVisible(valueVolumeReportLink, BaseDataConstants.EXPLICIT_TIMEOUT);
	}

	public Boolean verifyVMIStockAndDeliveriesLink() throws Exception {
		return isElementVisible(vmiStockAndDeliveriesLink, BaseDataConstants.EXPLICIT_TIMEOUT);
	}

	public Boolean verifyVMISiteEventsLink() throws Exception {
		return isElementVisible(vmiSiteEventsLink, BaseDataConstants.EXPLICIT_TIMEOUT);
	}

	public Boolean verifyFinancialsLinkText() throws Exception {
		return isElementVisible(financialsLink, BaseDataConstants.EXPLICIT_TIMEOUT);
	}

	public Boolean verifyDocCopiesLinkText() throws Exception {
		return isElementVisible(documentCopiesLink, BaseDataConstants.EXPLICIT_TIMEOUT);
	}

	public void waitForElement(WebElement el) throws Exception {
		waitForElementToBeVisible(el, BaseDataConstants.EXPLICIT_TIMEOUT);
	}
	
	public void waitForSecs(int secs) throws Exception {
		sleep(secs*1000);	
	}

	public void clickOnAutomatedTestLink() throws Exception {
		click(automatedTestLink);
	}

	public Boolean verifyAutomatedTestLink() throws Exception {
		return isElementVisible(automatedTestLink, BaseDataConstants.EXPLICIT_TIMEOUT);
	}

	public Boolean verifyAutomatedTestLinkUSF() throws Exception {
		return isElementVisible(automatedTestLinkUSF, BaseDataConstants.EXPLICIT_TIMEOUT);
	}

	public void clickOnAutomatedTestLinkUSF() throws Exception {
		click(automatedTestLinkUSF);
	}

	public String verifyNameDigitalData() throws Exception {
		return getDigitalData(nameDigitalData);
	}

	public String verifySectionDigitalData() throws Exception {
		return getDigitalData(sectionDigitalData);
	}

	public String verifyCountryDigitalData() throws Exception {
		return getDigitalData(countryDigitalData);
	}

	public String verifyLanguageDigitalData() throws Exception {
		return getDigitalData(languageDigitalData);
	}

	public String verifyUserIDDigitalData() throws Exception {
		return getDigitalData(userIDDigitalData);
	}

	public String verifyUserStatusDigitalData() throws Exception {
		return getDigitalData(userStatusDigitalData);
	}

	public String verifyUserPersonaDigitalData() throws Exception {
		return getDigitalData(userPersonaDigitalData);
	}

	public String verifyUserRole1DigitalData() throws Exception {
		return getDigitalData(userRole1DigitalData);
	}

	public String verifyUserRole2DigitalData() throws Exception {
		return getDigitalData(userRole2DigitalData);
	}

	public String verifyCompanyNameDigitalData() throws Exception {
		return getDigitalData(companyNameDigitalData);
	}

	public String verifyCompanyIDDigitalData() throws Exception {
		return getDigitalData(companyIDDigitalData);
	}

	public String verifyCOBDigitalData() throws Exception {
		return getDigitalData(COBDigitalData);
	}

	public String verifyLOBDigitalData() throws Exception {
		return getDigitalData(LOBDigitalData);
	}

	public String verifyOperationUnitDigitalData() throws Exception {
		return getDigitalData(operationUnitDigitalData);
	}

	//@Step("Navigate to {URL}")
	public void goToURL(String URL) throws Exception {
		step("Navigate to URL"+ URL);
		getURL(URL);
	}

	public void enterSearch(String name) throws Exception {
		sendKeys(searchEditbox, name);
	}

	public void clickOnSearchButton() throws Exception {
		click(searchButton);
	}

	public void closeMedalliaPopup() throws Exception {
		waitForElementToBeVisible(medalliaPopup, 10);
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("" + "document.getElementById(\"kampyleFormContainer\").remove();\n"
				+ "document.getElementsByTagName('body')[0].style['overflow']='scroll';");
	}

	public void clickOnDocumentSearchIcon() throws Exception {

		click(DCSearchIcon);
	}

	public void enterDocumentSearch(String name) throws Exception {
		Thread.sleep(5000);
		sendKeys(DCSearchBox, name);
	}

	public void clickOnAccountingDocsLink() throws Exception {
		click(accountingDocsLink);
	}

	public void clickOnYesLinkOnCookiesBanner() throws Exception {
		try {
			if (isElementVisible(yesLinkOnCookiesBanner, BaseDataConstants.EXPLICIT_TIMEOUT) == true) {
				click(yesLinkOnCookiesBanner);
			}
		} catch(Exception e) {}
	}
	public boolean verifyNotificationIcon() throws Exception {
		return isDisplayed(notificationIcon);
	}

	public void clickOnNotificationIcon() throws Exception {
		//clickOnYesLinkOnCookiesBanner();
		if (isElementVisible(log4jVullnerabilityNotificationBox, BaseDataConstants.IMPLICIT_TIMEOUT)) {
			clickOnLog4jVulnerabilityOKButton();
			} 
		clickUsingJavaScriptExecutor(notificationIcon, BaseDataConstants.EXPLICIT_TIMEOUT);
	}
	
	public boolean verifySubscriptionLink() throws Exception {
		return isDisplayed(subscriptionLink);
	}
	
	public void clickOnSubscriptionLink() throws Exception {
		click(subscriptionLink);
	}

	public Boolean verifyFuelPriceLinkText() throws Exception {
		return isElementVisible(fuelPriceLink, BaseDataConstants.EXPLICIT_TIMEOUT);
	}

	public void clickOnAllTab1() throws Exception {
		WaitTime(BaseDataConstants.IMPLICIT_TIMEOUT);
		Thread.sleep(5000);
		waitForElementToBeVisible(allTab, BaseDataConstants.IMPLICIT_TIMEOUT);
		waitForClickableElement(BaseDataConstants.IMPLICIT_TIMEOUT, allTab);
		doubleClick(allTab);
	}
	
	public boolean verifyWholesaleProgramUrl() throws Exception {
		return isDisplayed(wholesaleProgramUrl);
	}
	
	public void clickOnWholesaleProgramUrl() throws Exception {
		click(wholesaleProgramUrl);
	}

	public void clickOnProfileIcon() throws Exception {
		click(profileIcon);
	}
	
	public void clickOnDeliveryTicketLink() throws Exception {
		waitForElementToBeVisible(deliveryTicketLink, 1000);
		click(deliveryTicketLink);
	}
	public void clickplaceAnOrder() throws Exception {
		waitForElementToBeVisible(placeAnOrder, 1000);
		click(placeAnOrder);
	}

	public Boolean placeAnOrdericonPresence() throws Exception {
		return isElementVisible(placeAnOrder, BaseDataConstants.IMPLICIT_TIMEOUT);
	}
	
	// Canada Users
	
	public boolean verifyManageNotificationsLink() throws Exception {
		waitForElementToBeVisible(manageNotificationsLink, BaseDataConstants.EXPLICIT_TIMEOUT);
		return isDisplayed(manageNotificationsLink);
	}
	
	public void clickOnManageNotificationsLink() throws Exception {
		waitForElementToBeVisible(manageNotificationsLink, BaseDataConstants.EXPLICIT_TIMEOUT);
		click(manageNotificationsLink);
	}
	
	public void clickOnAllTabCanadaUser() throws Exception {
		Thread.sleep(10000);
		waitForElementToBeVisible(allTab, BaseDataConstants.EXPLICIT_TIMEOUT);
		//waitForClickableElement(BaseDataConstants.IMPLICIT_TIMEOUT, allTab);
		click(allTab);
	}
	
	public void clickOnFuelsLink() throws Exception {
		waitForElementToBeVisible(fuelsLink, BaseDataConstants.EXPLICIT_TIMEOUT);
		click(fuelsLink);
	}
	
	public void clickOnCarburantsLink() throws Exception {
		waitForElementToBeVisible(carburantsLink, BaseDataConstants.EXPLICIT_TIMEOUT);
		click(carburantsLink);
	}
	
	public boolean verifyGererLesNotificationsLink() throws Exception {
		waitForElementToBeVisible(gererLesNotificationsLink, BaseDataConstants.EXPLICIT_TIMEOUT);
		return isDisplayed(gererLesNotificationsLink);
	}
	
	public void clickOnGererLesNotificationsLink() throws Exception {
		waitForElementToBeVisible(gererLesNotificationsLink, BaseDataConstants.EXPLICIT_TIMEOUT);
		click(gererLesNotificationsLink);
	}
	
	public boolean verifyAgentOfflineBlock() throws Exception {
		return isDisplayed(agentOfflineBlock);
	}
	
	public boolean verifyBacktoBulkRequestHistoryPageButton() throws Exception {
		return isDisplayed(verifyBacktoBulkRequestHistoryPageButton);
	}
	
	public boolean verifyCancelRequestButton() throws Exception {
		return isDisplayed(verifyCancelRequestButton);
	}
	
	public boolean verifyDownloadButton() throws Exception {
		return isDisplayed(verifyDownloadButton);
	}
	
	public boolean verifyEditFuelRequestButton() throws Exception {
		return isDisplayed(verifyEditFuelRequestButton);
	}
	
	public void clickOnBulkFuelRequestUploadLink() throws Exception {
		Thread.sleep(5000);
		click(bulkFuelRequestUploadLink);
		Thread.sleep(5000);
	}
	
	public void clickOnBacktoBulkRequestHistoryPageButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnBacktoBulkRequestHistoryPageButton);
		Thread.sleep(5000);
	}
	
	public void clickOnBulkFuelRequestUploadButton() throws Exception {
		click(bulkFuelRequestUploadButton);
   }
	
	public void clickOnBulkFuelRequestHistoryLink() throws Exception {
		Thread.sleep(5000);
		click(bulkFuelRequestHistoryLink);
		Thread.sleep(5000);
	}
	
	public void clickOnBulkFuelRequestHistoryButton() throws Exception {
		click(bulkFuelRequestHistoryButton);
	}
	
	public void clickOnDownloadHereLink() throws Exception {
		Thread.sleep(5000);
		click(downloadHereLink);
		Thread.sleep(5000);
	}
	
	public void clickOnRowInHistoryPage() throws Exception {
		Thread.sleep(5000);
		click(clickOnRowInHistoryPage);
		Thread.sleep(5000);
	}
	
	public void clickOnEditFuelRequestButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnEditFuelRequestButton);
		Thread.sleep(5000);
	}
	
	public boolean verifyBulkFuelRequestID() throws Exception {
		return isDisplayed(verifyBulkFuelRequestID);
	}
	
	public boolean verifyFuelRequestID() throws Exception {
		return isDisplayed(verifyFuelRequestID);
	}
	
	public void clickOnDownloadButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnDownloadButton);
		Thread.sleep(5000);
	}
	
	public void clickOnReferenceDataLink() throws Exception {
		Thread.sleep(5000);
		click(referenceDataLink);
		Thread.sleep(5000);
	}
		
	public boolean verifyTermsAndConditionsText() throws Exception {
		Thread.sleep(10000);
		return isDisplayed(tncPolicyText);
	}
	public String getTncPolicyText() throws Exception {
		waitForElementToBeVisible(tncPolicyText, BaseDataConstants.IMPLICIT_TIMEOUT);
		return getText(tncPolicyText);
	}
	
	public String getTncLinkText() throws Exception {
		waitForElementToBeVisible(tncLinkText, BaseDataConstants.IMPLICIT_TIMEOUT);
		return getText(tncLinkText);
	}
	
	public String getTncLinkTextColorCode() throws Exception {
		 String colour = tncLinkText.getCssValue("color");
		 String tncLinkTextColorCode = Color.fromString(colour).asHex();
		 return (tncLinkTextColorCode);
	}
	
	public String getTncPolicyTextColorCode() throws Exception {
		 String colour = tncPolicyText.getCssValue("color");
		 String tncPolicyTextColorCode = Color.fromString(colour).asHex();
		 return (tncPolicyTextColorCode);
	}
	
	public String getTncPolicyTextColorFontSize() throws Exception {
		 String tncPolicyTextFontSize = tncPolicyText.getCssValue("font-size");
		 return (tncPolicyTextFontSize);
	}
	
	public String getTncPolicyTextColorFontFamily() throws Exception {
		  String fontFamily = tncPolicyText.getCssValue("font-family");
		 return (fontFamily);
	}
	
	public String getTncLinkTextColorFontSize() throws Exception {
		 String tncLinkTextFontSize = tncLinkText.getCssValue("font-size");
		 return (tncLinkTextFontSize);
	}
	
	public String getTncLinkTextColorFontFamily() throws Exception {
		 String fontFamily = tncLinkText.getCssValue("font-family");
		 return (fontFamily);
	}
	public boolean verifyTermsAndConditionsLink() throws Exception {
		return isElementVisible(termsAndConditionsLink, BaseDataConstants.EXPLICIT_TIMEOUT);
	}
	
	public boolean verifyPrivacyPolicyLink() throws Exception {
		return isElementVisible(privacyPolicyLink, BaseDataConstants.EXPLICIT_TIMEOUT);
	}
	
	public boolean verifyCookiePolicyLink() throws Exception {
		return isElementVisible(cookiePolicyLink, BaseDataConstants.EXPLICIT_TIMEOUT);
	}
	
	public void clickOnTermsAndConditionsLink() throws Exception {
		waitForElementToBeVisible(termsAndConditionsLink, BaseDataConstants.EXPLICIT_TIMEOUT);
		click(termsAndConditionsLink);
	}
	
	public void switchToTab(int index) throws Exception {
		switchWindowByIndex(index);
		}
	
	public boolean verifyIATAName() throws Exception {
		return isDisplayed(iATAName);	
	}
	
	public void clickOnSelectAndUploadFile() throws Exception {
		Thread.sleep(5000);
		click(selectAndUploadFile);
		Thread.sleep(5000);
	}
	
	public void clickOnCrossIcon() throws Exception {
		Thread.sleep(5000);
		click(deleteCrossIcon);
		Thread.sleep(5000);
	}
	
	public boolean verifyCrossIcon() throws Exception {
		return isDisplayed(crossIcon);	
	}
	
	public void clickOnGlobalIataList() throws Exception {
		
		Thread.sleep(5000);
		click(globalIataList);
		Thread.sleep(5000);
	}
	
	public void clickOnGlobalIATAName() throws Exception {
		click(globalIATAName);
	}
	
	public void clickOnGlobalAirportName() throws Exception {
		click(globalAirportName);	
	}
	
	public void clickOnGlobalCountryName() throws Exception {
		click(globalCountryName);
	}
	
	public boolean verifyApronName() throws Exception {
		return isDisplayed(apronName);
	}
	
	public boolean verifyProductName() throws Exception {
		return isDisplayed(productName);
	}
	
	public boolean verifySearchByBar() throws Exception {
		return isDisplayed(searchByBar);
	}
	
	public boolean verifyNameOfTheFile() throws Exception {
		return isDisplayed(nameOfTheFile);
	}
	
	public boolean verifyErrorMsgWithMoreRows() throws Exception {
		return isDisplayed(errorMsgWithMoreRows);
	
	}
	
	public boolean verifyErrorMsgWithEmptyTemplate() throws Exception {
		return isDisplayed(errorMsgWithEmptyTemplate);
	}
	
	public boolean verifySelectAndUploadFile() throws Exception {
		return isDisplayed(selectAndUploadFile1);
	}

	public boolean verifyErrorMsgNotInExcelFile() throws Exception {
		return isDisplayed(errorMsgNotInExcelFile);
	}
	
	public void clickOnNextButton() throws Exception {
		Thread.sleep(5000);
		click(selectOnNextButton);
		Thread.sleep(5000);
	}
	
	public void  clickOnProductAeroJetButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnProductAeroJetButton);
		Thread.sleep(5000);
	}
	
	public void  clickOnContractFRButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnContractFRButton);
		Thread.sleep(5000);
	}
	
	public void  clickOnProceedButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnProceedButton);
		Thread.sleep(5000);
	}
	
	public void  clickOnUpdateFuelRequestButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnUpdateFuelRequestButton);
		Thread.sleep(5000);
	}
	
	public void  clickOnBackToWorkspaceButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnBackToWorkspaceButton);
		Thread.sleep(5000);
	}
	
	public void  clickOnRequestFuelButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnRequestFuelButton);
		Thread.sleep(5000);
	}
	
	public void  clickOnBackToBulkUploadPageButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnBackToBulkUploadPageButton);
		Thread.sleep(5000);
	}
	
	public void clickOnDatetOfArrivalButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnDatetOfArrivalButton);
		Thread.sleep(5000);
	}
	
	public void clickSubmitAllButton() throws Exception {
		Thread.sleep(5000);
		click(clickSubmitAllButton);
		Thread.sleep(5000);
	}
	
	public void clickOnEditInStatusButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnEditInStatusButton);
		Thread.sleep(5000);
	}
	
	public void clickOnPageLink() throws Exception {
		Thread.sleep(5000);
		click(clickOnPageLink);
		Thread.sleep(5000);
	}
	
	public boolean verifyInfoMessage() throws Exception {
		return isDisplayed(infoMsg);
	}
	
	public boolean verifyApronNameErrorMessage() throws Exception {
		return isDisplayed(verifyApronNameErrorMessage);
	}
	
	public String getEmptyApronNameErrorMessage() throws Exception {
		return getText(emptyApronNameErrorMessage);
	}
	
	public String getEmptyAircraftRegistrationNumErrorMessage() throws Exception {
		return getText(emptyAircraftRegistrationNumErrorMessage);
	}
	
	public String getWrongAircraftRegistrationNumErrorMessage() throws Exception {
		return getText(wrongAircraftRegistrationNumErrorMessage);
	}
	
	public String getWrongFlightNumErrorMessage() throws Exception {
		return getText(wrongFlightNumErrorMessage);
	}
	
	public String getWrongOriginErrorMessage() throws Exception {
		return getText(wrongOriginErrorMessage);
	}
	
	public String getEmptyOriginErrorMessage() throws Exception {
		return getText(emptyOriginErrorMessage);
	}
	
	public String getWrongNextDestinationErrorMessage() throws Exception {
		return getText(wrongNextDestinationErrorMessage);
	}
	
	public String getEmptyNextDestinationErrorMessage() throws Exception {
		return getText(emptyNextDestinationErrorMessage);
	}
	
	public String getWrongIataInNextDestinationErrorMessage() throws Exception {
		return getText(wrongIataInNextDestinationErrorMessage);
	}

	public String getEmptyIataInNextDestinationErrorMessage() throws Exception {
		return getText(emptyIataInNextDestinationErrorMessage);
	}
	
	public String getWrongSecondNextDestinationErrorMessage() throws Exception {
		return getText(wrongSecondNextDestinationErrorMessage);
	}
	
	public String getWrongSecondIataNextDestinationErrorMessage() throws Exception {
		return getText(wrongSecondIataNextDestinationErrorMessage);
	}
	
	public String getWrongThirdNextDestinationErrorMessage() throws Exception {
		return getText(wrongThirdNextDestinationErrorMessage);
	}
	
	public String getWrongThirdIataNextDestinationErrorMessage() throws Exception {
		return getText(wrongThirdIataNextDestinationErrorMessage);
	}
	
	public String getWrongFinalDestinationErrorMessage() throws Exception {
		return getText(wrongFinalDestinationErrorMessage);
	}
	
	public String getEmptyFinalDestinationErrorMessage() throws Exception {
		return getText(emptyFinalDestinationErrorMessage);
	}
	
	public String getEmptySecondNextDestinationErrorMessage() throws Exception {
		return getText(emptySecondNextDestinationErrorMessage);
	}
	
	public String getEnterSecondNextDestinationErrorMessage() throws Exception {
		return getText(enterSecondNextDestinationErrorMessage);
	}
	
	public String getEmptyThirdNextDestinationErrorMessage() throws Exception {
		return getText(emptyThirdNextDestinationErrorMessage);
	}
	
	public String getEnterThirdNextDestinationErrorMessage() throws Exception {
		return getText(enterThirdNextDestinationErrorMessage);
	}
	
	public String getWrongFinalDestinationIataErrorMessage() throws Exception {
		return getText(wrongFinalDestinationIataErrorMessage);
	}
	
	public String getEmptyFinalDestinationIataErrorMessage() throws Exception {
		return getText(emptyFinalDestinationIataErrorMessage);
	}
	
	public String getArrivalDateAndTimeInWrongFormatErrorMessage() throws Exception {
		return getText(arrivalDateAndTimeInWrongFormatErrorMessage);
	}
	
	public String getArrivalDateAndTimeInEmptyFormatErrorMessage() throws Exception {
		return getText(arrivalDateAndTimeInEmptyFormatErrorMessage);
	}
	
	public String getDepartureDateAndTimeInWrongFormatErrorMessage() throws Exception {
		return getText(departureDateAndTimeInWrongFormatErrorMessage);
	}
	
	public String getDepartureDateAndTimeInEmptyFormatErrorMessage() throws Exception {
		return getText(departureDateAndTimeInEmptyFormatErrorMessage);
	}
	
	public String getEmptyOperatorsNameErrorMessage() throws Exception {
		return getText(emptyOperatorsNameErrorMessage);
	}
	
	public String getWrongProductNameErrorMessage() throws Exception {
		return getText(wrongProductNameErrorMessage);
	}
	
	public String getEmptyProductNameErrorMessage() throws Exception {
		return getText(emptyProductNameErrorMessage);
	}

	public String getWrongVolumeErrorMessage() throws Exception {
		return getText(wrongVolumeErrorMessage);
	}
	
	public String getEmptyVolumeAndCaptainsRequestErrorMessage() throws Exception {
		return getText(emptyVolumeAndCaptainsRequestErrorMessage);
	}
	
	public String getWrongUnitErrorMessage() throws Exception {
		return getText(wrongUnitErrorMessage);
	}
	
	public String getEmptyUnitErrorMessage() throws Exception {
		return getText(emptyUnitErrorMessage);
	}
	
	public boolean verifyStatusInTable() throws Exception {
		return isDisplayed(verifyStatusInTable);
	}
	
	public boolean verifyStatusAsNewInTable() throws Exception {
		return isDisplayed(verifyStatusAsNewInTable);
	}
	
	public boolean verifyStatusAsFailedInTable() throws Exception {
		return isDisplayed(verifyStatusAsFailedInTable);
	}
	
	public boolean verifyStatusAsEditInTable() throws Exception {
		return isDisplayed(verifyStatusAsEditInTable);
	}
	
	public String getIATAAirportCodeErrorMessage() throws Exception {
		return getText(iATAAirportCodeErrorMessage);
	}
	
	public String getDateOfArrivalErrorMessage() throws Exception {
		Thread.sleep(5000);
		return getText(dateOfArrivalErrorMessage);
	}
	
	public String getDateOfDepartureErrorMessage() throws Exception {
		Thread.sleep(5000);
		return getText(dateOfDepartureErrorMessage);
	}
	
	public String getErrorMsgForDate_Time() throws Exception {
		Thread.sleep(5000);
		return getText(errorMsgForDate_Time);
	}
	
	public boolean verifyBulkFuelRequestIDInTable() throws Exception {
		return isDisplayed(verifyBulkFuelRequestIDInTable);
	}
	
	public void clickOnSelectAllCheckBox() throws Exception {
		Thread.sleep(5000);
		click(clickOnSelectAllCheckBox);
		Thread.sleep(5000);
	}
	
//	public boolean getIATAInTable() throws Exception {
//		return isDisplayed(iATAInTable);
//	}
	
	public String getIATAInTable() throws Exception {
		return getText(iATAInTable);
	}
	
	public String getApronNameInTable() throws Exception {
		return getText(apronNameInTable);
	}
	
	public String getAircraftRegistrationInTable() throws Exception {
		return getText(aircraftRegistrationInTable);
	}
	
	public String getFlightNumberInTable() throws Exception {
		return getText(flightNumberInTable);
	}
		
	public String getOriginInTable() throws Exception {
		return getText(originInTable);
	}
	
	public String getNextDestinationTable() throws Exception {
		return getText(nextDestinationTable);
	}
	
	public String getNextDestinationIATATable() throws Exception {
		return getText(nextDestinationIATATable);
	}
	
	public String get2ndDestinationInTable() throws Exception {
		return getText(verify2ndDestinationInTable);
	}
	
	public String get2ndDestinationIATAInTable() throws Exception {
		return getText(verify2ndDestinationIATAInTable);
	}
	
	public String get3rdDestinationInTable() throws Exception {
		return getText(verify3rdDestinationInTable);
	}
	
	public String get3rdDestinationIATAInTable() throws Exception {
		return getText(verify3rdDestinationIATAInTable);
	}
	
	public String getFinalDestinationInTable() throws Exception {
		return getText(verifyFinalDestinationInTable);
	}
	
	public String getFinalDestinationIATAInTable() throws Exception {
		return getText(verifyFinalDestinationIATAInTable);
	}
	
	public String getArrivalDateAndTimeInTable() throws Exception {
		return getText(verifyArrivalDateAndTimeInTable);
	}
	
	public String getDepartureDateAndTimeInTable() throws Exception {
		return getText(verifyDepartureDateAndTimeInTable);
	}
	
	public String getOperatorTobeFuelledInTable() throws Exception {
		return getText(verifyOperatorTobeFuelledInTable);
	}
	
	public String getProductInTable() throws Exception {
		return getText(verifyProductInTable);
	}
	
	public String getVolumeInTable() throws Exception {
		return getText(verifyVolumeInTable);
	}
	
	public String getCaptainsRequestInTable() throws Exception {
		return getText(verifyCaptainsRequestInTable);
	}
	
	public String getContractIDInTable() throws Exception {
		return getText(verifyContractIDInTable);
	}
	
	public String getUnitL_UGLInTable() throws Exception {
		return getText(verifyUnitL_UGLInTable);
	}
	
	public boolean verifyEditButton() throws Exception {
		return isDisplayed(editButton);
	}
	
	public boolean verifyDeleteButton() throws Exception {
		return isDisplayed(deleteButton);
	}
	
	public void clickOnDeleteButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnDeleteButton);
		Thread.sleep(5000);
	}

	public void clickOnDeleteNoButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnDeleteNoButton);
		Thread.sleep(5000);
	}
	
	public void clickOnDeleteYesButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnDeleteYesButton);
		Thread.sleep(5000);
	}
	
	public void clickOnCancelUploadYesButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnCancelUploadYesButton);
		Thread.sleep(5000);
	}
	
	public void clickOnCancelUploadNoButton() throws Exception {
		Thread.sleep(5000);
		click(clickOnCancelUploadNoButton);
		Thread.sleep(5000);
	}
	
	public void clickOnCancelUploadButton() throws Exception {
		Thread.sleep(5000);
		click(cancelUploadButton);
		Thread.sleep(5000);
	}

	
	public void clickOnDeSelecrAllCheckBox() throws Exception {
		Thread.sleep(5000);
		click(selectOnDeSelecrAllCheckBox);
		Thread.sleep(5000);
	}

	public boolean verifyEditButtonEnable() throws Exception {
		return isEnabled(editButtonEnable);
	
	}
	
	public boolean verifyDeleteButtonEnable() throws Exception {
		return isEnabled(deleteButtonEnable);
	
	}
	
	public void clickOnOneCheckBox() throws Exception {
		Thread.sleep(5000);
		click(selectOnOneCheckBox);
		Thread.sleep(5000);
	}
	
	public void clickOnTwoCheckBox() throws Exception {
		Thread.sleep(5000);
		click(selectOnTwoCheckBox);
		Thread.sleep(5000);
	}
	
	public void clickOnEditButton() throws Exception {
		Thread.sleep(5000);
		click(selectOnEditButton);
		Thread.sleep(5000);
	}
	
	public void clickOnSaveButton() throws Exception {
		Thread.sleep(5000);
		click(selectOnSaveButton);
		Thread.sleep(5000);
	}
	
	public void clickOnCancelEditButton() throws Exception {
		Thread.sleep(5000);
		click(selectOnCancelEditButton);
		Thread.sleep(5000);
	}
	
	public boolean verifyDeleteButtonDisable() throws Exception {
		return isEnabled(deleteButtonDisable);
	}

		public void selectDayCalenderDate_Arrival(int d) throws Exception {
			click(dateofArrivalField);
			 click(nextMonthFlickerArrival);
			if (listInactiveDate.size() > 25) {
				click(nextMonthFlickerArrival);
				Thread.sleep(2000);
				String xp = "//div[@class='dayContainer']/span[text()='" + d + "']";
				driver.findElement(By.xpath(xp)).click();

			} else {

				Thread.sleep(2000);
				Calendar cal = Calendar.getInstance();
				cal.add(cal.DAY_OF_YEAR, d);
				SimpleDateFormat s = new SimpleDateFormat("d");
				String nextDay = s.format(cal.getTime());
				String xp = "//div[@class='dayContainer']/span[text()='" + nextDay
						+ "'][not(contains(@class, 'flatpickr-disabled'))]";
				driver.findElement(By.xpath(xp)).click();
			}
		}
		
		public void selectDayCalenderDate_Arrival1(int d) throws Exception {
			click(dateofArrivalField);
			 click(withinDayFlickerArrival);
			if (listInactiveDate.size() > 25) {
				click(nextMonthFlickerArrival);
				Thread.sleep(2000);
				String xp = "//div[@class='dayContainer']/span[text()='" + d + "']";
				driver.findElement(By.xpath(xp)).click();

			} else {

				Thread.sleep(2000);
				Calendar cal = Calendar.getInstance();
				cal.add(cal.DAY_OF_YEAR, d);
				SimpleDateFormat s = new SimpleDateFormat("d");
				String nextDay = s.format(cal.getTime());
				String xp = "//div[@class='dayContainer']/span[text()='" + nextDay
						+ "'][not(contains(@class, 'flatpickr-disabled'))]";
				driver.findElement(By.xpath(xp)).click();
			}
		}
		
		public void selectDayCalenderDate_Departure1(int d) throws Exception {
			click(dateofArrivalField);
		    click(withinDayFlickerArrival);
			Thread.sleep(1000);

			if (arrivalDateSelected.getText().equals("1")) {
				Thread.sleep(2000);
				click(nextMonthFlickerDeparture);
				waitForElementToBeVisible(nextMonthFlickerDeparture, 10);
				click(nextMonthFlickerDeparture);
				Thread.sleep(2000);
				String xp1 = "(//div[@class='dayContainer']/span[@class='flatpickr-day 'and text()='" + d + "'])[2]";
				Thread.sleep(1000);
				driver.findElement(By.xpath(xp1)).click();

			} else {
				Thread.sleep(2000);
				click(nextMonthFlickerDeparture);
				waitForElementToBeVisible(nextMonthFlickerDeparture, 10);
				click(nextMonthFlickerDeparture);
				Thread.sleep(2000);
				Calendar cal = Calendar.getInstance();
				cal.add(cal.DAY_OF_YEAR, d);
				SimpleDateFormat s = new SimpleDateFormat("d");
				String nextDays = s.format(cal.getTime());
				String xp1 = "(//div[@class='dayContainer']/span[@class='flatpickr-day 'and text()='" + nextDays + "'])[2]";
				Thread.sleep(2000);
				driver.findElement(By.xpath(xp1)).click();
			}
		}

		public void selectDayCalenderDate_Departure(int d) throws Exception {
			click(dateofArrivalField);
		    click(nextMonthFlickerArrival);
			Thread.sleep(1000);

			if (arrivalDateSelected.getText().equals("1")) {
				Thread.sleep(2000);
				click(nextMonthFlickerDeparture);
				waitForElementToBeVisible(nextMonthFlickerDeparture, 10);
				click(nextMonthFlickerDeparture);
				Thread.sleep(2000);
				String xp1 = "(//div[@class='dayContainer']/span[@class='flatpickr-day 'and text()='" + d + "'])[2]";
				Thread.sleep(1000);
				driver.findElement(By.xpath(xp1)).click();

			} else {
				Thread.sleep(2000);
				click(nextMonthFlickerDeparture);
				waitForElementToBeVisible(nextMonthFlickerDeparture, 10);
				click(nextMonthFlickerDeparture);
				Thread.sleep(2000);
				Calendar cal = Calendar.getInstance();
				cal.add(cal.DAY_OF_YEAR, d);
				SimpleDateFormat s = new SimpleDateFormat("d");
				String nextDays = s.format(cal.getTime());
				String xp1 = "(//div[@class='dayContainer']/span[@class='flatpickr-day 'and text()='" + nextDays + "'])[2]";
				Thread.sleep(2000);
				driver.findElement(By.xpath(xp1)).click();
			}
		}

		public void setUtcTime_Arrival(int val) throws Exception {
			click(btnUtcTime_Arrival);
			Thread.sleep(1000);
			listUtcTime_Arrival.get(val).click();
		}
		public void setUtcTime_Arrival1(int val) throws Exception {
			click(btnUtcTime_Arrival);
			Thread.sleep(1000);
			listUtcTime_Arrival.get(val).click();
		}
		
		public void setUtcTime_Departure2(int val) throws Exception {
			click(btnUtcTime_Departure);
			Thread.sleep(1000);
			listUtcTime_Departure.get(val).click();
		}
		
		public void setUtcTime_Departure(int val) throws Exception {
			click(btnUtcTime_Departure);
			Thread.sleep(1000);
			listUtcTime_Departure.get(val).click();
		}
	
		public void selectDayCalenderDate_Arrival2(int d) throws Exception {
			click(dateofArrivalField);
			Thread.sleep(1000);
			 click(withinDayFlickerArrival);
		}
		
		public void selectDayCalenderDate_Arrival3(int d) throws Exception {
			click(dateofArrivalField);
			Thread.sleep(1000);
			 click(nextDayFlickerArrival);
		}
		
		public void selectDayCalenderDate_Departure2(int d) throws Exception {
			click(dateofArrivalField);
			Thread.sleep(1000);
		    click(withinDayFlickerArrival);
		}
		
		public void selectDayCalenderDate_Departure3(int d) throws Exception {
			click(dateofDepartureField);
			Thread.sleep(1000);
		    click(nexDayFlickerDeparture);
		}
		
}