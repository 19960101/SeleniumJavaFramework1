package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	@Test(dataProvider = "testdata")
	public void test(String userName, String password) throws InterruptedException {
		System.out.println(userName + " | " + password);

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);
		driver.close();
	}

	@DataProvider(name = "testdata")
	public Object[][] getData() {
		String excelPath = "C:\\Users\\ANSHUL\\eclipse-workspace\\MYSeleniumProj\\SeleniumWebDriverManagerSample\\excel\\data.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}

	WebDriver driver = null;

	@BeforeTest
	public void setupTest() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath = " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	public static Object[][] testData(String excelPath, String sheetName) {
		ExcelUtil excel = new ExcelUtil(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		Object data[][] = new Object[rowCount - 1][colCount];
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				data[i - 1][j] = cellData;
			}
		}
		return data;
	}
}
