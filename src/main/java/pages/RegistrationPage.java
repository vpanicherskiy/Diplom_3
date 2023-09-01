package pages;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends Factory {
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By nameField = By.xpath("//label[.='Имя']/../input");
    private final By emailField = By.xpath("//label[.='Email']/../input");
    private final By passwordField = By.name("Пароль");
    private final By registrationButton = By.xpath("//form/button");
    private final By passwordDiv = By.cssSelector(".input_type_password");
    private final By passwordError = By.xpath("//p[@class='input__error text_type_main-default']");
    private final By loginLink = By.xpath("//a[.='Войти']");

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void fillForm(User user) {
        setName(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public String getPasswordAttribute() {
        return driver.findElement(passwordDiv).getAttribute("class");
    }

    public String getPasswordErrorMessage() {
        return driver.findElement(passwordError).getText();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
