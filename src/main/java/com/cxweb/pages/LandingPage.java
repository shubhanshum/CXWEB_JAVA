package com.cxweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cxweb.utils.UtilityMethods;

public class LandingPage {

	WebDriver driver;
	
	@FindBy(id="username")
	WebElement txt_email;
	
	@FindBy(id="password")
	WebElement txt_password;
	
	@FindBy(name="commit")
	WebElement btn_login;
	
	@FindBy(id="otp")
	WebElement txt_otp;
	
	@FindBy(name="submitOtp")
	WebElement btn_verify;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String email, String password) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		txt_email.sendKeys(email);
		txt_password.sendKeys(password);
		btn_login.click();
		if (txt_otp.isDisplayed()==true) {
			txt_otp.sendKeys(UtilityMethods.getMailcatcherOtp());
			btn_verify.click();
		}
	}
}
