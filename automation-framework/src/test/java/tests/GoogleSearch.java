package tests;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class GoogleSearch {

	    public static void main(String[] args) {
	        // Setup ChromeDriver
	    	WebDriver Driver = new ChromeDriver();
	    	Driver.manage().window().maximize();
	    	Driver.get("https://www.google.com");

	        // Handle "Stay signed out" popup if present
	    	WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(5));
	        try {
	            
	            WebElement staySignedOut = wait.until(ExpectedConditions
	                .elementToBeClickable(By.xpath("//*[text()='Stay signed out']")));
	            staySignedOut.click();
	            System.out.println("Clicked on 'Stay signed out'");
	        } catch (Exception e) {
	            System.out.println("Popup not appeared, continuing...");
	        }
	       

	        // Print title
	       
		
		WebElement search=Driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		search.click();
		search.sendKeys("Selenium ");
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='OBMEnb']/ul[@class='G43f7e']/li")));
		
		List<WebElement> sugestions=Driver.findElements(By.xpath("//div[@class='OBMEnb']/ul[@class='G43f7e']/li"));
		
		for(WebElement s:sugestions){
			if(s.getText().equalsIgnoreCase("selenium python")) {
				s.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
