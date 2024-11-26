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
			Sheet URL_SHEET=workbook.getSheet("URL");
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
			/*
			 * constants.HOME = URL_SHEET.getRow(0).getCell(1).getStringCellValue();
			 * constants.ARRAY_PAGE_URL =
			 * URL_SHEET.getRow(1).getCell(1).getStringCellValue();
			 * constants.ARRAY_PYTHON_URL =
			 * URL_SHEET.getRow(2).getCell(1).getStringCellValue(); constants.ARRAY_LIST_URL
			 * = URL_SHEET.getRow(3).getCell(1).getStringCellValue();
			 * constants.ARRAY_BASIC_URL =
			 * URL_SHEET.getRow(4).getCell(1).getStringCellValue(); constants.ARRAY_APPS_URL
			 * = URL_SHEET.getRow(5).getCell(1).getStringCellValue();
			 * constants.ARRAY_PRACTICE =
			 * URL_SHEET.getRow(6).getCell(1).getStringCellValue(); constants.EDITOR =
			 * URL_SHEET.getRow(7).getCell(1).getStringCellValue();
			 * 
			 * constants.SEARCH_THE_ARRAY_URL=URL_SHEET.getRow(8).getCell(1).
			 * getStringCellValue();
			 * constants.MAX_CONSECUTIVES_URL=URL_SHEET.getRow(9).getCell(1).
			 * getStringCellValue();
			 * constants.FIND_NUM_WITH_EVEN_DIGITS_URL=URL_SHEET.getRow(10).getCell(1).
			 * getStringCellValue();
			 * constants.SQUARES_OF_A_SORTED_ARRAY_URL=URL_SHEET.getRow(11).getCell(1).
			 * getStringCellValue();
			 * 
			 * 
			 * constants.GRAPHPG_URL = URL_SHEET.getRow(12).getCell(0).getStringCellValue();
			 * constants.GRAPHREP_URL =
			 * URL_SHEET.getRow(13).getCell(0).getStringCellValue(); constants.EDITOR_URL =
			 * URL_SHEET.getRow(14).getCell(0).getStringCellValue();
			 * 
			 * constants.dsintropage = URL_SHEET.getRow(15).getCell(0).getStringCellValue();
			 * constants.arraypage =URL_SHEET.getRow(16).getCell(0).getStringCellValue();
			 * constants.llpage = URL_SHEET.getRow(17).getCell(0).getStringCellValue();
			 * constants.stackpage = URL_SHEET.getRow(18).getCell(0).getStringCellValue();
			 * constants.queuepage =URL_SHEET.getRow(19).getCell(0).getStringCellValue();
			 * constants.treepage = URL_SHEET.getRow(20).getCell(0).getStringCellValue();
			 * constants.graphpage =URL_SHEET.getRow(21).getCell(0).getStringCellValue();
			 * constants.gspage = URL_SHEET.getRow(22).getCell(0).getStringCellValue();
			 * 
			 * constants.LLINTRO_URL =URL_SHEET.getRow(23).getCell(0).getStringCellValue();
			 * constants.CREATE_LL_URL =
			 * URL_SHEET.getRow(24).getCell(0).getStringCellValue();
			 * constants.TYPE_OF_LL_URL =
			 * URL_SHEET.getRow(25).getCell(0).getStringCellValue();
			 * constants.IMPLEMENT_LL_URL
			 * =URL_SHEET.getRow(26).getCell(0).getStringCellValue();
			 * constants.TRAVERSE_LL_URL =
			 * URL_SHEET.getRow(27).getCell(0).getStringCellValue();
			 * constants.INSERTION_LL_URL
			 * =URL_SHEET.getRow(28).getCell(0).getStringCellValue();
			 * constants.DELETION_LL_URL =
			 * URL_SHEET.getRow(29).getCell(0).getStringCellValue();
			 * 
			 * constants.OVERVIEW_OF_TREE_URL=URL_SHEET.getRow(30).getCell(0).
			 * getStringCellValue();
			 * constants.TERMINOLOGIES_URL=URL_SHEET.getRow(31).getCell(0).
			 * getStringCellValue();
			 * constants.TYPES_OF_TREES_URL=URL_SHEET.getRow(32).getCell(0).
			 * getStringCellValue();
			 * constants.TREE_TRAVERSALS_URL=URL_SHEET.getRow(33).getCell(0).
			 * getStringCellValue();
			 * constants.TRAVERSALS_ILLUSTRATION_URL=URL_SHEET.getRow(34).getCell(0).
			 * getStringCellValue();
			 * constants.BINARY_TREE_URL=URL_SHEET.getRow(35).getCell(0).getStringCellValue(
			 * ); constants.TYPES_OF_BINARY_TREE_URL=URL_SHEET.getRow(36).getCell(0).
			 * getStringCellValue();
			 * constants.IMPLEMENTATION_IN_PYTHON_URL=URL_SHEET.getRow(37).getCell(0).
			 * getStringCellValue();
			 * constants.BINARY_TREE_TRAVERSALS_URL=URL_SHEET.getRow(38).getCell(0).
			 * getStringCellValue();
			 * constants.IMPLEMENTATION_OF_BINARY_TREES_URL=URL_SHEET.getRow(39).getCell(0).
			 * getStringCellValue();
			 * constants.APPLICATIONS_OF_BINARY_TREES_URL=URL_SHEET.getRow(40).getCell(0).
			 * getStringCellValue();
			 * constants.BINARY_SEARCH_TREE_URL=URL_SHEET.getRow(41).getCell(0).
			 * getStringCellValue();
			 * constants.IMPLEMENTATION_OF_BST_URL=URL_SHEET.getRow(42).getCell(0).
			 * getStringCellValue(); //
			 * 
			 * System.out.println("constants.HOME "+constants.HOME );
			 * System.out.println("constants.ARRAY_PAGE_URL "+ constants.ARRAY_PAGE_URL);
			 * System.out.println("constants.ARRAY_PYTHON_URL "+constants.ARRAY_PYTHON_URL);
			 * System.out.println("constants.ARRAY_LIST_URL "+constants.ARRAY_LIST_URL);
			 * System.out.println("constants.ARRAY_BASIC_URL "+constants.ARRAY_BASIC_URL);
			 * System.out.println("constants.ARRAY_APPS_URL "+constants.ARRAY_APPS_URL);
			 * System.out.println("constants.ARRAY_PRACTICE "+constants.ARRAY_PRACTICE);
			 * System.out.println("constants.EDITOR "+constants.EDITOR);
			 * 
			 * System.out.println("constants.SEARCH_THE_ARRAY_URL :"+constants.
			 * SEARCH_THE_ARRAY_URL);
			 * System.out.println("constants.MAX_CONSECUTIVES_URL :"+constants.
			 * MAX_CONSECUTIVES_URL);
			 */
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