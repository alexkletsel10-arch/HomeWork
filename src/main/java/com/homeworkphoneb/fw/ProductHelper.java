package com.homeworkphoneb.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductHelper extends BaseHelpere {

    public ProductHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnShoppingCartLink() {
        click(By.linkText("Shopping cart"));
    }

    public void clickOnAddToCartButtton() {
        click(By.cssSelector(".button-2.product-box-add-to-cart-button"));
    }

    public void selectItemNoteBook() {
        click(By.cssSelector("[alt='Picture for category Notebooks']"));
    }

    public void selectComputerCategory() {
        click(By.cssSelector("a[href='/computers']"));
    }

    public boolean isItemAdded(String text) {
        List<WebElement> items = driver.findElements(By.linkText("14.1-inch Laptop"));
        for (WebElement item : items) {
            if (item.getText().contains(text))
                return true;
        }
        return false;
    }

    public void clickOnUpgradePageButton() {
        click(By.cssSelector(".button-2.update-cart-button"));
    }

    public void clickOnCheckBox() {
        click(By.cssSelector("td.remove-from-cart input[name='removefromcart']"));
    }

    public int sizeOfItems() {
        if (isElementPresent(By.cssSelector("td.remove-from-cart input[name='removefromcart']"))){
            return driver.findElements(By.cssSelector("td.remove-from-cart input[name='removefromcart']")).size();

       }
        return 0;
}
}
