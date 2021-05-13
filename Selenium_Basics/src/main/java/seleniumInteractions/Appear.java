package seleniumInteractions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Appear {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//Url Launching
		driver.get("http://www.leafground.com/pages/appear.html");
		driver.manage().window().maximize();			
		WebDriverWait wait  =new WebDriverWait(driver,Duration.ofSeconds(20));
		
		//TOtal Number of buttons		
		List<WebElement> tbuttons = driver.findElements(By.tagName("button"));
		int  nButton =  tbuttons.size();
		System.out.println("Total No Of Buttons " + nButton);
		 for(WebElement allbuttons : tbuttons ) 
         {
			 if((allbuttons).isDisplayed())
			 {
				 System.out.println(allbuttons.getText());
             }
         }
		 //to Find and display the disappear button
		WebElement button=driver.findElement(By.xpath("//button[@id='btn']//b[1]"));
		wait.until(ExpectedConditions.visibilityOf(button));	
		System.out.println(button.isDisplayed());		
		if(button.isDisplayed()==true)
		{
			String disapp=driver.findElement(By.id("btn")).getText();
			System.out.println("Disappeared Button is : "+disapp);
		}         

	}

}
