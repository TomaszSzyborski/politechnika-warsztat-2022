package com.warsztat.tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;



abstract class BaseTest {
    protected WebDriver driver;
    protected Faker fake = new Faker();

    @BeforeEach
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        this.driver = WebDriverManager.chromedriver().create();
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

}
