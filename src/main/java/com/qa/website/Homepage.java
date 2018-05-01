package com.qa.website;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends PageParent {
	
	@FindBy(name = "search_query")
	private WebElement searchBox;
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	private WebElement tShirts;

	public void searchFor(String text) {
		
		searchBox.sendKeys(text);
		searchBox.submit();
	}
	
	public void findTshirts() {
		tShirts.click();
	}
	
	
}
