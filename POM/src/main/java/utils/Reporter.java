package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporter 
{
	public static ExtentHtmlReporter reporter;
	public static 	ExtentReports extent;
	public static ExtentTest test;
	public String testName,testDescription,testCategory,testAuthor;
	
	@BeforeSuite
	public void startReport()
	{
		 reporter=new ExtentHtmlReporter("./reports/loginresult.html");
	     extent=new ExtentReports();
		 extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testdetails()
	{
		test=extent.createTest("testName","testDescription");		
		test.assignCategory("testCategory");
		test.assignAuthor("testAuthor");
	}
	public long takesnap(RemoteWebDriver driver) 
	{
		Math.random();
		int random=(int)(Math.random()*999999);
	
	try
	{
	File source=driver.getScreenshotAs(OutputType.FILE);
	File target=new File("./reports/snaps/"+random+".png");
	FileUtils.copyFile(source,target);
	}
	catch(WebDriverException e) {
		System.out.println("The browser has been closed.");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("The snapshot could not be taken");
	}
	return random;
	}
	public void reportstep(String msg,String status,RemoteWebDriver driver) throws IOException
	{
      if(status.equalsIgnoreCase("pass"))
		{		 
		test.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath("./reports/snaps/"+takesnap(driver)+".png").build());
		}
		else if(status.equalsIgnoreCase("fail"))
		{
			test.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath("./reports/snaps/"+takesnap(driver)+".png").build());
		}
		
	}
	  
   @AfterSuite
	    public void endReport()
	    {
			extent.flush();
	    }
	
}
