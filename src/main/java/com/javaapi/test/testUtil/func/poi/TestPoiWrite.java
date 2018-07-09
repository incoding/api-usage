package com.javaapi.test.testUtil.func.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;


public class TestPoiWrite {


	@Test
	public void testPoiRead() throws Exception {
		TestPoiRead.read();
		write();
	}

	private static void write() throws IOException, FileNotFoundException {
		String post = ".xls";
		String pre = "C:\\Users\\hncw\\Desktop\\东北大区22";
		String filePath = pre + post;
		HSSFWorkbook hss = new HSSFWorkbook(new FileInputStream(new File(
				filePath)));
		HSSFSheet sheetAt = hss.getSheetAt(4);
		iterateRow(sheetAt);
		hss.write(new FileOutputStream(new File(pre+"处理后"+post)));
	}

	private static void iterateRow(HSSFSheet sheetAt) {
		for (Row row : sheetAt) {
			iterateCell(row);
			System.out.println("--");
		}
	}

	private static void iterateCell(Row row)  {
		try {
			Cell cell2 = row.getCell(1);
			String cellStringValue = getCellStringValue(cell2);
			if(row.getCell(0) == null) {
				Cell cell = row.createCell(0);  
				String shi = TestPoiRead.dealMap.get(cellStringValue);
				cell.setCellValue(shi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private static  String getCellStringValue(Cell cell) {
		String cellVal = "";
		if(cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			break;
		case Cell.CELL_TYPE_ERROR:
			break;
		case Cell.CELL_TYPE_FORMULA:
			break;
		case Cell.CELL_TYPE_NUMERIC:
			cellVal = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_STRING:
			cellVal = cell.getStringCellValue();
			break;
		default:
			break;
		}
		return cellVal;
	}


}
