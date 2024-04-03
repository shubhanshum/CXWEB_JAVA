package com.cxweb.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cxweb.utils.UtilityMethods;

public class RunnerTest {

	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	@BeforeClass
	public void Setup(String browserName) {
		if (browserName.equalsIgnoreCase(UtilityMethods.getPropFileData("browser_name"))) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--ignore-ssl-errors=yes");
			firefoxOptions.addArguments("--ignore-certificate-errors");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			threadLocalDriver.set(new FirefoxDriver(firefoxOptions));
			getDriver().get(UtilityMethods.getPropFileData("env_url"));
			getDriver().manage().window().maximize();
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		}

	}

	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}

	@AfterClass
	public void tearDown() {
		getDriver().quit();
		threadLocalDriver.remove();
	}
}
