@Create
Feature: US_010_011 Create Customer
  Background:
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


  @US010TC01
    Scenario:Middle Intial should be provided and cannot be left as blank
    And User enter MI "middle"


    @US010T02
    Scenario:Mobile Phone Number should be provided and cannot be left as blank
      And User enter MP "mobile"


  @US010T03
  Scenario:Phone Numer should be provided and cannot be left as blank
    And User enter PH "phone"


  @US010T04
  Scenario:Zip Code  should be provided and cannot be left as blank
    And User enter ZC "zipcode"


  @US010T05
  Scenario:Address as street and number should be provided and cannot be left blank
    And User enter  Adress "adress"


  @US010T06
  Scenario:City should be provided and cannot be left as blank
    And User enter City "city"


  @US010T07
  Scenario:Country should be typed and cannot be blank
    And User enter Country "country"


  @US010T08
  Scenario:State should be provided as US state and cannot be blank
    And User enter State"state"

