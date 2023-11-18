package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homepage;

public class D03_currenciesStepDef {

    P03_homepage homepage = new P03_homepage();

    @When("I select the Euro Currency from dropdown menu")
    public void iSelectTheEuroCurrencyFromDropdownMenu() {
        homepage.pressingCurrencyButton();
    }

    @Then("All products will be displayed in Euro Currency")
    public void allProductsWillBeDisplayedInEuroCurrency() {
        homepage.checkEuroCurrency();
    }
}
