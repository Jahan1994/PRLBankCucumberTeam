Feature:

  Background:
    Given user should first get a bearer token with end point "https://gmibank-qa-environment.com/api/authenticate"

  @read_country
  Scenario: read countries

    Then user reads all countries and write country ids to txt using api endpoint "https://gmibank-qa-environment.com/api/tp-countries"

  @create_country
  Scenario: Create a country
    And user creates an country "https://www.gmibank.com/api/tp-countries"

  @@validate_country
  Scenario: Validate created country
    Then user validates this created new country

  @update_country
  Scenario Outline:  Update country
    Given user update a country using api end point "https://gmibank-qa-environment.com/api/tp-countries"  "<name>" and its extension "<id>"
    And user validates this updated country with Api end point "https://gmibank-qa-environment.com/api/tp-countries" "<name>" and its extension "<id>"
    Examples: Update country
      |name|id|
      |Updated ULKE|21156|
#      |Update with Api2|18872|
#      |Update with Api3|18873|
#      |Update with Api4|18874|
#      |Update with Api5|18875|



Scenario Outline: User validate the updated country with UI
  Given User on the home page "homepage_url"
  Then  User clicks menu icon
  And  User navigates to Login page
  And User enter valid "employee_username"
  And  User enters valid "employee_password"
  Then User cliks sign in button
  And User clicks My Opertions
  Then User select Manage Customers
  And User clicks Create a New Customer
  And User enter Country "country"
  Then user validates this updated country with UI "<name>"
  Examples: Update country
    |name|id|
    |Updated ANGARA|94844|
#    |Update with Api2|18872|
#    |Update with Api3|18873|
#    |Update with Api4|18874|
#    |Update with Api5|18875|




  Scenario Outline: database ders bank7 read and validate created data using with ssn
    Given user creates a connection with db using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"
    And user updates a country data by using "<query>" and "<columnName>"
    Then user validates this updated country with Database
    Examples: database read the data
      |query|columnName|
      |Select * from tp_country|id|

  Scenario Outline: User validate the updated country with UI
    Given User on the home page "homepage_url"
    Then  User clicks menu icon
    And  User navigates to Login page
    And User enter valid "employee_username"
    And  User enters valid "employee_password"
    Then User cliks sign in button
    And User clicks My Opertions
    Then User select Manage Customers
    And User clicks Create a New Customer
    And User enter Country "country"
    Then user validates this updated country with UI "<name>"
    Examples: Update country
      |name|id|
      |Update with Api|18871|
#      |Update with Api2|18872|
#      |Update with Api3|18873|
#      |Update with Api4|18874|
#      |Update with Api5|18875|






#
#  @create_country
#  Scenario: Create a country
#    And create country "https://gmibank-qa-environment.com/api/tp-countries"
#
#
#  @@validate_country
#  Scenario: Validate created country
#    Then validate created a country
#
#  @delete_country
#  Scenario Outline: Delete country
#    Given delete updated a country using endpoint "<endPoint>" and its extension "<id>" and validate
#    Examples: Delete Country ders
#      |endPoint                                |id    |
#      |https://gmibank-qa-environment.com/api/tp-countries|/93279|