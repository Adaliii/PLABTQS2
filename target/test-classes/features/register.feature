@Register
Feature: Register user

  @RegistreNormal
  Scenario: Registrar Usuari 
    Given the user is in the home page
    When the user clicks the signup or login button
    And the user puts his name
    And the user puts his email address
    And the user clicks the signup button
    And the user enters personal data
    And the user clicks button account
    Then I validate account is created
    
   @RegistreAmbCorreuUsat
   Scenario: Registrar incorrectament
    Given the user is in the home page
    When the user clicks the signup or login button
    And the user puts his name
    And the user puts his email address
    And the user clicks the signup button
    Then the website shows mail is used
