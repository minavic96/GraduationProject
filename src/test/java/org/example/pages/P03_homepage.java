package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

import static org.example.dtos.Data.*;

public class P03_homepage {
    //elements
    private final By categories = By.xpath("//ul[@class=\"top-menu notmobile\"]/li");
    private final By currency = By.id("customerCurrency");
    private final By price = By.cssSelector("[class=\"price actual-price\"]");
    private final By search = By.cssSelector("[placeholder=\"Search store\"]");
    private final By searchButton = By.cssSelector("[type=\"submit\"]");
    private final By results = By.cssSelector("[class=\"product-title\"] [href]");
    private final By sku = By.cssSelector("[class=\"additional-details\"] [id]");
    private final By title = By.cssSelector("div[class=\"page-title\"] h1\n");
    private final By slider1 = By.cssSelector("[rel=\"0\"]");
    private final By slider2 = By.cssSelector("[rel=\"1\"]");
    private final By facebook = By.cssSelector("[href=\"http://www.facebook.com/nopCommerce\"]");
    private final By twitter = By.cssSelector("[href=\"https://twitter.com/nopCommerce\"]");
    private final By rss = By.cssSelector("[href=\"/news/rss/1\"]");
    private final By youtube = By.cssSelector("[href=\"http://www.youtube.com/user/nopCommerce\"]");
    private final By wishlistProducts = By.cssSelector("[title=\"Add to wishlist\"]");
    private final By wishlistButton = By.cssSelector("[class=\"wishlist-label\"]");
    private final By successMessage = By.cssSelector("[class=\"bar-notification success\"]");
    private final By qty = By.cssSelector("[class=\"qty-input\"]");


    //private final By slider = By
    //actions
    public void pressingCurrencyButton() {
        Select select = new Select(Hooks.driver.findElement(currency));
        select.selectByIndex(1);
    }

    public void checkEuroCurrency() {
        for (int i = 0; i < 3; i++) {
            String prices = Hooks.driver.findElements(price).get(i).getText();
            Assert.assertTrue(prices.contains("€"));
        }
    }

    public void search(String a) {
        Hooks.driver.findElement(search).sendKeys(a);
        Hooks.driver.findElement(searchButton).click();
    }

    public void validate(String b) {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Hooks.driver.getCurrentUrl(),expectedUrl.concat(b));
       for (int i = 0; i < Hooks.driver.findElements(results).size(); i++) {
          soft.assertTrue(Hooks.driver.findElements(results).get(i).getText().toLowerCase().contains(b));
        }
        soft.assertAll();
    }

    public void selectResult() {
        Hooks.driver.findElement(results).click();
    }

    public void makingSureSkuIsCorrect(String c) {
        Assert.assertEquals(Hooks.driver.findElement(sku).getText(), c);
    }

    public void hover() {
        Random random = new Random();
        Actions actions = new Actions(Hooks.driver);
        int min = 0;
        int max = 2;
        int randomNum = random.nextInt(max - min + 1) + min;
        actions.moveToElement(Hooks.driver.findElements(categories).get(randomNum)).perform();
        String selectedCategoryText = Hooks.driver.findElements(categories).get(randomNum).getText();
        int randomNum2 = random.nextInt((max - min) + 1) + 1;
        By subcategory = By.xpath("//ul[@class=\"sublist first-level\"]/li[" + randomNum2 + "]");
        Hooks.driver.findElements(subcategory).get(randomNum).click();
        String selectedSubCategoryText = Hooks.driver.findElements(subcategory).get(randomNum).getText();
        Assert.assertTrue(Hooks.driver.findElement(title).getText().contains(selectedSubCategoryText));
    }

    public void selectSlider1() {
        Hooks.driver.findElement(slider1).click();
    }

    public void verifySlider1() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),expectedSlider1);
    }

    public void selectSlider2() {
        Hooks.driver.findElement(slider2).click();
    }

    public void verifySlider2() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), expectedSlider2);
    }

    public void openFacebook() {
        Hooks.driver.findElement(facebook).click();
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
    }

    public void checkFacebook(String f) {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), f);
    }

    public void openTwitter() {
        Hooks.driver.findElement(twitter).click();
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
    }

    public void openRSS() {
        Hooks.driver.findElement(rss).click();
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
    }

    public void openYoutube() {
        Hooks.driver.findElement(youtube).click();
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
    }

    public void addingItemToWishlist() {
        Hooks.driver.findElements(wishlistProducts).get(2).click();
    }

    public void checkingOnSuccessMessage() {
        String color = Hooks.driver.findElement(successMessage).getCssValue("background-color").toLowerCase();
        String text = Hooks.driver.findElement(successMessage).getText();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(color, "rgba(75, 176, 122, 1)");
        soft.assertTrue(text.contains("The product has been added to your wishlist"));
        soft.assertAll();

    }

    public void waiting() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(wishlistButton));
    }

    public void goToWishList() {
        Hooks.driver.findElement(wishlistButton).click();
    }

    public void checkingWishlist(int i) {
        String quantity = Hooks.driver.findElement(qty).getAttribute("value");
        int q = Integer.parseInt(quantity);
        Assert.assertTrue(q > i);
    }

}


