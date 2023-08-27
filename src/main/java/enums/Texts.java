package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Texts {
    LOGIN_PAGE_HEADING("Вход"),
    LOGIN_PAGE_PASSWORD_ERROR_MESSAGE("Некорректный пароль"),
    HOME_PAGE_ORDER_BUTTON_TEXT("Оформить заказ"),
    ACCOUNT_PAGE_INFO_TEXT("В этом разделе вы можете изменить свои персональные данные");

    private final String text;
}
