package tests;

import data.DataProvider;
import enums.Texts;
import enums.URLs;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация")
    public void testRegistration() {
        User user = DataProvider.getUser();

        header().clickProfile();
        accountPage().clickRegistration();
        registrationPage().fillForm(user);
        registrationPage().clickRegistrationButton();
        loginPage().waitingForLoading();
        Assert.assertEquals(loginPage().getHeadingText(), Texts.LOGIN_PAGE_HEADING.getText());
        Assert.assertEquals(getCurrentUrl(), URLs.LOGIN_PAGE.getUrl());
        deleteUser(user);
    }

    @Test
    @DisplayName("Неуспешная регистрация по длине пароля")
    public void invalidPasswordLength() {
        header().clickProfile();
        accountPage().clickRegistration();
        registrationPage().setPassword(DataProvider.getInvalidPassword());
        registrationPage().clickRegistrationButton();
        Assert.assertTrue(registrationPage().getPasswordAttribute().contains("input_status_error"));

        String actualErrorText = registrationPage().getPasswordErrorMessage();
        String expectedErrorText = Texts.LOGIN_PAGE_PASSWORD_ERROR_MESSAGE.getText();
        Assert.assertEquals(actualErrorText, expectedErrorText);
    }
}
