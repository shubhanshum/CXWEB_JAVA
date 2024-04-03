package com.cxweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPayeePage {

	WebDriver driver;
	
	@FindBy(id="account_holder")
	WebElement txt_accountHolder;
	
	@FindBy(id="account_number")
	WebElement txt_accountNumber;
	
	@FindBy(xpath="//button[@data-testid='button-payments.addPayee.continue']")
	WebElement btn_continue;
	
	public AddPayeePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillAddPayeeData(String accHolder, String accNo) {
		txt_accountHolder.sendKeys(accHolder);
		txt_accountNumber.sendKeys(accNo);
		btn_continue.click();
	}
	
	public boolean verifyAccountHolderFieldIsDisplayed() {
		return txt_accountHolder.isDisplayed();
	}
}
