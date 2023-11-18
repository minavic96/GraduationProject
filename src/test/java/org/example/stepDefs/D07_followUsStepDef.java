package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homepage;

public class D07_followUsStepDef {
    P03_homepage homepage = new P03_homepage();

    @When("user opens facebook link")
    public void userOpensFacebookLink() {
        homepage.openFacebook();
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String arg0) {
        homepage.checkFacebook(arg0);
    }

    @When("user opens twitter link")
    public void userOpensTwitterLink() {
        homepage.openTwitter();
    }

    @When("user opens rss link")
    public void userOpensRssLink() {
        homepage.openRSS();
    }

    @When("user opens youtube link")
    public void userOpensYoutubeLink() {
        homepage.openYoutube();
    }
}
