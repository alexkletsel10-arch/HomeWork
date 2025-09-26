package com.homework.test;

import com.homeworkphoneb.data.UserData;
import com.homeworkphoneb.models.User;
import com.homeworkphoneb.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateAccountTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogoutButton();
        }
    }

    @Test()

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
                .setFirstName(UserData.FIRSTNAME)
                .setLastName(UserData.LASTNAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setConfirmPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationButton();
        //verify LogOut link is displayed
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
        //verify Continue button is displayed
        Assert.assertTrue(app.getUser().isContinueButtonPresent());


    }

    @Test(dataProvider = "createNewAccountWithCsv", dataProviderClass = DataProviders.class)
    public void createNewAccountPositiveFromDataProviderWithCsvFileTest(User user){
        app.getUser().clickOnRegisterLink();
        app.getUser().clickOnGenderRadioButton();
        app.getUser().fillInRegisterForm(user);
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
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
                .setFirstName(UserData.FIRSTNAME)
                .setLastName(UserData.LASTNAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setConfirmPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationButton();
        //verify LogOut link is displayed
        //Assert.assertTrue(isLogOutButtonPresent());
        //verify Continue button is displayed
        //Assert.assertTrue(isContinueButtonPresent());
        Assert.assertTrue(app.getUser().isErrorMassagePresenteRegistration());


    }
    @Test(dataProvider = "exsistedUserRegistrationWithCsv",dataProviderClass = DataProviders.class)
    public void exsistedUserRegistrationNegativeFromDataProviderWithCsvFileTest(User user){
        app.getUser().clickOnRegisterLink();
        app.getUser().clickOnGenderRadioButton();
        app.getUser().fillInRegisterForm(user);
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isErrorMassagePresenteRegistration());


    }

}


