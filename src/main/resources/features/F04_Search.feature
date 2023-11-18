@smoke
Feature: Search

  Scenario Outline: 1
    When    user search using "<product name>"
    Then user should find products with same "<product name>"
    Examples:
      | product name |
      | book         |
      | laptop       |
      | nike         |

  Scenario Outline: 2
    When user search using "<sku>"
    Then user should find products with "<sku>"
    Examples:
      | sku       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |


