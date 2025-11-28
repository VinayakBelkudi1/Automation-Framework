package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import utils.ConfigReader;

public class BaseTest {
public static WebDriver Driver;
public static ConfigReader Config;


@BeforeSuite
public void beforeSuite() {
    System.out.println(">> BeforeSuite: Initialize test suite setup (load Config,DB connection,Start Selenium Grid).");
    Config = new ConfigReader();   // Load config only once for entire suite
}

@AfterSuite
public void afterSuite() {
    System.out.println(">> AfterSuite: Clean up after test suite (Stop Selenium Grid,close DB, generate reports).");
}

@BeforeTest
public void beforeTest() {
    System.out.println(">> BeforeTest: Runs before <test> block from testng.xml.");
    //Whatever the code runs here , its for all the test classes inside <classes> tag
    //Open browser session for a group of tests.
}

@AfterTest
public void afterTest() {
    System.out.println(">> AfterTest: Runs after <test> block from testng.xml.");
    //Closes browser session for a group of tests.
}

@BeforeClass
public void beforeClass() {
    System.out.println(">> BeforeClass: Setup before first @Test method in this class.");
    //If you want a new browser session each class then mention Driver=new ChromeDriver(); in this block
	String baseurl=Config.getPropertyValue("baseurl");
	String browser=Config.getPropertyValue("browser");

	switch(browser) {

						case "chrome": WebDriverManager.chromedriver().setup();
									   Driver=new ChromeDriver();
									   break;

						case "firefox":WebDriverManager.firefoxdriver().setup();
									   Driver=new FirefoxDriver();
									   break;

						case "edge":   WebDriverManager.edgedriver().setup();
									   Driver=new EdgeDriver();
									   break;

						default:       throw new IllegalArgumentException("Browser not supported"+browser);

					}
	Driver.manage().window().maximize();

	Driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

	Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	Driver.get(baseurl);
	
	
	// Just for demo - let the page be visible before quitting
	try { Thread.sleep(3000); } catch (InterruptedException e) {}
}

@AfterClass
public void afterClass() {
    System.out.println(">> AfterClass: Tear down after all @Test methods in this class.");
	if(Driver!=null) {
		Driver.quit();

	 }

}

@BeforeMethod
public void setUp() {
	
		//used to add login code to make sure every test executed with new login				
	
						//int wait=Integer.parseInt(config.getPropertyValue("implicitWait"));
	System.out.println(">> BeforeClass: Setup before Each @Test method in this class.");	
	//Login
	
}

@AfterMethod
public void teardown() {
						System.out.println("Teardoen after each @Test in class");
						//Logout
}
}