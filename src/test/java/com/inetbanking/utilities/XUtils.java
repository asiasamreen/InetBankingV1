package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;


public class XUtils {
	//public static String path; 
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellType type;


	public static int  getRowCount(String xlfile,String Sheet) throws IOException
	{
		int rowCount =0;
		fis = new FileInputStream(xlfile);
		try {
			wb = new XSSFWorkbook(fis);
			sheet=wb.getSheet(Sheet);
			rowCount = sheet.getLastRowNum();
			fis.close();
			wb.close();
		}
		catch(Exception e) {
			System.out.println("Unable to open the file " + e.getMessage());
		}
		return rowCount;
	}

	public static int getColumnCount(String xlfile,String Sheet)
	{
		int columnCount=0;
		try {
			fis = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fis);
			sheet=wb.getSheet(Sheet);
			columnCount = sheet.getRow(1).getLastCellNum();
			fis.close();
			wb.close();

		} catch (Exception e) {
			System.out.println("Unable to open the file " + e.getMessage());
		}
		return columnCount;
	}

	public static String  getData(String xlfile,String Sheet, int r, int c)//reading from excel
	{
		String data = " ";
		try {
			fis = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fis);
			sheet=wb.getSheet(Sheet);
			row= sheet.getRow(r);
			cell = row.getCell(c);
			DataFormatter df = new DataFormatter();
			//data= cell.getStringCellValue();
			data = df.formatCellValue(cell);


		} catch (Exception e) {
			System.out.println("Unable to open the file " + e.getMessage());
		}
		return data;
	}
	//writing to excel,creating extra columns in the same sheet
	//used when reading a dynamic table ans writing it to the excel sheet.
	public static void  writeNewColumnData(String xlfile,String Sheet ,int rownum , int colnum,String data)
	{
		
		try {
			File file = new File(xlfile);
			if(!file.exists())
			{
				wb = new XSSFWorkbook(fis);
				fos= new FileOutputStream(xlfile);
				wb.write(fos);
			}
			fis = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fis);

			if(wb.getSheetIndex(sheet)==-1)
			{
				wb.createSheet(Sheet);
			}

			sheet=wb.getSheet(Sheet); 

			if(sheet.getRow(rownum)==null)
			{
				sheet.createRow(rownum);
			}
			row = sheet.getRow(rownum);
			if(row.getCell(colnum)==null)
			{
				row.createCell(colnum);
			}
			cell = row.getCell(colnum);
			cell.setCellValue(data);
			fis.close();
			fos = new FileOutputStream(xlfile);
			wb.write(fos);
			fos.close();
		}
		catch(Exception e)
		{
			System.out.println("uanble to write to excel " + e.getMessage());
		}
	}


	public static void writedata(String xlfile,String sheetname) {
		try {							
			fis = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetname);
			int totalrows = sheet.getLastRowNum();//number of rows

			int toatlcolumns = row.getLastCellNum();//number of  columns
			for(int i=0;i<=totalrows;i++)
			{
				row=sheet.getRow(i);
				if(row.getRowNum()==0)
					row.createCell(toatlcolumns).setCellValue("Continent");
				//row.getCell(toatlcolumns).setCellValue("Continent");
				else
					row.createCell(toatlcolumns).setCellValue("Europe");
				//row.getCell(toatlcolumns).setCellValue("Europe");
			}
			fis.close();
			fos = new FileOutputStream(xlfile);
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			System.out.println("Unable to open the file " + e.getMessage());
		}
	}


		public static CellType getCellType(String xlfile,String Sheet, int r ,int c)
		{
			try {
				fis = new FileInputStream(xlfile);
				wb = new XSSFWorkbook(fis);
				sheet=wb.getSheet(Sheet);
				row=sheet.getRow(r);
				cell = row.getCell(c);
				type = cell.getCellType();
				fis.close();
				wb.close();

			} catch (Exception e) {
				System.out.println("Unable to open the file " + e.getMessage());
			}
			return type;
		}



	}


