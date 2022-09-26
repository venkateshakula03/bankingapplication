package bankingapplication.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import bankingapplication.pageobjects.Addnewcustomer;
import bankingapplication.pageobjects.loginpage;

public class TC_Addcustomer_003 extends Baseclass{
	
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		loginpage lp=new loginpage(driver);
		lp.setusername(username);
		logger.info("User name is provided");
		lp.setpassword(password);
		logger.info("Passsword is provided");
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		Addnewcustomer addcust=new Addnewcustomer(driver);
		
		addcust.clickaddnewcustomer();
		
		logger.info("providing customer details....");
		
		addcust.customername("venkatesh");
		addcust.customergender("male");
		addcust.customerdob("26","03","1995");
		Thread.sleep(5000);
		addcust.customeraddress("INDIA");
		addcust.customercity("ONGOLE");
		addcust.customerstate("AP");
		addcust.customerpincode("523001");
		addcust.customermobile("987890091");
		
		//String email=randomestring()+"@gmail.com";
		addcust.customeremail("venkateshakula04@gmail.com");
		addcust.customerpassword("abcdef");
		addcust.submitbutton();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			capturescreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}

	
	}
	
	


