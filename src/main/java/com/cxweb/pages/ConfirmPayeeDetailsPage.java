package com.cxweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPayeeDetailsPage {

	WebDriver driver;
	
	@FindBy(xpath="//button[@data-testid='button-payments.confirm_payee.confirm']")
	WebElement btn_addPayee;
	
	public ConfirmPayeeDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddPayeeConfirmBtn() {
		btn_addPayee.click();
	}
	
	public boolean verifyAddpayeeConfirmBtnIsDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return btn_addPayee.isDisplayed();
	}
}
