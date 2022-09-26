package bankingapplication.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;
	
	public Readconfig()
	{
		File src = new File("./configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
				
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}

	public String getapplicationurl()
	{
		String url = pro.getProperty("baseURL");
		return url;
		
	}
	public String getusername()
	{
		String username = pro.getProperty("username");
		return username;
		
	}
	public  String  getpassword()
	{
		String password=pro.getProperty("password");
		return password;
		
	}
	public String getchromedriver()
	{
		String chromedriverpath=pro.getProperty("chromepath");
		return chromedriverpath;
		
	}
	public String getfirefoxdriver()
	{
		String firefoxdriverpath=pro.getProperty("firefoxpath");
		return firefoxdriverpath;
		
	}
	public String getedgedriver()
	{
		String edgedriverpath=pro.getProperty("msedgepath");
		return edgedriverpath;
	}
}

