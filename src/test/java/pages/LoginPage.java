package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public LoginPage open() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage enterUsername(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).clear();
        driver.findElement(username).sendKeys(value);
        return this;
    }

    public LoginPage enterPassword(String value) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(value);
        return this;
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public InventoryPage loginValid(String u, String p) {
        enterUsername(u);
        enterPassword(p);
        clickLogin();
        return new InventoryPage(driver, wait);
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
}
