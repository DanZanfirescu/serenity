package com.fast.cosmin.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://fasttrackit.org/selenium-test/")
public class HomePage extends PageObject {


    @FindBy(css = ".skip-account")
    private WebElementFacade accountLink;
    @FindBy(css = "#header-account .last")
    private WebElementFacade loginOption;
    @FindBy(css = "#search")
    private WebElementFacade searchField;
    @FindBy(css = ".search-button")
    private WebElementFacade searchButton;


    public void clickAccountLink(){
        waitFor(accountLink);
        clickOn(accountLink);
    }

    public void clickLoginOption(){
        waitFor(loginOption);
        clickOn(loginOption);
    }

    public void setSearchField(String searchWord){
        waitFor(searchField);
        typeInto(searchField, searchWord);
    }

    public void click(){
        clickOn(searchButton);
    }


}
