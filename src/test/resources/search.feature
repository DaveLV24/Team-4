@regression
Feature: Search tests

  @TC-001-AO
  Scenario Outline: Search field exists on all pages
    Given Open page: "<page>"
    Then Find search field
    Examples:
      | page                   |
      | books                  |
      | computers              |
      | desktops               |
      | notebooks              |
      | accessories            |
      | electronics            |
      | camera-photo           |
      | cell-phones            |
      | apparel-shoes          |
      | digital-downloads      |
      | jewelry                |
      | gift-cards             |
      | register               |
      | login                  |
      | cart                   |
      | wishlist               |
      | sitemap                |
      | shipping-returns       |
      | privacy-policy         |
      | conditions-of-use      |
      | about-us               |
      | contactus              |
      | search                 |
      | news                   |
      | blog                   |
      | recentlyviewedproducts |
      | compareproducts        |
      | newproducts            |

  @TC-002-AO
  Scenario Outline: Search field works on the all pages
    Given Open page: "<page>"
    When Type "Phone" in the search Text-Field
    And Press search button
    Then I see founded items with name "Phone"
    Examples:
      | page                   |
      | books                  |
      | computers              |
      | desktops               |
      | notebooks              |
      | accessories            |
      | electronics            |
      | camera-photo           |
      | cell-phones            |
      | apparel-shoes          |
      | digital-downloads      |
      | jewelry                |
      | gift-cards             |
      | register               |
      | login                  |
      | cart                   |
      | wishlist               |
      | sitemap                |
      | shipping-returns       |
      | privacy-policy         |
      | conditions-of-use      |
      | about-us               |
      | contactus              |
      | search                 |
      | news                   |
      | blog                   |
      | recentlyviewedproducts |
      | compareproducts        |
      | newproducts            |

  @TC-003-AO
  Scenario Outline: Count of items matches in item menu and search result
    Given Open page home page
    When Type "<search value>" in the search Text-Field
    And Count elements in the item menu
    And Press search button
    And Count elements in the search result page
    Then Compare count results
    Examples:
      | search value |
      | pho          |
      | diam         |
      | card         |
      | book         |
