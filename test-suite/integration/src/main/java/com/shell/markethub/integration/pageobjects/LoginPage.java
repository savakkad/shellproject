package com.shell.markethub.integration.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static io.qameta.allure.Allure.step;
import com.shell.markethub.base.util.config.BaseDataConstants;
/**
 * 
 * @author N.Kumar8@shell.com
 * @description Page object for Loginpage
 *
 */
public class LoginPage extends IntegrationBasePageObject {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private static Logger logger = LogManager.getLogger(LoginPage.class);
	@FindBy(xpath = "//input[@name='userId']")
	WebElement userNameEditBox;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordEditBox;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement loginButton;

	@FindBy(xpath = "//select[@id='language']")
	WebElement countryLanguage;

	@FindBy(xpath = "//div[@class='columns']//img")
	WebElement shellImage;
	@FindBy(xpath = "(//form[@id='loginForm']//label[@class='label'])[1]")
	WebElement userNameLabel;

	@FindBy(xpath = "(//form[@id='loginForm']//label[@class='label'])[2]")
	WebElement passwordLabel;

	@FindBy(xpath = "//label[@for='rememberMe']/../input")
	WebElement rememberCheckBox;

	@FindBy(xpath = "//img[@id='authorImgPath']")
	WebElement shellcarImage;

	@FindBy(xpath = "//a[@id='forgot-username-link']")
	WebElement forgetUserNameLink;

	@FindBy(xpath = "//a[@id='forgot-password-link']")
	WebElement forgetPasswordLink;

	@FindBy(xpath = "//div[@class='tagline-text']")
	WebElement tagLine;
	@FindBy(xpath = "//a[@id='video-mh']")
	WebElement videoLink;
	@FindBy(xpath = "//a[@id='link-mh']")
	WebElement gettingStartedLink;
	@FindBy(xpath = "//a[@id='help-modal-link']")
	WebElement contactHelpLink;

	@FindBy(xpath = "//input[@id='userId']")
	WebElement userNameInputBox;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordInputBox;

	String loginPageDigitalData = "page.name";
	String sectionDigitalData = "page.section";
	String languageDigitalData = "page.language";
	String statusDigitalData = "user.status";

	@FindBy(xpath = "//label[@id='userId-error']")
	WebElement userFieldErrorMessage;
	@FindBy(xpath = "//label[@id='password-error']")
	WebElement passwordFieldErrorMessage;
	@FindBy(xpath = "//input[@id='rememberMe']")
	WebElement rememberMe;
	@FindBy(xpath = "//label[contains(text(),'Email address')]")
	WebElement emailAdrress;
	@FindBy(xpath = "//button[@id='forgotUsername']")
	WebElement forgetUserNameSubmitButton;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailInputBox;

	@FindBy(xpath = "//label[@id='email-error']")
	WebElement emailMandatoryMessage;

	@FindBy(xpath = "//form[@id='forgotUsernameForm']//a[@class='loginPage-link'][contains(text(),'Continue to Login')]")
	WebElement continueToLoginLink;

	@FindBy(xpath = "//p[contains(text(),'To receive your username, please enter the email a')]")
	WebElement rsetmandatoryText;
	@FindBy(xpath = "(//div[@class='column is-4']/p)[2]")
	WebElement resetusermandatoryText;
	@FindBy(xpath = "//form[@id='forgotPasswordForm']//label[@class='label'][contains(text(),'Username')]")
	WebElement resetuserNameLabel;

	@FindBy(xpath = "//input[@id='username']")
	WebElement resetUserNameInputBox;
	@FindBy(xpath = "//button[@id='forgotPassword']")
	WebElement resetPasswordSubmitButton;

