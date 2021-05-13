package seleniumInteractions;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {

	public static void main(String[] args) 
	{WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
    driver.get("http://www.leafground.com/home.html");
	//MoveToElement
   		WebElement link_Home = driver.findElement(By.xpath("//img[@alt='drop']"));
    	Actions actions = new Actions(driver);
    	actions.moveToElement(link_Home).build().perform();   	
    //DragAndDrop	
    	driver.navigate().to("http://www.leafground.com/pages/drop.html");		
    	WebElement From = driver.findElement(By.id("draggable"));
    	WebElement To = driver.findElement(By.id("droppable"));
    	Actions dragdrop = new Actions(driver);
    	//actions.clickAndHold(From).moveToElement(To).release(To).build().perform();
    	dragdrop.dragAndDrop(From, To).build().perform();
    	
    //ClickAndHold    	
    	driver.navigate().to("http://www.leafground.com/pages/selectable.html");
        List<WebElement> selectable= driver.findElements(
				By.xpath("//*[@id='selectable']/li"));
		int listSize=selectable.size();
		System.out.println(listSize);	
		Actions clickHold= new Actions(driver);
		clickHold.clickAndHold(selectable.get(0));
		clickHold.clickAndHold(selectable.get(1));
		clickHold.clickAndHold(selectable.get(2));
		clickHold.build().perform();
    //Release   
        driver.navigate().to("http://www.leafground.com/pages/sortable.html");
		
		List<WebElement> elements=driver.findElements(By.xpath("//*[@id='sortable']/li"));
		
		WebElement fromElement=elements.get(6);
		WebElement toElement=elements.get(0);
		
		Actions actions1= new Actions(driver);
		
		actions1.clickAndHold(fromElement);
		actions1.moveToElement(toElement);
		actions1.release(toElement);
		actions1.build().perform();
	}

}
