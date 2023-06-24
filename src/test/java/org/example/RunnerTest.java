package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.example.step.definitions",
        tags = "",
        plugin = {"pretty", "html:test-reports/cucumber", "json:test-reports/cucumber.json"})
public class RunnerTest extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}