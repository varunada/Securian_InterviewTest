package com.securion.base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SecuriontestingBaseTest {
			protected WebDriver driver;
			 protected ExtentReports extent;
			 protected ExtentTest logger;
			protected ExtentHtmlReporter reporter;

	    public WebDriver getDriver(String browsername) {
	    	if (browsername.equals("chrome")) {
	    		 ChromeDriverManager.chromedriver();
	 	        WebDriverManager.chromedriver().setup();
	 	    	ChromeOptions chromeOptions = new ChromeOptions();
	 	    	chromeOptions.addArguments("--disable-notifications");
	 	    	driver = new ChromeDriver(chromeOptions);
	    	} else if (browsername.equals("firefox")) {
	    		WebDriverManager.firefoxdriver().setup();
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("permissions.default.desktop-notification", 1);
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability(FirefoxDriver.PROFILE, profile);
				driver = new FirefoxDriver(capabilities);
	    	}
	        return driver;
	    }

}
