
Feature: US_001 Pozitif Registration with valid credentials
#  Background: Open page
#    Given user goes to "gmibank_url"
#    Then user cliks menu icon
#    And user clicks to register

#  bu metodu sadece SignIN tiklayabilmek icin olusturdum Ahmet abi bu metodu kendi feature sayfasinda olusturacak.
#  Sonra ben buradan silerim
      Background:
        Given User on the home page "homepage_url"
        Then User clicks menu icon
#        And  User navigates to Login page

  @registrationwithconcretevalues
  Scenario: TC_001 Success registration with valid credentials
#    Given User on the home page "homepage_url"
#    Then User clicks menu icon
    And  User navigates to registration page
    Then User provides a valid SSN
    Then User provides a valid Firstname
    Then User provides a valid Lastname
    Then User provides a valid Address
    Then User provides a valid Mobile Phone Number
    Then User provides a valid Username
    Then User provides a valid Email
    Then User provides a valid Password
    Then User provides a valid Password to Password confirmation textbox
    Then User clicks on Register button
    And  User validates that he registered succesfully

  @registrationwithjavafakervalues
  Scenario Outline: TC_002 Success registration with valid credentials with java faker
    And  User navigates to registration page
    Then User provides a valid SSN with javafaker as "<ssn>"
    Then User provides a valid Firstname with javafaker as "<firstname>"
    Then User provides a valid Lastname with javafaker as "<lastname>"
    Then User provides a valid Address with javafaker as "<address>"
    Then User provides a valid Mobile Phone Number with javafaker as "<mobilephone>"
    Then User provides a valid Username with javafaker as "<username>"
    Then User provides a valid Email with javafaker as "<email>"
    Then User provides a valid Password with javafaker as "<firstpassword>"
    Then User provides a valid Password to Password confirmation textbox with javafaker as "<secondpassword>"
    Then User clicks on Register button and validates that with a success message as "<message>"
#    And user close the browser

    Examples:
      | ssn | firstname | lastname | address | mobilephone | username | email | firstpassword | secondpassword | message |
      |     |           |           |         |            |          |       |               |                |         |