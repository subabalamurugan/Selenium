package shoppingApplications;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.lang.Thread;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

	public static void main(String[] args)throws InterruptedException
	{
		//Go to https://www.redbus.in/ in chrome
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.findElement(By.id("src")).sendKeys("c");
		Thread.sleep(1000);
		
		//Type C in the FROM text box
		//driver.findElement(By.xpath("//input[@class='db']")).click();
		
		//driver.findElement(By.xpath("//li[@data-no='2']")).sendKeys(Keys.ENTER);		
		
		//driver.findElement(By.xpath("(//i[@class='icon solr-icon icon-ic-city'])[2]")).click();
		driver.findElement(By.xpath("(//i[@class='icon solr-icon icon-ic-city'])[2]")).click();
		Thread.sleep(5000);			
		
		//Type in the Destination text box
		driver.findElement(By.id("dest")).sendKeys("b");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//i[@class='icon solr-icon icon-ic-city'])[1]")).click();
		//driver.findElement(By.xpath("//td[@class='next']/button")).click();*/
		driver.findElement(By.xpath("//td[@class='next']/button")).click();
		//Calendar
		driver.findElement(By.xpath("(//table[@class='rb-monthTable first last']//tr//td[@class=\"wd day\"])[1]")).click();
		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(5000);
        WebElement findElement = driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']/span"));
		String text = findElement.getText();
		System.out.println("Total No of buses" + " " + text );
		//Sleeper Buses
		driver.findElement(By.xpath("//i[@class='icon icon-close c-fs']")).click();
		driver.findElement(By.xpath("(//input[@id='bt_SLEEPER']/following-sibling::label)[1]")).click();
		Thread.sleep(5000);
		WebElement sleeper = driver.findElement(By.xpath("//span[@class='f-bold busFound']"));
		String sleepdisp = sleeper.getText();
		System.out.println("sleeper buses are"+ " "+ sleepdisp);
        //Ac Buses
		driver.findElement(By.xpath("(//input[@id='bt_AC']/following-sibling::label)[1]")).click();
		Thread.sleep(5000);
		WebElement sleeperandac = driver.findElement(By.xpath("//span[@class='f-bold busFound']"));
		String slacdisp = sleeperandac.getText();
		System.out.println("sleeper and ac bus are"+ " "+  slacdisp);
		//Fare		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Fare']")).click();
		WebElement sleeperandaccost = driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[1]"));
		String fare = sleeperandaccost.getText();
		System.out.println("Fare of Bus"+ " "+ fare);
	}


	}



