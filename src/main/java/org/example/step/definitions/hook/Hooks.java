package org.example.step.definitions.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    @Before("@ui")
    public void setUpBrowser(Scenario scenario) {
        browser = CHROME;
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "113.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", scenario.getName());
            /* How to set session timeout */
            put("enableVideo", true);
            put("enableVNC", true);
            put("videoName", scenario.getName());
        }});
        browserCapabilities = options;
        browserVersion = "113.0";
        browserSize = "1920x1080";
    }

    @After
    public void tearDown() {
        clearBrowserCookies();
        closeWebDriver();
    }
}