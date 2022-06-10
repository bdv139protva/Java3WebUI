package com.geekbrains.lesson5;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.junit.jupiter.api.*;
        import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WindowType;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import static org.hamcrest.MatcherAssert.assertThat;
        import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

        import java.time.Duration;
        import java.util.ArrayList;
        import java.util.List;

public class OrnamikaPlusCultureTest {
    WebDriver driver = new ChromeDriver();
    WebDriverWait webDriverWait;
    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void openReconstructionTest() {
        driver.get("https://ornamika.com/ru/");
        driver.findElement(By.xpath("//*[@id='reconstructions']/div[2]/a")).click();
        driver.findElement(By.id("filter-label")).click();
        driver.findElement(By.xpath("//a[contains(.,'Элементы')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'птица')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'человек')]")).click();
        driver.findElement(By.id("filter-done-btn")).click();
        driver.findElement(By.id("show-results-btn")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reconstructions-load-more-btn")));
        driver.findElement(By.id("reconstructions-load-more-btn")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://ornamika.com/ru/reconstruction/20021/']")));
        driver.findElement(By.xpath("//a[@href='https://ornamika.com/ru/reconstruction/20021/']")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("20021"));
    }

    @Test
    void closePropertiesBlockTest() {
        driver.get("https://ornamika.com/ru/reconstruction/20021/");
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("//div[@class='label'][contains(.,'Описание')]")))
                .click(driver.findElement(By.xpath("//div[@class='label'][contains(.,'Информация об источнике')]")))
                .click(driver.findElement(By.xpath("//div[@class='label'][contains(.,'Особенности узора')]")))
                .click(driver.findElement(By.xpath("//div[@class='label'][contains(.,'Особенности объекта')]")))
                .build()
                .perform();
        //Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='acc-item']")).isDisplayed(), true);
        assertThat(driver.findElement(By.xpath("//div[@class='acc-item']")), isDisplayed());
    }
    @Test
    void newWindowCultureTest() {
        driver.switchTo().newWindow(WindowType.TAB);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //culture rf
        driver.get("https://www.culture.ru/");
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.culture.ru/");
    }

    @Test
    void isDisplayedSvg(){
        driver.get("https://www.culture.ru/");
        /*Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("//button[@title='Поиск']")))
                .sendKeys(driver.findElement(By.xpath("//input[@placeholder='Введите поисковый запрос']")), "Пушкин")
                .click(driver.findElement(By.xpath("//button[@aria-label='Поиск']")))
                .build()
                .perform();*/
        driver.findElement(By.xpath("//button[@title='Поиск']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Введите поисковый запрос']")).sendKeys("Пушкин");
        driver.findElement(By.xpath("//button[@aria-label='Поиск']")).click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@href='https://www.culture.ru/s/pushkin/']")));

        driver.findElement(By.xpath("//a[@href='https://www.culture.ru/s/pushkin/']")).click();
        //driver.findElement(By.xpath("//div[@id='recorddiv31884470']/div[@class='t-cover__arrow']")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//div[@id='recorddiv31884470']/div[@class='t-cover__arrow']")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
 }
