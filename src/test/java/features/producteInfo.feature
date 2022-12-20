@InformacioProducte
Feature: Gestio/Consulta producte

  @EntrarAUnProducte
  Scenario: Consultar informacio de un producte
    Given the user is in the index page
    When the user clicks ViewProduct of the first product
    Then the user is in the product information page

	@AfegirProducteIMirarCarrito
	Scenario: Afegir un producte al carro i comprovar que esta al carrito
		Given the user is in the index page
		And the user is logged in
		When the user clicks ViewProduct of the first product
		And the user adds product to cart
		Then checks the item is in the cart
		
	@AfegirReview
	Scenario: Veure un producte i afegir una critica
		Given the user is in the index page
    When the user clicks ViewProduct of the first product
		And the user enters data by id "name" "Carl"
		And the user enters data by id "email" "Carl@gmail.com"
		And the user enters data by id "review" "nice"
		And the user clicks the button submit
		Then verify that the website gets the review

