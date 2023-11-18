package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homepage;

public class D08_WishlistStepDef {
    P03_homepage homepage = new P03_homepage();

    @When("Clicking on wishlist button on the product HTC One M8 Android L 5.0 Lollipop")
    public void clickingOnWishlistButtonOnTheProduct() {
        homepage.addingItemToWishlist();
    }

    @Then("User should see a green successful message")
    public void userShouldSeeASuccessfulMessage() {
        homepage.checkingOnSuccessMessage();
    }

    @And("Wait until message disappear")
    public void waitUntilMessageDisappear() {
        homepage.waiting();
    }

    @And("Go to Wishlist page")
    public void goToWishlistPage() {
        homepage.goToWishList();
    }

    @Then("User should see QTY of product bigger than {int}")
    public void userShouldSeeQTYOfProductBiggerThan(int arg0) {
        homepage.checkingWishlist(arg0);
    }
}
