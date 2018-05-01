package com.qa.website;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageParent{

	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
	private WebElement proceed;
	
	@FindBy(xpath = "//*[@id=\"product_5_19_0_0\"]/td[5]/input[2]")
	private WebElement quantityElement;

	
	public void changeQuantity(int quantity) {
		String numbers = Integer.toString(quantity);
		quantityElement.clear();
		//quantityElement.sendKeys(Keys.BACKSPACE);
		quantityElement.sendKeys(numbers);
	}
	
	public void confirm() {
		Actions actions = new Actions(driver);
		actions.moveToElement(proceed);
		actions.perform();
		proceed.click();
	}
}
