package com.homework.test;

import com.homeworkphoneb.fw.AppManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected AppManager app = new AppManager(System.getProperty("browser", Browser.CHROME.browserName()));

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }
    @BeforeMethod
    public void startTest(Method method){
       logger.info("Start test"+method.getName());
    }
    @AfterMethod
    public void stopTest(ITestResult result){
        if(result.isSuccess()) {
            logger.info("Passed" + result.getMethod().getMethodName());
        }else {
            logger.error("Failed"+ result.getMethod().getMethodName()+"Screenshot path: "+ app.getUser().takeScreenShot());
        }
        logger.info("Stop test");
        logger.info("*********************************");
    }


}
