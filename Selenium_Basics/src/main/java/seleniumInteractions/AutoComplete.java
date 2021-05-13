package seleniumInteractions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoComplete 
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/autoComplete.html");

		WebElement input=driver.findElement(By.id("tags"));
		input.sendKeys("s");
		Thread.sleep(4000);
		List<WebElement> optionsList=driver.findElements(By.xpath("//*[@id='ui-id-1']/li"));

		System.out.println(optionsList.size());
		
		for (WebElement webElement : optionsList) 
		{

			if(	webElement.getText().equals("Selenium"))
			{
				webElement.click();
				System.out.println(" selected");
				break;
			}
			else
			{
				System.out.println("Not selected");
			}

	  }
	}
}

	
