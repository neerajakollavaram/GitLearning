package com.qa.zerobank.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.zerobank.base.TestBase;

public class TestUtil extends TestBase {
	
	static JavascriptExecutor js;
	Connection con;
	
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + 
			"\\src\\test\\resources\\com\\qa\\zerobank\\testdata\\" +
			prop.getProperty("Testdata");
	
	static Workbook book;
	static Sheet sheet;
	
	public static void takeScreenshotAtEndOfTest(String pageName)throws IOException{
		
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
	String homeDir = System.getProperty("user.dir");
	try {
	FileUtils.copyFile(srcFile, new File(homeDir + "/screenshorts/" + pageName 
			+System.currentTimeMillis()+ ".png"));
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
	public void executeExeFile(String fileName) {

		try {

		Runtime.getRuntime().exec(fileName);
		//Example
		//Runtime.getRuntime().exec("C:\\SeleniumBrowserDrivers\\chromedriver.exe");


		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		}

		public void executeJavaScript(String jsQuery) {

		js = (JavascriptExecutor) driver;
		js.executeScript(jsQuery);

		//Examples
		//js.executeScript("document.getElementByID('element id').checked = false;");
		//js.executeScript("location.reload()");
		//js.executeScript("document.getElementByID('element id').value = 'xyz';");

		}

		//open database connection
		public Connection createDBConnection() throws ClassNotFoundException, SQLException {

		//load driver jar class
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("MySQL Connection Driver loaded");

		//Create connection
		con = DriverManager.getConnection(
		"jdbc:mysql://" +
		prop.getProperty("dbhost") +
		":" + prop.getProperty("port") +
		"/" + prop.getProperty("dbname"),
		prop.getProperty("dbuser"),
		prop.getProperty("dbpassword")
		);
		//like
		//con = DriverManager.getConnection("jdbc:mysql://dbhost:port/dbname", dbuser, dbpassword);

		System.out.println("Connected to MySQL DB");


		return con;
		}


		//process query
		public ResultSet executeDBQuery(Connection con , String query) throws SQLException {

		//create statement
		Statement smt = con.createStatement();

		//execute query
		ResultSet rs = smt.executeQuery(query);
		System.out.println(rs);

		return rs;

		//run through each row of result for a column
		//while(rs.next())
		//{
		// String cityname = rs.getString("Name");
		// system.out.println("city name is" + cityname);
		//}
		}


		//close database connection

		public void closeConnection(Connection con) throws SQLException {
		con.close();
		}
		
		public static Object[][] getTestData(String sheetName) {

	        FileInputStream file = null;

	        try {
	            file = new FileInputStream(TESTDATA_SHEET_PATH);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }

	        try {
	            book = WorkbookFactory.create(file);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        sheet = book.getSheet(sheetName);

	        int rowcount = sheet.getLastRowNum();
	        int columnCount = sheet.getRow(0).getLastCellNum();

	        Object[][] data = new Object[rowcount][columnCount];
	        // System.out.println(sheet.getLastRowNum() + "--------" +
	        // sheet.getRow(0).getLastCellNum());

	        for (int i = 0; i < rowcount; i++) {
	            for (int k = 0; k < columnCount; k++) {
	                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
	                // System.out.println(data[i][k]);
	            }
	        }
	        return data;
	    }
	

}
