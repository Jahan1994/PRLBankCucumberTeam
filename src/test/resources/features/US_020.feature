
Feature: Api testing customer

  Background:
    Given User first should get a token by using API "https://gmibank-qa-environment.com/api/authenticate"

  @Customer_validation
  Scenario: Read and validate customer data

    Given read all customer data using with api endpoint "https://gmibank-qa-environment.com/api/tp-customers?size=2000"
    Then deserialize using ObjectMapper
    Then validate customer data


  @Customer_id_validation
  Scenario: Read and validate customer data 1 by 1

    Given read customer data using with api endpoint <"https://gmibank-qa-environment.com/api/tp-customers/42323">
    Then validate customer by id





