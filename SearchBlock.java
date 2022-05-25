package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBlock extends BaseView {
    public SearchBlock(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@title='Поиск']")
    public WebElement searchButtonInHeader;

    @FindBy(xpath = "//input[@placeholder='Введите поисковый запрос']")
    public WebElement searchInputInForm;

    @FindBy(xpath = "//button[@aria-label='Поиск']")
    public WebElement searchButtonInForm;

    public PushkinSearchPage search(String searchText) {
        searchButtonInHeader.click();
        searchInputInForm.sendKeys(searchText);
        searchButtonInForm.click();
        return new PushkinSearchPage(driver);
    }

}
