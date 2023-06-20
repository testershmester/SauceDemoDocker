package org.example.page;


import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.util.PropertiesLoader;
import org.openqa.selenium.By;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static final By USER_NAME = By.id("user-name");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");

    private final Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage open() {
        Properties properties = PropertiesLoader.loadProperties();
        Selenide.open(properties.getProperty("base.url"));
        return this;
    }

    public boolean isOpened() {
        return $(LOGIN_BUTTON).isDisplayed();
    }

    public void loginAs(String userName, String password) {
        $(USER_NAME).sendKeys(userName);
        $(PASSWORD).sendKeys(password);
        $(LOGIN_BUTTON).click();
    }

    public ProductsPage loginAsStandardUser() {
        String userName = "standard_user";
        String password = "secret_sauce  ";
        log.info("Login as standard user: {}, {}", userName, password);
        loginAs(userName, password);
        return new ProductsPage();
    }
}