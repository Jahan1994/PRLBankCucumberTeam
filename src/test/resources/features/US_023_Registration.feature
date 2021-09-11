Feature:System should allow to read all registration info using api end point
  Background:
    Given user takes a token by using api "https://gmibank-qa-environment.com/api/authenticate"
  @Registration_validation

  Scenario: Read and validate registration data
    Then read all registration data using with api endpoint "https://gmibank-qa-environment.com/api/tp-account-registrations"
    And validate registration data





  Scenario:Read all registration you created and validate them 1 by 1
    Given Read all registration you created and validate them one by one using API "https://gmibank-qa-environment.com/api/tp-account-registrations"