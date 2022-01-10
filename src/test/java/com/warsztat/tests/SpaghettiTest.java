package com.warsztat.tests;

import com.warsztat.base.PropertySupplier;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class SpaghettiTest {
    private final PropertySupplier propertySupplier = new PropertySupplier();

    @Test
    void spaghettiStyle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get(propertySupplier.getUrl());
        driver.findElement(By.cssSelector("a.login")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("#email_create")).sendKeys("asaaeaad@asd.asd");
        driver.findElement(By.cssSelector("#SubmitCreate")).click();

        // driver.findElement(By.cssSelector("#email")).sendKeys("asd@asd.asd");
        // driver.findElement(By.cssSelector("#password")).sendKeys("asdasdasd");
        // driver.findElement(By.cssSelector("button[name='SubmitLogin']")).click();
        // driver.findElement(By.xpath("//button[text()='Sign in']")).click(); // coś nie halo

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String personalInformation = driver.findElement(By.cssSelector("h3.page-subheading")).getText();
        assert personalInformation.equals("YOUR PERSONAL INFORMATION");
    }
}
