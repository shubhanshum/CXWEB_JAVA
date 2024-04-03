package com.cxweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath="//span[@data-testid='menus.payments']")
	WebElement lnk_payments;
	
	@FindBy(xpath="//span[@data-testid='account_circle']")
	WebElement icon_profile;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickPaymentsTab() {
		lnk_payments.click();
	}
	
	public boolean verifyProfileIconIsDisplayed() {
		return icon_profile.isDisplayed();
	}
}
