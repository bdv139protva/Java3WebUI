package com.geekbrains.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import org.junit.jupiter.api.*;

public class CultureRfTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Visit cover on Pushkin page in special project section")
    void visitCoverPushkinTest() {
        driver.get("https://www.culture.ru/");
        new MainPage(driver)
                .cookieBlock.closeCookie()
                .searchBlock.search("Пушкин")
                .selectEntity("Здесь был Пушкин");
                //.checkCorrectCoverInPage();

        Assertions.assertAll(
                () -> Assertions.assertEquals(driver.getCurrentUrl(), "https://www.culture.ru/s/pushkin/"),
                () -> Assertions.assertTrue(new SpecialProjectPushkinPage(driver).svgButtonInCover.isDisplayed())
        );
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
