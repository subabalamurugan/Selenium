package webdriverCommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
//getUrl
//getTitle
//getCurrentUrL
//getPageSource
public class BrowserCommands {

	public static void main(String[] args)
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();		
	//getURl
		driver.get("http://leafground.com");
		driver.manage().window().maximize();
	//GetTitle
	    System.out.println("Title"+driver.getTitle());
	//getCurrentUrL
		System.out.println("URL"+driver.getCurrentUrl());
	//getPageSource
		System.out.println("URL"+driver.getPageSource());				
    }

}
