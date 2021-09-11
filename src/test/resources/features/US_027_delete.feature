@CreateState
Feature: System should allow to create states info using api end point

  Scenario Outline: User create each state 1 by 1
    Given User should get a token as first step "https://gmibank-qa-environment.com/api/authenticate"
    Then User using api end point "<endpoint>" create "<stateName>" and "<id>"

    Examples: create state
      | endpoint                                         | stateName  | id    |
     # | https://gmibank-qa-environment.com/api/tp-states | BAĞDAT     |24353  |
     # | https://gmibank-qa-environment.com/api/tp-states | RİYAD      | 24355 |
     # | https://gmibank-qa-environment.com/api/tp-states | ŞAM        | 20849 |
     # | https://gmibank-qa-environment.com/api/tp-states | ABU DABİ   | 20850 |
     # | https://gmibank-qa-environment.com/api/tp-states | KAHİRE     |24352  |


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
      | https://gmibank-qa-environment.com/api/tp-states/ | 59132 |


  Scenario Outline:
    Given User should get a token as first step "https://gmibank-qa-environment.com/api/authenticate"
    Then User verifies new state deleted "<idJson>"


    Examples: create state
      | idJson |
      | 59132  |































#
#@api_testing_ders_1
#Feature: Api testing ders 1
#  @Customer_validation
#  Scenario: Read and validate customer data
#    Given read all customer data using with api endpoint "https://gmibank.com/api/tp-customers"
#    Then validate customer data
#
#  @read_country
#  Scenario: read countries
#    Then read all countries and write country ids to txt using api endpoint "https://www.gmibank.com/api/tp-countries"
#
#
#  @create_country
#  Scenario: Create a country
#    And create country "https://www.gmibank.com/api/tp-countries"
#
#
#  @@validate_country
#  Scenario: Validate created country
#    Then validate created a country
#
#  @update_country
#  Scenario Outline:  Update country
#    And update created a country using api end point "https://www.gmibank.com/api/tp-countries"  "<name>" and its extension "<id>"
#
#    Examples: Update country
#      |name|id|
#      |Guncellenmis Ulke|93277|
#
#
#  @delete_country
#  Scenario Outline: Delete country
#    Given delete updated a country using endpoint "<endPoint>" and its extension "<id>" and validate
#    Examples: Delete Country ders
#      |endPoint                                |id    |
#      |https://www.gmibank.com/api/tp-countries%7C |/93270%7C|
#
#
#
