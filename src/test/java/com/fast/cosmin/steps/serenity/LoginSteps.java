package com.fast.cosmin.steps.serenity;


import com.fast.cosmin.pages.HomePage;
import com.fast.cosmin.pages.LoginPage;
import com.fast.cosmin.pages.MyAccountPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class LoginSteps extends ScenarioSteps{

    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private HomePage homePage;

    @Step
    public void navigateToHomePage(){
        homePage.open();
    }

    @Step
    public void navigateToLogin(){
        homePage.clickAccountLink();
        homePage.clickLoginOption();
    }

    @Step
    public void setCredentials(String username, String pass){
        loginPage.setUserEmailField(username);
        loginPage.setUserPassField(pass);
    }

    @Step
    public void clickLogin(){
        loginPage.clickLoginButton();
    }

    @Step
    public void userIsLoggedIn(){
        Assert.assertTrue(myAccountPage.isLoggedIn());
    }
    @Step
    public void userIsNotLoggedIn(){
        Assert.assertFalse(myAccountPage.isLoggedIn());
    }

    @StepGroup
    public void loginStepsGroup(){
        navigateToHomePage();
        navigateToLogin();
        setCredentials("danzanf@yahoo.com","abc123");
        clickLogin();
        userIsLoggedIn();
    }

}
