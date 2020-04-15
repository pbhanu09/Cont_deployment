package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	private static String data="";
	XSSFWorkbook wb;
	XSSFSheet ws;
	
	public  ExcelReader(String filepath) throws IOException
	{
		try {
				File src = new File(filepath);
			 
				FileInputStream fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
				
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		 
		wb.close();
	}
	
	public String getData(int SheetNo ,int row, int col)
	{
		ws = wb.getSheetAt(SheetNo);
		data = ws.getRow(row).getCell(col).getStringCellValue();
		return data;
		
	}
	
}
