package com.homework.test;

import com.homeworkphoneb.fw.AppManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected AppManager app = new AppManager(System.getProperty("browser", Browser.CHROME.browserName()));

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }


}
