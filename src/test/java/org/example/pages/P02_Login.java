package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import static org.example.dtos.Data.*;

public class P02_Login {
    //elements
    private final By login = By.cssSelector("[class=\"ico-login\"]");
    private final By email = By.id("Email");
    private final By password = By.id("Password");
    private final By loginButton = By.cssSelector("[class=\"button-1 login-button\"]");
    private final By myAccount = By.cssSelector("[class=\"ico-account\"]");
    private final By unSucessful = By.cssSelector("[class=\"message-error validation-summary-errors\"]");

    //Actions
    public void openLoginPage() {
        Hooks.driver.findElement(login).click();
    }

    public void enteringEmail(String a, String b) {
        Hooks.driver.findElement(email).sendKeys(a);
        Hooks.driver.findElement(password).sendKeys(b);
    }

    public void pressingLogin() {
        Hooks.driver.findElement(loginButton).click();
    }

    public void validation() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(), expected);
        softAssert.assertTrue(Hooks.driver.findElement(myAccount).isDisplayed());
        softAssert.assertAll();
    }

    public void notValidate() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Hooks.driver.findElement(unSucessful).getText().contains(errorMessage));
        softAssert.assertEquals(Hooks.driver.findElement(unSucessful).getCssValue("color"), Color.fromString(red).asRgba());
        softAssert.assertAll();
    }
}
