package com.securian.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.securian.base.SecuriantestingBaseTest;
import com.securian.pages.RetirementCalculator;

import junit.framework.Assert;
/**
 * 
 * @author varunadamodaran
 * Test class for Retirement calculator
 * Contains all the test cases using TestNg framework
 *
 */
public class RetirementCalculatorTest extends SecuriantestingBaseTest{

	WebDriver driver;
	RetirementCalculator rc;
	/**
	 * Setting up driver for specified browser and navigates to the URL
	 * 
	 * @param BrowserName - Settings for browser type
	 * @throws IOException
	 * @throws Exception
	 */
	@BeforeMethod
	@Parameters({"BrowserName"})
	public void beforeTest(String BrowserName) throws IOException, Exception {
			driver = getDriver(BrowserName);
	    	driver.get("https://www.securian.com/insights-tools/retirement-calculator.html");	
	}
	/**
	 * Tests if user is able to enter retirement calculator values without social benefits
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@Test(enabled=true,priority = 0)
	public void calcWithoutSocialBenefits() throws Exception {
		rc = new RetirementCalculator(driver);
		rc.currentAgeEnter("40");
		rc.retirementAgeEnter("68");		
		rc.currentIncomeEnter("100000");
		rc.spouseIncomeEnter("75000");
		rc.currentTotalSavingsEnter("500000");
		rc.currentAnnualSavingsEnter("10");
		rc.savingsIncreaseRateEnter("0.25");
		rc.calculateSubmit();
		Assert.assertEquals(rc.waitForResults(),true);
	}
	/**
	 * Tests when user toggles between social benefits the respective fields are displayed
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@Test(enabled=true,priority = 1)
	public void socialBenefitsToggle() throws Exception {
		rc = new RetirementCalculator(driver);
		rc.yesSocialBenefitsClick();
		Assert.assertEquals(rc.validateYesSocialBenefits(),true);
		rc.noSocialBenefitsClick();
		Assert.assertEquals(rc.hideSocialBenefits(),true);
	}
	/**
	 * Tests when user is able to open adjust default values
	 */
	
	@Test(enabled=true,priority = 2)
	public void defaultCalculatorValues() {
		rc = new RetirementCalculator(driver);
		rc.adjDefaultValuesClick();
		Assert.assertEquals(rc.validateAdjDefaultValues(),true);
	}
	/**
	 * Tests when user is able to enter values in retirement calculator with adjusted values
	 * @throws InterruptedException
	 */
	@SuppressWarnings("deprecation")
	@Test(enabled=true,priority = 3)
	public void calcWithAdjValues() throws InterruptedException {
		rc = new RetirementCalculator(driver);
		rc.currentAgeEnter("40");
		rc.retirementAgeEnter("68");		
		rc.currentIncomeEnter("100000");
		rc.spouseIncomeEnter("75000");
		rc.currentTotalSavingsEnter("500000");
		rc.currentAnnualSavingsEnter("10");
		rc.savingsIncreaseRateEnter("0.25");
		rc.adjDefaultValuesClick();
		rc.validateAdjDefaultValues();
		rc.additionalIncomeEnter("10000");
		rc.retirementDurationEnter("5");
		rc.retirementAnnualIncomeEnter("1000");
		rc.preRetirementROIEnter("1");
		rc.postRetirementROIEnter("3");
		rc.saveChanges();
		rc.calculateSubmit();
		Assert.assertEquals(rc.waitForResults(),true);
	}
	
	@AfterMethod(enabled=true)
	public void beforeTest() throws IOException, Exception {
		driver.close();	
	}
	

}
