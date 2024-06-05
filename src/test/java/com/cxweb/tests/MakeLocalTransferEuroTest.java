package com.cxweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cxweb.pages.ConfirmPaymentDetailsPage;
import com.cxweb.pages.HomePage;
import com.cxweb.pages.LandingPage;
import com.cxweb.pages.MakeLocalPaymentPage;
import com.cxweb.pages.PayeeDetailsPage;
import com.cxweb.pages.PaymentSentPage;
import com.cxweb.pages.PaymentsPage;
import com.cxweb.pages.TwoFAPage;
import com.cxweb.utils.UtilityMethods;

public class MakeLocalTransferEuroTest extends RunnerTest {

	LandingPage landingPage;
	HomePage homePage;
	PaymentsPage paymentsPage;
	PayeeDetailsPage payeeDetailsPage;
	MakeLocalPaymentPage makeLocalPaymentPage;
	ConfirmPaymentDetailsPage confirmPaymentPage;
	TwoFAPage twoFaPage;
	PaymentSentPage paymentSentPage;

	@Test
	public void doLocalTransferEuro() {
		
			landingPage = new LandingPage(getDriver());
			homePage = new HomePage(getDriver());
			paymentsPage = new PaymentsPage(getDriver());
			payeeDetailsPage = new PayeeDetailsPage(getDriver());
			makeLocalPaymentPage = new MakeLocalPaymentPage(getDriver());
			confirmPaymentPage = new ConfirmPaymentDetailsPage(getDriver());
			twoFaPage = new TwoFAPage(getDriver());
			paymentSentPage = new PaymentSentPage(getDriver());
			landingPage.login(UtilityMethods.getPropFileData("user_email"),
					UtilityMethods.getPropFileData("user_password"));
			Assert.assertEquals(homePage.verifyProfileIconIsDisplayed(), true, "Profile Icon Is Displayed");
			
			homePage.clickPaymentsTab();
			Assert.assertEquals(paymentsPage.verifyAddPayeeBtnIsDisplayed(), true, "Add Payee Button Is Displayed");
			paymentsPage.clickOnPayee(UtilityMethods.getPropFileData("payeeName"));
			payeeDetailsPage.clickMakeLocalPayment();
			Assert.assertEquals(makeLocalPaymentPage.verifyAmountFieldIsDisplayed(), true, "Amount Field Is Displayed");
			makeLocalPaymentPage.makeLocalPayment(UtilityMethods.getPropFileData("local_transfer_euro_amount"));
			Assert.assertEquals(confirmPaymentPage.verifyCnfPaymentBtnDisplayed(), true,
					"Confirm Payment Button Is Displayed");
			confirmPaymentPage.clickConfirmPaymentBtn();
			Assert.assertEquals(twoFaPage.verifyOtpTextBoxDisplayed(), true, "OTP Field Is Displayed");
			twoFaPage.completeTwoFA(UtilityMethods.getMailcatcherOtp());
			paymentSentPage.clickDoneBtn();
		
		
	}
}
