package seleniumInteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class RadioButton {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	
		driver.get("http://www.leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("yes")).click();
		//isSelected 
		WebElement selected=driver.findElement(By.id("yes"));
		boolean isselected = selected.isSelected();
		if(isselected == false)
		 {
			selected.click();
		 }
		//isEnabled 
		WebElement enabled=driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
		boolean isEnabled = enabled.isEnabled();  
		if(isEnabled == true)
		 {
			enabled.click();
		 }
		//isDisplayed
		WebElement displayed=driver.findElement(By.xpath("(//input[@name='age'])[2]"));
		boolean isDisplayed = displayed.isDisplayed();  
		if(isDisplayed == true)
		 {
			System.out.println("21 to 40 Years Selected");
		 }

		
	

	}

}
