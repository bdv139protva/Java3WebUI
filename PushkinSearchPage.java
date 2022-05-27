package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PushkinSearchPage extends BaseView {

    public PushkinSearchPage(WebDriver driver) {

        super(driver);
    }

    //spisok
    @FindBy(xpath = "//div[@class='entity-list-v2_title']/a")
    private List<WebElement> entityPushkinList;

    @Step("Клик на нужную ссылку на странице результатов поиска")
    public SpecialProjectPushkinPage selectEntity(String entity) {
        entityPushkinList.stream()
                .filter(e -> e.getText().equals(entity))
                .findFirst()
                .get()
                .click();
        return new SpecialProjectPushkinPage(driver);
    }
}
