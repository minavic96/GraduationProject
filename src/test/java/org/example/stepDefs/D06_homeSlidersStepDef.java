package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homepage;

public class D06_homeSlidersStepDef {
    P03_homepage homepage = new P03_homepage();

    @When("user click on first slider")
    public void userClickOnFirstSlider() {
        homepage.selectSlider1();
    }

    @Then("the user should go to the Samsung url")
    public void theUserShouldGoToTheSamsungUrl() {
        homepage.verifySlider1();
    }

    @When("user click on second slider")
    public void userClickOnSecondSlider() {
        homepage.selectSlider2();
    }

    @Then("the user should go to the iphone url")
    public void theUserShouldGoToTheIphoneUrl() {
        homepage.verifySlider2();
    }
}
