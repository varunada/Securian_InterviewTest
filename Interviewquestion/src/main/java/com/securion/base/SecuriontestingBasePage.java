package com.securion.base;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SecuriontestingBasePage {

		
		private static final int TIMEOUT = 5;
	    private static final int POLLING = 100;

	    protected WebDriver driver;
	    protected WebDriverWait wait;

	    public SecuriontestingBasePage(WebDriver driver) {
	    	this.driver = driver;
	        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
	        PageFactory.initElements(driver,this);
	    }
		
		
	    public void waitForVisibility(WebElement element) throws Error{
	        new WebDriverWait(driver, 60)
	             .until(ExpectedConditions.visibilityOf(element));
	   }
	    
	    public void waitForHiding(WebElement element) throws Error{
	        new WebDriverWait(driver, 60)
	             .until(ExpectedConditions.invisibilityOf(element));
	   }
}
