Feature: User can add an item to cart in the E Commerce app

  Background:
    Given I see application opened

    Scenario: User can add a Pink Drop Shoulder Oversized T Shirt to cart
      And I click "pink drop shoulder oversized t shirt" link
      When I add to cart an element with color "Pink", size "36" and quantity "2"
      Then I should see the items added and the total