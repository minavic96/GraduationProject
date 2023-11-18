package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homepage;

public class D04_searchStepDef {
    P03_homepage homepage = new P03_homepage();

    @When("user search using {string}")
    public void userSearchUsing(String arg0) {
        homepage.search(arg0);
    }

    @Then("user should find products with same {string}")
    public void userShouldFindProductsWithSame(String arg0) {
        homepage.validate(arg0);
    }

    @Then("user should find products with {string}")
    public void userShouldFindProductsWith(String arg0) {
        homepage.selectResult();
        homepage.makingSureSkuIsCorrect(arg0);
    }

}
