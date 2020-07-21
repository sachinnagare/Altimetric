/**
 * Used data driven approach whereas data is passed from Excelsheet
 *
 * @author  Sachin Nagare
 * @version 1.0
 * @since   2020-07-21
 */
package utility;



import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static XSSFWorkbook workbook;
	static 	XSSFSheet sheet;

	//Create a constructor of a class to provide you a excel path and sheet Name.
	// constructor name is same as class name.

	public ExcelUtility(String excelPath, String sheetName)
	{

		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception exp) {
			// TODO Auto-generated catch block

			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}



	//Create a function to read rows count from excel sheet

	public static void getRowCount()
	{

		//by using getPhysicalNumberOfRows method find the number of rows into the sheet.
		int rowCount=	sheet.getPhysicalNumberOfRows();
		System.out.println("Number of rows into sheet is: " +rowCount );

	}

	// write a function to fetch values of sheet using row and column number.

	public static String getCellData(int rowNumber, int colNumber)
	{


		//Data Formatter object created 
		DataFormatter formatter=new DataFormatter();
		//Object value4=	formatter.formatCellValue(sheet.getRow(rowNumber).getCell(colNumber));
		String value5= formatter.formatCellValue(sheet.getRow(rowNumber).getCell(colNumber));
		//System.out.println("Value of cell is: "+value4);
		System.out.println("Value of cell is: "+value5);

		return value5;

	}




}

