package com.shell.markethub.crossbusiness.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SectorsPage extends CrossBusinessBasePageObject {

	public SectorsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

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
	String LOBDigitalData ="user.lineOfBusiness";
	String operationUnitDigitalData = "user.operationUnit";
	
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
}
