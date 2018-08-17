package com.javaapi.test.testUtil.func.poi.poiUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiUtil {
	private static final SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static HSSFWorkbook readDocument(String filePath) {
		HSSFWorkbook hss = null;
		FileInputStream s = null;
		try {
			s = new FileInputStream(new File(filePath));
			hss = new HSSFWorkbook(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (s != null) {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return hss;
	}

	public static Workbook readDocument2(String filePath) {
		Workbook book = null;
		FileInputStream s = null;
		try {
			try {
				book = new XSSFWorkbook(filePath);
			} catch (Exception ex) {
				book = new HSSFWorkbook(new FileInputStream(filePath));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (s != null) {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return book;
	}
	public static List<List<List<String>>> getAllSheetInfo2(Workbook hssfWorkbook) {
		List<List<List<String>>> list = new ArrayList<>();
		int sheetSize = hssfWorkbook.getNumberOfSheets();
		for (int i = 0; i < sheetSize; i++) {
			Sheet sheetAt = hssfWorkbook.getSheetAt(i);
			List<List<String>> sheetList = getOneSheet2(sheetAt);
			list.add(sheetList);
		}
		return list;
	}

	public static List<List<List<String>>> getAllSheetInfo(HSSFWorkbook hssfWorkbook) {
		List<List<List<String>>> list = new ArrayList<>();
		int sheetSize = hssfWorkbook.getNumberOfSheets();
		for (int i = 0; i < sheetSize; i++) {
			HSSFSheet sheetAt = hssfWorkbook.getSheetAt(i);
			List<List<String>> sheetList = getOneSheet(sheetAt);
			list.add(sheetList);
		}
		return list;
	}

	private static List<List<String>> getOneSheet(HSSFSheet sheetAt) {
		List<List<String>> list = new ArrayList<>();
		int size = sheetAt.getPhysicalNumberOfRows();
		for (int i = 0; i < size; i++) {
			List<String> rowList = getOneRow(sheetAt.getRow(i));
			list.add(rowList);
		}


		return list;
	}

	private static List<List<String>> getOneSheet2(Sheet sheetAt) {
		List<List<String>> list = new ArrayList<>();
		int size = sheetAt.getPhysicalNumberOfRows();
		for (int i = 0; i < size; i++) {
			List<String> rowList = getOneRow2(sheetAt.getRow(i));
			list.add(rowList);
		}


		return list;
	}



	private static List<String> getOneRow(HSSFRow row) {
		List<String> list = new ArrayList<>();
		int cellNum = row.getPhysicalNumberOfCells();
		for (int i = 0; i < cellNum; i++) {
			String cellStringValue = getCellStringValue(row.getCell(i));
			list.add(cellStringValue);
		}
		return list;
	}

	private static List<String> getOneRow2(Row row) {
		List<String> list = new ArrayList<>();
		int cellNum = row.getPhysicalNumberOfCells();
		for (int i = 0; i < cellNum; i++) {
			String cellStringValue = getCellStringValue(row.getCell(i));
			list.add(cellStringValue);
		}
		return list;
	}

	private static String getCellStringValue(Cell cell) {
		String cellVal = "";
		if (cell == null) {
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
			if(DateUtil.isCellDateFormatted(cell)) {
				cellVal= sd.format(cell.getDateCellValue());
			}else {
				cellVal = new BigDecimal(cell.getNumericCellValue()).toString();
			}
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
