package testcases;

import pageobjects.LoginPage;

import java.io.IOException;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonfunctions.CommonMethods;
public class Output extends CommonMethods 
{
	
	@BeforeTest
	public void setFileName()
	{
		
		testName="LoginwithValidData";
		testDescription="Verify loginfor valid Data";
		testCategory="funtional";
		testAuthor="Suba";
	}
	@Test
	public void runlogin() throws IOException
	{
	new LoginPage(driver,test).enterUserName(prop.getProperty("username"))
	.enterPassword(prop.getProperty("password")).clickLogin();
	}
}
