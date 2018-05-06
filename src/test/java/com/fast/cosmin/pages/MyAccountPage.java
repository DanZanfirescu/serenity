package com.fast.cosmin.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://fasttrackit.org/selenium-test/customer/account/")
public class MyAccountPage extends PageObject {

    @FindBy(css = ".success-msg span")
    private WebElementFacade succesRegisterMessage;
    public boolean registerComplete(){
        waitFor(succesRegisterMessage);
        return succesRegisterMessage.containsText("Thank you for registering with Madison Island.");
    }

    @FindBy(css = ".header-language-container .welcome-msg")
    private WebElementFacade welcomeTextHeaderParagraph;
    public boolean isLoggedIn() {
        waitFor(welcomeTextHeaderParagraph);
        return welcomeTextHeaderParagraph.containsText("WELCOME, DAN DANFIRESCU!");
    }

    @FindBy(css = "#search")
    private WebElementFacade searchField;
    public void setSearchField(String searchWord){
        waitFor(searchField);
        typeInto(searchField, searchWord);
    }

    @FindBy(css = ".search-button")
    private WebElementFacade searchButton;
    public void click(){
        clickOn(searchButton);
    }

}
