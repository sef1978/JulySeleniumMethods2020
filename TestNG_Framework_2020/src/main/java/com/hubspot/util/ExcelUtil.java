package com.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	// book
	public static Workbook book;
	// sheet
	public static Sheet sheet;
	
	// pathname of excel file, right click on the file and go to properties
	public static String TESTDATA_SHEET_DATA = "/Users/sefikaarslan/Documents/workspace/TestNG_Framework_2020"
			+ "/src/main/java/com/hubspot/testdata/HubSpot_TestData.xlsx";

	
	public static Object[][] getTestData(String sheetName){
		try {
			FileInputStream ip = new FileInputStream(TESTDATA_SHEET_DATA);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
			
    Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i = 0; i < sheet.getLastRowNum(); i++) {
				
				for(int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					
					data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				}
			}
             return data;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		     return null;

	}
}
