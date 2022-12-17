@Cart
Feature: Carrito

  @ClickHere
  Scenario: Clicar el here amb carrito buit
    Given the user is in the index page
    And the user enters the cart page
    When the user clicks the here button
    Then the user is redirected to the products page


  @EraseCartItem
  Scenario: Borrar item del carrito
  	Given the user is in the index page
  	And the user is logged in
  	And the user has added an item to the cart
    And the user enters the cart page
    And the user erases the product
    Then the cart is empty
    
  @CheckQuantity
  Scenario: Check quantity in cart
  	Given the user is in the index page
  	And the user is logged in
  	And the user has added an item to the cart
  	And the user enters the cart page
  	And the user is in the index page
  	And the user has added an item to the cart
  	And the user enters the cart page
  	Then the quantity of the product is "2"
  	
  	