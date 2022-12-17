@Login
Feature: Login

	@LoginCorrecte
	Scenario: Login Correcte
	  Given the user is in the index page
    And the user enters the signup or login page
    And the user enters data by xpath "//html//body//div[1]//div//form//input[2]" "NoSoyUnBot@Bot.Cat"
    And the user enters data by name "password" "123456789"
    And the user clicks the login button
    Then I validate the login was correct
    
  @LoginIncorrecte
  Scenario: Login incorrecte
    Given the user is in the index page
    And the user enters the signup or login page
    And the user enters data by xpath "//html//body//div[1]//div//form//input[2]" <mail>
    And the user enters data by name "password" <pswd>
    And the user clicks the login button
    Then I validate the login was incorrect
    
Examples:
		| mail                | pswd         |
		| "asdf@a.a"          | "asdfg"      |
		|"NoSoyUnBot@Bot.Cat" | "1234567890" |
		|"NoSoyUnBot@Bot.Cat" | "12345678"   |




	
      

