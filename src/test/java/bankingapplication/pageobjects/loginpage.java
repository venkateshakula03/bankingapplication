package bankingapplication.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver ldriver;
	public loginpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements( rdriver,this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginbutton;
	
	@FindBy(xpath="//a[@href='Logout.php']")
	@CacheLookup
	WebElement logoutbutton;
	
	
	public void setusername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void setpassword(String  pwd)
	{
		password.sendKeys(pwd);
	}
	public void clicksubmit()
	{
		loginbutton.click();
	}
	public void clicklogout()
	{
		logoutbutton.click();
	}

}
