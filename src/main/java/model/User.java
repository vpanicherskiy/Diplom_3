package model;

import enums.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private String email;
    private String password;

    public User(Users users) {
        this.name = users.getName();
        this.email = users.getEmail();
        this.password = users.getPassword();
    }
}
