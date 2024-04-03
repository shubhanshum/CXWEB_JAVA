package com.cxweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cxweb.pages.AddPayeePage;
import com.cxweb.pages.ConfirmPayeeDetailsPage;
import com.cxweb.pages.HomePage;
import com.cxweb.pages.LandingPage;
import com.cxweb.pages.PaymentsPage;
import com.cxweb.pages.SelectPaymentTypePage;
import com.cxweb.pages.TwoFAPage;
import com.cxweb.utils.UtilityMethods;

public class CreateLocalTransferEuroPayeeTest extends RunnerTest {

	LandingPage landingPage;
	HomePage homePage;
	PaymentsPage paymentsPage;
	SelectPaymentTypePage selectPaymentTypePage;
	AddPayeePage addPayeePage;
	ConfirmPayeeDetailsPage confirmPayeeDetailsPage;
	TwoFAPage twoFaPage;

	@Test
	public void createLocalTransferEurPayeeTest() {
		landingPage = new LandingPage(getDriver());
		homePage = new HomePage(getDriver());
		paymentsPage = new PaymentsPage(getDriver());
		addPayeePage = new AddPayeePage(getDriver());
		selectPaymentTypePage = new SelectPaymentTypePage(getDriver());
		confirmPayeeDetailsPage = new ConfirmPayeeDetailsPage(getDriver());
		twoFaPage = new TwoFAPage(getDriver());
		landingPage.login(UtilityMethods.getPropFileData("user_email"),
				UtilityMethods.getPropFileData("user_password"));
		Assert.assertEquals(homePage.verifyProfileIconIsDisplayed(), true, "Profile Icon Is Displayed");
		homePage.clickPaymentsTab();
		Assert.assertEquals(paymentsPage.verifyAddPayeeBtnIsDisplayed(), true, "Add Payee Button Is Displayed");
		paymentsPage.clickAddPayeeBtn();
		Assert.assertEquals(selectPaymentTypePage.verifyLocalTransferEuroIsDisplayed(), true,
				"Local Transfer France Is Displayed");
		selectPaymentTypePage.selectLocalTransferFrance();
		Assert.assertEquals(addPayeePage.verifyAccountHolderFieldIsDisplayed(), true,
				"Account Holder Field Is Displayed");
		String timeStamp = UtilityMethods.getTimeStamp();
		int payeeAccountNum = UtilityMethods.generateRandomNumber(1, 999);
		System.out.println("Account holder name=" + "PayeeLocalEuro_" + timeStamp);
		System.out.println("Account Number for " + "PayeeLocalEuro_" + timeStamp + " holder is=" + "EE11118250157911771"
				+ payeeAccountNum);
		addPayeePage.fillAddPayeeData("PayeeLocalEuro_" + timeStamp, "EE11118250157911771" + payeeAccountNum);
		Assert.assertEquals(confirmPayeeDetailsPage.verifyAddpayeeConfirmBtnIsDisplayed(), true,
				"Add Payee Confirm Button Is Displayed");
		confirmPayeeDetailsPage.clickAddPayeeConfirmBtn();
		Assert.assertEquals(twoFaPage.verifyOtpTextBoxDisplayed(), true, "OTP Text Box Is Displayed");
		twoFaPage.completeTwoFA(UtilityMethods.getMailcatcherOtp());

	}
}
