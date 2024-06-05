package com.cxweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentsPage {

	WebDriver driver;
	
	@FindBy(xpath="//button[@data-testid='quickLink-payments.root_quick_link_add_payee']")
	WebElement btn_addPayee;
	
	@FindBy(xpath="//div[@data-testid='detailsTable-accountHolder' and text()='Netflix']")
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
	
	public void clickOnPayee(String payeeName) {
		
			btn_payee.click();
		
	}
}
