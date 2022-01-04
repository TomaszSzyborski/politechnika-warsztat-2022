package com.warsztat.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.warsztat.base.PropertySupplier;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

// TODO task for students fix code to get rid of warnings
// TODO implement logging in using Selenide - without and with page objects
// TODO implement negative test cases for login
// TODO add inheritance/composition to tests
// TODO implement setup configuration (base url) using PropertySupplier class
public class SampleTest {
    private static final PropertySupplier properties = new PropertySupplier();

    @BeforeAll
    public static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @Test
    public void openPage() {
        Selenide.open("http://automationpractice.com/index.php");

    }
}
