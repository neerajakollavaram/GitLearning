package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class LoginPage extends TestBase{
	
	//Object repository
	
	@FindBy(id = "user_login")
	WebElement lusername;

	@FindBy(name = "user_password")
	WebElement lpassword;

	@FindBy(css = ".icon-question-sign")
	WebElement questionmark;

	@FindBy(css = "[name='user_remember_me]")
	WebElement signincheckbox;

	@FindBy(name = "submit")
	WebElement signinbutton;

	@FindBy(linkText = "Forgot your password")
	WebElement forgotpassword;

	@FindBy(id = "details-button")
	WebElement detailsbutton;

	@FindBy(linkText = "Proceed to zero.webappsecurity.com (unsafe)")
	WebElement proceedtolink;
	
	//Initializing the page objects

	public LoginPage() {
		PageFactory.initElements(driver,this );
	}
	public void assertLoginPageTitle() {
		assertEquals(driver.getTitle(),"Zero - Log in");
	}
	
	public AccountSummaryPage login() {
		lusername.sendKeys(prop.getProperty("username"));
		lpassword.sendKeys(prop.getProperty("password"));
		signinbutton.click();
		detailsbutton.click();
		proceedtolink.click();
		
		return new AccountSummaryPage();
	}

}
