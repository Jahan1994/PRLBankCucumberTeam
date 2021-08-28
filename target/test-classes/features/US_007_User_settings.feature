@US_007
Feature: User Info Email Functionality
  Background: User goes to login page
    Given User go to Url "homepage_url"
    And User click menuIcon
    Then User click signInButton
    Then User enter a valid Username
    Then User enter a valid Password
    Then User click sign in button


  Scenario Outline: US_007 TC_01_02_03_04_05 Email id can not update without @ sign or . extension
    Given User click account menu
    Then User click user info
    Then User send "<User Info invalid email adress>" into email box
    And  User click save button
    Then User varifies that can not update with "<User Info invalid email adress>"
    Then user closes the page

    Examples: invalid email adress
      |User Info invalid email adress|
      |12345                         |
      |12345xxxmail.com              |
      |12345@gmailcom                |
      |abcdxxx                       |
      |abcdxxx@mailcom               |


  @language
  Scenario: US_007 TC_06 There should not be an option of any other language other than English or Turkish
    Given user click to account menu
    And   user click to user info
    And   user see an option language dropdown
    Then  user assert that there is no option other than English and Turkish


#    Scenario: US_007 TC_701 User can not update with invalid email address
#      Given user click to account menu
#      And   user click to user info
#      And   user send  new email into the email box
#      And   user click save button
#      Then  user assert that user account can not update with invalid email address