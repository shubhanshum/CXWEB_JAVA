package com.cxweb.tests;

import org.testng.annotations.Test;

import com.cxweb.pages.LandingPage;
import com.cxweb.utils.UtilityMethods;

public class LoginTest extends RunnerTest{

	LandingPage landingPage;
	
	@Test
	public void loginTest() {
		landingPage=new LandingPage(getDriver());
		landingPage.login(UtilityMethods.getPropFileData("user_email"),
				UtilityMethods.getPropFileData("user_password"));
	}
}
