package com.cxweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentSentPage {

	WebDriver driver;
	
	@FindBy(xpath="//button[@data-testid='button-undefined']")
	WebElement btn_done;
	
	public PaymentSentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickDoneBtn() {
		btn_done.click();
	}
}
