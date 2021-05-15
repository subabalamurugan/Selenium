package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLead extends BaseClass
{
	
	
	@And("Click on Create Lead")
	public void create_lead()
	{
		driver.findElement(By.linkText("Create Lead")).click();
		
	}
	@And("Enter the Company Name as {string}")
	public void company_name(String cname)
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
	}
	@And("Enter the First Name as {string}")
	public void first_name(String fname)
	{
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
	}
	@And("Enter the Last Name as {string}")
	public void last_name(String lname)
	{
	     driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
	}

	@Then("Submit button is clicked")
	public void submit_click()
	{
		driver.findElement(By.name("submitButton")).click();
	}
}
