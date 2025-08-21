package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='from']")
	private WebElement fromCity;
	
	@FindBy(xpath="//input[@id='toCity']")
	private WebElement toCity;
	
	@FindBy(xpath="//input[@id='departure'")
	private WebElement departureDate;
	
	@FindBy(linkText="Search")
	private WebElement search;
	
	
	public FlightsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFromCity(String fromCityInput) {
		fromCity.sendKeys(fromCityInput);
	}
	
	public void enterToCity(String toCityInput) {
		toCity.sendKeys(toCityInput);
	}
	
	public void selectDate(String date) {
		departureDate.click();
		
		String departureDateXpath="//div[@aria-lable='"+date+"']";
		WebElement dateElement=driver.findElement(By.xpath(departureDateXpath));
		dateElement.click();
	}
	
	public void search() {
		search.click();
	}
}
