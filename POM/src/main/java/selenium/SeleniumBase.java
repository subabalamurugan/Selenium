package selenium;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Reporter;

public class SeleniumBase extends Reporter
{
	
	public RemoteWebDriver driver;
	public WebDriverWait wait;	
	//Methods for Browser
	public RemoteWebDriver startApp(String url)
	{
		return startApp("chrome", url);
	}

	public RemoteWebDriver startApp(String browser, String url)
	{
		try 
		{
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			driver.navigate().to(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} 
		catch (Exception e)
		{
			System.out.println("The Browser Could not be Launched.Hence Failed");
			throw new RuntimeException();
		} 
		return driver;

	}
	//End Method for Browser
	//****************************************************************************//
	
	//Methods for Clear And Type
	
	public void clearAndType(WebElement ele, String data) throws IOException
	{
		try 
		{
			//ele.clear();
			System.out.print(data);
			ele.sendKeys(data);
			System.out.println("Data : "+data+"entered Successfully");
			
		} catch (ElementNotInteractableException e) 
		{
			System.out.println("The Element "+ele+" is not Interactable");
			throw new RuntimeException();
		}

	}
    //End Method for Clear And Type
	//***************************************************************************//
	
	//Methods for Click
	
	public void click(WebElement ele) throws IOException
	{
		String text="";
		try
		{
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			System.out.println("The element "+text+"clicked");
			
		} catch (StaleElementReferenceException e)
		{
			System.out.println("The Element "+text+" could not be clicked");
			throw new RuntimeException();
		} 
	}
	 //End Method for Click
	 //***************************************************************************//
}
