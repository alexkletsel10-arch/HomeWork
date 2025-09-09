package com.homework.test;
import com.homeworkphoneb.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemTest extends TestBase {
    @BeforeMethod
    public void preconditionsAdd() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogoutButton();
        }
        app.getUser().clickOnLoginLink();
        //Enter Email
        app.getUser().fillLoginForm(new User().setEmail("aaron18@gmail.com").setPassword("Cadi26$lac"));
        // click on Login button
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addItemToShoppingCart() {
        //Select Computer category in header
        app.getProduct().selectComputerCategory();
        //Select Notebooks On computers page click on picture
        app.getProduct().selectItemNoteBook();
        //click on Add to cart Button
        app.getProduct().clickOnAddToCartButtton();
        // click On Shopping cart link
        app.getProduct().clickOnShoppingCartLink();
        app.getProduct().pause(200);
        Assert.assertTrue(app.getProduct().isItemAdded("14.1-inch Laptop"));


    }
}