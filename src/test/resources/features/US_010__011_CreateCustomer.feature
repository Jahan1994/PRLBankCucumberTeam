@Create
Feature: US_010_011 Create Customer
  #Background:
  Scenario:
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
    Then User sees SSN written



    Scenario:Middle Intial should be provided and cannot be left as blank
      And User enter MI "middle"


    Scenario:Mobile Phone Number should be provided and cannot be left as blank
      And User enter MP "mobile"


    Scenario:Phone Numer should be provided and cannot be left as blank
      And User enter PH "phone"


    Scenario:Zip Code  should be provided and cannot be left as blank
      And User enter ZC "zipcode"


    Scenario:Address as street and number should be provided and cannot be left blank
      And User enter Adress "adress"


    Scenario:City should be provided and cannot be left as blank
      And User enter City "city"


    Scenario:Country should be typed and cannot be blank
      And User enter Country "country"


    Scenario:State should be provided as US state and cannot be blank
      And User enter State"state"



    Scenario: The date cannot be typed earlier, in the past, at the time of creation a customer
      And User sees entered today date and time


    Scenario: The date cannot be typed earlier, in the past, at the time of creation a custome
      And User sees correct order date


    Scenario: User can choose a user from the registration and it cannot be blank
      And User choose valid user


    Scenario: There user can choose an account created on manage accounts
      And User choose valid account


    Scenario: User can select Zelle Enrolled optionally and save it
      And User click zelle enrolled check box
      Then User click save button to create customer
      And User sees success message2

