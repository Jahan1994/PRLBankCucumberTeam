Feature: US_16

  Background:
    Given User on the home page "homepage_url"
    Then User clicks menu icon
    And  User navigates to Login page
    And User enter valid "customer_username1"
    And  User enters valid "customer_password1"
    Then User cliks sign in button
    Then User clicks My Opertions
    Then User clicks Money Transfer



  Scenario: Money Transfer

    And User selects account from dropdown menu
    And User selects account from the to drop-down menu
    And User enters "amountus15" in the balance text box
    And User enters "descriptionus15" in the description text box
    And User click Make Transfer icon
    Then Assert  visible text
    And User close driver




  Scenario: Negative Money Transfer From the From Drop-down Menu

    And User selects account from dropdown menu
    And User selects account from the to drop-down menu
    And User remove from account
    And User enters "amountus15" in the balance text box
    And User enters "descriptionus15" in the description text box
    And User click Make Transfer icon
    And The test that money cannot be transferred
    And User close driver


  Scenario: Negative Money Transfer from To drop-down Menu

    And User selects account from dropdown menu
    And User do not selects account from the to drop-down menu
    And User enters "amountus15" in the balance text box
    And User enters "descriptionus15" in the description text box
    And User click Make Transfer icon
    And The test that money cannot be transferred
    And User close driver


  Scenario: Negative Money Transfer Balance Text Box

    And User selects account from dropdown menu
    And User selects account from the to drop-down menu
    And User do not enter amount in balance text box
    And User enters "descriptionus15" in the description text box
    And User click Make Transfer icon
    And The test that money cannot be transferred
    And User close driver


  Scenario: Negative Money Transfer from Description Text Box

    And User selects account from dropdown menu
    And User selects account from the to drop-down menu
    And User enters "amountus15" in the balance text box
    And User do not enters description in the description text box
    And User click Make Transfer icon
    And The test that money cannot be transferred from description
    And User close driver