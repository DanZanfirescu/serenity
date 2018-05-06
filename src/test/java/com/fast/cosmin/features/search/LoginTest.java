package com.fast.cosmin.features.search;

import com.fast.cosmin.steps.serenity.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximise(){
        driver.manage().window().maximize();
    }
    @Steps
    private LoginSteps loginSteps;

    @Test
    public void checkLoginWithValidCredentials(){
        loginSteps.navigateToHomePage();
        loginSteps.navigateToLogin();
        loginSteps.setCredentials("danzanf@yahoo.com", "abc123");
        loginSteps.clickLogin();
        loginSteps.userIsLoggedIn();
    }
}
