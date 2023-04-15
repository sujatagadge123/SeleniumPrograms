	package TestNGPrgms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {

	public static Object[][] readData() {

		FileInputStream fis;
		Object[][] data = new Object[3][2];
		String fileName = "C:\\Users\\Administrator\\eclipse-workspace\\SleniumPrograms\\src\\data_provider_with_excel\\InputData.xlsx";
		XSSFWorkbook workbook;

		try {
			fis = new FileInputStream(fileName);

			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			int rowCount = sheet.getLastRowNum();

			for (int rowNo = 1; rowNo <= rowCount; rowNo++) {

				int cellCount = sheet.getRow(rowNo).getLastCellNum();
				for (int cellNo = 0; cellNo < cellCount; cellNo++) {
					data[rowNo - 1][cellNo] = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
				}
			}
			workbook.close();

		} catch (FileNotFoundException fnf) {
			System.out.println("File name is not correct");
		} catch (IOException ioe) {
			System.out.println("Not able to read or write, pls check");

		}

		return data;
	}
}
