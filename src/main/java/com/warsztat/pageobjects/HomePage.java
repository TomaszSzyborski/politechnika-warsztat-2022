package com.warsztat.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "a.login")
    private WebElement signInButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToSignInPage() {
        signInButton.click();
    }
}
