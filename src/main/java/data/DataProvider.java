package data;

import com.github.javafaker.Faker;
import model.User;

public class DataProvider {
    private static final Faker faker = new Faker();

    public static User getUser() {
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        return new User(name, email, password);
    }

    public static String getInvalidPassword() {
        return faker.internet().password(1, 5);
    }
}
