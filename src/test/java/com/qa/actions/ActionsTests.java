package com.qa.actions;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

public class ActionsTests {

	static WebDriver driver;
	static ExtentReports report;
	ExtentTest test;
	static final String REPORT_FILE_NAME = "DDT.html";
	
	
	@BeforeClass
	public static void setUp() {
		System.setProperty(Constants.WEB_DRIVER, Constants.PATH_DRIVER);
		driver = new ChromeDriver();
		report = new ExtentReports(Constants.PATH_OUTPUT_DATA + REPORT_FILE_NAME);
	}

	@Test
	public void registrationTest() {
		
		
		List<Integer> date = new ArrayList<Integer>();  
		List<Boolean> hobbies = new ArrayList<Boolean>();  
		/*hobbies.add(true);
		hobbies.add(false);
		hobbies.add(true);
		
		date.add(5);
		date.add(8);
		date.add(1987);*/
		

		test = report.startTest("StartingTest");

		//driver.get("http://demoqa.com/registration/");
		test.log(LogStatus.INFO, "navigate to registration page");

		RegistrationPage registration = PageFactory.initElements(driver, RegistrationPage.class);
		sleep(1);
		registration.setDriver(driver);
		driver.manage().window().maximize();
		driver.get(registration.getURL());
		//registration.lazyMethod();
		
		test.log(LogStatus.INFO, "Inputting names");
		registration.setFirstName(null);
		registration.setLastName(null);
		sleep(1);
		
		test.log(LogStatus.INFO, "Setting Hobbies and marital status");
		registration.setMaritalStatus(null);
		registration.setHobbies(hobbies);
		sleep(1);
		
		test.log(LogStatus.INFO, "Finding a Country");
		registration.setCountry(null);
		sleep(1);
		
		test.log(LogStatus.INFO, "Setting Date of Birth");
		registration.setDate(date);
		sleep(1);
		
		test.log(LogStatus.INFO, "Setting Phone Number and Username");
		registration.setPhoneNumber(null);
		registration.setUsername(null);
		sleep(1);
		
		test.log(LogStatus.INFO, "Setting Email and Profile Picture");
		registration.setEmail(null);
		registration.setPicture(null);
		sleep(1);
		
		test.log(LogStatus.INFO, "Setting Date of Birth");
		registration.setDescription(null);
		registration.setPassword(null);
		sleep(1);

		/*
		String title = loginPage.checkOutput();

		String expected = "**Successful Login**";
		assertEquals(expected, title);
		test.log(LogStatus.PASS, "Successfully created a user and logged in with it");
		 */
	}

	@After //it throws the exception if it fails, but this never happens if there is no workbook
	public void tearDown() throws IOException {
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

}