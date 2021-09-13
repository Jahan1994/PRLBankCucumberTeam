
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
      | 20843  | Edinburg |







