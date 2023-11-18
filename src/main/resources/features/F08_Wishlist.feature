@smoke
Feature: Adding product to Wishlist

  Scenario: 1
    When Clicking on wishlist button on the product HTC One M8 Android L 5.0 Lollipop
    Then User should see a green successful message

  Scenario: 2
    When Clicking on wishlist button on the product HTC One M8 Android L 5.0 Lollipop
    And Wait until message disappear
    And Go to Wishlist page
    Then User should see QTY of product bigger than 0