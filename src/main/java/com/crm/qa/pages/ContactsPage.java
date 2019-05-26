package com.crm.qa.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement buttonnewlnk;

	@FindBy(name = "first_name")
	WebElement txtfirstname;

	@FindBy(name = "last_name")
	WebElement txtlastname;

	@FindBy(name = "value")
	WebElement txtemail;

	@FindBy(name = "address")
	WebElement txtaddress;

	@FindBy(name = "city")
	WebElement txtcity;

	@FindBy(name = "state")
	WebElement txtstate;

	@FindBy(name = "zip")
	WebElement txtzip;

	@FindBy(name = "status")
	WebElement ddstatus;

	@FindBy(xpath = "//div[@class='ui active visible selection dropdown']//div//div//span")
	List<WebElement> ddoptionstatus;

	@FindBy(name = "category")
	WebElement ddcategory;

	@FindBy(xpath = "//div[@class='visible menu transition']//div//span")
	List<WebElement> ddselectcategory;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement savebtn;

	// @FindBy(xpath="//html[1]//body[1]//div[1]//div[1]//div[2]//div[2]//div[1]//div[2]//form[1]")

	//@FindBy(xpath = "//div[@class='ui toggle checkbox']")
	//WebElement chkboxdonotcall;
	


	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public void buttonnewclk() {
		buttonnewlnk.click();
	}
   
	public void selectddstatus(String status) {
		
		Actions action = new Actions(driver);
		action.moveToElement(ddstatus).build().perform();
		ddstatus.click();
		for (int i = 0; i < ddoptionstatus.size(); i++) {
			if (ddoptionstatus.get(i).getText().contains(status)) {
				ddoptionstatus.get(i).click();
				break;
			}
		} // completion of status dropdown
	}
	public void selectddcategory(String category) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",ddcategory);
		Actions action = new Actions(driver);
		
		action.moveToElement(ddcategory).build().perform();
		ddcategory.click();// choose category option from dropdwon
		for (int j = 0; j < ddselectcategory.size(); j++) {
			if (ddselectcategory.get(j).getText().contains(category)) {
				ddselectcategory.get(j).click();
				break;
			}
		} // completion of category dropdown

	}
	public void checkdonotcallbtn(String callstatus) {
		WebElement chkboxdonotcall = driver
				.findElement(new ByChained(By.xpath("//div[@class='ui toggle checkbox']"), By.name("do_not_call")));
		Actions action = new Actions(driver);
		action.moveToElement(chkboxdonotcall).build().perform();
		
		/*
		 * if(callstatus.contains("Yes")) {
		 * driver.findElement(By.xpath("//div[@class='ui toggle checkbox']//label")).
		 * click(); }
		 */
		
		try {
			Assert.assertEquals(callstatus, "Yes");
			driver.findElement(By.xpath("//div[@class='ui toggle checkbox']//label")).click();
		} catch (Exception e) { // TODO: handle exception

		}

		} //end of do not text
		
	
	public void checkdonottextbtn(String txtstatus) {
		WebElement chkdntnottxt = driver.findElement(new ByChained(By.xpath("//div[@class='ui toggle checkbox']"),
				(By.xpath("//input[@name='do_not_text']"))));
		Actions action = new Actions(driver);
		action.moveToElement(chkdntnottxt).build().perform();
		if (txtstatus.contains("Yes")) {
			driver.findElement(By.xpath("//div[@class='ui toggle checkbox']//label")).click();
		}
	}
	public void checkdonotemailbtn(String emailstatus) {
	 WebElement chkdntemail = driver.findElement(new ByChained(By.xpath("//div[@class='ui toggle checkbox']"),
             (By.name("do_not_email"))));
     	Actions actionemail = new Actions(driver);
    	actionemail.moveToElement(chkdntemail).build().perform();
     	if(emailstatus.contains("Yes"))
     	{
     		driver.findElement(By.xpath("//div[@class='ui toggle checkbox']//label")).click();
     	}
		}

	public void createnewcontact(String firstname, String lastname, String email, String address, String city,
			String state, String zip, String status, String category, String callstatus, String txtstatus,
			String emailstatus) throws InterruptedException {
		txtfirstname.sendKeys(firstname);
		txtlastname.sendKeys(lastname);
		txtemail.sendKeys(email);
		txtaddress.sendKeys(address);
		txtcity.sendKeys(city);
		txtstate.sendKeys(state);
		txtzip.sendKeys(zip);
		Thread.sleep(3000);
		selectddstatus(status);
		selectddcategory(category);
		checkdonotcallbtn(callstatus);
		checkdonottextbtn(txtstatus);
		checkdonotemailbtn(emailstatus);
        
 		// Dynamic checkbox for Do_not_text
		/*
		 * Actions act = new Actions(driver);
		 * act.moveToElement(chkboxdonotcall).build().perform(); if
		 * (callstatus.contains("Yes")) { chkboxdonotcall.click(); } //end of do not
		 * text
		 */
		/*
		 * WebElement chkdntnottxt = driver.findElement(new
		 * ByChained(By.xpath("//div[@class='ui toggle checkbox']"),
		 * By.name("do_not_text"))); Actions acti = new Actions(driver);
		 * acti.moveToElement(chkdntnottxt).build().perform();
		 * if(txtstatus.contains("Yes")) {
		 * driver.findElement(By.xpath("//div[@class='ui toggle checkbox']//label")).
		 * click(); }
		 */
       
		/*
		 * WebElement chkdntemail = driver.findElement(new
		 * ByChained(By.xpath("//div[@class='ui toggle checkbox']"),
		 * (By.name("do_not_email")))); Actions actionemail = new Actions(driver);
		 * actionemail.moveToElement(chkdntemail).build().perform();
		 * if(emailstatus.contains("Yes")) {
		 * driver.findElement(By.xpath("//div[@class='ui toggle checkbox']//label")).
		 * click(); }
		 */
		}

	public void contactsavelink() {
		savebtn.click();
	}

}
