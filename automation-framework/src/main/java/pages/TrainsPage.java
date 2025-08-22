package com.makemytrip.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainsPage {

    WebDriver driver;

    public TrainsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 🔹 Elements
    @FindBy(id = "fromCity")
    private WebElement fromCity;

    @FindBy(id = "toCity")
    private WebElement toCity;

    @FindBy(id = "travelDate")
    private WebElement travelDateInput;

    @FindBy(xpath = "//button[text()='Search']")
    private WebElement searchBtn;

    // 🔹 Actions
    public void enterFromCity(String city) {
        fromCity.sendKeys(city);
    }

    public void enterToCity(String city) {
        toCity.sendKeys(city);
    }

    // 🔹 Dynamic Date Selection
    public void selectTravelDate(String date) {
        travelDateInput.click(); // open calendar

        // Example date format: "Tue Aug 26 2025"
        String dateXpath = "//div[@aria-label='" + date + "']";
        WebElement dateElement = driver.findElement(By.xpath(dateXpath));
        dateElement.click();
    }

    public void clickSearch() {
        searchBtn.click();
    }
}
