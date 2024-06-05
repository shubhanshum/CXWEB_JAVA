package com.cxweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPaymentDetailsPage {

	WebDriver driver;
	
	@FindBy(xpath="//button[@data-testid='button-payments.confirm_payment']")
	WebElement btn_confirmPayment;
	
	public ConfirmPaymentDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickConfirmPaymentBtn() {
		btn_confirmPayment.click();
	}
	
	public boolean verifyCnfPaymentBtnDisplayed() {
		return btn_confirmPayment.isDisplayed();
	}
}
