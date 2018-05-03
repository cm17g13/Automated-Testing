package com.qa.ddt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAccountPage extends PageParent{

	@FindBy(xpath = "/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[1]/td[2]/input")
	private WebElement username;
	
	@FindBy(xpath = "/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[2]/td[2]/input")
	private WebElement password;
	
	@FindBy(xpath = "/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[3]/td[2]/input")
	private WebElement confirm;

	@FindBy(xpath= "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/small/strong/a[4]")
	private WebElement login;
	
	public void inputUsername(String name) {
		
		username.sendKeys(name);
	}
	
	public void inputPassword(String pass) {
		
		password.sendKeys(pass);
	}
	
	public void confirm() {
		
		confirm.click();
	}
	
	public void clickLoginPage() {
		
		login.click();
	}
	
	
	
}
