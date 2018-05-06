package com.fast.cosmin.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class ProductPage extends PageObject {
    private SearchResultPage searchResultPage;

    @FindBy(css = ".product-options .clearfix .input-box #configurable_swatch_color")
    private WebElementFacade colorOption;
    @FindBy(css = ".product-options .clearfix .input-box #configurable_swatch_size")
    private WebElementFacade sizeOption;
    @FindBy(css = ".product-options .clearfix .input-box #configurable_swatch_shoe_size")
    private WebElementFacade shoeSizeOption;
    @FindBy(css = "#downloadable-links-list")
    private WebElementFacade checkBoxOption;
    @FindBy(css = ".product-options .bundle-option-select")
    private WebElementFacade selectionOption;
    @FindBy(css = ".product-options .input-box")
    private List<WebElementFacade> listOfSelection;
    @FindBy(css = ".qty-wrapper .input-text")
    private WebElementFacade qtyInputField;
    @FindBy(css = "#super-product-table")
    private WebElementFacade tableOption;
    @FindBy(css = "#super-product-table tr")
    private List<WebElementFacade> tableList;
    @FindBy(css = ".add-to-cart-buttons .btn-cart")
    private WebElementFacade buttonAddToCart;

    public void setColorOption(){
        if(colorOption.isCurrentlyVisible()){
            colorOption.findBy(".swatch-label").click();
        }
    }
    public void setSizeOption(){
        if(sizeOption.isCurrentlyVisible()){
            sizeOption.findBy(".swatch-label").click();
        }
    }
    public void setShoeSizeOption(){
        if(shoeSizeOption.isCurrentlyVisible()){
            shoeSizeOption.findBy(".swatch-label").click();
        }
    }
    public void setCheckBoxOption(){
        if(checkBoxOption.isCurrentlyVisible()){
            checkBoxOption.findBy("#downloadable-links-list label").click();
        }
    }
    public void listOfSelectionOption() {
        if (selectionOption.isCurrentlyVisible()) {
            for (int i = 0; i < listOfSelection.size(); i++) {
                listOfSelection.get(i).click();
                listOfSelection.get(i).findBy(".product-options .bundle-option-select").selectByIndex(1).click();
            }
        }
    }
    public void setTableOption(){
        if(tableOption.isCurrentlyVisible()){
                tableList.get(tableList.size()-1).findBy(".qty-wrapper .input-text").type("1");
                }
    }
    public void addToCart(){
        clickOn(buttonAddToCart);
    }




}
