package seleniumInteractions;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFiles {

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/upload.html");

		WebElement uploadButton=driver.findElement(By.name("filename"));

		uploadButton.click();
		// windows controls begins here

		Thread.sleep(3000);
		String	file="C:\\Users\\Bala\\Downloads\testleaf.xls";

		StringSelection selection = new StringSelection(file);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);


		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
