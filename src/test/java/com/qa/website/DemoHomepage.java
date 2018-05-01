package com.qa.website;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class DemoHomepage {

	static WebDriver driver = null;
	
	@BeforeClass
	public static void method() {
		System.setProperty("webdriver.chrome.driver","C:/Development/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void DressSearch() {
		driver.get("http://automationpractice.com/index.php");
		Homepage page = PageFactory.initElements(driver, Homepage.class);
		sleep(1);
		page.setDriver(driver);
		page.searchFor("Dress");
		sleep(1);
		SearchResultsPage dresses = PageFactory.initElements(driver, SearchResultsPage.class);
		dresses.setDriver(driver);
		dresses.addDress();
		sleep(1);
		dresses.confirmDress();
		CheckoutPage checkout = PageFactory.initElements(driver, CheckoutPage.class);
		checkout.setDriver(driver);
		checkout.changeQuantity(10);
		sleep(1);
		checkout.confirm();
		
		//WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span"));

		//assertEquals("Selenium", checkElement.getText());
		
	}

	@After
	public void tearDown() throws InterruptedException {

		Thread.sleep(30000);
		driver.close();

	}
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}