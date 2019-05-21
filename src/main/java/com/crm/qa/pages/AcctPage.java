package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AcctPage extends TestBase {

	@FindBy(xpath="//span[contains(text(),'Vruttika Prajapati')]")
	WebElement lblvalidmsg;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactlnk;
	
	
	
	public AcctPage() {
		PageFactory.initElements(driver, this);
	}
	public String validmsg() {
		return lblvalidmsg.getText();
	}
	public ContactsPage contactslnkclick() {
		contactlnk.click();
		return new ContactsPage();
		
	}
	
}
