package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header extends Factory {
    private final By profile = By.linkText("Личный Кабинет");
    private final By constructor = By.linkText("Конструктор");
    private final By logo = By.xpath("//div[contains(@class, 'AppHeader_header__logo')]");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProfile() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(profile));
        driver.findElement(profile).click();
    }

    public void clickConstructor() {
        driver.findElement(constructor).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }
}
