package org.example.page;


import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {

    private static final String PRODUCTS_TITLE = "//span[text()='Products']";

    public void shouldBeOpened() {
        $x(PRODUCTS_TITLE).shouldBe(Condition.visible);
    }
}
