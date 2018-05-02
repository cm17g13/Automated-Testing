package com.qa.tdd;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.constants.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DDTReadFromFile {

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	XSSFWorkbook workbook;
	static final String FILE_TEST_DATA = "testData.xlsx";
	static final String REPORT_FILE_NAME = "DDT.html";
	
	
	@Before
	public void setUp() {
		System.setProperty(Constants.WEB_DRIVER, Constants.PATH_DRIVER);
		driver = new ChromeDriver();
		report = new ExtentReports(Constants.PATH_OUTPUT_DATA + REPORT_FILE_NAME);
		test = report.startTest("StartingTest");
	}

	@Test
	public void excelTest() {

		XSSFSheet sheet = getSheet();

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

			Cell username = sheet.getRow(i).getCell(0);
			Cell password = sheet.getRow(i).getCell(1);

			String user = username.getStringCellValue();
			String pass = password.getStringCellValue();

			driver.get("http://asp.thedemosite.co.uk/");
			test.log(LogStatus.INFO, "navigate to demosite homepage");

			test.log(LogStatus.INFO, "inputting new username");

			driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/small/strong/a[3]")).click();
			sleep(1);
			//driver.findElement(By.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/input")).click();
			driver.findElement(By.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/input")).sendKeys(user);

			test.log(LogStatus.INFO, "inputting new password");

			//driver.findElement(By.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/input")).click();
			driver.findElement(By.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/input")).sendKeys(pass);

			test.log(LogStatus.INFO, "Saving new user");

			driver.findElement(By.xpath("/html/body/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/input")).click();

			test.log(LogStatus.INFO, "navigate to login");

			driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/small/strong/a[4]")).click();
			sleep(1);

			test.log(LogStatus.INFO, "Entering username on login screen");

			//driver.findElement(By.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[1]/td[2]/input")).click();
			driver.findElement(By.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[1]/td[2]/input")).sendKeys(user);

			test.log(LogStatus.INFO, "Entering password in login screen");

			//driver.findElement(By.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[2]/td[2]/input")).click();
			driver.findElement(By.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[2]/td[2]/input")).sendKeys(pass);

			test.log(LogStatus.INFO, "Saving login, testing if it exists");

			driver.findElement(By.xpath("/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[3]/td[2]/input")).click();

			String title = driver.findElement(By.xpath("/html/body/big/blockquote/blockquote/div/h2/font/center/b")).getText();

			String expected = "**Successful Login**";
			assertEquals(expected, title);
			test.log(LogStatus.PASS, "Successfully created a user and logged in with it");

			sleep(1);

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
	
	public XSSFSheet getSheet() {
		FileInputStream file;
		try {
			file = new FileInputStream(Constants.PATH_TEST_DATA + FILE_TEST_DATA);
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		return sheet;
	}
	

}