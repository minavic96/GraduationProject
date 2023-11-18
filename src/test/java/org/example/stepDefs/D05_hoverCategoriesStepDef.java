package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homepage;

public class D05_hoverCategoriesStepDef {
    P03_homepage homepage = new P03_homepage();

    @When("Hovering over a random category and Selecting a random subcategory")
    public void hoveringOverCategories() {
        homepage.hover();
    }

    @Then("We can navigate to that random Category")
    public void weCanNavigateToThatRandomCategory() {
        // Included in Hover method
    }


}
