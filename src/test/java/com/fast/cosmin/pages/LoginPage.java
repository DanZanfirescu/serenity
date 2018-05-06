package com.fast.cosmin.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://fasttrackit.org/selenium-test/customer/account/login/")
public class LoginPage extends PageObject{

    @FindBy(id = "email")
    private WebElementFacade userEmailField;

    @FindBy(id = "pass")
    private WebElementFacade userPassField;

    @FindBy(id = "send2")
    private WebElementFacade loginButton;

    public void setUserEmailField(String userName){
        typeInto(userEmailField, userName);
    }

    public void setUserPassField(String password){
        typeInto(userPassField, password);
    }

    public void clickLoginButton(){
        clickOn(loginButton);
    }

}
