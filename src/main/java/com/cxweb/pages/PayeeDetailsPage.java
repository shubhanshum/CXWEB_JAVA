package com.cxweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayeeDetailsPage {

	WebDriver driver;
	
	@FindBy(xpath="//span[@data-testid='payments.payeeDetails.makeAPayment']")
	WebElement btn_makePayment;
	
	public PayeeDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMakeLocalPayment() {
		btn_makePayment.click();
	}
}
