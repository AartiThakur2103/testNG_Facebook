package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class lib implements IAutoConstant{

// Method to retrieve properties from a properties file	
	public static String property_file(String key) throws IOException {	
		FileInputStream file = new FileInputStream(PropertyPath);
		Properties prop = new Properties();
		prop.load(file);
		String property = prop.getProperty(key);
		return property;	
	}
	
//	Method to retrieve data from excel
     public static String excelfile(String sheet1 , int row , int col) throws EncryptedDocumentException, IOException{	
    	FileInputStream file = new FileInputStream(Excelpath);
 		Workbook workbook = WorkbookFactory.create(file);
 		String testdata = workbook.getSheet(sheet1).getRow(row).getCell(col).toString();
 		/*Row rows = sheet.getRow(0);
 		Cell cell = rows.getCell(0);
 		System.out.println(cell.toString());
		*/
 		System.out.println(testdata);
		return testdata;
		}

//   Method to get no. of rows in a specified sheet
    public static int Rowlength(String sheet1) throws EncryptedDocumentException, IOException {
    	 FileInputStream file = new FileInputStream(Excelpath);
  		Workbook workbook = WorkbookFactory.create(file);
// 		String testdata = workbook.getSheet(sheet1).getRow(row).getCell(col).toString();
 		int rowlen=workbook.getSheet(sheet1).getLastRowNum();
  	    return rowlen;	
     }
     
//  Method to capture screenshot
	public static void Screenshot_Method(WebDriver driver) throws IOException{
	TakesScreenshot screenshot = (TakesScreenshot) driver;
	File src = screenshot.getScreenshotAs(OutputType.FILE);
	File dstn = new File(Screenshot);
	com.google.common.io.Files.copy(src, dstn);
		
}
}