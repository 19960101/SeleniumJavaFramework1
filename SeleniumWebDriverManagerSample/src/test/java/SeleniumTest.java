import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		/*
		 * WebDriverManager.firefoxdriver().setup(); WebDriver driver = new
		 * FirefoxDriver();
		 */

		driver.get("http://google.com");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation step by step");

		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		
		int count =listOfInputElements.size();
		System.out.println("count of elements :"+count);
		/*
		 * WebElement textBox = driver.findElement(By.name("q"));
		 * textBox.sendKeys("Automation step by step");
		 */ try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.quit();

	}
}
