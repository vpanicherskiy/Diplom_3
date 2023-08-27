package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Users {
    REGISTERED("registered", "already@registered.ru", "already");

    private final String name;
    private final String email;
    private final String password;
}
