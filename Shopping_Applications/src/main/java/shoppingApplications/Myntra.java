package shoppingApplications;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.lang.Integer;
import java.lang.Thread;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Myntra {

	public static void main(String[] args) throws InterruptedException
	{
		//Open https://www.myntra.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		//Adding wait 
	    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Mouse over on women
		 
         Actions actions = new Actions(driver);		
         WebElement mover=driver.findElement(By.xpath("(//a[@class='desktop-main'])[2]"));
         actions.moveToElement(mover).perform();
         System.out.println("Mouse Over");
         
        //Click Jackets & Coats
     	
         driver.findElement(By.linkText("Jackets & Coats")).click();
         System.out.println("Jackets & Coats Click");
         Thread.sleep(5000);
         
         //Total Item
         String item=driver.findElement(By.xpath("//span[@class='title-count']")).getText();;
         System.out.println("Jackets and Coats "+item);
         String item1=item.replaceAll("[^0-9]", "");      
         int itemint=Integer.parseInt(item1);
         System.out.println("Total Item"+itemint);
         
         // Validate the sum of categories count matches
         
         driver.findElement(By.xpath("//span[text()='Categories']")).click();
         String jacketsnumber = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
         
         System.out.println("Jackets Total "+jacketsnumber); 
         String coatsnumber = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
         System.out.println("Coats Toal "+coatsnumber);        
         String jCcatcount;
         int jcint,catsum=0;
         List<WebElement> allCBox = driver.findElements(By.xpath("//span[@class='categories-num']"));
         for(WebElement checkbox : allCBox ) 
         {
             jCcatcount=checkbox.getText().replaceAll("[^0-9]", "");
             jcint=Integer.parseInt(jCcatcount);             
             catsum=jcint+catsum;
          } 
         if(itemint==catsum)
         {
        	 System.out.println("Jackets"+jacketsnumber+"and Coats"+ coatsnumber+"is equal to total count"+catsum);
         }
         
        //Check Coats
         driver.findElement(By.xpath("//label[text()='Coats']")).click();
        // Click + More option under BRAND	
         driver.findElement(By.className("brand-more")).click();
        
         //Type MANGO and click checkbox
         driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("m");
         Thread.sleep(5000);
         driver.findElement(By.xpath("(//label[text()='MANGO'])[2]")).click();
         String mANGOtext = driver.findElement(By.xpath("(//label[text()='MANGO'])[2]")).getText();
         String manGomatch=mANGOtext.replaceAll("[^A-Z,a-z]", ""); 
         Thread.sleep(5000);         
         
        //Close PopUpMenu
        WebElement load= driver.findElementByXPath("//ul[@class='FilterDirectory-list']//label[1]");
        load.click();
        
        // driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]")).click();
         driver.findElementByXPath("//div[@class='FilterDirectory-titleBar']//span").click();

      //Confirm all the Coats are of brand MANGO
       String mANGO = driver.findElement(By.xpath("//div[text()='MANGO']")).getText();
       if(manGomatch.equals(mANGO))
        	 System.out.println("Confirm all the Coats are of brand MANGO");
         else
        	 System.out.println("Confirm all the Coats are of brand MANGO");
		   
		//Sort By Special Discount		    
			Actions actions1 = new Actions(driver);	
			WebElement sort=driver.findElementByClassName("sort-sortBy");
	        actions1.moveToElement(sort).perform();	         
			driver.findElementByXPath("//label[text()='Better Discount']").click();
		 
		//Find the price of first displayed item
			String price = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
			System.out.println("The price of first displayed :"+price);
			
		//Mouse over on size of the first items
			Actions actions2 = new Actions(driver);	
			WebElement firstmover=driver.findElement(By.xpath("(//img[@class='img-responsive'])[3]"));
			actions2.moveToElement(firstmover).perform();
	        System.out.println("Mouse Over action performed");

		//closing browser
			driver.close();
	}
	
}
