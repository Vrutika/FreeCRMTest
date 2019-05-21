package com.crm.qa.testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.css.ParsedValue;

public class ExcelRW {
	XSSFWorkbook wb;
	FileInputStream fis;
	public ExcelRW(String filePath) throws Exception{
//		create an input stream from excel
		 fis= new FileInputStream(filePath);
		
//		load the input stream to a workbook object
		 wb= new XSSFWorkbook(fis);
	}
	
	
	public int getRow(String sheetname){
		XSSFSheet sheet = wb.getSheet(sheetname);		
		return sheet.getLastRowNum();
		
	}
	
	public int getColum(String sheetname){
		XSSFSheet sheet = wb.getSheet(sheetname);	
		return sheet.getRow(0).getLastCellNum();
		
	}
	
	public String readCell(String sheetname,int row,int col){
		XSSFSheet sheet = wb.getSheet(sheetname);
		 Cell cell = sheet.getRow(row).getCell(col);
		 String celltext = "";
		 
		 switch(cell.getCellType()){
		 case NUMERIC:
		    celltext =String.valueOf(cell.getNumericCellValue());
		    return celltext;
		 
		 case STRING:
			 celltext = cell.getStringCellValue();
		  return celltext;
		 
		 }
		 /*if(cell.getCellType()==STRING){
			 celltext=cell.getStringCellValue();
		 }else if(cell.getCellType()==NUMERIC){
			  celltext=String.valueOf(cell.getNumericCellValue());
		 }else if(cell.getCellType()==BLANK){
			 celltext="";
		 }
		return celltext;*/
	//	 return cell;
		return celltext;
	}
	
	/*
	 * public void writeCell(String sheetname,int row,int col,String value){
	 * XSSFSheet sheet = wb.getSheet(sheetname);
	 * sheet.getRow(row).getCell(col).setCellValue(value); }
	 */
	public void saveandClose(String fpath) throws Exception{
		FileOutputStream fos = new FileOutputStream(fpath);
//		save and close
		wb.write(fos);
		fis.close();
		fos.close();	
	}

}
