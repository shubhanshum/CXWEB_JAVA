package com.cxweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPaymentTypePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@data-testid='payments.selectPaymentType.types.payment_type.label.LOCAL_TRANSFER_EUR_LOCAL_FRANCE']")
	WebElement btn_localTransferFrance;
	
	public SelectPaymentTypePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectLocalTransferFrance() {
		btn_localTransferFrance.click();
	}
	
	public boolean verifyLocalTransferEuroIsDisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return btn_localTransferFrance.isDisplayed();
	}

}
