@son
Feature: US_017_TC01701-04 System should allow the Admin to manage users

  Background:
    Given User on the home page "homepage_url"
    And User clicks menu icon
    Then User navigates to Login page
    Then enters valid <"admin_username"> as admin
    Then enters a valid <"admin_password">  as admin
    Then clicks the sing in button
    Then clicks on the Administration link from the active page
    Then clicks on the User Management link from the dropdown menu

  @TC01701-01704
  Scenario Outline: Admin can activate all roles
    Then user clicks on the date
    Then user searches for "<userName>"
    Then activates the user
    Then clicks save button
    Then asserts the updated message

    Examples:
      | userName   |
      | sibel      |
      | testadmin5 |
      | testadmin4 |
      | testadmin3 |
      | testadmin2 |
      | testadmin1 |

#
#  @TC01705-01708
#  Scenario Outline: Admin can view all roles
#
#    Then selects "<profile>" role and clicks the view button
#
#    Then asserts that the user info is displayed
#
#
#    Examples:
#
#      | profile       |
#      | ROLE_USER     |
#      | ROLE_EMPLOYEE |
#      | ROLE_MANAGER  |
#      | ROLE_ADMIN    |
#
#  @TC01709-01712
#  Scenario Outline: Admin can edit all roles
#    Then clicks "<profile>" edit button
#    Then updates user info
#    Then clicks save button
#    Then asserts the updated message
#
#    Examples:
#      | profile       |
#      | ROLE_USER     |
#      | ROLE_EMPLOYEE |
#      | ROLE_MANAGER  |
#      | ROLE_ADMIN    |
#
#
#  @TC01713-01716
#  Scenario Outline:
#    Then user searches for "<userName>" to delete
#    Then confirms delete operation
#    Then asserts the updated message
#
#    Examples:
#      | userName   |
#      | sibel      |
#      | testadmin5 |
#      | testadmin4 |
#      | testadmin3 |
#      | testadmin2 |
#      | testadmin1 |