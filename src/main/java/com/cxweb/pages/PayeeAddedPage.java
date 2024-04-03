package com.cxweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayeeAddedPage {

	WebDriver driver;
	
	@FindBy(id="OTP")
	WebElement txt_code;
	
	@FindBy(name="Verify")
	WebElement btn_verify;
	
	public PayeeAddedPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
