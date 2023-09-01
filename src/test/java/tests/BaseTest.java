package tests;

import enums.URLs;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.User;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import pages.*;
import request.GetAccessTokenRequest;
import specification.JsonSpecification;

import static enums.URLs.API_DELETE;
import static enums.URLs.API_LOGIN;
import static org.hamcrest.Matchers.equalTo;

public class BaseTest {
    private final String browser = System.getProperty("browser", Browser.CHROME.browserName());
    private WebDriver driver;
    private Header header;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private RegistrationPage registrationPage;
    private HomePage homePage;
    private ForgotPasswordPage forgotPasswordPage;

    @Before
    public void before() {
        //При запуске тестов через Яндекс Браузер сменить расположение браузер
        switch (browser) {
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }
            case "chrome": {
                driver = new ChromeDriver();
                break;
            }
            case "yandex": {
                System.setProperty("driver.chrome.driver", "src/resources/yandexdriver");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
                driver = new ChromeDriver(options);
                break;
            }
        }

        driver.get(URLs.MAIN_PAGE.getUrl());
        header = new Header(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage = new HomePage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @After
    public void after() {
        driver.quit();
    }

    public void deleteUser(User user) {
        GetAccessTokenRequest getAccessTokenRequest = new GetAccessTokenRequest(
                user.getEmail(),
                user.getPassword()
        );
        RestAssured.given()
                .header("Authorization", getAccessToken(getAccessTokenRequest))
                .delete(API_DELETE.getUrl())
                .then()
                .statusCode(HttpStatus.SC_ACCEPTED)
                .and()
                .body("success", equalTo(true))
                .body("message", equalTo("User successfully removed"));
    }

    private String getAccessToken(GetAccessTokenRequest getAccessTokenRequest) {
        String json = JsonSpecification.setGsonBuilder().toJson(getAccessTokenRequest);
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(API_LOGIN.getUrl())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .path("accessToken");
    }

    public Header header() {
        return header;
    }

    public LoginPage loginPage() {
        return loginPage;
    }

    public AccountPage accountPage() {
        return accountPage;
    }

    public RegistrationPage registrationPage() {
        return registrationPage;
    }

    public HomePage homePage() {
        return homePage;
    }

    public ForgotPasswordPage forgotPasswordPage() {
        return forgotPasswordPage;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
