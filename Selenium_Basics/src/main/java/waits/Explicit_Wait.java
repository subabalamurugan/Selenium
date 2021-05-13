package waits;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit_Wait 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
		//Adding wait 
	    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	    //wait Explicit Command For Click Me Button
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement button=driver.findElement(By.id("btn"));
	    wait.until(ExpectedConditions.textToBePresentInElement(button, "Click ME!"));
	    if(button.isDisplayed())
	     System.out.println("Now im going to change!! button is changed into Click ME!");
	    
	    //Click ->Click ME! button	    
	    driver.findElement(By.id("btn")).click();	    
	    //AlertBox
	    // Switching to Alert        
        Alert alert = driver.switchTo().alert();        		
        // Capturing alert message.    
        String alertMsg= driver.switchTo().alert().getText();        		
        // Displaying alert message		
        System.out.println(alertMsg); 
        // Accepting alert		
        alert.accept();	
       

	}

}
