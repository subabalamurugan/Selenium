package steps;

import org.openqa.selenium.By;



import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login extends BaseClass
{
	    
@Given("Enter the username as {string}")
public void enterusername(String uname)
 {
	
	 driver.findElement(By.id("username")).sendKeys(uname);
 }

@And("Enter the password as {string}")
 public void enterpassword(String pwd)
 {

	 driver.findElement(By.id("password")).sendKeys(pwd);
 }
@When("click on login button")
 public void Loginbutton()
 {
	 driver.findElement(By.className("decorativeSubmit")).click();
 }
@When("HomePage Should be displayed")
 public void verifyHomePage()
 {
	 String title=driver.getTitle();
	 if(title.equals("Leaf-taps-TestLeaf Automation Platforms"))
	   System.out.println("homePage displayed");
	 
 }
@When("Click on crm/sfa button")
public void click_on_crm_sfa_button()
{
driver.findElement(By.linkText("CRM/SFA")).click();
}
@When("Click on Leads")
public void lead_click()
{
	driver.findElement(By.linkText("Leads")).click();
}
@But("Errormesage Should be displayed")
public void errorHomePage()
{
	 String title=driver.getTitle();
	 if(title.equals("Leaf-taps-TestLeaf Automation Platforms"))
	   System.out.println("homePage displayed");
	 else
		 System.out.println("homePage title not displayed");
	 
}


}
