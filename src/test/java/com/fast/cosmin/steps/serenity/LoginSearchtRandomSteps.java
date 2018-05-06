package com.fast.cosmin.steps.serenity;

import com.fast.cosmin.pages.CartPage;
import com.fast.cosmin.pages.ProductPage;
import com.fast.cosmin.pages.SearchResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;

public class LoginSearchtRandomSteps extends SearchSteps {

    private SearchResultPage searchResultPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @Step
    public void readNumberOfProductsDisplayed() {
        searchResultPage.readNumberOfProductsDisplayed();
    }
    @Step
    public void readTotalNumberOfProducts() {
        searchResultPage.readTotalNumberOfProducts();
    }
    @Step
    public void computeTotalNumberOfPages() {
        searchResultPage.totalNumberOfPages();
    }
    @Step
    public void generateRandomPage() {
        searchResultPage.randomPageNumber();
    }
    @Step
    public void navigateToRandomPage() {
        searchResultPage.navigateToRandomPage();
    }
    @Step
    public void generateRandomProduct() {
        searchResultPage.randomProduct();
    }
    @Step
    public void clickOnRandomProduct(){
        searchResultPage.moveToProductAndClick();
    }

    @StepGroup
    public void selectRandomProduct() {
    readNumberOfProductsDisplayed();
    readTotalNumberOfProducts();
    computeTotalNumberOfPages();
    generateRandomPage();
    navigateToRandomPage();
    generateRandomProduct();
    clickOnRandomProduct();
    }

    @Step
    public void clickReqiuredFields(){
        productPage.setColorOption();
        productPage.setSizeOption();
        productPage.setShoeSizeOption();
        productPage.setCheckBoxOption();
        productPage.listOfSelectionOption();
        productPage.setTableOption();
    }
    @Step
    public void addToCart(){
        productPage.addToCart();
    }
    @Step
    public void checkProductInCart(){
        String msg = cartPage.msg();
        System.out.println(msg);
        Assert.assertTrue(msg.toUpperCase().contains(searchResultPage.selectedProductName));

    }
    @Step
    public void emptyCart(){
        cartPage.clickOnEmptyCart();
    }
}

