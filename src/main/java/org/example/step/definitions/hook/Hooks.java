package org.example.step.definitions.hook;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.page.LoginPage;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    private final Logger log = LogManager.getLogger(LoginPage.class);

    @Before
    public void setUpBrowser(Scenario scenario) {
        log.info("Before hook");
        browser = CHROME;
        browserVersion = "113.0";
        browserSize = "1920x1080";
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "113.0");
        browserCapabilities = options;
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        clearBrowserCookies();
        closeWebDriver();
    }
}