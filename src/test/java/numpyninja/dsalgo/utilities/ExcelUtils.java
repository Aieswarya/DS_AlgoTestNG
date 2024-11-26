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


	public static void readExcelData() {

		try {
			Constants constants = new Constants();
			FileInputStream file = new FileInputStream(new File("Data.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			Sheet LOGIN_SHEET = workbook.getSheet("VALID_LOGIN");
			Sheet EDITOR_SHEET = workbook.getSheet("EDITOR");
			Sheet REGISTER_SHEET=workbook.getSheet("REGISTER");
			Sheet ARRAY_PRACTISE_SHEET=workbook.getSheet("ARRAY_PRACTISE");
			Row row1 = LOGIN_SHEET.getRow(1);
			Constants.USERNAME = row1.getCell(0).getStringCellValue(); // -- set credential values from properties file
			constants.PASSWORD = row1.getCell(1).getStringCellValue();
			
			Row row2 = EDITOR_SHEET.getRow(1);
			constants.PYTHON_EDITOR_INPUT = row2.getCell(0).getStringCellValue(); // --set python editor values
			constants.PYTHON_EDITOR_OUTPUT = row2.getCell(1).getStringCellValue();
			
			constants.REGISTER_TEST_PSWD=REGISTER_SHEET.getRow(1).getCell(1).getStringCellValue();
			constants.REGISTER_ALERT_MSG=REGISTER_SHEET.getRow(1).getCell(2).getStringCellValue();
			constants.REGISTER_TEST_USERNAME=REGISTER_SHEET.getRow(1).getCell(0).getStringCellValue();
			constants.REGISTER_TEST_PSWD2=REGISTER_SHEET.getRow(2).getCell(1).getStringCellValue();
			constants.REGISTER_VALIDATION_MSG=REGISTER_SHEET.getRow(2).getCell(2).getStringCellValue();
			
			constants.SEARCH_ARRAY_VALID_CODE=ARRAY_PRACTISE_SHEET.getRow(1).getCell(0).getStringCellValue();
			constants.MAX_CONS_ONES_VALID_CODE=ARRAY_PRACTISE_SHEET.getRow(2).getCell(0).getStringCellValue();
			constants.FIND_EVEN_NUM_OF_DIGITS_VALID_CODE=ARRAY_PRACTISE_SHEET.getRow(3).getCell(0).getStringCellValue();
			constants.SQUARES_OF_SORTED_ARRAY_VALID_CODE=ARRAY_PRACTISE_SHEET.getRow(4).getCell(0).getStringCellValue();
			
			constants.SEARCH_ARRAY_OUTPUT=ARRAY_PRACTISE_SHEET.getRow(1).getCell(1).getStringCellValue();
			constants.MAX_CONS_ONES_OUTPUT=ARRAY_PRACTISE_SHEET.getRow(2).getCell(1).getStringCellValue();
			constants.FIND_EVEN_NUM_OUTPUT=ARRAY_PRACTISE_SHEET.getRow(3).getCell(1).getStringCellValue();
			constants.SQUARES_OF_SORTED_ARRAY_OUTPUT=ARRAY_PRACTISE_SHEET.getRow(4).getCell(1).getStringCellValue();
			
			constants.SEARCH_ARRAY_INVALID_CODE=ARRAY_PRACTISE_SHEET.getRow(7).getCell(0).getStringCellValue();
			constants.MAX_CONS_ONES_INVALID_CODE=ARRAY_PRACTISE_SHEET.getRow(8).getCell(0).getStringCellValue();
			constants.FIND_EVEN_NUM_OF_DIGITS_INVALID_CODE=ARRAY_PRACTISE_SHEET.getRow(9).getCell(0).getStringCellValue();
			constants.SQUARES_OF_SORTED_ARRAY_INVALID_CODE=ARRAY_PRACTISE_SHEET.getRow(6).getCell(0).getStringCellValue();
			
			constants.ARRAY_PRACTISE_SUCCESS_MSG=ARRAY_PRACTISE_SHEET.getRow(0).getCell(0).getStringCellValue();
			
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