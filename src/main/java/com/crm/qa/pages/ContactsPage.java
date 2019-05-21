package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement buttonnewlnk;
	
	@FindBy(name="first_name")
	WebElement txtfirstname;
	
	@FindBy(name="last_name")
	WebElement txtlastname;
	
	@FindBy(name="value")
	WebElement txtemail;
	
	@FindBy(name="address")
	WebElement txtaddress;
	
	@FindBy(name="city")
	WebElement txtcity;
	
	@FindBy(name="state")
	WebElement txtstate;
	
	@FindBy(name="zip")
	WebElement txtzip;
	
	@FindBy(name="status")
	WebElement ddstatus;
	
	@FindBy(xpath="//div[@class='ui active visible selection dropdown']//div//div//span")
	List<WebElement> ddoptionstatus;
	
	@FindBy(name="category")
	WebElement ddcategory;
	
	@FindBy(xpath="//div[@class='visible menu transition']//div//span")
    List<WebElement> ddselectcategory;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
    WebElement savebtn;

	@FindBy(xpath="//html[1]//body[1]//div[1]//div[1]//div[2]//div[2]//div[1]//div[2]//form[1]")
	List<WebElement> chkboxdonottext;
	
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void buttonnewclk()
	{
		buttonnewlnk.click();
	}
	public void createnewcontact(String firstname,String lastname,String email,String address,String city,String state,String zip,String status,String category,String callstatus) throws InterruptedException
	{
		txtfirstname.sendKeys(firstname);
		txtlastname.sendKeys(lastname);
		txtemail.sendKeys(email);
		txtaddress.sendKeys(address);
		txtcity.sendKeys(city);
		txtstate.sendKeys(state);
		txtzip.sendKeys(zip);
		Thread.sleep(3000);
		//fetch data from status dropdown
		Actions action = new Actions(driver);
		action.moveToElement(ddstatus).build().perform();
		ddstatus.click();
		for(int i=0;i<ddoptionstatus.size();i++)
		{
			 if(ddoptionstatus.get(i).getText().contains(status))
			 {
				 ddoptionstatus.get(i).click();
				 break;
			 } 
		}//completion of status dropdown
        
		Actions action2 = new Actions(driver);
		action2.moveToElement(ddcategory).build().perform();
		ddcategory.click();//choose category option from dropdwon
		for(int j=0;j<ddselectcategory.size();j++)
		{
			 if(ddselectcategory.get(j).getText().contains(category))
			 {
				 ddselectcategory.get(j).click();
				 break;
			 } 
		}//completion of status dropdown
		
		//check for checkbox
		for(int k = 0;k<chkboxdonottext.size();k++)
		{
			if(chkboxdonottext.get(k).getText().contains(callstatus))
				chkboxdonottext.get(k).click();
		}
		}
	
	 public void contactsavelink() { savebtn.click(); }

}
