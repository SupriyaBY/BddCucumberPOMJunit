Feature: Testing Amazon Products Page

  Background: 
    Given the Amazon homepage is open
    When I search for products with the following criteria:
      | search_query | category               | sorting_option       |
      | laptop       | Electronics            | Price: Low to High   |
      | headphones   | Electronics            | Avg. Customer Review |
      | book         | Books                  | Featured             |
      | shoes        | Clothing & Accessories | Price: High to Low   |
      | camera       | Electronics            | Newest Arrivals      |
      | toys         | Toys & Games           | Best Sellers         |

  Scenario: Verify various interactions on the products page
    When I search for "<search_query>"
    And I filter by "<category>"
    And I sort by "<sorting_option>"
    Then I should see a list of products
    And I should be able to click on a product