	@FindBy(xpath = "//label[@id='username-error']")
	WebElement resetPasswordError;
	@FindBy(xpath = "//form[@id='forgotPasswordForm']//a[@class='loginPage-link'][contains(text(),'Continue to Login')]")
	WebElement resetContinueToLoginLink;
	@FindBy(xpath = "//div[@class='conAlign']/div/h4")
	WebElement wrongEmailIdErrorMessage;
	@FindBy(xpath = "//a[@class='tertiaryLink']")
	WebElement errorMessagePageContinueLink;

	@FindBy(xpath = "//p[@class='red errorMessageLogIn']/span")
	WebElement invalidCredentialErrorMessage;
	@FindBy(xpath = "//span[contains(text(),'We were unable to log you in successfully, please contact your Superuser or the Customer Service Centre.')]")
	WebElement deactivatedUser;
	
	@FindBy(xpath = "//*[@id=\"otp\"]")
	WebElement enterotp;
	
	public String verifyDeactivatedInternalUser() throws Exception {
		return getText(deactivatedUser);
	}
	public String verifyInvalideCredentialsErrorMessages() throws Exception {
		return getText(invalidCredentialErrorMessage);
	}

	public void clickOnErrorMessagePageContinueToLoginLink() throws Exception {
		click(errorMessagePageContinueLink);
	}

	public String verifyWrongEmailIdErrorMessage() throws Exception {
		return getText(wrongEmailIdErrorMessage);
	}

	public void clickOnResetPasswordContinueToLoginLink() throws Exception {
		click(resetContinueToLoginLink);
	}

	public boolean verifyResetPasswordContinueToLoginLink() throws Exception {
		return isDisplayed(resetContinueToLoginLink);
	}

	public String verifyrestPasswordErrorMessage() throws Exception {
		return getText(resetPasswordError);
	}

	public void clickOnPasswordResetSubmit() throws Exception {
		click(resetPasswordSubmitButton);
	}

	public void enterResetUserNameInputBox(String userName) throws Exception {
		sendKeys(resetUserNameInputBox, userName);
	}
	
	public void enterotp(String otp) throws Exception {
		sendKeys(enterotp, otp);
	}
	
	

	public String verifyrestUserNameLabel() throws Exception {
		return getText(resetuserNameLabel);
	}

	public String verifyUserNameMandatoryText() throws Exception {
		return getText(resetusermandatoryText);
	}

	public String verifyEmailAddressMandatoryText() throws Exception {
		return getText(rsetmandatoryText);
	}

	public void clickContinueToLoginLink() throws Exception {
		click(continueToLoginLink);
	}

	public boolean verifyContinueToLoginLink() throws Exception {
		return isDisplayed(continueToLoginLink);
	}

	public void enterEmailAddress(String emailId) throws Exception {
		sendKeys(emailInputBox, emailId);
	}

	public String verifyEmailAddressMandatoryMessage() throws Exception {
		return getText(emailMandatoryMessage);
	}

	public boolean verifyEmailInpuBox() throws Exception {
		return isDisplayed(emailInputBox);
	}

	public void clickOnForgetUserNameSubmitButton() throws Exception {
		click(forgetUserNameSubmitButton);
	}

	public String verifyEmailAddressLable() throws Exception {
		return getText(emailAdrress);
	}

	public void clickOnRememberMeCheckBox() throws Exception {
		click(rememberMe);
	}

	public String verifyPasswordInputFieldMandatoryErrorMessage() throws Exception {
		return getText(passwordFieldErrorMessage);
	}

	public String verifyUserInputFieldMandatoryErrorMessage() throws Exception {
		return getText(userFieldErrorMessage);
	}

	public boolean verifyPasswordInpuBox() throws Exception {
		return isDisplayed(passwordInputBox);
	}

	public boolean verifyUserNameInpuBox() throws Exception {
		return isDisplayed(userNameInputBox);
	}

	public boolean verifyShellContactLink() throws Exception {
		return isDisplayed(contactHelpLink);
	}

	public boolean verifyShellMarketHubLink() throws Exception {
		return isDisplayed(gettingStartedLink);
	}

