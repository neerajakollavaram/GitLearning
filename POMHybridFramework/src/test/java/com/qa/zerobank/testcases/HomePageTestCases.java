package com.qa.zerobank.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LoginPage;
import com.qa.zerobank.pages.SearchResultsPage;
import com.qa.zerobank.util.TestUtil;


public class HomePageTestCases extends TestBase {
	
	HomePage homepage;
	LoginPage loginPage;
	TestUtil testUtil;
	SearchResultsPage searchResultsPage;
	
	String sheetName = "SearchOptions";
	public HomePageTestCases(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
	}
	@AfterMethod
	public void cleanUp() throws IOException {
		TestUtil.takeScreenshotAtEndOfTest("HomePage");
		driver.close();
		driver.quit();
	}
	
	@Test
	public void validateHomePage() {
		homepage.assertHomePageTitle();
	}
	@Test
	public void validateLogo() {
		assertTrue(homepage.validateBandLogo());
	}
	@Test
	public void signInButtonTest() {
		loginPage  = homepage.clickOnSignInButton();
		loginPage.assertLoginPageTitle();
		
	}
//	@Test
//	 public ResultSet executeDBQuery(Connection con, String query) throws SQLException{           
//         //create statement
//         Statement smt = con.createStatement();           
//         //execute query
//         ResultSet rs = smt.executeQuery(query);
//         System.out.println(rs);
//         return rs;   
//     }
	//@Test
//    public void dbConnectionTest() throws SQLException, ClassNotFoundException {
//
//        Connection testcon = testUtil.createDBConnection();
//        ResultSet results = testUtil.executeDBQuery(testcon, "select * from student");
//
//        //run through each row of result for a column
//        while(results.next()) {
//            String studentname = results.getString("Name");
//            System.out.println("Student name is " + studentname);
//        }
//        testUtil.closeConnection(testcon);
//        
//        }     
        
//        @DataProvider
//        public Object[][] getSearchData(){
//        Object data[][] = TestUtil.getTestData(sheetName);
//        return data;
   //     }

//        @Test(dataProvider = "getSearchData")
//        public void validateSearchField(String searchText) {
//
//        searchResultsPage = homepage.enterOnSearchBox(searchText);
//        searchResultsPage.assertSearchResultsPageTitle();
//        searchResultsPage.verifySearchResult();
//        }
        @Test
        public void searchBoxTest() {
        searchResultsPage = homepage.enterOnSearchBox("Online Banking");
        searchResultsPage.assertSearchResultsPageTitle();
        searchResultsPage.verifySearchResult();
        }
        
        
	}

