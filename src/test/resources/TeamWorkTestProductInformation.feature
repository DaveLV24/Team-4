@Sample

Feature: Basic HTML Form Testing
  As a user
  I want to check if products on Website display required information

@TC001SS
  Scenario Outline: Open the products at "Book" section and check information inside
    Given I navigate to the "Book" section page
    When I open a <product>
    And I am redirected to the product page
    Then I can see all required information about this product
  Examples:
    |product |
    |  1     |
    |  2     |
    |  3     |
    |  4     |
    |  5     |
    |  6     |


@TC002SS
Scenario Outline: Open the products at "Book" section and check required buttons inside
  Given I navigate to the "Book" section page
  When I open a <product>
  And I am redirected to the product page
  Then I can see "Add to compare list" button is displayed
  And I can see "Add to Cart" button is displayed
  And I can see "Add to Wish List" button is displayed
Examples:
    |product |
    |  1     |
    |  2     |
    |  3     |
    |  4     |
    |  5     |
    |  6     |

  @TC003SS
  Scenario Outline: Open the products at "Computers" section, "Desktop" subsection and check if "Available options" are displayed
    Given I navigate to subsection "Desktop" page
    When I open a <product>
    And I am redirected to the product page
    Then I can see "Available options" attributes are displayed
    Examples:
      |product |
      |  1     |
      |  2     |
      |  3     |
      |  4     |
      |  5     |
      |  6     |

