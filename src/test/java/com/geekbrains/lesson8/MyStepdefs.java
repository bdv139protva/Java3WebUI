package com.geekbrains.lesson8;

import com.codeborne.selenide.Selenide;
import com.geekbrains.lesson8.MainPage;
import com.geekbrains.lesson8.PushkinSearchPage;
import com.geekbrains.lesson8.SpecialProjectPushkinPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("user on main page")
    public void userOnMainPage() {
        open("https://www.culture.ru/");
    }

    @When("close cookie block")
    public void closeCookieBlock() {
        new MainPage().cookieBlock.closeCookie();
    }

    @And("search {string} in search block")
    public void searchSearchTextInSearchBlock(String searchText) {
        new MainPage().searchBlock.search(searchText);
    }

    @And("select entity {string}")
    public void selectEntityEntity(String entity) {
        new PushkinSearchPage().selectEntity(entity);
    }

    @Then("check correct cover in page")
    public void checkCorrectCoverInPage() {
        new SpecialProjectPushkinPage().checkCorrectCoverInPage();
    }

    @After(value = "@close")
    public void quitBrowser() {
        Selenide.closeWebDriver();
    }
}
