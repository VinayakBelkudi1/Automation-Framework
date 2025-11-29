package tests;
import pages.FlightsPage;
import pages.HomePage;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import utils.ExcelUtils;

public class FlightPageTest extends BaseTest {

	
	@Test
	public void testSearch() throws InterruptedException, IOException {
		
		  HomePage h = new HomePage(Driver);

		    // Close login popup
		    h.cancelHomePopup();
		    
		    // Close AI popup
		    h.closeAiPopup();
		    
		    
		    Thread.sleep(3000);

		String path="C:\\Users\\Lenovo\\OneDrive\\Desktop\\Flights.xlsx";

		ExcelUtils eu=new ExcelUtils(path);
		String sheet ="Sheet123";
		
		FlightsPage f=new FlightsPage(Driver);
		
		int totalRows=3;
		
	    for (int i = 1; i <= totalRows; i++) {

	        String from = eu.getCellData(sheet, i, 0);
	        String to = eu.getCellData(sheet, i, 1);
	        
	        f.clickFrom();
	        f.enterFromCity(from);
	        
	        f.clickTo();
	        f.enterToCity(to);
	        
	        f.search();
	        
	        Thread.sleep(5000);
	        
	        Boolean result;
	        try {
	            result = Driver.getCurrentUrl().contains("search") 
	                     || Driver.getTitle().contains("Flights");
	        } catch (Exception e) {
	            result = false;
	        }
	        if (result) {
	        	eu.writeCell(sheet, i,2 ,"PASS");
	        }
	        else
	        {
	        	eu.writeCell(sheet, i,2 ,"FAIL");
	        }
	       Driver.navigate().back(); 
	}
	eu.close();
	    
}
}
