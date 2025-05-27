@Regression

Feature: Basic HTML Form Testing
  As a user
  I want to check if products on Website display required information

TC001SS
  Scenario: Open the product and check information inside
    Given I navigate to the section page
    When I open a product
    And I am redirected to the product page
    Then I can see all required information about this product

# Scenario Outline: Open the product and check information inside
#    Given I open the "<Product>"
#    When I can see all required information about this product
#   Examples:
#     | Product                                                        |
#     |https://demowebshop.tricentis.com/computing-and-internet        |
#     |https://demowebshop.tricentis.com/copy-of-computing-and-internet|
#     |https://demowebshop.tricentis.com/fiction                       |
#     |https://demowebshop.tricentis.com/fiction-ex                    |
#     |https://demowebshop.tricentis.com/health                        |
#     |https://demowebshop.tricentis.com/science                       |
#

#@TC002SS
#Scenario: Open the product and check required buttons inside
#  When I open a product
#  And I am redirected to the product page
#  Then I can see "Compare" button is displayed
#  And I can see "Add to Cart" button is displayed
#  And I can see "Add to Wish List" button is displayed
#
#  @TC001SS
#  Scenario: Open the product and check available options are displayed
#    When I open a product
#    And I am redirected to the product page
#    Then I can see avaliable options are displayed

