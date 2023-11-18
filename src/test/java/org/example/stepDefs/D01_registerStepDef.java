package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;


public class D01_registerStepDef {
    P01_register register = new P01_register();

    @Given("user go to register page")
    public void goRegisterPage() {
        register.registerLink().click();
    }

    @When("user select gender type")
    public void userSelectGenderType() {
        register.selectGenderType().click();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String arg0, String arg1) {
        register.enterUserName(arg0, arg1);
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        register.enterBirthDay();
        register.enterBirthMonth();
        register.enterBirthYear();
    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String arg0) {
        register.enterEmail(arg0);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String arg0, String arg1) {
        register.enterPassword(arg0, arg1);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.clickRegisterButton();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        register.validation();
    }


}
