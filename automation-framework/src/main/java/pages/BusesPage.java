package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusesPage {

    WebDriver driver;

    // PageFactory locators
    @FindBy(id = "fromCity")
    private WebElement fromCityInputvalue;

    @FindBy(id = "toCity")
    private WebElement toCityInput;

    @FindBy(id = "searchButton") // Replace with actual ID or locator
    private WebElement searchButton;

    public BusesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void enterFromCity(String fromCity) {
    	fromCityInputvalue.sendKeys(fromCity);
    }

    public void enterToCity(String toCity) {
        toCityInput.sendKeys(toCity);
    }

    public void clickSearch() {
        searchButton.click();
    }

    /**
     * Selects a travel date dynamically
     * @param date in format "Mon Aug 25 2025"
     */
    public void selectDate(String date) {
        String dateXpath = "//div[@aria-label='" + date + "']";
        WebElement dateElement = driver.findElement(By.xpath(dateXpath));
        dateElement.click();
    }
}

