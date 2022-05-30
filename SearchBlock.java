package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SearchBlock {
    private SelenideElement searchButtonInHeader = $(By.xpath("//button[@title='Поиск']"));
    private SelenideElement searchInputInForm = $(By.xpath("//input[@placeholder='Введите поисковый запрос']"));
    private SelenideElement searchButtonInForm = $(By.xpath("//button[@aria-label='Поиск']"));

    @Step("Поиск через заполение поисковой строки в шапке страницы")
    public PushkinSearchPage search(String searchText) {
        searchButtonInHeader.click();
        searchInputInForm.sendKeys(searchText);
        searchButtonInForm.click();
        return page(PushkinSearchPage.class);
    }

}
