package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consists of generic methods related files
 * @author Shiva
 */
public class FileUtilities {
	/**
	 * this method will read data from property file and return the value to caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
public String readDataFromPropertyFile(String key) throws IOException
{
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String value=prop.getProperty(key);
	return value;
}
/**
 * 
 * @param sheetname
 * @param rowNo
 * @param cellno
 * @return value
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public String readDataFromExcelFile(String sheetname ,int rowNo, int cellno) throws EncryptedDocumentException, IOException
{
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
	Workbook wb=WorkbookFactory.create(fise);
	Sheet sh=wb.getSheet(sheetname);
	Row rw=sh.getRow(rowNo);
	Cell cl=rw.getCell(cellno);
	String value=cl.getStringCellValue();
	return value;
}
}
