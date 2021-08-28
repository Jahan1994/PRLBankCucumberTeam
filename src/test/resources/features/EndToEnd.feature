Feature:
  @registrationwithjavafakervalues
  Scenario Outline: TC_002 Success registration with valid credentials with java faker
    Given User on the home page "homepage_url"
    Then User clicks menu icon
    And  User navigates to registration page
    Then User provides a valid SSN with javafaker as "<ssn>"
    Then User provides a valid Firstname with javafaker as "<firstname>"
    Then User provides a valid Lastname with javafaker as "<lastname>"
    Then User provides a valid Address with javafaker as "<address>"
    Then User provides a valid Mobile Phone Number with javafaker as "<mobilephone>"
    Then User provides a valid Username with javafaker as "<username>"
    Then User provides a valid Email with javafaker as "<email>"
    Then User provides a valid Password with javafaker as "<firstpassword>"
   Then User provides a valid Password to Password confirmation textbox with javafaker as "<secondpassword>"
    And User clicks on Register button
#    Then User clicks on Register button and validates that with a success message as "<message>"
#    And user close the browser

    Examples:
      | ssn | firstname | lastname | address | mobilephone | username | email | firstpassword | secondpassword | message |
      |     |           |           |         |            |          |       |               |                |         |

  @loginasadminandactiveuser
  Scenario Outline: Active a new user as admin

   Given User on the home page "homepage_url"
    Then User click menu icon
    And User click signIn Option
    Then user provides username "<userName>"
    Then user provides password "<passWord>"
    And User click secondSignInButton
#    And User see Failed Message
    Examples:
      | userName   | passWord    |
      |team53admin|Team53admin.|

    @loginasmanagerandaccountcreate
    Scenario Outline: Create a new acount as manager
      Given User on the home page "homepage_url"
      Then User clicks menu icon
      Then User navigates to Login page
      Then user provides username and password
        |username|password|
        |admin|admin|
        |team53manager|Team53manager.|
      Then user logs in
      And user navigates to my operations
      When user clicks on manageAccount
      Then user creates a new account
      Given user types a description "<description>"
      And user types the balance as "<balance>"
      Then user selects an account type from dropdown "<accountType>"
      When user selects an accountStatusType "<accountStatusType>"
      Given user selects a current create date "<currentDate>" "<currentTime>"
      Given user selects a closed date "<closedDate>" "<currentTime>"
#      And user selects an employee
      And user clicks on save button
#      Then user creates a new account
#      Given user types a description "<description>"
#      And user types the balance as "<balance>"
#      Then user selects an account type from dropdown "<accountType>"
#      When user selects an accountStatusType "<accountStatusType>"
#      Given user selects a current create date "<currentDate>" "<currentTime>"
#      Given user selects a closed date "<closedDate>" "<currentTime>"
##      And user selects an employee
#      And user clicks on save button
#      Then user confirm that he saves the account with success
      Examples: all data
        |description|balance|accountType|accountStatusType|currentDate|currentTime|closedDate|
        |saving account|10000|CHECKING|ACTIVE  |            |          |           |

  @loginasmanagerandaccountcreate
  Scenario Outline: Create a new acount as manager
    Given User on the home page "homepage_url"
    Then User clicks menu icon
    Then User navigates to Login page
    Then user provides username and password
      |username|password|
      |admin|admin|
      |team53manager|Team53manager.|
    Then user logs in
    And user navigates to my operations
    When user clicks on manageAccount
    Then user creates a new account
    Given user types a description "<description>"
    And user types the balance as "<balance>"
    Then user selects an account type from dropdown "<accountType>"
    When user selects an accountStatusType "<accountStatusType>"
    Given user selects a current create date "<currentDate>" "<currentTime>"
    Given user selects a closed date "<closedDate>" "<currentTime>"
#      And user selects an employee
    And user clicks on save button
    Examples: all data
      |description|balance|accountType|accountStatusType|currentDate|currentTime|closedDate|
      |saving2 account|50000|CHECKING|ACTIVE  |            |          |           |