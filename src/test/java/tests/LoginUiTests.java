package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginUiTests extends BaseTest {

    @Test
    public void TC01_validLogin_shouldOpenInventory() {
        var login = new LoginPage(driver, wait).open();
        var inventory = login.loginValid("standard_user", "secret_sauce");

        Assert.assertTrue(inventory.isOpened(),
                "Inventory page nije otvorena nakon validnog logina.");
    }

    @Test
    public void TC02_invalidPassword_shouldShowError() {
        var login = new LoginPage(driver, wait).open();

        login.enterUsername("standard_user")
                .enterPassword("kriva_lozinka")
                .clickLogin();

        Assert.assertTrue(
                login.getErrorMessage().toLowerCase().contains("username and password"),
                "Poruka o grešci nije prikazana."
        );
    }

    @Test
    public void TC03_emptyUsername_shouldShowError() {
        var login = new LoginPage(driver, wait).open();

        login.enterPassword("secret_sauce").clickLogin();

        Assert.assertTrue(
                login.getErrorMessage().toLowerCase().contains("username is required"),
                "Poruka 'Username is required' nije prikazana."
        );
    }
}
