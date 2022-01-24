package com.qa.zerobank.testcases;

import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.AccountSummaryPage;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LoginPage;
import com.qa.zerobank.util.TestUtil;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class LoginPageTestcases extends TestBase {
	
	HomePage homepage;
	LoginPage loginPage;
	AccountSummaryPage accountSummaryPage;
	TestUtil testUtil;
	
	public LoginPageTestcases() {
		super();
	}
	
 
  @BeforeMethod
  public void beforeMethod() {
	  initialization();
	  homepage = new HomePage();
	  loginPage = new LoginPage();
	  accountSummaryPage = new AccountSummaryPage();
	  testUtil = new TestUtil();
  }

  @AfterMethod
  public void afterMethod() throws IOException {
	  testUtil.takeScreenshotAtEndOfTest("LogInPage");
	  driver.close();
	  driver.quit();
  }
  @Test
  public void validatLogInPage() {
	  loginPage = homepage.clickOnSignInButton();
	  loginPage.assertLoginPageTitle();
	  
  }
  
  @Test
  public void validateLogInFunctionality() {
	  loginPage = homepage.clickOnSignInButton();
	  accountSummaryPage = loginPage.login();
	  accountSummaryPage.assertSummaryPageTitle();
	  
	  
  }

}
