package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage extends Factory {
    private final By registrationLink = By.linkText("Зарегистрироваться");
    private final By informationText = By.xpath("//p[contains(@class, 'Account_text')]");
    private final By exitButton = By.xpath("//button[.='Выход']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegistration() {
        driver.findElement(registrationLink).click();
    }

    public String getInformationText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(informationText));
        return driver.findElement(informationText).getText();
    }

    public void clickExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton));
        driver.findElement(exitButton).click();
    }
}
