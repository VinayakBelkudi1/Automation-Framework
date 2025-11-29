package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage {
	WebDriver driver;
	
	@FindBy(xpath="//span[text(),'From']")
	private WebElement fromCity;
	
	@FindBy(xpath="//input[@placeholder,'From']")
	private WebElement fromInput;
	
	@FindBy(xpath="//span[text(),'To']")
	private WebElement toCity;
	
	@FindBy(xpath="//input[@placeholder,'To']")
	private WebElement toInput;
	
	@FindBy(linkText="Search")
	private WebElement searchButton;
	

	
	
	
	
	public FlightsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFrom() {
		fromCity.click();
	}
	
	public void clickTo() {
		toCity.click();
	}

	public void enterFromCity(String fromCityInput) {
		fromInput.sendKeys(fromCityInput);
	}
	
	public void enterToCity(String toCityInput) {
		toInput.sendKeys(toCityInput);
	}
	
	
	
	public void search() {
		searchButton.click();
	}
}
