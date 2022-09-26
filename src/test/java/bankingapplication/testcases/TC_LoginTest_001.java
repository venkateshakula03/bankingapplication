package bankingapplication.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import bankingapplication.pageobjects.loginpage;

public class TC_LoginTest_001 extends Baseclass{
	
	@Test
	public void logintest() throws IOException
	{
		
		logger.info("url is opened");
		loginpage lp = new loginpage(driver);
		lp.setusername(username);
		logger.info("entered username");
		lp.setpassword(password);
		logger.info("entered password");
		lp.clicksubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login is success");
		}
		else
		{
			capturescreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("login is failure");
		}
	}
	

}
