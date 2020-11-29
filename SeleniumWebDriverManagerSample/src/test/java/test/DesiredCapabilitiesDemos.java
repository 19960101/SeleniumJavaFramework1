package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemos {

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		DesiredCapabilities ceps = new DesiredCapabilities();
		ceps.setCapability("ignoreProectedModeSettings", true);

		System.out.println("projectPath : " + projectPath);
		System.setProperty("webdriver.ie.driver", projectPath + "\\drivers\\Internetexplorerdriver\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation step by step");

		// click on search button
		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.close();
		driver.quit();
	}

}
