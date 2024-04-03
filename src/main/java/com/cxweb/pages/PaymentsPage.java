package com.cxweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentsPage {

	WebDriver driver;
	
	@FindBy(xpath="//button[@data-testid='quickLink-payments.root.quickLink.addPayee']")
	WebElement btn_addPayee;
	
	@FindBy(xpath="//button[@data-testid='detailsTable-accountHolder']")
	WebElement btn_payee;
	
	public PaymentsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddPayeeBtn() {
		btn_addPayee.click();
	}
	
	public boolean verifyAddPayeeBtnIsDisplayed() {
		return btn_addPayee.isDisplayed();
	}
	
	public boolean verifyPayeeIsDisplayed() {
		return btn_payee.isDisplayed();
	}
	
	public void clickOnPayee() {
		btn_payee.click();
	}
}
