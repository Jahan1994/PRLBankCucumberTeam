@US_008
Feature: US_008_Password segment as user Homepage should be editable

  Background: User sign in
    Given User go to Url "homepage_url"
    And User click menuIcon
    Then User click signInButton
    Then User enter a valid Username
    Then User enter a valid Password
    Then User click sign in button
    Then User click user menu icon
    Then User click password icon
    Then User enter current password

  @US_008_TC_801
  Scenario: US_008_TC_801 old password can not be used again
    Given User enter old password as a new password
    Then User enter new old password for confirmation
    When User click save button for password
    Then User verifies the not saved message


  @US_008_TC_802
  Scenario: US_008_TC_802 There should be at least 1 lowercase char user see the level chart change accordingly
    Given User enter new password at least one lower_case
    Then User sees and verifies the change the level bar accordigly red

  @US_008_TC_803
  Scenario: US_008_TC_803 There should be at least 1 uppercase char and see the level chart change accordingly
    Given User enter new password at least one upper_case
    Then User sees and verifies the change the level bar accordigly orange

  @US_008_TC_804
  Scenario: US_008_TC_804 There should be at least 1 digit and see the level chart change accordingly
    Given User enter new password at least one digit
    Then User sees and verifies the change the level bar accordigly yellow

  @US_008_TC_805
  Scenario: US_008_TC_805 There should be at least 1 special char and see the level bar change accordingly
    Given User enter new password at least one special char
    Then User sees and verifies the change the level bar accordigly lime

  @US_008_TC_806
  Scenario: US_008_TC_806 There should be at least 7 chars for a stronger password
    Given User enter new password at least seven char
    Then User sees and verifies the change the level bar accordigly green


  @US_008_TC_807
  Scenario: US_008_TC_807 The new password should be confirmed
    Given User enter new password to change
    Then User enter new password confirmation
    Then User click save button for password
    Then User sees and verifies the password has changed