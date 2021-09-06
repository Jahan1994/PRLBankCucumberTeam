
Feature: Api testing customer

  Background:
    Given User first should get a token by using API "https://gmibank-qa-environment.com/api/authenticate"

  @Customer_validation
  Scenario: Read and validate customer data
 # Given User first should get a token by using API "https://gmibank-qa-environment.com/api/authenticate"
    Given read all customer data using with api endpoint "https://gmibank-qa-environment.com/api/tp-customers?size=2000"
    Then deserialize using ObjectMapper
    Then validate customer data


  @Customer_id_validation
  Scenario: Read and validate customer data 1 by 1

    Given read customer data using with api endpoint <"https://gmibank-qa-environment.com/api/tp-customers/42323">
    Then validate customer by id














#
#
#  Scenario Outline: User validate the updated country with UI
#    Given User on the home page "homepage_url"
#    Then  User clicks menu icon
#    And  User navigates to Login page
#    And User enter valid "employee_username"
#    And  User enters valid "employee_password"
#    Then User cliks sign in button
#    And User clicks My Opertions
#    Then User select Manage Customers
#    And User clicks Create a New Customer
#    And User enter Country "country"
#    Then user validates this updated country with UI "<name>"
#    Examples: Update country
#      |name|id|
#      |Updated ANGARA|94844|
##    |Update with Api2|18872|
##    |Update with Api3|18873|
##    |Update with Api4|18874|
##    |Update with Api5|18875|
#
#
#
#
#  Scenario Outline: database ders bank7 read and validate created data using with ssn
#    Given user creates a connection with db using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"
#    And user updates a country data by using "<query>" and "<columnName>"
#    Then user validates this updated country with Database
#    Examples: database read the data
#      |query|columnName|
#      |Select * from tp_country|id|
#
#  Scenario Outline: User validate the updated country with UI
#    Given User on the home page "homepage_url"
#    Then  User clicks menu icon
#    And  User navigates to Login page
#    And User enter valid "employee_username"
#    And  User enters valid "employee_password"
#    Then User cliks sign in button
#    And User clicks My Opertions
#    Then User select Manage Customers
#    And User clicks Create a New Customer
#    And User enter Country "country"
#    Then user validates this updated country with UI "<name>"
#    Examples: Update country
#      |name|id|
#      |Update with Api|18871|
##      |Update with Api2|18872|
##      |Update with Api3|18873|
##      |Update with Api4|18874|
##      |Update with Api5|18875|