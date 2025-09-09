package com.homework.test;

import com.homeworkphoneb.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateAccountTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogoutButton();
        }
    }

    @Test

    public void newUserRegistrationPositiveTest() {
        //int i = (int) ((System.currentTimeMillis()/1000)%3600);
        //click on Register link
        app.getUser().clickOnRegisterLink();
        //Select gender radio button
        app.getUser().clickOnGenderRadioButton();
        //driver.findElement(By.cssSelector("#gender-male")).clear();
        //findElement(By.cssSelector("#gender-female")).click()
        //Enter first name
        app.getUser().fillInRegisterForm(new User()
                .setFirstName("Aaron")
                .setLastName("Kennedy")
                .setEmail("aaron18@gmail.com")
                .setPassword("Cadi26$lac")
                .setConfirmPassword("Cadi26$lac"));
        app.getUser().clickOnRegistrationButton();
        //verify LogOut link is displayed
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
        //verify Continue button is displayed
        Assert.assertTrue(app.getUser().isContinueButtonPresent());


    }
     @Test
    public void exsistedUserRegistrationNegativeTest() {
        //int i = (int) ((System.currentTimeMillis()/1000)%3600);
        //click on Register link
        app.getUser().clickOnRegisterLink();
        //Select gender radio button
        app.getUser().clickOnGenderRadioButton();
        //driver.findElement(By.cssSelector("#gender-male")).clear();
        //findElement(By.cssSelector("#gender-female")).click()
        //Enter first name
        app.getUser().fillInRegisterForm(new User()
                .setFirstName("Aaron")
                .setLastName("Kennedy")
                .setEmail("aaron18@gmail.com")
                .setPassword("Cadi26$lac")
                .setConfirmPassword("Cadi26$lac"));
        app.getUser().clickOnRegistrationButton();
        //verify LogOut link is displayed
        //Assert.assertTrue(isLogOutButtonPresent());
        //verify Continue button is displayed
        //Assert.assertTrue(isContinueButtonPresent());
        Assert.assertTrue(app.getUser().isErrorMassagePresenteRegistration());


    }

}


