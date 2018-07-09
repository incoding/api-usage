package com.javaapi.test.testUtil.func.poi.poiUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import com.javaapi.test.testUtil.func.poi.TestPoi;

public class PoiCreate {
	
	@Test
	public void create() {// 创建Excel的工作书册 Workbook,对应到一个excel文档  
		Random rd = new Random();
		int nextInt = rd.nextInt(1000);
		String filePath = TestPoi.class.getResource("").getPath()+nextInt+".xls";
String string = "/home/kk/git/apiTest/src/main/java/com/javaapi/test/test/testUtil/poi/poiUtil/";
filePath= string +nextInt+".xls";
	    HSSFWorkbook wb = new HSSFWorkbook();  
	    
	    // 创建Excel的工作sheet,对应到一个excel文档的tab  
	    HSSFSheet sheet = wb.createSheet("sheet1");  
	  
	    // 设置excel每列宽度  
	    sheet.setColumnWidth(0, 4000);  
	    sheet.setColumnWidth(1, 3500);  
	  
	    // 创建字体样式  
	    HSSFFont font = wb.createFont();  
	    font.setFontName("Verdana");  
	    font.setBoldweight((short) 100);  
	    font.setFontHeight((short) 300);  
	    font.setColor(HSSFColor.BLUE.index);  
	  
	    // 创建单元格样式  
	    HSSFCellStyle style = wb.createCellStyle();  
	    style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
	    style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
	    style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);  
	    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
	  
	    // 设置边框  
	    style.setBottomBorderColor(HSSFColor.RED.index);  
	    style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
	    style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
	    style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
	    style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
	  
	    style.setFont(font);// 设置字体  
	  
	    // 创建Excel的sheet的一行  
	    HSSFRow row = sheet.createRow(0);  
	    row.setHeight((short) 500);// 设定行的高度  
	    // 创建一个Excel的单元格  
	    HSSFCell cell = row.createCell(0);  
	  
	    // 合并单元格(startRow，endRow，startColumn，endColumn)  
	    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));  
	  
	    // 给Excel的单元格设置样式和赋值  
	    cell.setCellStyle(style);  
	    cell.setCellValue("hello world");  
	  
	    // 设置单元格内容格式  
	    HSSFCellStyle style1 = wb.createCellStyle();  
	    style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("h:mm:ss"));  
	  
	    style1.setWrapText(true);// 自动换行  
	  
	    row = sheet.createRow(1);  
	  
	    // 设置单元格的样式格式  
	  
	    cell = row.createCell(0);  
	    cell.setCellStyle(style1);  
	    cell.setCellValue(new Date());  
	  
	    // 创建超链接  
	    HSSFHyperlink link = new HSSFHyperlink(HSSFHyperlink.LINK_URL);  
	    link.setAddress("http://www.baidu.com");  
	    cell = row.createCell(1);  
	    cell.setCellValue("百度");  
	    cell.setHyperlink(link);// 设定单元格的链接  
	  
	    try {
			FileOutputStream os = new FileOutputStream(filePath);  
			wb.write(os);  
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}
	@Test
	public void testCreateSelf() throws Exception {
		Random rd = new Random();
		int nextInt = rd.nextInt(1000);
		String string = "/home/kk/git/apiTest/src/main/java/com/javaapi/test/test/testUtil/poi/poiUtil/";
		String filePath = string + nextInt + ".xls";
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet("sheet1");
		HSSFRow createRow = sheet.createRow(0);
		createRow.createCell(0).setCellValue("银行名称");
		createRow.createCell(1).setCellValue("银行卡号");
		createRow.createCell(2).setCellValue("创建时间");
		createRow.createCell(3).setCellValue("提现金额");
		createRow.createCell(4).setCellValue("");
		createRow.createCell(5).setCellValue("是否成功");
		createRow.createCell(6).setCellValue("到帐时间");
		createRow.createCell(7).setCellValue("银行交易流水");
		try {
			FileOutputStream os = new FileOutputStream(filePath);
			wb.write(os);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除行内容，以及删除整行
	 */
	@Test
	public void testShiftRow() throws Exception {
		Random rd = new Random();
		int nextInt = rd.nextInt(1000);
		String string = "/home/kk/git/apiTest/src/main/java/com/javaapi/test/test/testUtil/poi/poiUtil/";
		String filePath = string + nextInt + ".xls";
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet("sheet1");
		int size =10;
		for (int i = 0; i < size; i++) {
			HSSFRow createRow = sheet.createRow( i);
			createRow.createCell(0).setCellValue(String.valueOf(i));
			if(i==5) {
//				sheet.removeRow(createRow);
				//从当前行，到最后行整体上移一行。
				// 但是这么写不生效，新生成时候，当前行就是最后行 
				sheet.shiftRows(i, sheet.getLastRowNum(), -1);
			}
			
		}
		try {
			FileOutputStream os = new FileOutputStream(filePath);
			wb.write(os);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
