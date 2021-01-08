package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

public class ApplitoolsDemo {
	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Eyes eyes = new Eyes();
		eyes.setApiKey("wynMtR7Q3yXCZKvApIHF4apLCDH2O9DZllcKNnlbCUY110");

		eyes.open(driver, "Hello world!", "My first Selenium java test", new RectangleSize(800, 600));
		driver.get("https://applitools.com/helloworld");
		eyes.checkWindow("Hello!");

		driver.findElement(By.tagName("button")).click();
		eyes.checkWindow("Click!");

		eyes.close();
		driver.close();
		driver.quit();
	}
}
