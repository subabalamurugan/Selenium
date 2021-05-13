package waits;

import java.time.Duration;
//import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Fluent_Wait {

	public static void main(String[] args)
	{
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();	
		driver.get("http://leaftaps.com/opentaps");		
		driver.manage().window().maximize();
        //UserName and Password
		driver.findElement(By.xpath("//input[@class='inputLogin']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("(//input[@class='inputLogin'])[2]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//GetTitle
		 System.out.println("Title"+driver.getTitle());
		Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		
		WebElement profile=wait.until(new Function<WebDriver, WebElement>()
		{
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.linkText("CRM/SFA"));
			}

			});
		
		profile.click();		
		}
	}


