package com.homeworkphoneb.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class AppManager {
    String browser;
    UsersHelper user;
    ProductHelper product;
    WebDriver driver;

    public AppManager(String browser) {
        this.browser = browser;
    }
    public void init() {
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UsersHelper(driver);
        product = new ProductHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UsersHelper getUser() {
        return user;
    }
    public ProductHelper getProduct(){
        return product;
    }
}
