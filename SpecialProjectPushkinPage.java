package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SpecialProjectPushkinPage {
    //проверить свг и юрл
    private SelenideElement svgButtonInCover = $(By.xpath("//div[@id='recorddiv31884470']/div[@class='t-cover__arrow']"));

    @Step("Проверка корректности адреса страницы и отображения svg кнопки на ней")
    public void checkCorrectCoverInPage() {

        //svgButtonInCover.scrollTo();

        Assertions.assertAll(
                () -> svgButtonInCover.shouldBe(visible),
                () -> webdriver().shouldHave(url("https://www.culture.ru/s/pushkin/"))
        );
    }
}
