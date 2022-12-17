@Products
Feature: Products

	@SearchProduct
	Scenario: Busca productes 

	Given the user is in the index page
	And the user enters the products page
	When the user enters "<name>" in the search bar
	And the user clicks the search button
	Then the product list appears

	Examples:
      	| name      | 
      	| dress     |    
      	| top       |
      	| saree     |
      	| inshallah |  
     
	@SearchCategory
	Scenario: Buscar productes amb una opció de les categories
	
	Given the user is in the index page
	And the user enters the products page
	When the user selects the "<category>" and the "<type>"
	Then the products from "<filter>" appear
	
	Examples:
				| category                                            | type                             | filter                          |
				| //div[@id='accordian']//div[1]//div//h4//a//span//i | //div[@id = 'Women']//li[1]//a   | WOMEN - DRESS PRODUCTS          |
				| //div[@id='accordian']//div[1]//div//h4//a//span//i | //div[@id = 'Women']//li[2]//a   | WOMEN - TOPS PRODUCTS           |
				| //div[@id='accordian']//div[1]//div//h4//a//span//i | //div[@id = 'Women']//li[3]//a   | WOMEN - SAREE PRODUCTS          |
				| //div[@id='accordian']//div[2]//div//h4//a//span//i | //div[@id = 'Men']//li[1]//a     | MEN - TSHIRTS PRODUCTS          |
				| //div[@id='accordian']//div[2]//div//h4//a//span//i | //div[@id = 'Men']//li[2]//a     | MEN - JEANS PRODUCTS            |
				| //div[@id='accordian']//div[3]//div//h4//a//span//i | //div[@id = 'Kids']//li[1]//a    | KIDS - DRESS PRODUCTS           |
				| //div[@id='accordian']//div[3]//div//h4//a//span//i | //div[@id = 'Kids']//li[2]//a    | KIDS - TOPS & SHIRTS PRODUCTS   |
				
	@SearchBrand
	Scenario: Buscar productes amb una opcio de les marques
	Given the user is in the index page
	And the user enters the products page
	When the user selects the "<brand>" brand
	Then the products from "<brandProducts>" appear
	
	Examples:
			| brand 											                               | brandProducts                       |
			| //a[contains(@href, '/brand_products/Polo')]               | BRAND - POLO PRODUCTS               |
			| //a[contains(@href, '/brand_products/H&M')]                | BRAND - H&M PRODUCTS                |
			| //a[contains(@href, '/brand_products/Madame')]             | BRAND - MADAME PRODUCTS             |
			| //a[contains(@href, '/brand_products/Mast & Harbour')]     | BRAND - MAST & HARBOUR PRODUCTS     |
			| //a[contains(@href, '/brand_products/Babyhug')]            | BRAND - BABYHUG PRODUCTS            |
			| //a[contains(@href, '/brand_products/Allen Solly Junior')] | BRAND - ALLEN SOLLY JUNIOR PRODUCTS |
			| //a[contains(@href, '/brand_products/Kookie Kids')]        | BRAND - KOOKIE KIDS PRODUCTS        |
			| //a[contains(@href, '/brand_products/Biba')]               | BRAND - BIBA PRODUCTS               |
	
	@AddItemToCart
	Scenario: Afegir un producte al carrito i veure que esta al carrito
		Given the user is in the index page
  	And the user is logged in	
  	And the user enters the products page
  	When the user adds blue top to the cart
  	And the user goes to the cart page
  	Then there is a blue top in the cart
				

	