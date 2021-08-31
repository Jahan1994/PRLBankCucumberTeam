@hal
Feature:US_012_An Employee can manage Customer

  Scenario:
    Given User on the home page "homepage_url"
    Then  User clicks menu icon
    And  User navigates to Login page
    And User enter valid "employee_username"
    And  User enters valid "employee_password"
    Then User cliks sign in button
    And User clicks My Opertions
    Then User select Manage Customers

  Scenario: User see all their manage customers info populated
    And User sees all registrations info
      |ID|
      |First Name|
      |Last Name |
      |Middle Initial|
      |Email         |
      |Mobile Phone Number|
      |Phone Number       |
      |Address            |
      |Create Date        |


  Scenario: When user click view button, user can see customer information in their own page
    And User click view button
    Then User sees all information populated
   And User sees edit button

  Scenario: There should be an Edit button where all customer information can be populated
    Then User clicks edit button
    And User sees all editable information populated

  Scenario: The Edit portal can allow user to create or update the user info
   # When User click edit button
    Then User update information
    And User back customerHomePage

  Scenario: User can delete a customer, but seeing a message if the user is sure about deletion
    When User click delete button
    Then User sees confirm delete operation message
   # And User click second delete button
   # And User sees success edit message
