package com.qa.ddt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends PageParent {
	
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/small/strong/a[3]")
	private WebElement newAccount;

	
	public void clickNewAccount() {
		newAccount.click();
	}
	
	
}
