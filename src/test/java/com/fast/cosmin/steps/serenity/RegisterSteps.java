package com.fast.cosmin.steps.serenity;

import com.fast.cosmin.pages.MyAccountPage;
import com.fast.cosmin.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import java.util.Random;

public class RegisterSteps extends ScenarioSteps {

    private RegisterPage registerPage;
    private MyAccountPage myAccountPage;
    private char[] passwordChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private char[] lowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char[] upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private StringBuffer firstNameBuffer = new StringBuffer();
    private StringBuffer lastNameBuffer =new StringBuffer();
    private StringBuffer passwordBufer = new StringBuffer();
    private Random letters = new Random();
    private String firstName;
    private String lastName;
    private String password;
    private String emailAddress;

    @Step
    public void navigateToRegisterPage(){
        registerPage.open();
    }

    @Step
    private void generateFirstName(){
        for (int i = 0; i < 1; i++) {
            char firstLeterRandom = upperCase[letters.nextInt(upperCase.length)];
            firstNameBuffer.append(firstLeterRandom);
            for (int j = 0; j < 4; j++) {
                char nextLetersRandom = lowerCase[letters.nextInt(lowerCase.length)];
                firstName = firstNameBuffer.append(nextLetersRandom).toString();
            }
        }
    }

    @Step
    private void generateLastName(){
        for (int i = 0; i < 1; i++) {
            char firstLeterRandom = upperCase[letters.nextInt(upperCase.length)];
            lastNameBuffer.append(firstLeterRandom);
            for (int j = 0; j < 10; j++) {
                char nextLetersRandom = lowerCase[letters.nextInt(lowerCase.length)];
                lastName = lastNameBuffer.append(nextLetersRandom).toString();
            }
        }
    }

    @Step
    private void generatePassword(){
        for (int j = 0; j < 10; j++) {
            char passwordRandom = passwordChar[letters.nextInt(passwordChar.length)];
            password = passwordBufer.append(passwordRandom).toString();
        }
    }

    @Step
    private void generateEmailAddress(){
        emailAddress = firstName+"."+lastName+"@domain.com";
    }

    @StepGroup
    public void generateRandom(){
        generateFirstName();
        generateLastName();
        generateEmailAddress();
        generatePassword();

    }

    @Step
    public void completeRegisterForms(){
        registerPage.setFirstNameField(firstName);
        registerPage.setLastNameField(lastName);
        registerPage.setEmailAddressField(emailAddress);
        registerPage.setPasswordField(password);
        registerPage.setConfirmationPasswordField(password);
    }

    @Step
    public void clickRegister(){
        registerPage.clickRegisterButton();
    }

    @Step
    public void checkRegistration(){
        Assert.assertTrue(myAccountPage.registerComplete());
    }
}
