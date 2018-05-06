package com.fast.cosmin.steps.serenity;

import com.fast.cosmin.pages.HomePage;
import com.fast.cosmin.pages.MyAccountPage;
import com.fast.cosmin.pages.ProductPage;
import com.fast.cosmin.pages.SearchResultPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;


public class SearchSteps extends ScenarioSteps {
    private MyAccountPage myAccountPage;
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private ProductPage productPage;
    @Step
    public void navigateTo(){
        homePage.open();
    }
    @Step
    public void typeInFromHomePage(String searchWord){
        homePage.setSearchField(searchWord);
    }
    @Step
    private void  typeInFromMyAccountPage(String searchWord){
        myAccountPage.setSearchField(searchWord);
    }

    @Step
    public void clickSearchButtonFromHomePage(){
        homePage.click();
    }

    @Step
    private void clickSearchButtonFromMyAccountPage(){
        myAccountPage.click();
    }

    @Step
    public void searchResultPageIsDisplayed(){
        Assert.assertTrue(searchResultPage.searchResult());
    }
    @StepGroup
    public void searchStepsGroup(){
        typeInFromMyAccountPage("a");
        clickSearchButtonFromMyAccountPage();
        searchResultPageIsDisplayed();

    }


}
