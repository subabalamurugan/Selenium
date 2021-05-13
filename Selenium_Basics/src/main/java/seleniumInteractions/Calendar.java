package seleniumInteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
      driver.get("http://www.leafground.com/pages/Calendar.html");
		
	    WebElement calendar=driver.findElement(By.id("datepicker"));
	  //  calendar.sendKeys("01/10/2019"+Keys.ENTER);    
	        
	    
	    calendar.click();
	    
	  WebElement nextButton=driver.findElement(
			  By.xpath(" //a[@title='Next']"));  
	  
	  nextButton.click();
	  
	

	  
	  WebElement dateToBeGiven=driver.findElement(
			  By.xpath("//a[contains(text(),'10')]"));
	  
	  dateToBeGiven.click();

	}

}
