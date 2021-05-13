package seleniumInteractions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class DropDown {
   
	public static void main(String[] args)
    {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Url Launching
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		// Using Index		
		WebElement selIndex=driver.findElement(By.id("dropdown1"));
		Select sIndex=new Select(selIndex);
		sIndex.selectByIndex(1);
		
		// Using Text
		WebElement selText=driver.findElement(By.name("dropdown2"));
		Select sTExt=new Select(selText);
		sTExt.selectByVisibleText("Appium");
		
		//Using Value
		WebElement selValue=driver.findElement(By.id("dropdown3"));
		Select sValue=new Select(selValue);
		sValue.selectByValue("3");
		
		//Get the Number of DropDown OPtion
		Select selOptions = new Select(driver.findElement(By.xpath("(//div[@class='example']/select)[4]")));
		List<WebElement> options = selOptions.getOptions();
		System.out.println("Number of Dropdown option :"+options.size());
		driver.findElement(By.xpath("(//div[@class='example']/select)[4]")).sendKeys(Keys.TAB);
		
		//Send keys 
		driver.findElement(By.xpath("(//div[@class='example'])[5]")).click();
		driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[5]/select[1]")).sendKeys("Loadrunner"+Keys.ENTER);
		
		//Check Enabled
		boolean enabled = driver.findElement(By.xpath("(//div[@class='example'])[6]/select/option[4]")).isEnabled();
		if (enabled == true ) 
		{
			System.out.println("Select the options are enabled");
		}
		else 
		{
			System.out.println("Select the options are disabled");
		}
			

	}

}
