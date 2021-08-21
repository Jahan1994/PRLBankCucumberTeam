@createcustomer
Feature: US_009 Search for a new applicant by their SSN
  Scenario:User see all their registration info populated
    Given User on the home page "homepage_url"
    Then  User clicks menu icon
    And  User navigates to Login page
    And User enter valid "employee_username"
    And  User enters valid "employee_password"
    Then User cliks sign in button
    And User clicks My Opertions
    Then User select Manage Customers
    And User clicks Create a New Customer
    And User enter "ssn"
     And User cliks Search button
    Then User sees success message
    And User sees firstname written
  And User sees lastname written
   And User sees Email written
    And User sees Adress written
   Then  User sees SSN written



