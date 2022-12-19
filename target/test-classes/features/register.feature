
    
@Register
Feature: Register user

  @RegistreNormal
  Scenario: Registrar Usuari 
    Given the user is in the index page
    And the user enters the signup or login page
    When the user puts his name
    And the user enters data by xpath "//html//body//div[3]//div//form//input[3]" "hahahaha@gmail.com"
    And the user clicks the signup button
    And the user selects male gender
    And the user enters data by id "password" "contrasenya"
    And the user selects some value by id "days" "17"
    And the user selects some value by id "months" "January"
    And the user selects some value by id "years" "2003" 
    And the user enters data by id "first_name" "Juan"
    And the user enters data by id "last_name" "Garcia"
    And the user enters data by id "address1" "Carrer UserTest"
    And the user enters data by id "address2" "Carrer de les Sitges"
    And the user selects some value by id "country" "Israel" 
    And the user enters data by id "state" "nose"
    And the user enters data by id "city" "Haifa"
    And the user enters data by id "zipcode" "12345"
    And the user enters data by id "mobile_number" "123456789"
    And the user clicks button account
    Then I validate account is created
   
   @BorrarUsuari
   Scenario: El usuari borra el compte que acabem de crear
   Given the user is in the index page
   When the user deletes account
   Then I validate account has been deleted
    
   @RegistreAmbCorreuUsat
   Scenario: Registrar incorrectament
    Given the user is in the index page
    And the user enters the signup or login page
    When the user puts his name
    And the user puts his email address
    And the user clicks the signup button
    Then the website shows mail is used
    
    
    
    
