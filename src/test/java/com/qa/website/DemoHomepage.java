package com.qa.website;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoHomepage {

	static WebDriver driver = null;
	private static ExtentReports report;
	private ExtentTest dressTest;
		
	
	@BeforeClass
	public static void method() {
		report = new ExtentReports("C:/Users/Admin/eclipse-workspace/SeleniumExamples/Reporting/target/BasicReport.html", true);
		System.setProperty("webdriver.chrome.driver","C:/Development/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void DressSearch() {
		dressTest = report.startTest("Verify application Title");
		driver.get("http://automationpractice.com/index.php");
		dressTest.log(LogStatus.INFO, "Browser started");
		Homepage page = PageFactory.initElements(driver, Homepage.class);
		sleep(1);
		checkTitle(dressTest, "My Store");
		page.setDriver(driver);
		page.searchFor("Dress");
		dressTest.log(LogStatus.INFO, "Dresses searched");
		sleep(1);
		SearchResultsPage dresses = PageFactory.initElements(driver, SearchResultsPage.class);
		checkTitle(dressTest, "Search - My Store");
		dresses.setDriver(driver);
		dresses.addDress();
		dressTest.log(LogStatus.INFO, "Dresses found");
		sleep(1);
		dresses.confirmDress();
		CheckoutPage checkout = PageFactory.initElements(driver, CheckoutPage.class);
		checkTitle(dressTest, "Order - My Store");
		checkout.setDriver(driver);
		checkout.changeQuantity(10);
		dressTest.log(LogStatus.INFO, "Increased dress quantity");
		sleep(1);
		checkout.confirm();		
	}
	

	@After
	public void tearDown()  {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		report.endTest(dressTest);
		report.flush();
		driver.close();
	}
	
	public void checkTitle(ExtentTest test, String expectedTitle) {

		if (driver.getTitle().equals(expectedTitle)) {
			// report the test as a pass
			test.log(LogStatus.PASS, "verify Title of the page");
		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
		}
	}
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}