package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGListenerDemo {

	@Test
	public void test1() {
		System.out.println("Inside test1");
	}

	@Test
	public void test2() {
		System.out.println("Inside test2");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation step by step");
		driver.findElement(By.xpath("//input[@name='qqq']")).sendKeys("Automation step by step");
	}

	@Test
	public void test3() {
		System.out.println("Inside test3");
		throw new SkipException("this test is skipped");

	}
}
