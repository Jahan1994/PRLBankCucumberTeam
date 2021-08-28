@son
Feature: US_018 System should allow Manager to manage a customer

  Background:
    Given User on the home page "homepage_url"
    And User clicks menu icon
    Then User navigates to Login page
    Then enters valid <"manager_username"> as admin
    Then enters a valid <"manager_password">  as admin
    Then clicks the sing in button
    Then clicks on the My Operations link
    Then clicks on the Manage Customers link

  @TC_01801
  Scenario:
    Then asserts the elements visibility

  @TC_01802
  Scenario:
    Then asserts the view button is displayed
    Then clicks the view button
    Then asserts the edit button at the bottom

  @TC_01803
  Scenario:
    Then asserts the Edit button is displayed

  @TC_01804
  Scenario:
    Then clicks the edit button
    Then updates or creates user info
    Then clicks save button
    Then asserts the updated message

  @TC_01805
  Scenario:
    Then clicks the delete button
    Then asserts the deletion message
    Then clicks the delete button on the popup
    Then asserts the updated message