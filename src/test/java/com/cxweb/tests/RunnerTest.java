package com.cxweb.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class RunnerTest {

	protected static 
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	@Parameters({ "browserName","url" })
    @BeforeClass
	public void Setup(String browserName,String url){
		if (browserName.equalsIgnoreCase("Firefox")) {
			FirefoxOptions firefoxOptions=new FirefoxOptions();
			firefoxOptions.addArguments("--ignore-ssl-errors=yes");
			firefoxOptions.addArguments("--ignore-certificate-errors");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			threadLocalDriver.set(new FirefoxDriver(firefoxOptions));
			getDriver().get(url);
		    getDriver().manage().window().maximize();
		    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		
		
	}
	
	public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    @AfterClass
    public void tearDown(){
        getDriver().quit();
        threadLocalDriver.remove();
    }
}
