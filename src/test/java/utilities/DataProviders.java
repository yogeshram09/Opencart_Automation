package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "loginData")
	public String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "\\testData\\LoginTest.xlsx";

		ExcelUtility excel = new ExcelUtility(path);

		int totalRows = excel.getNumbersOfRows("LoginData");
		int totalColumn = excel.getNubersOfColumns("LoginData", 1);

		String loginData[][] = new String[totalRows][totalColumn];

		for (int i = 1; i <= totalRows; i++) {

			for (int j = 0; j < totalColumn; j++) {

				loginData[i - 1][j] = excel.getCellData("LoginData", i, j);
			}
		}

		return loginData;

	}

	// DataProvider 2
	// Data provider 3

}
