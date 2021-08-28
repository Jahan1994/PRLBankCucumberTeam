
Feature: US_001 Pozitif Registration with valid credentials
#  Background: Open page
#    Given user goes to "gmibank_url"
#    Then user cliks menu icon
#    And user clicks to register

#  bu metodu sadece SignIN tiklayabilmek icin olusturdum Ahmet abi bu metodu kendi feature sayfasinda olusturacak.
#  Sonra ben buradan silerim
      Scenario:
        Given User on the home page "homepage_url"
        Then User clicks menu icon
        And  User navigates to Login page

  @registration
  Scenario: TC_001 Success registration with valid credentials
    Given User on the home page "homepage_url"
    Then User clicks menu icon
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

  Scenario: TC User cannot login with invalid SSN validating the error message