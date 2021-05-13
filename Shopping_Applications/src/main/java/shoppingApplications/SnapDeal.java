package shoppingApplications;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal 
{

	public static void main(String[] args) throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();			
	    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	    Thread.sleep(5000);
	    System.out.println("Welcome To SnapDeal");
	    System.out.println("---------------------");
	    
	   //Select Mens Fashion->Sports Shoes
	    driver.findElement(By.xpath("//*[@id='leftNavMenuRevamp']/div[1]/div[2]/ul/li[7]/a/span")).click();
	    driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
	    System.out.println("Mens Fashion->Sports Shoes");
	    Thread.sleep(5000);
	    
	    //Get the count of the sports shoes
	    String items = driver.findElement(By.className("category-count")).getText();
	    String item1=items.replaceAll("[^0-9]", "");      
        int itemint=Integer.parseInt(item1);
        System.out.println("Count Of Sports Shoes "+itemint);
        
        //Click Training shoes
        Thread.sleep(6000);
        driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
        Thread.sleep(6000);
        //Low to High
        driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
        
        //To check
        Thread.sleep(5000);
        //List<WebElement> allCBox = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
        List<WebElement> ltohitem = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
        System.out.println("No of Shoes : "+ltohitem.size()); 		 
        List<Integer> all_item=new ArrayList<Integer>();
		String listarray;    
        for(int i=0; i<ltohitem.size(); i++)
		    {
		        //loading text of each element in to array all_elements_text
		    	listarray=ltohitem.get(i).getText().replaceAll("[^0-9]","");
		    	int price=Integer.parseInt(listarray);
		    	all_item.add(price);
               
		    }	
		    System.out.print(all_item);
		   // Collections.sort(all_item);
		    int previousPrice=all_item.get(0);
		    for(int schknum=1;schknum<ltohitem.size()-1;schknum++) 
		    {
		        if(all_item.get(schknum)<previousPrice)
		        {
		            System.out.println("Previous Number : "+previousPrice+"  Next Number "+all_item.get(schknum)+" notSorted");
		            
		        }
		        else
		        {
		            previousPrice=all_item.get(schknum);
		        }

		    }  		    
       
       
           //Select Puma
		    driver.findElement(By.xpath("//button[text()='View More ']")).click();
		    driver.findElement(By.xpath("//label[@for='Brand-Puma']")).click();
		    driver.findElement(By.xpath("//div[text()='APPLY']")).click();
		   //Mouse Hover on puma Blue Training shoes
		   
		    Actions actions = new Actions(driver);	
			WebElement firstmover=driver.findElement(By.xpath("//input[@id='Color_s-Blue']/following-sibling::label[1]"));
			actions.moveToElement(firstmover).perform();
	        System.out.println("Mouse Over action performed for Puma Blue Shoe Brand");
		   
	        Set<String> allWindows=driver.getWindowHandles();
	        System.out.println("Current Windows :"+allWindows.size());
	        
	       //click QuickView button	        
	      
	        List<String> fWindow= new ArrayList<String>(allWindows);
	        Iterator<String> i = fWindow.iterator();
		    String popwnd = i.next();
	        driver.switchTo().window(popwnd);			    
	        System.out.println("Popup Window Opened");
	       
	        //Print the cost and the discount percentage
	        String cost=driver.findElement(By.xpath("//div[contains(@class,'product-price pdp-e-i-PAY-l')]//span[1]")).getText();
	        System.out.println("Cost Of Shoe : Rs. "+cost);
	        String off = driver.findElement(By.xpath("(//div[contains(@class,'product-price pdp-e-i-PAY-l')]//span)[2]")).getText();
	        System.out.println("Percentage of Shoe :"+off);
	        
	        // Take the snapshot of the shoes.
	        File copy = driver.getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(copy, new File("./Ass_Week4/snaps.jpg"));
	        System.out.println("Snapshots are copied");
	        //Close the current window
	        driver.close();
	        // Close the main window
	        driver.quit();
	}

}
