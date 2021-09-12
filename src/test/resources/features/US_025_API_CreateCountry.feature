@US_025
Feature: Create country

  Background:
    Given user should get a token by using API "https://gmibank-qa-environment.com/api/authenticate"

  Scenario: read country
    Then user reads all countries from end point "https://gmibank-qa-environment.com/api/tp-countries"

  Scenario:  create country
    Then user sets the response using api end point "https://gmibank-qa-environment.com/api/tp-countries" and creates country

  Scenario:  assert country
    Then user asserts for new country