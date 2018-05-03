package com.qa.ddt;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.constants.Constants;
import com.qa.ddt.pages.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DDTReadFromFile {

	static WebDriver driver;
	static ExtentReports report;
	ExtentTest test;
	XSSFWorkbook workbook;
	static final String FILE_TEST_DATA = "testData.xlsx";
	static final String REPORT_FILE_NAME = "DDT.html";
	
	
	@BeforeClass
	public static void setUp() {
		System.setProperty(Constants.WEB_DRIVER, Constants.PATH_DRIVER);
		driver = new ChromeDriver();
		report = new ExtentReports(Constants.PATH_OUTPUT_DATA + REPORT_FILE_NAME);
	}

	@Test
	public void excelTest() {

		test = report.startTest("StartingTest");
		XSSFSheet sheet = getSheetAt(0);

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

			Cell username = sheet.getRow(i).getCell(0);
			Cell password = sheet.getRow(i).getCell(1);

			String user = username.getStringCellValue();
			String pass = password.getStringCellValue();
			
			System.out.println(user);
			System.out.println(pass);

			driver.get("http://asp.thedemosite.co.uk/");
			test.log(LogStatus.INFO, "navigate to demosite homepage");

			Homepage home = PageFactory.initElements(driver, Homepage.class);
			sleep(1);
			home.setDriver(driver);
			home.clickNewAccount();
			
			test.log(LogStatus.INFO, "inputting new user");
			
			NewAccountPage newPage = PageFactory.initElements(driver, NewAccountPage.class);
			sleep(1);
			newPage.setDriver(driver);
			newPage.inputUsername(user);
			newPage.inputPassword(pass);
			newPage.confirm();
			
			test.log(LogStatus.INFO, "navigate to login");
			newPage.clickLoginPage();
			
			sleep(1);
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			sleep(1);
			loginPage.setDriver(driver);
			loginPage.inputUsername(user);
			loginPage.inputPassword(pass);
			loginPage.confirm();

			test.log(LogStatus.INFO, "Saving login, testing if it exists");

			String title = loginPage.checkOutput();

			String expected = "**Successful Login**";
			assertEquals(expected, title);
			test.log(LogStatus.PASS, "Successfully created a user and logged in with it");

		}
	}

	@After //it throws the exception if it fails, but this never happens if there is no workbook
	public void tearDown() throws IOException {
		if(workbook != null) {
			workbook.close();
		}
		report.endTest(test);
		report.flush();
		driver.quit();

	}
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public XSSFSheet getSheetAt(int index) {
		try {
			FileInputStream file = new FileInputStream(Constants.PATH_TEST_DATA + FILE_TEST_DATA);
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		XSSFSheet sheet = workbook.getSheetAt(index);
		return sheet;
	}
	

}