package com.qa.ddt;

import static org.junit.Assert.assertEquals;
import com.qa.constants.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.qa.utils.ExcelUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DDTReadAndWrite {

	WebDriver driver;
	ExtentReports report;
	ExtentTest testReport;
	static final String REPORT_FILE_NAME = "ExcelUtilsDemoTestReport.html";
	static final String FILE_TEST_DATA = "LoginData.xlsx";

	@BeforeClass
	public void setUp() throws Exception {
		//How to load the file into memory
		ExcelUtils.setExcelFile(Constants.PATH_TEST_DATA + FILE_TEST_DATA, 0);
		System.setProperty(Constants.WEB_DRIVER, Constants.PATH_DRIVER);
		driver = new ChromeDriver();
		report = new ExtentReports(Constants.PATH_OUTPUT_DATA + REPORT_FILE_NAME, true);

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		for (int i = 1; i < ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows(); i++) {

			testReport = report.startTest("Excel Data Test: " + i);

			testReport.log(LogStatus.INFO, "Opening Browser");

			sleep(1);

			driver.get(Constants.WEBSITE_URL);

			testReport.log(LogStatus.INFO, "Navigated to thedemosite.co.uk");

			testReport.log(LogStatus.INFO, "Set up Excel Utils path - Opened file stream");

			driver.get(Constants.REGISTER_URL);
			testReport.log(LogStatus.INFO, "Clicked on link to addUser page");
			WebElement addUser = driver.findElement(By.xpath(
					"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
			addUser.click();
			addUser.sendKeys(ExcelUtils.getCellData(i, 0));
			testReport.log(LogStatus.INFO, "Input Username");
			WebElement addPass = driver.findElement(By.xpath(
					"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
			addPass.click();
			addPass.sendKeys(ExcelUtils.getCellData(i, 1));
			testReport.log(LogStatus.INFO, "Input password");
			WebElement save = driver.findElement(By.xpath(
					"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
			save.click();
			testReport.log(LogStatus.INFO, "Created New User");

			driver.get(Constants.LOGIN_URL);
			testReport.log(LogStatus.INFO, "Navigated to login page");
			WebElement username = driver.findElement(By.xpath(
					"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
			username.click();
			username.sendKeys(ExcelUtils.getCellData(i, 0));
			testReport.log(LogStatus.INFO, "Input Username");
			WebElement password = driver.findElement(By.xpath(
					"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
			password.click();
			password.sendKeys(ExcelUtils.getCellData(i, 1));
			testReport.log(LogStatus.INFO, "Input password");
			WebElement loginButton = driver.findElement(By.xpath(
					"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
			loginButton.click();
			testReport.log(LogStatus.INFO, "Logged In");

			sleep(1);

			String title = driver
					.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"))
					.getText();
			String expected = "**Successful Login**";

			if (!title.equals(expected)) {
				testReport.log(LogStatus.FAIL, "Demo Site Login Test");
				report.endTest(testReport);
				report.flush();
				ExcelUtils.setCellData(FILE_TEST_DATA, "Fail", i, 2);
			}

			assertEquals(expected, title);

			ExcelUtils.setCellData(FILE_TEST_DATA, "Pass", i, 2);
			testReport.log(LogStatus.PASS, "Demo Site Login Test");

		}
		report.endTest(testReport);
		report.flush();
	}
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}