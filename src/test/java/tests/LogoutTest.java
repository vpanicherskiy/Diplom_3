package tests;

import enums.Texts;
import enums.Users;
import io.qameta.allure.junit4.DisplayName;
import model.Credentials;
import model.User;
import org.junit.Assert;
import org.junit.Test;

public class LogoutTest extends BaseTest {
    Credentials credentials = new Credentials(new User(Users.REGISTERED));

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void logout() {
        header().clickProfile();
        loginPage().fillLoginForm(credentials);
        header().clickProfile();
        accountPage().clickExitButton();
        Assert.assertEquals(loginPage().getHeadingText(), Texts.LOGIN_PAGE_HEADING.getText());
    }
}
