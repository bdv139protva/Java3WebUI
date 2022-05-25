package com.geekbrains.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class SpecialProjectPushkinPage extends BaseView{

    public SpecialProjectPushkinPage(WebDriver driver) {

        super(driver);
    }
    //проверить свг и юрл
    @FindBy(xpath = "//div[@id='recorddiv31884470']/div[@class='t-cover__arrow']")
    public WebElement svgButtonInCover;

    public void checkCorrectCoverInPage(String expectedText) {
        Assertions.assertAll(
                () -> Assertions.assertEquals(driver.getCurrentUrl(), "https://www.culture.ru/s/pushkin/"),
                () -> Assertions.assertTrue(new SpecialProjectPushkinPage(driver).svgButtonInCover.isDisplayed())
        );
    }
}
