package com.homework.test;

import com.homeworkphoneb.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class DeleteItem extends TestBase {
    @BeforeMethod
    public void preconditionsDelete() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogoutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail("aaron18@gmail.com").setPassword("Cadi26$lac"));
        app.getUser().clickOnLoginButton();


        //Select Computer category in header
        app.getProduct().selectComputerCategory();
        //Select Notbooks On computers page click on picture
        app.getProduct().selectItemNoteBook();
        //click on addToCartButton
        app.getProduct().clickOnAddToCartButtton();

    }

    @Test
    public void deleteItemFromShoppingCartTest() {
        // click On Shopping cart link
        app.getProduct().clickOnShoppingCartLink();
        int sizeBefore = app.getProduct().sizeOfItems();
        //Click on check box
        app.getProduct().clickOnCheckBox();
       //Click on updateButton
        app.getProduct().clickOnUpgradePageButton();
        app.getProduct().pause(200);
        int sizeAfter = app.getProduct().sizeOfItems();
        Assert.assertEquals( sizeAfter,sizeBefore-1);

    }

}
