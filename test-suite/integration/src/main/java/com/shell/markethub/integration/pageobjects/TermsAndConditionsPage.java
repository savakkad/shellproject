package com.shell.markethub.integration.pageobjects;

import java.util.ArrayList;
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

public class TermsAndConditionsPage extends IntegrationBasePageObject {

	public TermsAndConditionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private static Logger logger = LogManager.getLogger(TermsAndConditionsPage.class);
	
	@FindBy(xpath = "(//*[@class=\"copy\"]//h1)[1]")
	WebElement termsAndConditionsTitle;
	@FindBy(xpath = "//*[@id=\"pageWrapper\"]/div/div/div/div[1]/section/div/div/p[2]")
	WebElement termsAndConditionsParagraphText;
	
	public String getTermsAndConditionsTitle() throws Exception {
		waitForElementToBeVisible(termsAndConditionsTitle, BaseDataConstants.IMPLICIT_TIMEOUT);
		return getText(termsAndConditionsTitle);
	}

	public String getTermsAndConditionsParagraphText() throws Exception {
		waitForElementToBeVisible(termsAndConditionsParagraphText, BaseDataConstants.IMPLICIT_TIMEOUT);
		return getText(termsAndConditionsParagraphText);
	}
}