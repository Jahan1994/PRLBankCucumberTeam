Feature: System should allow to read states using api end point
  "https://www.gmibank.com/api/tp-states"

  Background:
    Given User first should get a token by using Api_ "https://gmibank-qa-environment.com/api/authenticate"



  Scenario: Read all states you created and validate them from your data set
   # Given User first should get a token by using API "https://gmibank-qa-environment.com/api/authenticate"
    Then User should read all states by using API  "https://gmibank-qa-environment.com/api/tp-states"
    And User should validate a state


  Scenario:
    #  Given User first should get a token by using API "https://gmibank-qa-environment.com/api/authenticate"
    And Read all states you created and validate them one by one using API "https://gmibank-qa-environment.com/api/tp-states"
