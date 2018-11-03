package com.javaapi.test.util.func.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

public class TestPoiRead {

	private  static Map<String,String> map= new LinkedHashMap<>();
	public  static Map<String,String> dealMap= new LinkedHashMap<>();

	@Test
	public void testPoiRead() throws Exception {
		read();
	}

	public static void read() throws IOException, FileNotFoundException {
		String filePath = "C:\\Users\\hncw\\Desktop\\东北大区22.xls";
//		String filePath = this.getClass().getResource(file).getPath();
		HSSFWorkbook hss = new HSSFWorkbook(new FileInputStream(new File(
				filePath)));
		HSSFSheet sheetAt = hss.getSheetAt(4);
		iterateRow(sheetAt);
		try {
			dealAddressMap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			System.out.println("cell1==>"+cellStringValue);
			 map.put(cellStringValue, cellStringValue);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void dealAddressMap() throws Exception {
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			String key = entry.getKey();
			try {
				dealAddress(key);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void dealAddress(String cellStringValue) throws Exception {
		String url = getBaiKeUrl(cellStringValue);
		String address = JsoupUtil.getAddress(url);
		String shi = AddressUtil.getShi(address);
		if(shi == null) {
		shi = JsoupUtil.parseFromMap(cellStringValue);
		}
		if("北京市".equals(shi)) {
			shi=null;
		}
		dealMap.put(cellStringValue, shi);
		System.out.println(cellStringValue+"&&=>"+shi);
	}

	private static String getBaiKeUrl(String cellStringValue) {
		String baike = "http://baike.baidu.com/search?word="+cellStringValue;
		return baike;
	}

	private static String getCellStringValue(Cell cell) {
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
