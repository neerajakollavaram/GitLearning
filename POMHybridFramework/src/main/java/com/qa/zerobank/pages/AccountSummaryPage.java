package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class AccountSummaryPage extends TestBase {
//object repository
	@FindBy(id="account_activity_tab") 
	WebElement account_activity_tab;
    @FindBy(id="transfer_funds_tab") 
    WebElement transfer_funds_tab;
    @FindBy(id="pay_bills_tab") 
    WebElement pay_bills_tab;
    @FindBy(id="money_map_tab") 
    WebElement money_map_tab;
    @FindBy(id="online_statements_tab") 
    WebElement online_statements_tab;

    // constructor
    public AccountSummaryPage() {
        PageFactory.initElements(driver, this);
    }

    // assert title
    public void assertSummaryPageTitle() {
        assertEquals(driver.getTitle(), "Zero - Account Summary");
    }
	
	
	
	
	
	
	
	
	
    }
	
	
	
	
	
