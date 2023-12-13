package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utilities {

	/**
	 * this method is used to fetch the data from excel sheet
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return 
	 * @return
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public String getExceldata(String sheetName,int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("C:\\Users\\sneha\\OneDrive\\Desktop\\MyExcelData.xlsx");
		Workbook book= WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		String ExcelData = cel.getStringCellValue();
		return ExcelData;
	}
	
	public String getExcelDataUsingDataFormatter(String sheetName,int rowNum, int cellNum) throws Throwable, IOException
	{
		FileInputStream fes = new FileInputStream("C:\\Users\\sneha\\OneDrive\\Desktop\\MyExcelData.xlsx");
		Workbook book= WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		
		DataFormatter format= new DataFormatter();
		String Exceldata= format.formatCellValue(cel);
		return Exceldata;
	}

	public Object[][]getDataProvider(String sheetName) throws Throwable
	{
		FileInputStream fes = new FileInputStream("C:\\Users\\sneha\\OneDrive\\Desktop\\MyExcelData.xlsx");
		Workbook book= WorkbookFactory.create(fes);
	    Sheet sheet = book.getSheet(sheetName);
	    int lastRow = sheet.getLastRowNum()+1;
	    short lastCell = sheet.getRow(0).getLastCellNum();
		
	    Object[][]obj=new Object[lastRow][lastCell];
	    
	    for(int i=0;i<lastRow;i++)
	    {
	    	for(int j=0;j<lastCell;j++)
	    	{
	    		obj[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();
	    	}
	    }
		return obj;
	    
	}
	
	
}
