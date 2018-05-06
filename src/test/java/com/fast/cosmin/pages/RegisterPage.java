package com.fast.cosmin.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://fasttrackit.org/selenium-test/customer/account/create/")
public class RegisterPage extends PageObject {

    @FindBy(css = "#firstname")
    private WebElementFacade firstNameField;
    public void setFirstNameField(String firstName){
        typeInto(firstNameField, firstName);

    }

    @FindBy(css = "#lastname")
    private WebElementFacade lastNameField;
    public void setLastNameField(String lastname){
        typeInto(lastNameField, lastname);
    }

    @FindBy(css = "#email_address")
    private WebElementFacade emailAddressField;
    public void setEmailAddressField(String emailAddress){
        typeInto(emailAddressField, emailAddress);
    }

    @FindBy(css = "#password")
    private WebElementFacade passwordField;
    public void setPasswordField(String password){
        typeInto(passwordField, password);
    }

    @FindBy(css = "#confirmation")
    private WebElementFacade confirmationPasswordField;
    public void setConfirmationPasswordField(String password){
        typeInto(confirmationPasswordField, password);
    }

    @FindBy(css = ".buttons-set .button ")
    private WebElementFacade registerButton;
    public void clickRegisterButton(){
        clickOn(registerButton);
    }
}
