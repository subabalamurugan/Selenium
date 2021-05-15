package pageobjects;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonfunctions.CommonMethods;

public class HomePage extends CommonMethods
{
	public HomePage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver = driver;
		this.test=test;
	}
}
