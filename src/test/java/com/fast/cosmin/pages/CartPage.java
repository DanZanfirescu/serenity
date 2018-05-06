package com.fast.cosmin.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://fasttrackit.org/selenium-test/checkout/cart/")
public class CartPage extends PageObject{

    @FindBy(css = ".success-msg")
    private WebElementFacade succesMsg;
    @FindBy(css = "#empty_cart_button")
    private WebElementFacade emptyCartButton;


    public String msg(){
        return succesMsg.getText();
    }
    public void clickOnEmptyCart(){
        clickOn(emptyCartButton);
    }



}
