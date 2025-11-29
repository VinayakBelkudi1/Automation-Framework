package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private String filePath;
	private Workbook wb;
	
	
	
	public ExcelUtils(String filePath) throws FileNotFoundException {
		this.filePath=filePath;
		FileInputStream fis=new FileInputStream(filePath);
		wb=new XSSFWorkbook();
		
	}
	
	
	public String getCellData(String sheetName,int rowNum,int colNum) {
		Sheet sheet=wb.getSheet(sheetName);
		Row r=sheet.getRow(rowNum);
		Cell c=r.getCell(colNum);
		
		return c== null ? "" : c.toString();		
	}
	
	
	public void writeCell(String sheetName,int rowNum,int colNum,String value) throws IOException {
		
		Sheet s=wb.getSheet(sheetName);
		
		Row r=s.getRow(rowNum);
		if(r==null) {
			r=s.createRow(rowNum);
		}
		
		Cell c=r.getCell(colNum);
		if(c==null) {
			c=r.createCell(colNum);
		}
		
		c.setCellValue(value);
		
		
		FileOutputStream fos=new FileOutputStream(filePath);
		wb.write(fos);
		fos.close();
		
		
	}
	
	public void close() throws IOException {
		wb.close();
	}
}
