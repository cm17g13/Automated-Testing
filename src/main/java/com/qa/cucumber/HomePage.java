package com.qa.cucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageParent {
	
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	private WebElement menuButton;

	
	public void clickMenuButton() {
		menuButton.click();
	}
	
	
}
