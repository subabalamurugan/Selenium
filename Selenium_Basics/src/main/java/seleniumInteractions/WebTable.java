package seleniumInteractions;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;


public class WebTable {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		List<WebElement> tableRows=driver.findElements(By.xpath("//table[@class='display']//tr"));
        System.out.println("Rows : "+tableRows.size());
        List<WebElement> tableCols=driver.findElements(By.xpath("//table[@class='display']//td"));
        System.out.println("Columns : "+tableCols.size());
        List<WebElement> row=driver.findElements(By.xpath("//table[@class='display']//tr[3]/td[2]"));
        for(WebElement eachrow:row)
        {
        System.out.println("Value Of Learn to interact with Elements : "+eachrow.getText());
        }
        List<Integer> listRow=new ArrayList<Integer>(); 
        for(int i=1;i<tableRows.size();i++)
        {
        	WebElement rows=tableRows.get(i);
        	tableCols=rows.findElements(By.tagName("td"));
        	String text=tableCols.get(1).getText();
        	String num=text.replaceAll("[^\\d.]", "");
        	int numonly=Integer.parseInt(num);
        	listRow.add(numonly);
        	
        }
        Collections.sort(listRow);
        Integer minvalue=Collections.min(listRow);
        System.out.print("Minimum Value : "+minvalue);
        WebElement mvalueResult=driver.findElement(By.xpath("//td[contains(text(),'"+ minvalue +"%')]"
        		+ "/following-sibling::td/input" ));
        mvalueResult.click();            
       }

	

}
