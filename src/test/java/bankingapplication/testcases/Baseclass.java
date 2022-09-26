package bankingapplication.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import bankingapplication.utilities.Readconfig;

public class Baseclass {
	Readconfig readconfig = new Readconfig();
	
	public String baseURL=readconfig.getapplicationurl();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	public static  WebDriver driver;
	public static Logger logger;

	
	@Parameters("browser")
	@BeforeClass
	
		public void setup(String br)
		{
		
		
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties.txt");
		if(br.equals("chrome"))
		{
	    System.setProperty("webdriver.chrome.driver",readconfig.getchromedriver());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxdriver());
			driver=new FirefoxDriver();
		}
		else if(br.equals("msedge"))
		{
			System.setProperty("webdriver.edge.driver",readconfig.getedgedriver() );
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
	
		}
		
		
		@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	public void capturescreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
		
	}
	
	/*public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public String randomenum()
	{
		String generatedstring1=RandomStringUtils.randomNumeric(4);
		return(generatedstring1);
	}	*/
}  
