package tests;

import enums.Texts;
import io.qameta.allure.junit4.DisplayName;
import model.Credentials;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static enums.Users.REGISTERED;

public class LoginTest extends BaseTest {
    Credentials credentials = new Credentials(new User(REGISTERED));

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void mainPageLogin() {
        homePage().clickLoginButton();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void accountPageLogin() {
        header().clickProfile();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void registrationPageLogin() {
        header().clickProfile();
        loginPage().clickRegistration();
        registrationPage().clickLoginLink();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void restorePasswordPageLogin() {
        header().clickProfile();
        loginPage().clickRestorePasswordLink();
        forgotPasswordPage().clickLoginLink();
    }

    @After
    public void afterEach(){
        loginPage().fillLoginForm(credentials);
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT.getText());
    }
}
