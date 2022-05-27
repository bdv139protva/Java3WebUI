package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CookieBlock extends BaseView {

    public CookieBlock(WebDriver driver) {
        super(driver);
    }

    private final static String COOKIE_XPATH_LOCATOR = "//span[contains(.,'Понятно, спасибо')]/parent::button[@type='button']";

    @FindBy(xpath = COOKIE_XPATH_LOCATOR)
    public WebElement cookieButton;

    @Step("Клик на кнопке в сообщении о куках для его закрытия")
    public MainPage closeCookie() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(COOKIE_XPATH_LOCATOR)));
        cookieButton.click();
        return new MainPage(driver);
    }

}
