package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AcctPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;;

public class ContactsPageTest extends TestBase{
	HomePage Homepg;
	LoginPage loginpg;
	AcctPage actpg;
	ContactsPage contactpg;

	public ContactsPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initilization();
		Homepg = new HomePage();
		loginpg = new LoginPage();
		actpg = new AcctPage();
		contactpg = new ContactsPage();
	}
	@DataProvider(name="addcontactData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/crm/qa/testdata/Testdata.xlsx";
		
		int rownum=TestUtil.getRowCount(path, "Contacts");
		int colcount=TestUtil.getCellCount(path,"Contacts",1);
		
		String contactdata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				contactdata[i-1][j]=TestUtil.getCellData(path,"Contacts", i,j);//1 0
			}
				
		}
	return contactdata;
}
	
	
	 @Test(dataProvider="addcontactData") 
	  public void Addcontact(String firstname,String lastname,String email,String address,String city,String state,String zip,String status,String category,String callstatus) throws InterruptedException 
	  {
	    
		 Homepg.loginlnk();
		 actpg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
         actpg.contactslnkclick();
         contactpg.buttonnewclk();
         contactpg.createnewcontact(firstname, lastname, email, address, city, state, zip, status, category,callstatus);
         contactpg.contactsavelink();
         
	    
	  
	  }
	 @AfterMethod
		public void teardown() {
			driver.quit();
		}

	
}