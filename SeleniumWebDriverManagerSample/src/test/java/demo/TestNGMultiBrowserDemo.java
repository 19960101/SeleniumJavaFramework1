package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {
	String projectPath = System.getProperty("user.dir");
	WebDriver driver = null;

	@BeforeTest
	@Parameters("browserName")
	public void setup(String browserName) {
		System.out.println("Browser name is : " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			System.out.println("projectPath = " + projectPath);
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.out.println("projectPath = " + projectPath);
			System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else {
			System.out.println("projectPath = " + projectPath);
			System.setProperty("webdriver.ie.driver",
					projectPath + "\\drivers\\Internetexplorerdriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

	}

	@Test
	public void test() throws InterruptedException {
		driver.get("https://google.com");
		Thread.sleep(2000);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Test completed successfullly");
	}
}
