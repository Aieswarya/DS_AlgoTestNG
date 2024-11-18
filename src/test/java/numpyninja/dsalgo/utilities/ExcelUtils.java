package numpyninja.dsalgo.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import numpyninja.dsalgo.constants.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelUtils {
	
public FileInputStream fi;
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;   
	String path;


	public static void getLogin() {

		try {
			Constants constants = new Constants();
			FileInputStream file = new FileInputStream(new File("Data.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			Sheet sheet1 = workbook.getSheet("VALID_LOGIN");
			Row row1 = sheet1.getRow(1);
			Constants.USERNAME = row1.getCell(0).getStringCellValue(); // -- set credential values from properties file
			constants.PASSWORD = row1.getCell(1).getStringCellValue();
			Sheet sheet2 = workbook.getSheet("EDITOR");
			Row row2 = sheet2.getRow(1);
			constants.PYTHON_EDITOR_INPUT = row2.getCell(0).getStringCellValue(); // --set python editor values
			constants.PYTHON_EDITOR_OUTPUT = row2.getCell(1).getStringCellValue();
			workbook.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}

	}
	
	public int getRowCount(String sheetName) throws IOException 
	{
		FileInputStream fi = new FileInputStream(new File("Data.xlsx"));
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;		
	}
	

	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		FileInputStream fi = new FileInputStream(new File("Data.xlsx"));
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}
	
	
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		FileInputStream fi = new FileInputStream(new File("Data.xlsx"));
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		DataFormatter formatter = new DataFormatter();
		String data;
		data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		workbook.close();
		fi.close();
		return data;
	
	
	
	
	}

	

}