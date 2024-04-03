package com.cxweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TwoFAPage {

	WebDriver driver;
	
	@FindBy(id="OTP")
	WebElement txt_code;
	
	@FindBy(name="Verify")
	WebElement btn_verify;
	
	public TwoFAPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyOtpTextBoxDisplayed() {
		return txt_code.isDisplayed();
	}
	
	public void completeTwoFA(String otp) {
		txt_code.sendKeys(otp);
		btn_verify.click();
	}
}
