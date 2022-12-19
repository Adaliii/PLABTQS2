@Home
Feature: Subscriures/logout

	@SubscriuresCorrecte
	Scenario: Subscriures correctament
		Given the user is in the index page
		And the user puts their email address
		And the user clicks the arrow button
		Then the website shows that user has been successfully subscribed
			
	@SubscriuresIncorrecte
	Scenario: Subscriures incorrectament
		Given the user is in the index page
		And the user puts their name
		And the user clicks the arrow button
		Then the website does not subscribe the user
		
	@LogOut
	Scenario: Sortir del compte
		Given the user is in the index page
		And the user enters the signup or login page
    And the user enters data by name "email" "NoSoyUnBot@Bot.Cat"
    And the user enters data by name "password" "123456789"
    And the user clicks the login button
    And the user clicks the logout button
    Then the user is in the signup or login page