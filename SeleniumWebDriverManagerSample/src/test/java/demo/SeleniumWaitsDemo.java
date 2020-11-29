package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitsDemo {

	public static void main(String[] args) {
		seleniumWaits();	
	}
	
	public static void seleniumWaits()
	{
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	/*	//implicit
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//250ms
*/		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation step  by step");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		
		//explicit
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcdef")));
		
		driver.findElement(By.name("adcd")).click();
		
		driver.close();
		driver.quit();
	}
}
