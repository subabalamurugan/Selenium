package seleniumInteractions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class Disappear {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Url Launching
		driver.get("http://leafground.com/pages/disapper.html");
		driver.manage().window().maximize();		
		WebDriverWait wait  =new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement button=driver.findElement(By.id("btn"));
		wait.until(ExpectedConditions.invisibilityOf(button));			
	    System.out.println(button.isDisplayed());
		//To Check
		if(button.isDisplayed()==true)
		{
			String disapp=driver.findElement(By.id("btn")).getText();
			System.out.println(disapp);
		}
		else
		{
			String iKnowYou = driver.findElement(By.tagName("strong")).getText();
		    System.out.println(iKnowYou);
		}		
	}

}
