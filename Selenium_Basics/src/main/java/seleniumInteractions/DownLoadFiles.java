package seleniumInteractions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownLoadFiles {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
        driver.get("http://www.leafground.com/pages/download.html");
		
		WebElement downloadLink=driver.findElement(
				By.linkText("Download xls"));
		
		downloadLink.click();
		
		Thread.sleep(3000);
		
		
		File fileLocation= new File("C:\\Users\\Bala\\Downloads");
		
		File[] totalFiles=fileLocation.listFiles();
		
		for (File file : totalFiles) 
		{
			
			if(file.getName().equals("testleaf.xls"))
			{
				System.out.println("File is downloaded");
				break;
			}
		}
		
		
		
		

	}

}
