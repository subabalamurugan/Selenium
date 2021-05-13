package shoppingApplications;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Nykaa 
{
	public static void main(String[] args)throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//1.Launch URL
		driver.get( "https://www.nykaa.com/");
		driver.manage().window().maximize();			
	    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	    Thread.sleep(5000);
	    System.out.println("Welcome To Nykaa");
	    System.out.println("-----------------------------------------------");	
	    //2. Enter text as Perfumes in Search Bar and press Enter
	    driver.findElement(By.id("SearchInputBox")).sendKeys("Perfumes",Keys.ENTER);
	    System.out.println("Perfumes");
	    
	    //3 & 4. Get The Names and Price Of all the Perfumes Displayed   
	   
	    List<WebElement> perfumenames = driver.findElements(By.xpath("//div[@class='m-content__product-list__title']//span"));
	    System.out.println("No of Perfumes Names: "+perfumenames.size()); 
	    List<WebElement> perfumeprice = driver.findElements(By.xpath("//span[@class='post-card__content-price-offer']"));
        List<String> all_names_perfumes=new ArrayList<String>();
        List<Integer> all_item_price=new ArrayList<Integer>();
        String listarray;
        int listarray1; 
        System.out.println("-----------------------------------------------");
        System.out.println("Perfume Names");
        System.out.println("-----------------------------------------------");
        if(perfumenames.size()==perfumeprice.size())
         {
	        for(int i=0; i<perfumeprice.size(); i++)
			    {
	        	all_names_perfumes.add(perfumenames.get(i).getText());
	        	listarray=perfumeprice.get(i).getText().replaceAll("[^0-9]","");
		    	int price=Integer.parseInt(listarray);
		    	all_item_price.add(price);
		    	
		    	System.out.println(perfumenames.get(i).getText()+" ( Rs : "+price+" )");
               }
	        System.out.println("-----------------------------------------------");
         }
      
        //5. Click on the Highest Price Perfume 
       int maxvalue=Collections.max(all_item_price); 
     
       System.out.println("Highest Value : "+maxvalue);
       System.out.println("-----------------------------------------------");
       for(int i=0; i<perfumeprice.size(); i++)
	    {
    	  listarray1=all_item_price.get(i);    	  
    	  if(maxvalue==listarray1)
    	  {    	  	
    		  driver.findElement(By.xpath("(//span[text()='"+maxvalue+"'])")).click();
    	  }  
	    }
       Set<String> allWindows=driver.getWindowHandles();       
       List<String> fWindow= new ArrayList<String>(allWindows);
       String swindow=fWindow.get(1);
       driver.switchTo().window(swindow);
        Thread.sleep(5000);
      
       // 6.Click on Add To Bag
       driver.findElement(By.xpath("//button[contains(@class,'combo-add-to-btn prdt-des-btn')][1]")).click();       
        String itemAddedTo = driver.findElement(By.xpath("//div[text()='Item added to cart']")).getText();
      
      
       //7. verify Message Product Added To the bag       
       String cnfm="Item added to cart";
       if(cnfm.equalsIgnoreCase(itemAddedTo))
    	   System.out.println("verified Message Product Added To the bag");
       System.out.println("-----------------------------------------------");
       Thread.sleep(5000);
       //8. Click on bag Icon       
       driver.findElement(By.className("AddBagIcon")).click();       
       List<String> tWindow= new ArrayList<String>(allWindows);
       String fthwindow=tWindow.get(1);
       driver.switchTo().window(fthwindow); 
       
       //9. Get the Grand Total Value
       String  total= driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
       String total1=total.replaceAll("[^0-9]", "");      
       int gtotal=Integer.parseInt(total1);
       System.out.println("Grand Total : Rs."+gtotal);
       System.out.println("-----------------------------------------------");
       
       //10. Click on Proceed
       driver.findElement(By.xpath("//button[@type='button']//span[1]")).click();
      
       // 11. Click on Continue as Guest
       driver.findElement(By.xpath("(//div[contains(@class,'login-auth-container prl20')]//button)[3]")).click();
     
       // 12. Fill all the Fields in Address 
       driver.findElement(By.name("name")).sendKeys("subbulakshmi");
       driver.findElement(By.name("email")).sendKeys("lakshmi.pers@gmail.com");
       driver.findElement(By.name("phoneNumber")).sendKeys("6380241341");
       driver.findElement(By.name("pinCode")).sendKeys("600059");
       //driver.findElement(By.xpath("//textarea[@class='textarea-control prl10']"));
       driver.findElement(By.tagName("textarea")).sendKeys("NGO Colony");
       driver.findElement(By.xpath("//button[@type='submit']")).click();
       
       // 13. Click on Paynow
       driver.findElement(By.xpath("//div[@class='prl10 pb10']//button[1]")).click();
      
       // 14. Get the Error Message displayed in Red Color
       String cardfield = driver.findElement(By.xpath("//span[@class='field-error']")).getText();
       System.out.println("Card Number : "+cardfield);
       String expirydate = driver.findElement(By.xpath("(//span[@class='field-error'])[2]")).getText();
       System.out.println("Expiry Date is : "+expirydate);
       String cvv = driver.findElement(By.xpath("(//span[@class='field-error'])[3]")).getText();
       System.out.println("cvv is : "+cvv);
       System.out.println("-----------------------------------------------");
       //15. close the current browser
       
     // driver.quit();
       //End
      
	}
}
