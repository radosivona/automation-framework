package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By title = By.cssSelector(".title");

    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isOpened() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title))
                .getText().equalsIgnoreCase("Products");
    }
}
