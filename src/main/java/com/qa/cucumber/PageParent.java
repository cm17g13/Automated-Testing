package com.qa.cucumber;

import org.openqa.selenium.WebDriver;

public abstract class PageParent  {

	WebDriver driver;
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
}
