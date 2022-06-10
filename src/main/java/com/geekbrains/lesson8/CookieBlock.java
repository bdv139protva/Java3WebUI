package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CookieBlock{
    private SelenideElement cookieButton = $(By.xpath("//span[contains(.,'Понятно, спасибо')]/parent::button[@type='button']"));

    @Step("Клик на кнопке в сообщении о куках для его закрытия")
    public MainPage closeCookie() {
        cookieButton.click();
        return page(MainPage.class);
    }

}
