package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Factory {
    private final By loginButton = By.xpath("//button[.='Войти в аккаунт']");
    private final By orderButton = By.xpath("//button[.='Оформить заказ']");
    private final By bunsTab = By.xpath("//div[contains(@class, 'tab_tab')]/span[.='Булки']/..");
    private final By saucesTab = By.xpath("//div[contains(@class, 'tab_tab')]/span[.='Соусы']/..");
    private final By fillingsTab = By.xpath("//div[contains(@class, 'tab_tab')]/span[.='Начинки']/..");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getOrderButtonText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        return driver.findElement(orderButton).getText();
    }

    public void clickBunsTab() {
        driver.findElement(bunsTab).click();
    }

    public void clickSaucesTab() {
        driver.findElement(saucesTab).click();
    }

    public void clickFillingsTab() {
        driver.findElement(fillingsTab).click();
    }

    public String getBunsTabAttributes() {
        return driver.findElement(bunsTab).getAttribute("class");
    }

    public String getSaucesTabAttributes() {
        return driver.findElement(saucesTab).getAttribute("class");
    }

    public String getFillingsTabAttributes() {
        return driver.findElement(fillingsTab).getAttribute("class");
    }
}