	public boolean verifyShellVideoLink() throws Exception {
		return isDisplayed(videoLink);
	}

	public String verifyTagLine() {
		waitForElementToBeVisible(tagLine, 200);
		return getText(tagLine);
	}

	public void clickOnForgetPassWordLink() throws Exception {
		waitForElementToBeVisible(forgetPasswordLink, 100);
		click(forgetPasswordLink);
	}

	public String verifyForgetPassWordLink() {
		return getText(forgetPasswordLink);
	}

	public void clickOnForgetUserNameLink() throws Exception {
		click(forgetUserNameLink);
	}

	public String verifyForgetUserNameLink() {
		return getText(forgetUserNameLink);
	}

	public boolean verifyShellCarImage() throws Exception {
		return isDisplayed(shellcarImage);
	}

	public void clickOnLogInButton() throws Exception {
		click(loginButton);
	}

	public String verifyLoginInnerText() throws Exception {
		return getText(loginButton);
	}

	public boolean verifyLoginButton() throws Exception {
		return isDisplayed(loginButton);
	}

	public boolean verifyRememberCheckBox() throws Exception {
		return isDisplayed(rememberCheckBox);
	}

	public boolean verifyPassWordInputBox() throws Exception {
		return isDisplayed(passwordEditBox);
	}

	public boolean verifyUserNameInputBox() throws Exception {
		return isDisplayed(userNameEditBox);
	}

	public String verifyLoginPasswordLabel() {
		return getText(passwordLabel);
	}

	public String verifyLoginUserNameLabel() {

		return getText(userNameLabel);
	}

	public boolean verifyShellMarketHubTitle() throws Exception {
		return isDisplayed(shellImage);
	}

	public void selectCountryLanguage(String countryIndex) {
		selectVisibleText(countryLanguage, countryIndex);
	}

	
	public String  getUserName() throws Exception {
		String usrName=userNameEditBox.getAttribute("value");
		System.out.println(usrName);
		return  usrName;
	}
	public void enterUserName(String userName) throws Exception {
		try {
			waitForElementToBeVisible(userNameEditBox, BaseDataConstants.EXPLICIT_TIMEOUT);
			sendKeys(userNameEditBox, userName);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clearPasswordField() throws Exception {
		passwordEditBox.clear();
	}

	public void enterPassword(String password) throws Exception {
		try {
			waitForElementToBeVisible(passwordEditBox, BaseDataConstants.EXPLICIT_TIMEOUT);
			sendKeys(passwordEditBox, password);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnLogin() throws Exception {
		try {
			Thread.sleep(2000);
			waitForClickableElement(BaseDataConstants.EXPLICIT_TIMEOUT, loginButton);
			click(loginButton);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//@Step("Login into markethub using {userName} and {password}")
	public void loginMarketHub(String userName, String password) throws Exception {
		enterUserName(userName);
		enterPassword(password);
		clickOnLogin();
		writeDTMUserConfigurations(getDTMObject(), userName);
		step("Login into markethub using {userName} and {password}");
	}

	//@Step("Navigate to {URL}")
	public void getMarketHubHomePage(String URL) throws Exception {
		getURL(URL);
		step("Navigate to "+URL);
	}

	public String getDTMObject() throws Exception {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		String script = "return JSON.stringify({page:digitalData.page, user:digitalData.user}, null, 4)";
		return (String) javascriptExecutor.executeScript(script);
	}

	public String verifyLoginPageDigitalData() throws Exception {
		return getDigitalData(loginPageDigitalData);
	}

	public String verifySectionDigitalData() throws Exception {
		return getDigitalData(sectionDigitalData);
	}

	public String verifyLanguageDigitalData() throws Exception {
		return getDigitalData(languageDigitalData);
	}

	public String verifyStatusDigitalData() throws Exception {
		return getDigitalData(statusDigitalData);
	}
	
}