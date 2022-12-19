
@Checkout
Feature: Checkout

  @FerCheckout
  Scenario: Fer el checkout
    Given the user is in the index page
  	And the user is logged in
  	And the user has added an item to the cart
    And the user enters the cart page
    When the user clicks the checkout button
    And the user clicks the place order button
    And the user enters data by name "name_on_card" "Daniel Ponsa"
    And the user enters data by name "card_number" "12345678909876246"
    And the user enters data by name "cvc" "420"
    And the user enters data by name "expiry_month" "12"
    And the user enters data by name "expiry_year" "2026"
    And the user clicks the pay and confirm order button
    Then order placed appears
    
