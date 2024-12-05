package com.dhl.utilities;

import com.dhl.stepdef.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionLibrary {

    WebDriverWait webDriverWait= new WebDriverWait(Hooks.driver,15);;


    public void clickElement(WebElement element){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        LoggerUtility.logInfo("element {} is clicked ");


    }

    public void launchUrl() {
        Hooks.driver.get(ReadConfigValues.getProperty("hostUrl"));
        LoggerUtility.logInfo("Url is launched and the current Url is "+Hooks.driver.getCurrentUrl());

    }

    public void enterText(WebElement element, String value) {
        if(webDriverWait.until(ExpectedConditions.visibilityOf(element)).isDisplayed()){
            element.sendKeys(value);
        }else{
            throw new ElementNotVisibleException("Element is not visible:"+ new Throwable().getCause());
        }

    }


    public void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
    }

    public void scrollElementIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public void selectElement(WebElement element, String value){
        if(webDriverWait.until(ExpectedConditions.visibilityOf(element)).isDisplayed()){
            Select selectValues = new Select(element);
            selectValues.selectByValue(value);
        }else{
            throw new ElementNotSelectableException("Element is not selectable:"+ new Throwable().getCause());
        }
    }

    public void waitForElementToDisplay(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}