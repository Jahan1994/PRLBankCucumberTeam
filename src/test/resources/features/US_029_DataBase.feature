Feature: database testing
  Background: create connection with DB
    Given user creates a connection with db using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"

  @DB_customer
  Scenario Outline: test all customer info based on DB
    Then user reads the Customers data using "<query>" and "<columnName>"
    Then user save DB Customer info to correspondent files
    Then user validates customers data

    Examples: All customer DB data
      | query                     | columnName |
      | Select * from tp_customer | ssn |


  @DB_country
  Scenario Outline: test all country info based on DB
    Then user reads the country data using "<query>" and "<columnName>"
    Then user save DB country info to correspondent files
    Then user validates all countries' info

    Examples:
      | query                    | columnName |
      | Select * from tp_country | id         |



  @DB_state
  Scenario Outline: test state info based on DB
    Then user reads the names of the state from USA "<query>" and "<columnName>"
    Then user validates the names of the state from USA

    Examples:
      | query                                                                                                   | columnName |
      | select distinct state from tp_customer where country_id in (select id from tp_country where name='USA') | state      |


