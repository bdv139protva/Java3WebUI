package com.geekbrains.lesson6;

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

    public SpecialProjectPushkinPage selectEntity(String entity) {
        entityPushkinList.stream()
                .filter(e -> e.getText().equals(entity))
                .findFirst()
                .get()
                .click();
        return new SpecialProjectPushkinPage(driver);
    }
}
