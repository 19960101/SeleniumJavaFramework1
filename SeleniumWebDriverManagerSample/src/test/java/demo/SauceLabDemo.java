package demo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class SauceLabDemo {
    public static final String USERNAME ="prachetaMalvi";
    public static final String ACCESS_KEY ="f2cb4f88-cea4-469a-b801-abf9f1843d3f";
    public static final String URL ="https://prachetaMalvi:f2cb4f88-cea4-469a-b801-abf9f1843d3f@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	
	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Linux");
		caps.setCapability("version", "latest");
		caps.setCapability("name", "GoogleTest1");
		caps.setCapability("extendedDebugging", "true");
		caps.setCapability("buildNumber", "3.0");
		
		WebDriver driver =new RemoteWebDriver(new URL(URL),caps);
		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Automation step  by step");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		System.out.println("Completed");
		
		driver.quit();
		
	}

}
