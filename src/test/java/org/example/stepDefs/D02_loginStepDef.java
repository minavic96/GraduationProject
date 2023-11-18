package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Login;

public class D02_loginStepDef {
    P02_Login login = new P02_Login();

    @When("user go to login page")
    public void userGoToLoginPage() {
        login.openLoginPage();
    }

    @And("user login with valid {string} and {string}")
    public void userLoginWithValid(String arg0, String arg1) {
        login.enteringEmail(arg0, arg1);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.pressingLogin();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        login.validation();
    }

    @And("user login with invalid {string} and {string}")
    public void userLoginWithInvalid(String arg0, String arg1) {
        login.enteringEmail(arg0, arg1);
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        login.notValidate();
    }
}
