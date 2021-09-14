Feature:
  Scenario Outline:
    Given user goes to database and write it and then make a PDF from Database and UI "<email>"
    Examples:
      | email  |
      |       |

  Scenario Outline: Active a new user as admin
    Given User on the home page "homepage_url"
    And User clicks menu icon
    Then User navigates to Login page
    Then enters valid <"admin_username"> as admin
    Then enters a valid <"admin_password">  as admin
    Then user logs in
#    Then clicks the sing in button
    Then clicks on the Administration link from the active page
    Then clicks on the User Management link from the dropdown menu
    Then user clicks on the date
    Given user goes to database and write it and then make a PDF from Database and UI "<email>"
#    Then user searches for "<userName>"
#   Then activates the user
#   Then clicks save button
#    Then asserts the updated message
#    And user close the browser
#    And user sing out from the page
    Examples:
      | userName   |
      | sibel      |