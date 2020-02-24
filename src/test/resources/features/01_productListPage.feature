@productlist @allTests
Feature: As a user I want to see product list.

  @1230
  Scenario: When the page loads, items should be displayed
    When I navigate to url
    Then Items should be displayed
      | Product Name           |  Price   |
      | iPad 4 Mini            | $ 500.01 |
      | H&M T-Shirt White      | $ 10.99  |
      | Charli XCX - Sucker CD | $ 19.99  |
