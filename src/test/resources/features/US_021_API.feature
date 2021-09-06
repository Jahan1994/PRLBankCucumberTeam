Feature: "System should allow to read all countries info using api end point
  "https://www.gmibank-qa-environment.com/api/tp-countries"


  Background:
  Given User first should get a token by using API "https://gmibank-qa-environment.com/api/authenticate"



  Scenario: Read all country you created and validate them from your data set

    Then User should read all country by using API  "https://www.gmibank.com/api/tp-countries"
    And User should validate a country


    Scenario: Read all countries you created and validate them 1 by 1

      And Read all country you created and validate them one by one using API "https://www.gmibank.com/api/tp-countries"











