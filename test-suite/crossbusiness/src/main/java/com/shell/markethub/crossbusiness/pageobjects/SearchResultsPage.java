package com.shell.markethub.crossbusiness.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends CrossBusinessBasePageObject{

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	String aemSearchTermDigitalData = "aemSearchTerm";
	String aemSearchResultDigitalData = "aemSearchCount";
	String aemSearchTypeDigitalData = "aemSearchType";

	@FindBy(xpath="//*[@id='searchLc']")
	WebElement searchLc;
	@FindBy(xpath="//*[@id='searchbox']")
	WebElement searchTerm;
	@FindBy(xpath="//*[@name='result']")
	WebElement result;
	
		 
	public String verifyAEMSearchTypeDigitalData()
	{
		 String value=searchLc.getAttribute("value");
		return  value;
	}
	public String verifyAEMSearchResultDigitalData()
	{   String value=result.getAttribute("value");
		return  value;
	}
	public String verifyAEMSearchTermDigitalData()
	{
		String value=searchTerm.getAttribute("value");
		return value;
	}
	public String getAEMSearchTermDigitalData() throws Exception {
		return getSatelliteData(aemSearchTermDigitalData); 
	}
	
	public String getAEMSearchResultDigitalData() throws Exception {
		return getSatelliteData(aemSearchResultDigitalData);
	}
	public String getAEMSearchTypeDigitalData() throws Exception {
		return getSatelliteData(aemSearchTypeDigitalData);
	}
}
