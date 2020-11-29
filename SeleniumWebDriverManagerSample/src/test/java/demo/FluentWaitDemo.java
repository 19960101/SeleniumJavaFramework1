package demo;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitDemo {

	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws Exception
	{
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation step  by step");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		///driver.findElement(By.linkText("ABCD - NIMH Data Archive - NIH")).click();
		
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

			   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			    	 
			    	 WebElement linkElement =driver.findElement(By.linkText("ABCD - NIMH Data Archive - NIH"));
			      
			    	 if(linkElement.isEnabled())
			    	 {
			    		 System.out.println("Element found");
			    	 }
			    	 
			    	 return linkElement;
			     }
			   });
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
