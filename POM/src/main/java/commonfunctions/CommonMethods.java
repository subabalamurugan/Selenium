package commonfunctions;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import selenium.SeleniumBase;

public class CommonMethods extends SeleniumBase
{
			
	public static Properties prop;
	
	
	@BeforeMethod
	public void precondion() throws IOException
	{
		  FileInputStream fis =new FileInputStream("./src/main/resources/configure.properties");
		  prop=new Properties();
		  prop.load(fis);		
		  driver = startApp("chrome",prop.getProperty("url"));
		 
	}
		   
    @AfterMethod
	public void postcondition()
	{
	    driver.close();
	}
		  

}
