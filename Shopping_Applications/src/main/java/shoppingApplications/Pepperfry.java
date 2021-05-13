package shoppingApplications;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Pepperfry {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		 //1) Go to https://www.pepperfry.com/
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();	
	   driver.get("https://www.pepperfry.com/");
	   driver.manage().window().maximize();			
	   driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	    Thread.sleep(5000);
	    System.out.println("Welcome To PepperFry");
	    System.out.println("---------------------");
	    Thread.sleep(4000);
	  //2) Mouseover on Furniture and click Office Chairs under Chairs
	     Actions actions = new Actions(driver);		
	    WebElement mover=driver.findElement(By.xpath("//div[@id='menu_wrapper']//a"));
        actions.moveToElement(mover).perform();
 
        driver.findElement(By.linkText("Office Chairs")).click();
        System.out.println("Furniture ->Office Chairs");
        Thread.sleep(5000);
		
      //3) click Executive Chairs
        driver.findElement(By.xpath("//h5[text()='Executive Chairs']")).click();
		
      //4) Change the minimum Height to 50 in under Dimensions
        driver.findElement(By.xpath("//input[@class='clipFilterDimensionHeightValue']")).clear();
        driver.findElement(By.xpath("//input[@class='clipFilterDimensionHeightValue']")).sendKeys("50",Keys.ENTER);
		Thread.sleep(4000);
        
	 //5) Add "Galician High Back Executive Chair In Black Colour" chair to Wishlist	
		
	 driver.findElement(By.id("search")).sendKeys("Galician High Back Executive Chair",Keys.ENTER);     
	 Thread.sleep(4000);		 
	 driver.findElement(By.xpath("(//div[contains(@class,'clip-prd-hrt pf-col')]//a)[2]")).click();
	 System.out.println("Galician High Back Executive Chair(Black)-> Added to Wishlist");		
		 
	 //6) Mouseover on Bedroom and Click Study tables	   
	    
	        WebElement movbed=driver.findElement(By.xpath("(//div[@id='menu_wrapper']//a)[3]"));
	        actions.moveToElement( movbed).perform();	        
	        driver.findElement(By.xpath("//div[@id='meta-bedroom']/div[1]/div[4]/div[2]/div[3]/a[1]")).click();
	        System.out.println("BedRoom->Study table Click");
	        Thread.sleep(5000);
	        
     //7) Select Spacewood as Brand
	        driver.findElement(By.xpath("//label[text()='Spacewood']")).click();     
	   
	//8) Select Price as 7000 to 8000		              
	        
	        driver.findElement(By.xpath("//li[@data-search='7000-8000']//label[1]")).click();
	       WebElement price=driver.findElement(By.xpath("//*[@id='mCSB_11_container']/li[2]/label"));
	        price.click();      
	        	      
	        
	//9) Add "SOS Carter Study Table In Lorraine Walnut & Silver Grey Finish
			//" to Wishlist
		 
	         driver.findElement(By.id("search")).sendKeys("SOS Carter Study Table in Lorraine walnut & silver grey Finish",Keys.ENTER);     
			 Thread.sleep(4000);			
			 driver.findElement(By.xpath("//a[@data-productname='SOS Carter Study Table in Lorraine walnut & silver grey Finish']")).click();
            
	//10,11)Navigate and Verify
			
		 driver.findElement(By.xpath("//span[@class='header-nav-icon']//span")).click();             
		 String wishcount = driver.findElement(By.xpath("(//span[@class='item_count'])[2]")).getText();
         System.out.println("My Wishlist :"+wishcount);
         Thread.sleep(3000);           
         //Close Add
         driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
         driver.findElement(By.xpath("//span[contains(@class,'wewidgeticon we_close')]")).click();
         driver.switchTo().defaultContent();
         Thread.sleep(2000);
     //12) Move Table only to Cart from Wishlist
           driver.findElement(By.xpath("//a[@class='mini-userwishlist active']")).click();     
         // WebDriverWait wait1 = new WebDriverWait(driver, 10);
         // WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='action_block']//a")));
          //element1.click(); 
          driver.findElement(By.xpath("//div[@class='action_block']//a")).click();
     //13) Click Proceed to Pay Securely                
        driver.findElement(By.xpath("//div[@class='minicart_footer']//a[1]")).click();
        
	 //14) Enter Pincode as 600028 in Delivery & Assembly Details and click Go
	        driver.findElement(By.className("order_summary_pincode")).sendKeys("600028");
	        
	  //15) Click Place Order
	        driver.findElement(By.id("pin_check")).click();
	        driver.findElement(By.xpath("//a[@href='https://www.pepperfry.com/checkout/onepage/']")).click();
	        
	   //16) Capture a screenshot by Clicking on Order Summary
	          File copy = driver.getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(copy, new File("./Ass_Week4/snaps_pepper.jpg"));
	        System.out.println("Snapshots are copied");
	    //16) Close the browser 
	        driver.close();
	        
	        
	       
		
		

		
		
		
		

	}

}
