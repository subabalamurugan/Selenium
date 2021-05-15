package commondp;




import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;



import org.openqa.selenium.By;


public class CreateLead extends BaseClass{
	@BeforeTest
	public void setFileName() 
	{
		excelFileName = "createLead";

	}
 
	
    @Test(dataProvider = "fetchdata") 
	public  void runcreatelead(String cname,String fname,String lname)throws InterruptedException
    {
    	
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.name("submitButton")).click();
	 }
    
    
}
