@US15
Feature: US_015

  Background:
    Given User on the home page "homepage_url"
    Then User clicks menu icon
    And  User navigates to Login page
    And User enter valid "customer_username1"
    And  User enters valid "customer_password1"
    Then User cliks sign in button
    Then User clicks My Opertions
    Then User cliks My Accounts




  Scenario:View transfer transactions
    Then User clicks View Transfer
    And User verifies that Transfer transactions are displayed
    And User close driver



  Scenario: User verifies Account id and balance populated
    Then User verifies account id
    Then User verifies balance populated
    And User close driver