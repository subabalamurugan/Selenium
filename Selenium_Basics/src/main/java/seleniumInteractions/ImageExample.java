package seleniumInteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageExample {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Image.html");
		
	
		WebElement brokenImage=driver.findElement(
				By.xpath("//*[@id='contentblock']/section/div[2]/div/div/img"));
			
		//"naturalWidth" = 0
		
		if(brokenImage.getAttribute("naturalWidth").equals("0"))
		{
			System.out.println(brokenImage.getAttribute("outerHTML")+"The image is broken");
		}
		else
		{
			System.out.println("The image is NOT broken");
		}
		driver.findElement(By.xpath("//img[@src='../images/keyboard.png']")).click();
		
		System.out.println("Click me using mouse");
	}

}
