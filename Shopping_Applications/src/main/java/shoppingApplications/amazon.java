package shoppingApplications;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class amazon {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//1.Launch URL
		driver.get("https://www.amazon.in//");
		driver.manage().window().maximize();			
	    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	    Thread.sleep(5000);
	    System.out.println("Welcome To Amazon");
	    System.out.println("---------------------");
	    
	    //2.Type "one plus 7 pro mobiles" in Search Box and Enter
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one plus 7 pro mobiles",Keys.ENTER);
	    System.out.println("Brand  : One plus 7 pro mobiles");
	    
	    // 3.Print the price of the first resulting mobile
	    String fst = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[3]")).getText();
	    String fstmob=fst.replaceAll("[^0-9]", "");      
        int fstprice=Integer.parseInt(fstmob);
        System.out.println("The price of the first resulting mobile : Rs."+fstprice);
        
        //4.Click on the Mobile (First resulting) image
        driver.findElement(By.xpath("//img[@class='s-image']")).click();
        
        //5.Switch to the new window
        Set<String> allWindows=driver.getWindowHandles();   
        System.out.println("Total no of Windows: "+allWindows.size());
        List<String> fWindow= new ArrayList<String>(allWindows);
        String swindow=fWindow.get(1);
        driver.switchTo().window(swindow);
        
        //6.Print the number of customer ratings
        String ratings = driver.findElement(By.xpath("//span[@id='acrCustomerReviewText']")).getText();
        System.out.println("No of Customer Ratings : "+ratings);
        
        //7.Click 'Add to Cart'
        driver.findElement(By.id("add-to-cart-button")).click();      
        List<String> sWindow= new ArrayList<String>(allWindows);
        String twindow=sWindow.get(1);
        driver.switchTo().window(twindow);
        
        //8.Confirm "Added to Cart" text message appeared
        
        String cnfm="Added to Cart";   
        WebElement load = driver.findElement(By.id("add-to-cart-button"));  
        load.click();       
       // String addedToCart = driver.findElement(By.xpath("//div[@id='attachAddBaseItemSuccessAlert']/div/h4")).getText();
        String addedToCart = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-total-string']//b[1]/preceding::h4[@class='a-alert-heading'][1]")).getText();
        //System.out.print(addedToCart);
        if(cnfm.equalsIgnoreCase(addedToCart))
        
        System.out.println("Confirmed added to cart text message appeared");
       
        
       //9. Click on Proceed to checkout
        driver.findElement(By.xpath("//span[@id='attach-sidesheet-checkout-button']/span[1]/input[1]")).click();
        
        //10.Confirm the title is "Amazon Sign In"
        
        List<String> tWindow= new ArrayList<String>(allWindows);
        String fthwindow=tWindow.get(1);
        driver.switchTo().window(fthwindow);
        System.out.println("Login Page Title :"+driver.getTitle());
        
        
        //11. Click Continue (without entering mobile number/email)
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        
        //12. Verify the error message: Enter your email or mobile phone number
        String email = driver.findElement(By.xpath("(//div[@class='a-alert-content'])[2]")).getText();
        String verify="Enter your email or mobile phone number";
        if(email.equalsIgnoreCase(verify));
         System.out.println("Verified Error Messages");
         
         //13. Close both browsers
        //driver.quit();
	}

}
