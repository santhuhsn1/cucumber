package com.sjm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExlDataprovider {
	@DataProvider(name="places")
	public String[][] getData() throws IOException {
		File excelFile = new File("C:\\Users\\User\\eclipse-workspace\\MyAppTest1\\src\\test\\resources\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("place");
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[noOfRows-1][noOfColumns];
		for (int i = 0; i < noOfRows-1; i++) {
		for (int j = 0; j < noOfColumns; j++) {
			DataFormatter df = new DataFormatter();
			data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
		}
		}
		workbook.close();
		fis.close();
		return data;
		 
	}	
	
}