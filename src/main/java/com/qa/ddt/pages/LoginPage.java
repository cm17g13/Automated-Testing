package com.qa.ddt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageParent{

	@FindBy(xpath = "/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[1]/td[2]/input")
	private WebElement username;
	
	@FindBy(xpath = "/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[2]/td[2]/input")
	private WebElement password;
	
	@FindBy(xpath = "/html/body/form/div[1]/center/table/tbody/tr/td/div/center/table/tbody/tr[3]/td[2]/input")
	private WebElement confirm;
	
	@FindBy(xpath = "/html/body/big/blockquote/blockquote/div/h2/font/center/b")
	private WebElement check;
	public void inputUsername(String name) {
		
		username.sendKeys(name);
	}
	
	public void inputPassword(String pass) {
		
		password.sendKeys(pass);
	}
	
	public void confirm() {
		
		confirm.click();
	}
	
	public String checkOutput() {
		
		return check.getText();
		
	}
	
}
