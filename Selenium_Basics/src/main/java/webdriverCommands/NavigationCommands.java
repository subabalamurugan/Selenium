package webdriverCommands;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class NavigationCommands {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	  //navigatTo
		driver.navigate().to("http://www.google.co.in");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Selenium"+Keys.ENTER);				
       //Back
		driver.navigate().back();  
      //forward  
        driver.navigate().forward();        

        //Refresh browser  
        driver.navigate().refresh();  
    
        //Closing browser  
        driver.close();   

	}

}
