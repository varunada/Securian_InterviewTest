package com.securion.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.securion.base.SecuriontestingBasePage;

/**
 * 
 * @author varunadamodaran
 * Page class for Retirement Calculator
 * Contains web elements of the Retirement calculator page and functions for interacting with them
 *
 */
public class RetirementCalculator extends SecuriontestingBasePage {

	WebDriver driver;
	private static final int TIMEOUT = 5;
    private static final int POLLING = 100;
    public WebDriverWait wait;
    
	@FindBy(id = "current-age")
	WebElement currentAge;
	
	@FindBy(id = "retirement-age")
	WebElement retirementAge;
    
	@FindBy(id = "current-income")
	WebElement currentIncome;
	
	@FindBy(id = "spouse-income")
	WebElement spouseIncome;
	
	@FindBy(id = "current-total-savings")
	WebElement currentTotalSavings;
	
	@FindBy(id ="current-annual-savings")
	WebElement currentAnnualSavings;
	
	@FindBy(id ="savings-increase-rate")
	WebElement savingsIncreaseRate;
	
	@FindBy(xpath = "//input[@id='yes-social-benefits']/following-sibling::label")
	WebElement yesSocialBenefits;
	
	@FindBy(xpath = "//input[@id='no-social-benefits']/following-sibling::label")
	WebElement noSocialBenefits;
	
	@FindBy(xpath = "//button[@data-tag-id='submit']")
	WebElement calcSubmit;
	
	@FindBy(id = "marital-status-toggle-group")
	WebElement maritalStatus;
	
	@FindBy(id = "social-security-override-container")
	WebElement socialOverride;
	
	@FindBy(xpath = "//a[text()='Adjust default values']")
	WebElement adjDefValues;
	
	@FindBy(xpath = "//h1[text()='Default calculator values']")
	WebElement adjDefValuesHeading;
	
	@FindBy(id = "additional-income")
	WebElement additionalIncome;
	
	@FindBy(id = "retirement-duration")
	WebElement retirementDuration;
	
	@FindBy(id = "retirement-annual-income")
	WebElement retirementAnnualIncome;
	
	@FindBy(id = "pre-retirement-roi")
	WebElement preRetirementROI;
	
	@FindBy(id = "post-retirement-roi")
	WebElement postRetirementROI;
	
	@FindBy(xpath = "//input[@value = 'Save changes']")
	WebElement saveChanges;
	
	@FindBy(xpath = "//canvas[@id='results-chart']")
	WebElement results;
	
	public void currentAgeEnter(String s) {
		currentAge.sendKeys(s);
	}
	public void retirementAgeEnter(String s) {
		retirementAge.sendKeys(s);
	}
	public void currentIncomeEnter(String s) {
		currentIncome.click();
		currentIncome.clear();
		currentIncome.sendKeys(s);
	}
	public void spouseIncomeEnter(String s) {
		spouseIncome.click();
		spouseIncome.clear();
		spouseIncome.sendKeys(s);
	}
	public void currentTotalSavingsEnter(String s) {
		currentTotalSavings.click();
		currentTotalSavings.clear();
		currentTotalSavings.sendKeys(s);
	}
	public void currentAnnualSavingsEnter(String s) {
		currentAnnualSavings.sendKeys(s);
	}
	public void noSocialBenefitsClick(){
		noSocialBenefits.click();
	}
	public void yesSocialBenefitsClick(){
		yesSocialBenefits.click();
	}
	public void savingsIncreaseRateEnter(String s) {
		savingsIncreaseRate.sendKeys(s);
	}
	public void calculateSubmit() {
		calcSubmit.click();
	}
	
	public boolean validateYesSocialBenefits() {
		waitForVisibility(maritalStatus);
		waitForVisibility(socialOverride);
		return maritalStatus.isDisplayed() && socialOverride.isDisplayed();
	}
	public boolean hideSocialBenefits() {
		waitForHiding(maritalStatus);
		waitForHiding(socialOverride);
		return !maritalStatus.isDisplayed() && !socialOverride.isDisplayed();
	}
	public void getSocialBenefitsSelection() {
		if(yesSocialBenefits.getAttribute("checked") != null) {
			System.out.println(yesSocialBenefits.getAttribute("checked"));
		}
	}
	public void adjDefaultValuesClick() {
		adjDefValues.click();
	}
	public boolean validateAdjDefaultValues() {
		waitForVisibility(adjDefValuesHeading);
		return adjDefValuesHeading.isDisplayed();
	}
	
	public void additionalIncomeEnter(String s) {
		additionalIncome.click();
		additionalIncome.clear();
		additionalIncome.sendKeys(s);
	}
	
	public void retirementDurationEnter(String s) {
		retirementDuration.click();
		retirementDuration.clear();
		retirementDuration.sendKeys(s);
	}
	
	public void retirementAnnualIncomeEnter(String s) {
		retirementAnnualIncome.click();
		retirementAnnualIncome.clear();
		retirementAnnualIncome.sendKeys(s);
	}
	public void preRetirementROIEnter(String s) {
		preRetirementROI.click();
		preRetirementROI.clear();
		preRetirementROI.sendKeys(s);
	}
	public void postRetirementROIEnter(String s) {
		postRetirementROI.click();
		postRetirementROI.clear();
		postRetirementROI.sendKeys(s);
	}
	
	public void saveChanges() {
		saveChanges.click();
		waitForVisibility(calcSubmit);
	}
	
	public boolean waitForResults() {
		waitForVisibility(results);
		return results.isDisplayed();
	}
	
	public RetirementCalculator(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
	}

}
