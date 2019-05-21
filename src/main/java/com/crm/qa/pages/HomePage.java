package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'your business cloud partner')]")
	WebElement titlelblmessage;
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement lnkLogin;
	
	
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement lnkSignup;
	
    public HomePage() {
    	PageFactory.initElements(driver, this);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lnkLogin);
		
	}
    public String validateHomePageTitle()
	{
		return driver.getTitle();
		
	}
    public SignUpPage signuplnk()
    {
    	lnkSignup.click();
    	return new SignUpPage();
    }
    public LoginPage loginlnk() throws InterruptedException
	{
		
		 Actions action = new Actions(driver);
		
		 Thread.sleep(1000);
		
		 action.moveToElement(lnkLogin).build().perform();
    	 lnkLogin.click();
    	 return new LoginPage();
    	
    }
    public void Invalidmessage() {
    	
    }
    
 

}
