package com.geekbrains.lesson6;

import com.geekbrains.lesson7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import org.junit.jupiter.api.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

@Epic("Интернет-портал Миникультуры")
public class CultureRfTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
    }

    @Test
    @Story("Посещение сраницы в разделе спецпроекта")
    @DisplayName("Visit cover on Pushkin page in special project section")
    @TmsLink("123")
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

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry logEntry : logEntries) {
            Allure.addAttachment("Элемент лога браузера", logEntry.getMessage());
        }
        driver.quit();
    }
}
