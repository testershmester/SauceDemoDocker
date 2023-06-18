package org.example.step.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.page.LoginPage;
import org.example.page.ProductsPage;

public class Steps {

    private LoginPage loginPage = new LoginPage();
    private ProductsPage productsPagee = new ProductsPage();

    @Given("STANDARD_USER logs in")
    public void loginUser() {
        loginPage.loginAsStandardUser();
    }

    @And("Products page is opened")
    public void productPageIsOpened() {
        productsPagee.shouldBeOpened();
    }

    @And("Login page is opened")
    public void loginPageIsOpened() {
        loginPage.open();
    }
}
