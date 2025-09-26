package com.homeworkphoneb.fw;

import com.homeworkphoneb.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersHelper extends BaseHelpere {
    public UsersHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegistrationButton() {
        click(By.cssSelector(".button-1.register-next-step-button"));
    }

    public void fillInRegisterForm(User user) {
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        type(By.cssSelector("#FirstName"), user.getFirstName());
        //Enter lastname
        type(By.cssSelector("[name='LastName']"), user.getLastName());
        //Enter Email
        type(By.cssSelector("#Email"), user.getEmail());
        //Enter Password
        type(By.cssSelector("#Password"), user.getPassword());
        //Enter Confirm password
        type(By.cssSelector("#ConfirmPassword"), user.getConfirmPassword());
        // Click on register button
    }

    public void clickOnGenderRadioButton() {
        click(By.cssSelector("#gender-male"));
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector(".ico-register"));
    }

    public boolean isLogOutButtonPresent() {
        return isElementPresent(By.xpath("//a[text()='Log out']"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("input[value='Log in']"));
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("#Email"),user.getEmail());
        //Enter Password
        type(By.cssSelector("#Password"), user.getPassword() );
    }

    public void clickOnLoginLink() {
        click(By.cssSelector(".ico-login"));
    }
    public boolean isErrorMassagePresent() {
        return isElementPresent(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
    }

    public boolean isErrorMassagePresenteRegistration() {
        return isElementPresent(By.xpath("//li[text()='The specified email already exists']"));
    }

    public boolean isContinueButtonPresent() {
        return isElementPresent(By.cssSelector("input[value='Continue']"));
    }
    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void clickOnLogoutButton() {
        click((By.cssSelector("[href='/logout']")));
    }


}
