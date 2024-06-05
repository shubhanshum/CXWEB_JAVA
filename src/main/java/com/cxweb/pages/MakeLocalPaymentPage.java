package com.cxweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakeLocalPaymentPage {

	WebDriver driver;
	
	@FindBy(id="amount")
	WebElement txt_amount;
	
	@FindBy(id="reference")
	WebElement txt_reference;
	
	@FindBy(xpath="//button[@data-testid='button-payments.make_payment_continue']")
	WebElement btn_continue;
	
	public MakeLocalPaymentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void makeLocalPayment(String amount) {
		txt_amount.clear();
		txt_amount.sendKeys(amount);
		txt_reference.clear();
		txt_reference.sendKeys("Test");
		btn_continue.click();
	}
	
	public boolean verifyAmountFieldIsDisplayed() {
		return txt_amount.isDisplayed();
	}
}
