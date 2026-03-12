package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.JSUtils;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    JSUtils js;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        //initializes all @FindBy elements in the Page Object class and creates lazy-loading proxies, so we can use elements without calling findElement manually.
    }
    

    @FindBy(css="span.commonModal__close")  //id, linkText, partialLinkText, xpath
    private WebElement closeHomePopUp;

    @FindBy(css="div.tp-dt-header-icon")
    private WebElement closeAi;

    @FindBy(css ="#SW > div.landingContainer.eng > div.makeFlex.hrtlCenter.prependTop5.appendBottom30 > ul > li:nth-child(1) > div > p.whiteText.appendBottom3.font11")
    private WebElement listProperty;
    
    

    // ---------- POPUP HANDLING ---------- //

    public void cancelHomePopup() {
        try {
            wait.until(ExpectedConditions.visibilityOf(closeHomePopUp));
            wait.until(ExpectedConditions.elementToBeClickable(closeHomePopUp)).click();
        } catch (Exception e) {
            System.out.println("Home Popup not present or already closed.");
        }
    }

    public void closeAiPopup() {
        try {
            wait.until(ExpectedConditions.visibilityOf(closeAi));
            wait.until(ExpectedConditions.elementToBeClickable(closeAi)).click();
        } catch (Exception e) {
            System.out.println("AI popup not found or already closed.");
        }
    }

    
    
    // ---------- LIST PROPERTY ---------- //

    public void clickOnListProperty() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(listProperty));
            listProperty.click();
        } catch (Exception e) {
            System.out.println("Could not click List Your Property. Trying JS click...");
            js.jsClick(listProperty);
        }
    }
    
    
   
    
    


}
