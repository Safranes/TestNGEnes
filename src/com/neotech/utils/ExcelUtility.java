package com.neotech.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	
	private static Workbook book;
	private static Sheet sheet;
	
	private static void openExcel(String filePath) {
		
		FileInputStream fileIS;
		
		try {
			fileIS = new FileInputStream(filePath);
			book= new XSSFWorkbook(fileIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
}
