package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AcctPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginpg;
	HomePage homepg;
	AcctPage actpg;

	public LoginPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}

	@BeforeMethod
	public void setup() {
		initilization();
        homepg = new HomePage();  
		actpg = new AcctPage();
		loginpg = new LoginPage();

	}

	@Test(priority = 1)
	public void loginpageTitletest() {
		String title = loginpg.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the Cloud FreeCRM");

	}

	
	/*
	 * @Test(priority=2) public void validatelogininfo() { actpg =
	 * loginpg.login(prop.getProperty("username"), prop.getProperty("password")); //
	 * Assert.assertEquals(actual, expected); }
	 */
	@DataProvider(name="loginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/crm/qa/testdata/Testdata.xlsx";
		
		int rownum=TestUtil.getRowCount(path, "Login");
		int colcount=TestUtil.getCellCount(path,"Login",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=TestUtil.getCellData(path,"Login", i,j);//1 0
			}
				
		}
	return logindata;
}
	  @Test(priority = 2,dataProvider="loginData") 
	  public void valid_loginpageTest(String Uname,String Passw) throws InterruptedException 
	  {
	    
	     homepg.loginlnk();
         
        
	     try {
	    	 actpg = loginpg.login(Uname,Passw);
	    	 Assert.assertEquals(loginpg.validmsg(), "Vruttika Prajapati");
	    	 System.out.println("Valid Data Passed");
	    	 
	     }
	     catch (Exception e) {
			// TODO: handle exception
	    	 Assert.assertEquals(loginpg.invalidmsg(), "Something went wrong...");
	    	 System.out.println("Invalid data passed");
	    	 
		}
		finally {
			System.out.println("Test Passed");
		}
		
	  
	  }
	 

	
	 /** @Test(dataProvider="dp_InvalidLogin",dataProviderClass=com.crm.qa.testdata.
	 * CRM_dataProvider.class)
	 * 
	 * public void InvalidloginTest() {
	 * 
	 * }
	 */
	  
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
