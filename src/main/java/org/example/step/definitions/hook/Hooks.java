package org.example.step.definitions.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    @Before
    public void setUpBrowser(Scenario scenario) {
        browser = CHROME;
        browserVersion = "113.0";
        browserSize = "1920x1080";
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "113.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVideo", true);
            put("videoName", StringUtils.toRootLowerCase(scenario.getName()).replace(" ", "_"));
        }});
        browserCapabilities = options;
    }

    @After
    public void tearDown() {
        clearBrowserCookies();
        closeWebDriver();
    }
}