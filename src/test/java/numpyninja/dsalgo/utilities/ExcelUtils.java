package numpyninja.dsalgo.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import numpyninja.dsalgo.constants.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelUtils {

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

}