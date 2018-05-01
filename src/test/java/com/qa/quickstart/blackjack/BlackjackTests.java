package com.qa.quickstart.blackjack;


import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlackjackTests {
	
	private WebDriver driver;
	
	@Before
	public void setuo() {
		System.setProperty("webdriver.chrome.driver","C:/Development/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
        driver.quit();
    }
	
	@Test
	public void windowTest() {
		//driver.get("https://www.youtube.com/watch?v=tvTRZJ-4EyI");
		//WebElement search = driver.findElement(By.id("seach-input"));
	
		
		driver.get("https://www.google.co.uk");		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
		search.click();
		search.sendKeys("Kendrick Lamar - DNA");
		search.submit();
		driver.findElement(By.className("j0joJb")).click();
		//driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div[2]/h3/a")).click();
		try {
			Thread.sleep(22000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String time = driver.findElement(By.className("ytp-time-duration")).getText();
		//String time = driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[26]/div[2]/div[1]/div/span[3]")).getText();
		System.out.println(time);
		String[] time2 = time.split(":");
		try {
			Thread.sleep((Integer.valueOf(time2[0]))*60 + Integer.valueOf(time2[1]) * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	@Test
	public void testBlackJackFirst() {
		assertEquals("This was not the expected output", 21, Blackjack.blackjack(21, 15));
	}
	
	@Test
	public void testBlackJackSecond() {
		assertEquals("This was not the expected output", 20, Blackjack.blackjack(19, 20));
	}
	
	@Test
	public void testBlackJackEqual() {
		assertEquals("This was not the expected output", 19, Blackjack.blackjack(19, 19));
	}
	
	@Test //Don't need to test for negative numbers as the spec says that only numbers greater than 0 will be input
	public void testBlackJackOver() {
		assertEquals("This was not the expected output", 0, Blackjack.blackjack(22, 30));
	}
	
	@Test
	public void testUniqueSumFirst() {
		assertEquals("This was not the expected output", 6, Blackjack.uniqueSum(1, 2, 3));
	}
	
	@Test
	public void testUniqueSumSecond() {
		assertEquals("This was not the expected output", 6, Blackjack.uniqueSum(3, 1, 2));
	}
	
	@Test
	public void testUniqueSumThird() {
		assertEquals("This was not the expected output", 6, Blackjack.uniqueSum(2, 3, 1));
	}
	
	@Test
	public void testUniqueSumNone() {
		assertEquals("This was not the expected output", 0, Blackjack.uniqueSum(3, 3, 3));
	}
	
	@Test //You can have multiple assertEquals in one test, but they all have to pass, if one fails the whole test fails 
	public void testUniqueSumOne() {
		int[] numbers = {1, 3, 3};
		for(int i = 0; i < numbers.length; i++) {
			assertEquals("This was not the expected output", 1, Blackjack.uniqueSum(numbers[i%3], numbers[(i+1)%3], numbers[(i+2)%3]));
		}	
	}
	
	@Test
	public void testTooHotNormal1() {
		assertEquals("This was not the expected output", true, Blackjack.tooHot(70, false));
	}
	
	@Test
	public void testTooHotNormal2() {
		assertEquals("This was not the expected output", true, Blackjack.tooHot(70, true));
	}
	
	@Test
	public void testTooHotBelow() {
		assertEquals("This was not the expected output", false, Blackjack.tooHot(55, false));
	}
	
	@Test
	public void testTooHotAbove() {
		assertEquals("This was not the expected output", false, Blackjack.tooHot(95, false));
	}
	
	@Test
	public void testTooHotSummer() {
		assertEquals("This was not the expected output", true, Blackjack.tooHot(95, true));
	}
	
	@Test
	public void testTooHotSummerAbove() {
		assertEquals("This was not the expected output", false, Blackjack.tooHot(105, true));
	}	
 */
}
