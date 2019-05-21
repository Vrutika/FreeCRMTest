package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AcctPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	HomePage Homepg;
	LoginPage loginpg;
	AcctPage actpg;
	
	
	public HomePageTest()
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
	}
	@Test(priority=1)
	public void validatetitletest(){
		String title = Homepg.validateHomePageTitle();
		assertEquals(title, "#1 Free CRM software in the Cloud FreeCRM");
	}
    @Test(priority=2)
    public void loginlnktest() throws InterruptedException {
    	Homepg.loginlnk();
        actpg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
    	
    }
	
	  @AfterMethod public void teardown()
	  { 
		  driver.quit(); 
		  }
	  }
	 

