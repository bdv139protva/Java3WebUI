package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OrnamikaAndCultureTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        //Ornamika
        driver.get("https://ornamika.com/ru/");

        driver.findElement(By.xpath("//*[@id='reconstructions']/div[2]/a")).click();
        driver.findElement(By.id("filter-label")).click();
        driver.findElement(By.xpath("//a[contains(.,\"Элементы\")]")).click();
        driver.findElement(By.xpath("//span[contains(.,\"птица\")]")).click();
        driver.findElement(By.xpath("//span[contains(.,\"человек\")]")).click();
        driver.findElement(By.id("filter-done-btn")).click();
        driver.findElement(By.id("show-results-btn")).click();

        WebDriverWait webDriverWait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("reconstructions-load-more-btn")));

        driver.findElement(By.id("reconstructions-load-more-btn")).click();

        /*WebDriverWait webDriverWait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"https://ornamika.com/ru/reconstruction/20021/\"]")));

        driver.findElement(By.xpath("//a[@href=\"https://ornamika.com/ru/reconstruction/20021/\"]")).click();*/
        /*WebDriverWait webDriverWait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"title\"][contains(.,\"Реконструкция узора на ситце\")]")));*/

        Thread.sleep(10000);
        driver.findElement(By.xpath("//a[@href=\"https://ornamika.com/ru/reconstruction/20021/\"]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//div[@class=\"label\"][contains(.,\"Описание\")]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//div[@class=\"label\"][contains(.,\"Информация об источнике\")]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//div[@class=\"label\"][contains(.,\"Особенности узора\")]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//div[@class=\"label\"][contains(.,\"Особенности объекта\")]")).click();
        Thread.sleep(3000);

        //driver.findElement(By.xpath("/html/body/div[1]/a[position()=last()]")).click();

        driver.switchTo().newWindow(WindowType.TAB);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //culture rf
        driver.get("https://www.culture.ru/");

        driver.findElement(By.xpath("//button[@title=\"Поиск\"]")).click();
        driver.findElement(By.xpath("//input[@placeholder=\"Введите поисковый запрос\"]")).sendKeys("Пушкин");
        driver.findElement(By.xpath("//button[@aria-label=\"Поиск\"]")).click();

        WebDriverWait webDriverWait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"notify-bar_footer\"]/button")));
        driver.findElement(By.xpath("//div[@class=\"notify-bar_footer\"]/button")).click();

        WebDriverWait webDriverWait4 = new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"https://www.culture.ru/s/pushkin/\"]")));
        driver.findElement(By.xpath("//a[@href=\"https://www.culture.ru/s/pushkin/\"]")).click();
        driver.findElement(By.xpath("//div[@id=\"recorddiv31884470\"]/div[@class=\"t-cover__arrow\"]")).click();
        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(3000);
        driver.close();

        Thread.sleep(3000);
        driver.quit();
    }
}
