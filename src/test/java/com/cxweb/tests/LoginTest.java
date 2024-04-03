package com.cxweb.tests;

import org.testng.annotations.Test;

import com.cxweb.pages.LandingPage;

public class LoginTest extends RunnerTest{

	LandingPage landingPage;
	
	@Test
	public void loginTest() {
		landingPage=new LandingPage(getDriver());
		landingPage.login("shubhanshu@test.com", "Password@12");
	}
}
