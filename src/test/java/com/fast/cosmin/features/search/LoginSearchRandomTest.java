package com.fast.cosmin.features.search;

import com.fast.cosmin.steps.serenity.LoginSearchtRandomSteps;
import com.fast.cosmin.steps.serenity.LoginSteps;
import com.fast.cosmin.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginSearchRandomTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximise(){
        driver.manage().window().maximize();
    }
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private LoginSearchtRandomSteps loginSearchtRandomSteps;
    @Steps
    private SearchSteps searchSteps;

    @Test
    public void searchTest(){
       loginSteps.loginStepsGroup();
       searchSteps.searchStepsGroup();
       loginSearchtRandomSteps.selectRandomProduct();
       loginSearchtRandomSteps.clickReqiuredFields();
       loginSearchtRandomSteps.addToCart();
       loginSearchtRandomSteps.checkProductInCart();
       loginSearchtRandomSteps.emptyCart();
    }
}
