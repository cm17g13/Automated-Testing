package com.qa.cucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends PageParent {

	@FindBy(xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span")
	private WebElement greenTea;
	
	
	public void clickGreenTea() {
		greenTea.click();
	}
	
	
}
