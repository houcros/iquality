package com.indra.iquality.dao;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

public class JExcelTest {

	@Test
	public void testJExcelAPI() {
		try {
			Workbook wb = WorkbookFactory.create(new File("jexcelTest.xlsx"));
			Sheet sheet1 = wb.getSheetAt(0);
			Row row0 = sheet1.getRow(0);
			Cell cell00 = row0.getCell(0);
			String content00 = cell00.getRichStringCellValue().getString();
			System.out.println(content00);
			assertEquals("Test 0 0", content00);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
