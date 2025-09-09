package com.homework.test;

import com.homeworkphoneb.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {
        //click on Login link
        app.getUser().clickOnLoginLink();
        //Enter Email
        app.getUser().fillLoginForm(new User().setEmail("aaron18@gmail.com").setPassword("Cadi26$lac"));
        // click on Login button
        app.getUser().clickOnLoginButton();
        //verify Logout Button is displayed
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());


    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        //click on Login link
        app.getUser().clickOnLoginLink();
        //Enter Email
        app.getUser().fillLoginForm(new User().setPassword("Cadi26$lac"));
        // click on Login button
        app.getUser().clickOnLoginButton();
        //verify Error massege displayed
        Assert.assertTrue(app.getUser().isErrorMassagePresent());

    }


}



