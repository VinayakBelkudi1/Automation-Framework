package utils;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class JSUtils extends BaseTest{
	
	 public void jsClick(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) Driver;
	        js.executeScript("arguments[0].click();", element);
	    }
}
