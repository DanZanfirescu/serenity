package com.fast.cosmin.features.search;

import com.fast.cosmin.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximise(){
        driver.manage().window().maximize();
    }
    @Steps
    private SearchSteps searchSteps;

    @Test
    public void searchTest(){
        searchSteps.navigateTo();
        searchSteps.typeInFromHomePage("a");
        searchSteps.clickSearchButtonFromHomePage();
        searchSteps.searchResultPageIsDisplayed();
    }
}
