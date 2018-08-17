package com.javaapi.test.testUtil.func.poi.poiUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import com.javaapi.test.testUtil.func.poi.TestPoi;
import org.testng.collections.Lists;

public class TestPoiUtil {
	@Test
	public void testRead() throws Exception {
		String file = "testXls.xls";
		String filePath = TestPoi.class.getResource(file).getPath();
		HSSFWorkbook readDocument = PoiUtil.readDocument(filePath);
		List<List<List<String>>> allInfo = PoiUtil.getAllSheetInfo(readDocument);
	}
	@Test
	public void testRead2() throws IOException {
		String path = "/Users/user/Downloads/";
		Stream<Path> list = Files.list(Paths.get(path));
		List<String> lines = Lists.newArrayList();
		final Integer[] index = {0};


		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet("sheet1");
		HSSFRow createRow = sheet.createRow(index[0]++);
		createRow.createCell(0).setCellValue("");
		createRow.createCell(1).setCellValue("");


		list.forEach((tmpPath)->{
			if (tmpPath.toString().contains("xlsx")) {
				System.out.println("s = " + tmpPath.toString());
				Workbook readDocument = PoiUtil.readDocument2(tmpPath.toString());
				List<List<List<String>>> allInfo = PoiUtil.getAllSheetInfo2(readDocument);
				List<List<String>> lists = allInfo.get(0);
				int i = 0;
				for (List<String> strings : lists) {
					if (i== 0) {
						i++;
						continue;
					}
					HSSFRow row = sheet.createRow(index[0]++);
					row.createCell(0).setCellValue(strings.get(0));
					row.createCell(1).setCellValue(strings.get(1));

					lines.add(strings.get(0) + "," + strings.get(1));
				}
			}

		});

		String filePath = path + "/all.txt";
		String filePath2 = path + "/all.xlsx";

		FileUtils.writeLines(new File(filePath), lines);
		try {
			FileOutputStream os = new FileOutputStream(filePath2);
			wb.write(os);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
