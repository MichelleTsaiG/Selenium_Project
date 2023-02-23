Feature: Search SauceDemo

  Background:

    Given user navigates to https://www.saucedemo.com/

  Scenario Outline: User goes to the about tab, returns to items list, then adds the 4 most expensive items to the cart and checkout

    Given user inputs <username> and <password>
    And selects Login
    Then User selects About tab
    Given returns to items page
    When filters items from least to most expensive
    And adds the four most expensive items from the list to the cart
    Then go to the checkout cart
    Then go to the user input page
    Then input <firstName>, <lastName>, and <postalCode>
    Then check and verify information
    Then finalize checkout

    Examples:
    | username      | password     | firstName | lastName | postalCode |
    | standard_user | secret_sauce | Michelle  | Tsai     |   11300    |