Feature: Search Product Validation

  Scenario: Search product on the home page by shortname
    Given user is on GreenCart Landing page
    When user searched with shortname "Tom" and extracted actual name of product
    Then user searched for "Tom" shortname in offers page
    And validate product name in offers page match with landing page