package com.javaapi.test.testUtil.func.poi;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

public class TestPoi {

	@Test
	public void testPoiRead() throws Exception {
		String file = "testXls.xls";
		String filePath = this.getClass().getResource(file).getPath();
		HSSFWorkbook hss = new HSSFWorkbook(new FileInputStream(new File(
				filePath)));
		HSSFSheet sheetAt = hss.getSheetAt(0);
		iterateRow(sheetAt);
	}

	private void iterateRow(HSSFSheet sheetAt) {
		for (Row row : sheetAt) {
			iterateCell(row);
		}
	}

	private void iterateCell(Row row) {
		for (Cell cell : row) {
			String cellStringValue = getCellStringValue(cell);
			System.out.println(cellStringValue);
		}
	}

	private String getCellStringValue(Cell cell) {
		String cellVal = "";
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
