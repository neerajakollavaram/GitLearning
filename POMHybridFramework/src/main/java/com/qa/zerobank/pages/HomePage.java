package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(id="signin_button")
	WebElement signInButton;
	
	@FindBy(xpath="//strong[contains(text(),'Home')]")
	WebElement HOME;	
	
	@FindBy(id="feedback")
	WebElement FEEDBACK;
	
	@FindBy(className="brand")
	WebElement ZeroBank;
	
	@FindBy(css ="#signin_button")
	WebElement Signin;
	
	@FindBy(id="online-banking")
	WebElement MoreServices;
	WebElement brandLogo;
	
	@FindBy(xpath="//div[@class='top_offset']//a[1]")
    WebElement LinkAfterSearch;
    
    @FindBy(name="searchTerm")
    WebElement searchBox;
    
    @FindBy(xpath="//strong[contains(text(),'Online Banking')]")
	WebElement ONLINEBANKING;
    
    @FindBy(xpath = "//h2[contains(text(),'Search Results:')]")
	WebElement searchResults;

	@FindBy(partialLinkText = "Online Banking")
	WebElement OnlineBanking;

	@FindBy(partialLinkText = "Pay Bills")
	WebElement PayBills;


	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void assertHomePageTitle() {
		assertEquals(driver.getTitle(),"Zero - Personal Banking - Loans - Credit Cards","HomePage title as");
	}
	
	public boolean validateBandLogo() {
		return brandLogo.isDisplayed();
		
	}
	
	public LoginPage clickOnSignInButton() {
		signInButton.click();
		return new LoginPage();
	}
	public SearchResultsPage enterOnSearchBox(String searchData) {
		searchBox.click();
		searchBox.sendKeys(searchData);
		searchBox.sendKeys(Keys.ENTER);
		return new SearchResultsPage();
		}
	
	

    	
    
    	
    	
    	
    	
    	
    	
	
	
	
}
