package com.qa.ddt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends PageParent {

	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span")
	private WebElement addToCart;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	private WebElement confirmDress;
	
	public void addDress() {
		addToCart.click();
	}
	
	public void confirmDress() {
		confirmDress.click();
	}
	
}
