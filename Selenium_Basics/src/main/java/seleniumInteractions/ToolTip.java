package seleniumInteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();		
		driver.get("http://www.leafground.com/pages/tooltip.html");
		WebElement name=driver.findElement(By.id("age"));
		String toolTipText=	name.getAttribute("title");
		System.out.println(toolTipText);

	}

}
