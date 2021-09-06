@US_025
Feature: Create country

  Scenario:  create country
  #  Given user should get a token by using API "https://gmibank-qa-environment.com/api/authenticate"
    Then user sets the response using api end point "https://gmibank-qa-environment.com/api/tp-countries" and creates country
    Then user reads all countries from end point "https://gmibank-qa-environment.com/api/tp-countries"
    Then user asserts for new country
