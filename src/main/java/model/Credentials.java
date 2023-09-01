package model;

import lombok.Getter;

@Getter
public class Credentials {
    private String email;
    private String password;

    public Credentials(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
