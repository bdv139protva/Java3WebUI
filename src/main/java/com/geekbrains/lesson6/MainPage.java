package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
public class MainPage extends BaseView {
    public MainPage(WebDriver driver) {
        super(driver);
        searchBlock = new SearchBlock(driver);
        cookieBlock = new CookieBlock(driver);
    }

    public SearchBlock searchBlock;
    public CookieBlock cookieBlock;
}
