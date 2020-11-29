package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static void main(String[] args) {
		getRowCount();
		getCellDataString(0, 0);
		getCellDataNumeric(1, 1);
	}

	public ExcelUtil(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}

	}

	public static int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}
		return rowCount;
	}

	public static int getColCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}
		return colCount;
	}

	public static String getCellDataString(int rowNum, int colNum) {
		String cellData = null;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		} catch (Exception e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}
		return cellData;
	}

	public static void getCellDataNumeric(int rowNum, int colNum) {
		try {
			projectPath = System.getProperty("user.dir");

			workbook = new XSSFWorkbook(projectPath + "/excel/data.xlsx");
			sheet = workbook.getSheet("Sheet1");
			double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		} catch (IOException e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}

	}
}
