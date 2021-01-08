package action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import CssSelectors.Selectors;

public class Action extends Selectors{

	WebDriver driver;

	public void navigateURL(String URL) {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		// Navigate to mail.google.com
		driver.get(URL);
	}

	public void waitDriverForGivenSec(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public void loginGmail() {
		// enter emailid
		driver.findElement(By.id("identifierId")).sendKeys("AutomationTestingBasic@gmail.com");

		// click on next button
		driver.findElement(By.id("identifierNext")).click();
	}
	
	public void enterPassword()
	{
		
		// enter password
				driver.findElement(By.name("password")).sendKeys("Automation@001");

				// click on next button
				driver.findElement(By.id("passwordNext")).click();
	}
	
	public void composeEmail()
	{
		
		// click on compose button
				driver.findElement(
						By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div"))
						.click();
				
				driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				
				// enter recipients
				driver.findElement(By.name("to")).sendKeys("AutomationTestingBasic@gmail.com");

				//enter subject
				driver.findElement(By.name("subjectbox")).sendKeys("Automation Test");
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				// enter body
			   driver.findElement(By.cssSelector(body)).sendKeys("Automation Test Performed successfully.");

			   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			   
				//click send button
			   
			   driver.findElement(By.cssSelector(body)).click();
	}
	
	public void closeAndQuitDriver()
	{
		driver.close();
		driver.quit();
	}
}
