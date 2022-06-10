package com.geekbrains.lesson8;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class PushkinSearchPage{
    //spisok
     private ElementsCollection entityPushkinList = $$(By.xpath("//div[@class='entity-list-v2_title']/a"));

    @Step("Клик на нужную ссылку на странице результатов поиска")
    public SpecialProjectPushkinPage selectEntity(String entity) {
        entityPushkinList.findBy(text(entity)).click();
        return page(SpecialProjectPushkinPage.class);
    }
}
