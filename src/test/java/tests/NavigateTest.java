package tests;

import enums.Texts;
import enums.Users;
import io.qameta.allure.junit4.DisplayName;
import model.Credentials;
import model.User;
import org.junit.Assert;
import org.junit.Test;

public class NavigateTest extends BaseTest {
    Credentials credentials = new Credentials(new User(Users.REGISTERED));

    @Test
    @DisplayName("Переход по клику на Личный кабинет")
    public void goToAccountPage() {
        header().clickProfile();
        loginPage().fillLoginForm(credentials);
        header().clickProfile();
        Assert.assertEquals(accountPage().getInformationText(), Texts.ACCOUNT_PAGE_INFO_TEXT.getText());
    }

    @Test
    @DisplayName("Переход по клику на Конструктор")
    public void goToConstructor() {
        header().clickProfile();
        loginPage().fillLoginForm(credentials);
        header().clickConstructor();
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT.getText());
    }

    @Test
    @DisplayName("Переход по логотипу Stellar Burgers")
    public void goToMainPage() {
        header().clickProfile();
        loginPage().fillLoginForm(credentials);
        header().clickLogo();
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT.getText());
    }
}
