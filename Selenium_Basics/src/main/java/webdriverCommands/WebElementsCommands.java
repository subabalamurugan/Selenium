package webdriverCommands;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

//getAttribute ,getLocation,getSize,getTagName,isDispalyed,isEnabled
public class WebElementsCommands {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	    
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		//getAttribute		
		System.out.println("Attribute : "+driver.findElementByName("username").getAttribute("value"));
		
		//getLocation
		System.out.println("Location of x : "+driver.findElementByName("username").getLocation().getX());
		System.out.println("Location of y : "+driver.findElementByName("username").getLocation().getY());
		
		//getSize	
		System.out.println("Size of width  :"+driver.findElementById("email").getSize().getWidth());
		System.out.println("Size of height :"+driver.findElementById("email").getSize().getWidth());
		
		//getTagName		
		System.out.println("TagName : " +driver.findElementByName("username").getTagName());
		
		//isDispalyed
		System.out.println("isDispalyed : " +driver.findElementByName("username").isDisplayed());
		
		//isEnabled
		System.out.println("isEnabled : " +driver.findElementById("email").isEnabled());
	   
	    //Clear
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		//nexturl
		driver.navigate().to("http://leafground.com/pages/Button.html");
		//getcssValue		
		System.out.println("Background-Color :"+driver.findElementById("color").getCssValue("background-color"));
		//getText
		System.out.println("Get Text :"+driver.findElementById("color").getText());

	}

}
