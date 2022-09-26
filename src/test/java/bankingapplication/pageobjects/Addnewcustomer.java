package bankingapplication.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Addnewcustomer {
	WebDriver ldriver;
	
	public Addnewcustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@CacheLookup
	@FindBy(how = How.CSS,using="a[href='addcustomerpage.php']")
	WebElement addNewcustomerlink;
	
	@CacheLookup
	@FindBy(how=How.CSS,using="input[name='name']")
	WebElement cutomernamelink;
	
	@CacheLookup
	@FindBy(how=How.NAME,using="rad1")
	WebElement genderlink;
	
    @CacheLookup
    @FindBy(how=How.XPATH,using="//input[@onkeyup='validatedob();']")
    WebElement  dateofbirthlink;
    
    @CacheLookup
    @FindBy(how=How.NAME,using="addr")
    WebElement addresslink;
    
    @CacheLookup
    @FindBy(how=How.NAME,using="city")
    WebElement citylink;
    
    @CacheLookup
    @FindBy(how=How.NAME,using="state")
    WebElement statelink;
    
    @CacheLookup
    @FindBy(how=How.NAME,using="pinno")
    WebElement pinlink;
    
    @CacheLookup
    @FindBy(how=How.NAME,using="telephoneno")
    WebElement mobilenumberlink;
    
    @CacheLookup
    @FindBy(how=How.NAME,using="emailid")
    WebElement emaillink;
    
    @CacheLookup
    @FindBy(how=How.NAME,using="password")
    WebElement passwordlink;
    
    @CacheLookup
    @FindBy(how=How.NAME,using="sub")
    WebElement submitbuttonlink;
	
    public void clickaddnewcustomer()
    {
    	addNewcustomerlink.click();
    }
    
    public void customername(String cname)
    {
    	cutomernamelink.sendKeys(cname);
    }
	
    public void customergender(String cgender)
    {
    	genderlink.click();
    }
    
    public void customerdob(String mm,String dd,String yy)
    {
    	 dateofbirthlink.sendKeys(mm);
    	 dateofbirthlink.sendKeys(dd);
    	 dateofbirthlink.sendKeys(yy);
    }
    
    public void customeraddress(String caddress)
    {
    	addresslink.sendKeys(caddress);
    }
    public void customercity(String ccity)
    {
    	citylink.sendKeys(ccity);
    }
    public void customerstate(String cstate)
    {
    	 statelink.sendKeys(cstate);
    }
    public void customerpincode(String cpin)
    {
    	 pinlink.sendKeys(String.valueOf(cpin));
    }
    public void customermobile(String cmobile)
    {
    	mobilenumberlink.sendKeys(cmobile);
    }
    public void customeremail(String cemail)
    {
    	emaillink.sendKeys(cemail);
    }
    public void customerpassword(String cpassword)
    {
    	 passwordlink.sendKeys(cpassword);
    }
    public void submitbutton()
    {
    	submitbuttonlink.click();
    }
}

