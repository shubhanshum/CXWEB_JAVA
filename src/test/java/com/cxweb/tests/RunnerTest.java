package com.cxweb.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cxweb.utils.UtilityMethods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunnerTest {

	protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	@BeforeClass
	public void Setup() {
		String browserName=UtilityMethods.getPropFileData("browser_name");
		System.out.println("Launching "+browserName+" Browser");
		if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--ignore-ssl-errors=yes");
			firefoxOptions.addArguments("--ignore-certificate-errors");
			threadLocalDriver.set(new FirefoxDriver(firefoxOptions));
		} else {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions=new ChromeOptions();
			chromeOptions.addArguments("--ignore-ssl-errors=yes");
			chromeOptions.addArguments("--ignore-certificate-errors");
			threadLocalDriver.set(new ChromeDriver(chromeOptions));
		}
		getDriver().get(UtilityMethods.getPropFileData("env_url"));
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

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
