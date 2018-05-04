package com.qa.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage extends PageParent {

	private String url = "http://demoqa.com/registration/";
	
	@FindBy(id = "name_3_firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "name_3_lastname")
	private WebElement lastNameField;
	
	@FindBy(name = "radio_4[]")
	private List<WebElement> maritalStatus;
	
	@FindBy(name = "checkbox_5[]")
	private List<WebElement> hobbies;
	
	@FindBy(id = "dropdown_7")
	private WebElement countries;
	
	@FindBy(xpath = "//*[contains(@id, 'date_8')]")
	private List<WebElement> dates;
	
	@FindBy(id = "phone_9")
	private WebElement phoneNumber;
	
	@FindBy(id = "username")
	private WebElement usernameField;
	
	@FindBy(id = "email_1")
	private WebElement emailField;
	
	@FindBy(id = "profile_pic_10")
	private WebElement pictureField;
	
	@FindBy(id = "description")
	private WebElement descriptionField;
	
	@FindBy(id = "password_2") 
	private WebElement firstPassword;
	
	@FindBy(id = "confirm_password_password_2") 
	private WebElement secondPassword;
	
	
	Random rand = new Random();
	
	public void setFirstName(String firstName) {
		String newFirstName;
		if(firstName == null) {
			newFirstName = RandomStringUtils.randomAlphabetic(10);
		} else {
			newFirstName = firstName;
		}
		firstNameField.sendKeys(newFirstName);
	}
	
	public void setLastName(String lastName) {
		String newLastName;
		if(lastName == null) {
			newLastName = RandomStringUtils.randomAlphabetic(10);
		} else {
			newLastName = lastName;
		}
		lastNameField.sendKeys(newLastName);
	}
	
	public void setMaritalStatus(Integer button) {
		if(button == null) {
			maritalStatus.get(rand.nextInt(3)).click();
		} else {
			if(button < 3 && button >= 0) {
				maritalStatus.get(button).click();
			}
		}
	}
	
	public void setHobbies(List<Boolean> boxes) {
		for(int i = 0; i < hobbies.size(); i++) {
			
			if(boxes.size() <= i) {
				if(rand.nextBoolean()) {
					hobbies.get(i).click();
				}
			} else {
				boolean box = boxes.get(i);
				if(box) {
					hobbies.get(i).click();
				}
			}
		}
	}
	
	public void setCountry(String name) {
		Select selectBox = new Select(countries);
		if(name == null) {
			int optionSize = selectBox.getOptions().size();
			selectBox.selectByIndex((rand.nextInt(optionSize)));
			
			/*Actions actions = new Actions(driver);
			actions.click(countries);
			actions.moveToElement(countries, 230, 70);
			//actions.moveByOffset(60, -15);
			actions.click();
			actions.moveByOffset(0, rand.nextInt(250));
			actions.release();
			actions.moveByOffset(-230, 0);
			actions.click();
			actions.perform();*/
		} else {
			selectBox.selectByValue(name);
		}
	}
	
	public void setDate(List<Integer> dateList) {
		for(int i = 0; i < dates.size(); i++) {
			if(dateList.size() <= i) {
				int value = 0;
				if(i == 0) {
					value = rand.nextInt(12) + 1;
				} else if(i == 1) {
					value = rand.nextInt(28) + 1; //i could make this check the month but....
				} else {
					value = rand.nextInt(65) + 1950;
				}
				dates.get(i).sendKeys(Integer.toString(value));
			} else {
				dates.get(i).sendKeys(Integer.toString(dateList.get(i)));
			}
		}
	}
	
	public void setPhoneNumber(Integer number) {
		String newNumber = "";
		if(number == null) {
			for(int i = 0; i < 11; i ++) {
				newNumber = newNumber + Integer.toString(rand.nextInt(10));
			}
		} else {
			newNumber = Integer.toString(number);
		}
		phoneNumber.sendKeys(newNumber);
	}
	
	public void setUsername(String name) {
		String username;
		if(name == null) {
			username = RandomStringUtils.randomAlphabetic(10);
		} else {
			username = name;
		}
		usernameField.sendKeys(username);
	}
	
	public void setEmail(String email) {
		String newEmail;
		if(email == null) {
			newEmail = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
		} else {
			newEmail = email;
		}
		emailField.sendKeys(newEmail);
	}
	
	public void setPicture(String path) {
		String newPath;
		if(path == null) {
			newPath = "C:\\Users\\Admin\\Pictures\\HuskyChad.jpeg";
		} else {
			newPath = path;
		}
		pictureField.sendKeys(newPath);
	}
	
	public void setDescription(String description) {
		String newDescription;
		if(description == null) {
			newDescription = RandomStringUtils.randomAlphabetic(10) + ", And stuff.";
		} else {
			newDescription = description;
		}
		descriptionField.sendKeys(newDescription);
	}
	
	public void setPassword(String password) {
		String newPassword;
		if(password == null) {
			newPassword = RandomStringUtils.randomAlphabetic(8);
		} else {
			newPassword = password;
		}
		firstPassword.sendKeys(newPassword);
		secondPassword.sendKeys(newPassword);
	}
	
	public String getURL() {
		return url;
	}
	
	public void lazyMethod() {
		List<Integer> date = new ArrayList<Integer>();  
		List<Boolean> hobbies = new ArrayList<Boolean>();  
		/*hobbies.add(true);
		hobbies.add(false);
		hobbies.add(true);
		
		date.add(5);
		date.add(8);
		date.add(1987);*/
		
		setFirstName(null);
		setLastName(null);
		setMaritalStatus(null);
		setHobbies(hobbies);
		setCountry(null);
		setDate(date);
		setPhoneNumber(null);
		setEmail(null);
		setPicture(null);
		setDescription(null);
		setPassword(null);
		
	}
}
	
