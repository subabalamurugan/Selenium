package pageobjects;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import commonfunctions.CommonMethods;
public class LoginPage extends CommonMethods
{	
   public LoginPage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='divUsername']//input[1]")
	 public static WebElement eleUserName;	
	
	@FindBy(xpath="//div[@id='divPassword']//input[1]")
	 WebElement elePassword;	
	
	@FindBy(xpath="//div[@id='divLoginButton']//input[1]")
	 WebElement eleLogin;
	
	public LoginPage enterUserName(String data) throws IOException 
	{	
		clearAndType(eleUserName, data);
		reportstep("The Username "+data+ " is Entered Sucessfully","pass",driver);		
		return this;
	}	

   public LoginPage enterPassword(String data) throws IOException
	{
		clearAndType(elePassword, data);
		reportstep("The Password "+data+ " is Entered Sucessfully","pass",driver);
		return this;
	}	
	public HomePage clickLogin() throws IOException {
		click(eleLogin);
		reportstep("The Element clicked", "pass",driver); 
		return new HomePage(driver,test);		
	}
	
	
}
