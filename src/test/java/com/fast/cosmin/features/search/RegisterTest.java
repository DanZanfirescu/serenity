package com.fast.cosmin.features.search;

import com.fast.cosmin.steps.serenity.RegisterSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class RegisterTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
    }

    @Steps
    private RegisterSteps registerSteps;

    @Test
    public void registerTest(){
        registerSteps.navigateToRegisterPage();
        registerSteps.generateRandom();
        registerSteps.completeRegisterForms();
        registerSteps.clickRegister();
        registerSteps.checkRegistration();
    }
}
