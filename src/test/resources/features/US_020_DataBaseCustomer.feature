Feature: database testing
  Background: create connection
    Given database user creates a connection with db using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"

 @database
Scenario Outline: database read and validate created data using with ssn

# Given database user creates a connection with db using "jdbc:postgresql://157.230.48.97:5432/gmibank_db" , "techprodb_user" and "Techpro_@126"
Then database user reads the Customers data using "<query>" and "<columnName>"
Then database validate customers data

Examples: database demo read the data
|query|columnName|
|Select * from tp_customer|ssn|