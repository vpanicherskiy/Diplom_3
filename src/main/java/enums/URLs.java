package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum URLs {
    MAIN_PAGE("https://stellarburgers.nomoreparties.site/"),
    LOGIN_PAGE("https://stellarburgers.nomoreparties.site/login"),
    API_LOGIN("https://stellarburgers.nomoreparties.site/api/auth/login"),
    API_DELETE("https://stellarburgers.nomoreparties.site/api/auth/user");

    private final String url;
}
