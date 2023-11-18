package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import static org.example.dtos.Data.green;
import static org.example.dtos.Data.success;

public class P01_register {

    //elements
    private final By register = By.className("ico-register");
    private final By gender = By.id("gender-male");
    private final By firstName = By.id("FirstName");
    private final By lastName = By.id("LastName");
    private final By day = By.cssSelector("[name=\"DateOfBirthDay\"]");
    private final By month = By.cssSelector("[name=\"DateOfBirthMonth\"]");
    private final By year = By.cssSelector("[name=\"DateOfBirthYear\"]");
    private final By email = By.id("Email");
    private final By password = By.cssSelector("[type=\"password\"]");
    private final By registerButton = By.id("register-button");
    private final By successMessage = By.cssSelector("[class=\"result\"]");

    //Actions
    public WebElement registerLink() {
        return Hooks.driver.findElement(register);

    }

    public WebElement selectGenderType() {
        return Hooks.driver.findElement(gender);
    }

    public void enterUserName(String f, String l) {
        Hooks.driver.findElement(firstName).sendKeys(f);
        Hooks.driver.findElement(lastName).sendKeys(l);
    }

    public void enterBirthDay() {
        Select birthDay = new Select(Hooks.driver.findElement(day));
        birthDay.selectByIndex(1);
    }

    public void enterBirthMonth() {
        Select birthMonth = new Select(Hooks.driver.findElement(month));
        birthMonth.selectByIndex(2);
    }

    public void enterBirthYear() {
        Select birthYear = new Select(Hooks.driver.findElement(year));
        birthYear.selectByValue("1996");
    }

    public void enterEmail(String e) {
        Hooks.driver.findElement(email).sendKeys(e);
    }

    public void enterPassword(String p, String pp) {
        Hooks.driver.findElements(password).get(0).sendKeys(p);
        Hooks.driver.findElements(password).get(1).sendKeys(pp);
    }

    public void clickRegisterButton() {
        Hooks.driver.findElement(registerButton).click();
    }

    public void validation() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Hooks.driver.findElement(successMessage).getText(), success);
        softAssert.assertEquals(Hooks.driver.findElement(successMessage).getCssValue("color").toLowerCase(), green);
        softAssert.assertAll();
    }
}

