@addCart @allTests
Feature: As a user I want to see the product detail,
  I can see product name, in stock value and add to cart button.
  when an item is added to cart,the number items in card in header should be updated.
  It should not be possible to add more items into cart than there is in stock.


Background:
  Given User navigates to url
  @1231
  Scenario Outline: User clicks the product and The add to cart button should be visible
    When User clicks the product "<product>"
    Then The add to cart button should be visible

    Examples:
      | product       |
      | iPad 4 Mini   |

  @1232
  Scenario Outline: User clicks the product and product name should be visible
    When User clicks the product "<product>"
    Then Product name should be visible

    Examples:
      | product           |
      | iPad 4 Mini         |

  @1233
  Scenario Outline: User clicks the product and The stock information should be shown
    When User clicks the product "<product>"
    Then The stock information should be shown

    Examples:
      | product           |
      | iPad 4 Mini         |

  @1234
  Scenario Outline: User clicks the product and the add to cart button should be visible
    When User clicks the product "<product>" when it is in stock
    Then The stock in "<stockin>" should be visible

    Examples:
      | product           | stockin |
      | iPad 4 Mini         |    2    |


  @1237
  Scenario Outline: The product is added to cart and the cart number should be increased
    When User clicks the product "<product>"
    And User clicks add to cart button
    Then The cart number should be increased

    Examples:
      | product           |
      | iPad 4 Mini       |

  @1238
  Scenario Outline: The product is added to cart and the stock information should be updated
    When User clicks the product "<product>"
    And User clicks add to cart button
    Then The stock information should be updated

    Examples:
      | product           |
      | iPad 4 Mini       |

  @1239
  Scenario Outline: The product is added to cart and the add to cart button should be visible
    Then User clicks the product "<product>" when it is in stock
    When User clicks add to cart button
    Then The add to cart button should be visible

    Examples:
      | product           |
      | iPad 4 Mini       |

  @1240
  Scenario Outline: Products are added until it is out of stock and the add to cart button should be
    When User clicks the product "<product>" when it is out of stock "<stockValue>"
    And User clicks add to cart button
    Then The add to cart button should be enabled

    Examples:
      | product                | stockValue |
      | iPad 4 Mini            | 2          |
      | H&M T-Shirt White      | 10         |
      | Charli XCX - Sucker CD | 5          |

  @1241
  Scenario Outline: Items added when it is out of stock and In stock is equal  to 0
    When User clicks the product "<product>" when it is out of stock "<stockValue>"
    And User clicks add to cart button
    Then In stock value is equal to zero

    Examples:
      | product                | stockValue |
      | iPad 4 Mini            | 2          |
      | H&M T-Shirt White      | 10         |
      | Charli XCX - Sucker CD | 5          |

