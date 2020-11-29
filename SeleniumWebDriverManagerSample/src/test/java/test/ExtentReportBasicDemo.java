package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportBasicDemo {
	private static WebDriver driver = null;

	public static void main(String[] args) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReport and attach reporter(s)
		ExtentReports extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		// create a toggle for the given test, adds all logs events under it

		ExtentTest test = extent.createTest("GOOGLE SEARCH TEST", "Sample desciption");

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath = " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

		// goto googlee.com
		test.log(Status.INFO, "Starrting the test");
		driver.get("https://google.com");
		test.pass("Navigated to google.com");
		// enter text in search textbox

		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		test.pass("Entered inn search box");
		// click on search button

		// driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test.pass("Pressed keyboard");
		// close browser

		driver.close();
		driver.quit();
		test.pass("closed the browser");
		test.info("Test Completed");
		
		
		ExtentTest test2 = extent.createTest("GOOGLE SEARCH TEST", "Sample desciption");

		System.out.println("projectPath = " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

		// goto googlee.com
		test2.log(Status.INFO, "Starrting the test");
		driver.get("https://google.com");
		test2.pass("Navigated to google.com");
		// enter text in search textbox

		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		test2.pass("Entered inn search box");
		// click on search button

		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test2.fail("Pressed keyboard");
		// close browser

		driver.close();
		driver.quit();
		test2.pass("closed the browser");
		test2.info("Test Completed");
		extent.flush();

	}
}
