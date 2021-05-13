package seleniumInteractions;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.Alert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		   driver.get("http://www.leafground.com/pages/Alert.html");
		   driver.manage().window().maximize();
    
		//Simple Alert
		   driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		   org.openqa.selenium.Alert alert = driver.switchTo().alert();		
	       String alertMessage= driver.switchTo().alert().getText();		
	       System.out.println(alertMessage);	
	       alert.accept();		
	   
	    //Confirmation Alert
	        driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
	        org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
	        alert1.dismiss();
	        String Cancel = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).getText();
	        System.out.println(Cancel);	
	   
	    //Alert-Prompt 
	        driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
	        org.openqa.selenium.Alert promptAlert  = driver.switchTo().alert();
	        String alertText = promptAlert.getText();
	        System.out.println("Alert text is " + alertText);
		    promptAlert.sendKeys("Test User");
			promptAlert.accept();
			 
	        

	}
}
