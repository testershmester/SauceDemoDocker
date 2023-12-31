package org.example.step.definitions.hook;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.page.LoginPage;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

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
        browserVersion = "114.0";
        browserSize = "1920x1080";
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "114.0");
        options.addArguments("--disable-site-isolation-trials"); //to get access to the new opened tabs in tests
        options.addArguments("--disable-notifications");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {
            {
                put("enableVideo", true);
                put("enableVNC", true);
            }
        });
        browserCapabilities = options;
    }

    @After
    public void tearDown(Scenario scenario) {
        clearBrowserCookies();
        closeWebDriver();
    }
}