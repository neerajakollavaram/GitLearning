package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class SearchResultsPage extends TestBase{
	
	//constructor

			public SearchResultsPage() {

			PageFactory.initElements(driver, this);
			}

	
	
	//object repository

	@FindBy(xpath = "//h2[contains(text(),'Search Results:')]")
	WebElement searchResults;

	@FindBy(partialLinkText = "Online Banking")
	WebElement OnlineBanking;

	@FindBy(partialLinkText = "Pay Bills")
	WebElement PayBills;


	// @FindBy(xpath="//div[@class='top_offset']//a[1]")
	// WebElement NotFound;


		//assert title

		public void assertSearchResultsPageTitle() {
		assertEquals(driver.getTitle(), "Zero - Search Tips");
		}

		public OnlineBankingPage OnlineBankingPageLinkCLicked() {
		OnlineBanking.click();
		return new OnlineBankingPage();
		}

		public PayBillsPage PayBillsPageLinkClicked() {
		PayBills.click();
		return new PayBillsPage();
		}

		public void verifySearchResult() {
		if(OnlineBanking.isDisplayed()) {
		System.out.println("Result Found");
		OnlineBankingPageLinkCLicked();
		}else if(PayBills.isDisplayed()) {
		System.out.println("Result Found");
		PayBillsPageLinkClicked();
		}else
		System.out.println("Result not Found");

		}



		}


