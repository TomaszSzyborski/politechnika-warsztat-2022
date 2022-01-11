package com.practice.automationpractice;

import java.util.Map;
import java.util.Properties;

import com.practice.automationpractice.pages.pages.HomePage;
import com.practice.automationpractice.pages.pages.LoginPage;
import com.practice.automationpractice.utils.Client;
import com.practice.automationpractice.utils.PropertiesLoader;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static java.util.concurrent.TimeUnit.SECONDS;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

@Slf4j
public abstract class BaseTest {

    protected WebDriver driver;
    private String driverVersion;
    private static final int IMPLICIT_WAIT_TIMEOUT = 10;
    private static final Dimension FULL_HD = new Dimension(1920, 1200);
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected Client client;

    @BeforeMethod
    public void aSetupTest() {
        Properties properties = PropertiesLoader.loadProperites();
        driverVersion = properties.getProperty("driver.choice");

        Map<String, Runnable> driverMap = Map.of(
            "Chrome", () -> {
                chromedriver().setup();
                driver = new ChromeDriver();
            },
            "Firefox", () -> {
                firefoxdriver().setup();
                driver = new FirefoxDriver();
            },
            "Edge", () -> {
                edgedriver().setup();
                driver = new EdgeDriver();
            });


        driverMap.get(driverVersion).run();

        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, SECONDS);
        driver.manage().window().setSize(FULL_HD);

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        homePage.openHomePage();
        client = new Client();

        log.info("Client email: " + client.getEmail());
        log.info("Client password: " + client.getPassword());
        log.info("Client first name, last name: " + client.getFirstName() + " " + client.getLastName());
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
