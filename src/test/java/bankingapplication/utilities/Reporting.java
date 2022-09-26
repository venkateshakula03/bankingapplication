package bankingapplication.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting  extends TestListenerAdapter{
	public ExtentHtmlReporter  htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onstart(ITestContext testContext)
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-Output/"+repname);
	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	
	extent=new ExtentReports();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("Host name", "localhost");
	extent.setSystemInfo("Environment","QA");
	extent.setSystemInfo("user","venkatesh");
	
	htmlReporter.config().setDocumentTitle("internet banking test project");
	htmlReporter.config().setReportName("functional test automation report");
	htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); 
	htmlReporter.config().setTheme(Theme.DARK);
	
	}
	public void ontestsuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	public void ontestfailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenShotpath=System.getProperty("user.dir")+"\\screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenShotpath);
		if(f.exists())
		{
			try {
				logger.fail("screenshot is below:"+logger.addScreenCaptureFromPath(screenShotpath));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		
		
		}
		
	}
public void ontestskipped(ITestResult tr)
{
	logger=extent.createTest(tr.getName());
	logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE) );
}
	
	public void onfinish(ITestContext testcontext)
	{
		extent.flush();
	}
}
