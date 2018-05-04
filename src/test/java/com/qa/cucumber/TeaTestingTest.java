package com.qa.cucumber;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.constants.Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.*;
import cucumber.api.java.en.*;
import org.junit.Assert;

public class TeaTestingTest {

	
	WebDriver driver;
	ExtentReports report;
	ExtentTest testReport;
	String url;

	@Before
	public void setup() {
		//ExcelUtils.setExcelFile(Constants.PATH_TEST_DATA + FILE_TEST_DATA, 0);
		System.setProperty(Constants.WEB_DRIVER, Constants.PATH_DRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}


	@Given("^the correct web address \"([^\"]*)\"$")
	public void the_correct_web_address(String webAddress) {
	   driver.get(webAddress);
	}
	
	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page()  {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.setDriver(driver);
		home.clickMenuButton();
	}
	
	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
	    Assert.assertEquals(true, driver.getPageSource().contains("Check Out"));
	}

	
	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
	    MenuPage menu = PageFactory.initElements(driver, MenuPage.class);
	    menu.setDriver(driver);
	    menu.clickGreenTea();
	}
	
	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
	   Assert.assertEquals(driver.getCurrentUrl(), "http://www.practiceselenium.com/check-out.html");
	   
	}


}
