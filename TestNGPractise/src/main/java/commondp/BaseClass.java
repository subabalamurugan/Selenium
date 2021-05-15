package commondp;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass
{
	public ChromeDriver driver;
	public String excelFileName;
 
  @Parameters({"url","username","password"})
  @BeforeMethod 
	
	
  public void precondion(String url,String name,String pwd)
	{
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	driver.findElement(By.id("username")).sendKeys(name);
	driver.findElement(By.id("password")).sendKeys(pwd);
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Leads")).click();
	}
  
  @DataProvider
  public String[][] fetchdata() throws IOException
  {
  	ReadExcel obj=new ReadExcel();
  	String[][] excelRead=obj.excelRead(excelFileName);
  	return excelRead;
  }
  @AfterMethod
  public void postcondition()
	{
		driver.close();
	}
}
