package com.ninjacrm.generic.fileutilities;

import java.io.FileInputStream;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
	public String readDataFromExcel(String sheetname, int row, int col) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/NinjaCRM.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		String value = wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		wb.close();
		return value;
	}
	
	public int getLastRow(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/sells.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int cnt=0;
		for(int i=0;;i++) {
			try {
				String l = sh.getRow(i).getCell(0).getStringCellValue();
				cnt++;
			}
			catch(Exception e) {
				return cnt-1;
			}
		}
	}
}
