package com.dhl.pageObjects;

import com.dhl.utilities.ActionLibrary;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreightTransitTimeCalculatorPage {
    WebDriver driver;
    ActionLibrary actionLibrary = new ActionLibrary();

    public FreightTransitTimeCalculatorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="onetrust-accept-btn-handler")
    public WebElement acceptAllButton;

    @FindBy(id="title-58cb57b377")
    public WebElement headerText;

    @FindBy(id="origin-postcode")
    public WebElement originPostcodeInput;

    @FindBy(id="destination-postcode")
    public WebElement destinationPostcodeInput;

    @FindBy(css=".c-navigation-menu--headlinelink span")
    public WebElement navigationMenu_DhlFreight;

    @FindBy(xpath="//button/span[text()='E-commerce and Parcel Services']")
    public WebElement navigationMenu_EcommerceParcelServices;

    @FindBy(xpath="//button/span[text()='Freight Shipping Services for Business']")
    public WebElement navigationMenu_FreightShippingServicesForBusiness;

    @FindBy(xpath="//a/span[text()='myDHLFreight']")
    public WebElement navigationMenu_myDhlFreight;

    @FindBy(xpath="//div[@class='c-calculator--input-form c-calculator--padding-vertical l-grid l-grid--w-100pc-s l-grid--center-s l-grid--center-m']/div/button")
    public WebElement timeCalculateButton;

    @FindBy(id="origin-country")
    public WebElement originCountryDropdown;

    @FindBy(id="destination-country")
    public WebElement destinationCountryDropdown;

    @FindBy(xpath="//h3[contains(text(),'2/2 Transit Time Result')]")
    public WebElement transitTimeResultHeader;

    @FindBy(id="leadtime-datepicker")
    public WebElement pickUpDateInput;


    @FindBy(xpath = ".//p[@class='l-grid c-calculator--text-align-left l-grid--w-100pc-s js--origin-zip-error c-calculator--zip-error-message c-swe-leadtime-zip-error-message']")
    public WebElement originPostCodeError;

    @FindBy(xpath = ".//p[@class='l-grid c-calculator--text-align-left l-grid--w-100pc-s js--destination-zip-error c-calculator--zip-error-message c-swe-leadtime-zip-error-message']")
    public WebElement destinationPostCodeError;


    @FindBy(xpath = "//p[contains(text(),'B2B door-to-door parcel service')]")
    public WebElement DhlPaketOption;

    @FindBy(xpath = "//label[contains(text(),'Choose pick-up date:')]")
    public WebElement choosePickUpDateLabel;

    public boolean isFreightTransitTimeCalculatorPageDisplayed(){
        Assert.assertTrue(headerText.isEnabled());
        Assert.assertTrue(originPostcodeInput.isEnabled());
        Assert.assertTrue(destinationPostcodeInput.isEnabled());
        Assert.assertTrue(navigationMenu_EcommerceParcelServices.isEnabled());
        Assert.assertTrue(navigationMenu_FreightShippingServicesForBusiness.isEnabled());
        Assert.assertTrue(navigationMenu_myDhlFreight.isEnabled());
        return true;
    }

    public void selectOriginCountry(String country){
        actionLibrary.scroll();
        actionLibrary.clickElement(originCountryDropdown);
        actionLibrary.selectElement(originCountryDropdown,country);
    }

    public void selectDestinationCountry(String country){
        Actions actions = new Actions(this.driver);
        actions.moveToElement(destinationCountryDropdown).click().build().perform();
        // ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView();", headerText);
        //actionLibrary.scroll();
        //actionLibrary.clickElement(destinationCountryDropdown);
        actionLibrary.selectElement(destinationCountryDropdown,country);
    }



    public void launchApplication() throws InterruptedException {
        actionLibrary.launchUrl();
        if (acceptAllButton.isDisplayed()){
            acceptAllButton.click();
        }
    }

    public void enterOriginPostCode(String originPostCode) {
        actionLibrary.scroll();
        actionLibrary.enterText(originPostcodeInput,originPostCode);
    }

    public void enterDestinationPostCode(String destinationPostCode) {
        actionLibrary.enterText(destinationPostcodeInput,destinationPostCode);
        //destinationPostcodeInput.sendKeys(Keys.TAB);
    }

    public void calculate() {
        try{
            Thread.sleep(5000);
        }catch (Exception e){

        }
        WebElement element = this.driver.findElement(By.xpath(".//div[@class='l-grid--center-s l-grid l-grid--w-90pc-s l-grid--w-33pc-m']/button"));
        element.click();

    }

    public void validateTransitTimeResult() {
        actionLibrary.waitForElementToDisplay(transitTimeResultHeader);
    }

    public void selectPickUpDate() {
        try{
            Thread.sleep(5000);
        }catch (Exception e){

        }

        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].scrollIntoView(true);",choosePickUpDateLabel);
        actionLibrary.clickElement(pickUpDateInput);
        WebElement calendarDate = driver.findElement(By.xpath("//table/tbody/tr/td/button[text()='9']"));
        actionLibrary.clickElement(calendarDate);
    }

    public void isOriginPostCodeErrorDisplayed() {
        Assert.assertTrue(originPostCodeError.isDisplayed());
    }

    public void isDestinationPostCodeErrorDisplayed() {
        Assert.assertTrue(destinationPostCodeError.isDisplayed());
    }

}
