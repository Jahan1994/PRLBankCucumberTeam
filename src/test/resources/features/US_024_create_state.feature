
@CreateState
Feature: System should allow to create states info using api end point

  Scenario Outline: User create each state 1 by 1
    Given User should get a token as first step "https://gmibank-qa-environment.com/api/authenticate"
    Then User using api end point "<endpoint>" create state

    Examples: create state
      | endpoint                                         |
      | https://gmibank-qa-environment.com/api/tp-states |
      | https://gmibank-qa-environment.com/api/tp-states |


  Scenario Outline:
    Given User should get a token as first step "https://gmibank-qa-environment.com/api/authenticate"
    Then User reads all states from end pointt "https://gmibank-qa-environment.com/api/tp-states"
    Then User verifies new state using "<idJson>" and "<nameJson>"


    Examples: create state
      | idJson | nameJson |
      | 24377  | Edinburg |



#    ========================Us_027========
  Scenario Outline:
    Given User should get a token as first step "https://gmibank-qa-environment.com/api/authenticate"
    Then User reads all states from end point "https://gmibank-qa-environment.com/api/tp-states"
    Then User verifies new state using "<idJson>"


    Examples: create state
      | idJson |
      | 24353  |
      | 24355  |
      | 20849  |
      | 20850  |
      | 24352  |



  @Statedeletion
  Scenario Outline: Delete states
    Given User should get a token as first step "https://gmibank-qa-environment.com/api/authenticate"
    Then user deletes a state using "<endpoint>" and "<id>"

    Examples: all data
      | endpoint                                          | id    |
      | https://gmibank-qa-environment.com/api/tp-states/ | 24377  |


  Scenario Outline:
    Given User should get a token as first step "https://gmibank-qa-environment.com/api/authenticate"
    Then User verifies new state deleted "<idJson>"


    Examples: create state
      | idJson |
      | 24377   |







