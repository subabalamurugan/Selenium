package seleniumInteractions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
public class CheckBox {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
			
		//Select the languages that you know?
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		   
		//isSelected
		WebElement select=driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following::input"));
		
		if(select.isSelected())
		  {
		   	System.out.println("Selenium is Selected");
		  }
		
		//isEnabled 
		WebElement enabled=driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following::input"));
		boolean isEnabled = enabled.isEnabled();  
		if(isEnabled == true)
		 {
			enabled.click();
		 }
		
		//isDisplayed 
		WebElement displayed=driver.findElement(By.xpath("//div[@id='contentblock']/section/div[3]/div[2]/input"));
		boolean isDisplayed = displayed.isDisplayed();  
		if(isDisplayed == true)
		 {
			displayed.click();
		 }

		 
		  //Select All checkbox       
	     
	     
	    List<WebElement> chBoxes = driver.findElements(By.xpath("//div[@id='contentblock']/section/div[4]//input"));    
		System.out.println("CheckBoxes : "+chBoxes.size()); 
		for(int i=0; i<chBoxes.size(); i++) 
		{  

	        chBoxes.get(i).click();  

		}	
	  }

	}


