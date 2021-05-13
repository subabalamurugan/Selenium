package waits;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Implicity_Wait {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps");		
		driver.manage().window().maximize();
        //UserName and Password
		driver.findElement(By.xpath("//input[@class='inputLogin']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//GetTitle
	    System.out.println("Title"+driver.getTitle());
	    driver.quit();	
	}

}
