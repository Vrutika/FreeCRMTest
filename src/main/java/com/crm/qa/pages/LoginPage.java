package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'submit')]")
	WebElement signupbtn;
	
	@FindBy(xpath="//div[contains(text(),'Something went wrong...')]")
	WebElement lblinvalid;
	
	@FindBy(xpath="//span[contains(text(),'Vruttika Prajapati')]")
	WebElement lblvalidmsg;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	public void validateCRMlogotext() {
		
	}

	
	public AcctPage login(String un,String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new AcctPage();
		
	    
	}
	public String invalidmsg() {
		return lblinvalid.getText();
	}
	public String validmsg() {
		return lblvalidmsg.getText();
	}
	
	
}
