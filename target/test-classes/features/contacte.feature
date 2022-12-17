@Contacte
Feature: Contacte
  I want to use this template for my feature file

  @OmplirFormulari
  Scenario: Omplir el formulari de Contact Us
    Given the user is in the index page
    And the user enters the Contact us page
    When the user enters data by name "name" "Mr. White"
    And the user enters data by name "email" "NotAMail@gmail.com"
    And the user enters data by name "subject" "I don't know"
    And the user enters data by id "message" "I want to test this contact us thing"
    And the user clicks the submit button
    Then I validate the form was submitted

