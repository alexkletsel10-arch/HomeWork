package com.homeworkphoneb.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseHelpere {
    WebDriver driver;

    public BaseHelpere(WebDriver driver) {
        this.driver = driver;

    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        //driver.findElement(locator).click();
        waitForElementClickable(locator,10).click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public WebElement waitForElementClickable(By locator, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


}
