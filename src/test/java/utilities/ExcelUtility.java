package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	private FileInputStream fis;
	private String path;

	public ExcelUtility(String path) {
		super();
		this.path = path;
	}

	public int getNumbersOfRows(String sheetName) throws IOException {

		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
	}

	public int getNubersOfColumns(String sheetName, int rowNum) throws IOException {

		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;

	}

	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {

		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);

		DataFormatter formatter = new DataFormatter();
		String data;

		try {

			data = formatter.formatCellValue(cell);
		} catch (Exception e) {

			data = "";
		}

		workbook.close();
		fis.close();
		return data;

	}

}
