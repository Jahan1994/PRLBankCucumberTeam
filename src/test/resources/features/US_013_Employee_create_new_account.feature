Feature: US_0013 A Employee can create a new Account (EMPLOYEE olarak dusunecegiz)

  @Employeeaccountcreatesave
  Scenario: Navigate login page
    Given Employee on the home page "homepage_url"
    Then Employee clicks menu icon
    Then Employee navigates to Login page
    Then Employee provides username and password
      |username|password|
      |team53employee|Team53employee.|
    Then Employee logs in
    And Employee navigates to my operations
    When Employee clicks on manageAccount
    Then Employee creates a new account

  @Employeeaccountcreatesave
  Scenario Outline: TC_1301_User should create a description for the new account and it cannot be blank
    Given Employee types a description "<description>"

    Examples: all data
      |description|balance|accountType|accountStatusType|
      |Instructor saving account|10000|CHECKING|ACTIVE  |
    # |Instructor checking account|2000|SAVING|ACTIVE|

  @Employeeaccountcreatesave
  Scenario Outline: TC_1302	User should provide a balance for the first time account creation as Dollar
    And Employee types the balance as "<balance>"

    Examples: all data
      |description|balance|accountType|accountStatusType|
      |Instructor saving account|100000|CHECKING|ACTIVE  |
    # |Instructor checking account|2000|SAVING|ACTIVE|

  @Employeeaccountcreatesave
  Scenario Outline: TC_1303	User can select an account type as CHECKING, SAVING, CREDIT_CARD or INVESTING
    Then Employee selects an account type from dropdown "<accountType>"

    Examples: all data
      |description|balance|accountType|accountStatusType|
      |Instructor saving account|10000|CHECKING|ACTIVE  |
    # |Instructor checking account|2000|SAVING|ACTIVE|

  @Employeeaccountcreatesave
  Scenario Outline: TC_1304	Account status should be defined as ACTIVE, SUSPENDED or CLOSED
    When Employee selects an accountStatusType "<accountStatusType>"
    Examples: all data
      |description|balance|accountType|accountStatusType|
      |Instructor saving account|10000|CHECKING|ACTIVE  |
    # |Instructor checking account|2000|SAVING|ACTIVE|

  @Employeeaccountcreatesave
  Scenario Outline: TC_1305	User can select an Create and Close Date
    Given Employee selects a current create date
    Given Employee selects a closed date
    And Employee clicks on save button
    Then Employee confirm that he saves the account with success
    Given Employee close the browser

    Examples: all data
      |description|balance|accountType|accountStatusType|
      |Instructor saving account|10000|CHECKING|ACTIVE  |
    # |Instructor checking account|2000|SAVING|ACTIVE|

#  @Employeeaccountcreatesave
#  Scenario Outline: TC_1306	User can select an employee from the drop-down
##    And Employee selects an employee
#    And Employee clicks on save button
#    Then Employee confirm that he saves the account with success
#    Given Employee close the browser
#
#    Examples: all data
#      |description|balance|accountType|accountStatusType|
#      |Instructor saving account|10000|CHECKING|ACTIVE  |

  @Employeeaccountcreateback
  Scenario Outline: TC_1307	There should be a back button on the page
    Given Employee on the home page "homepage_url"
    Then Employee clicks menu icon
    Then Employee navigates to Login page
    Then Employee provides username and password
      |username|password|
      |team53employee|Team53employee.|
    Then Employee logs in
    And Employee navigates to my operations
    When Employee clicks on manageAccount
    Then Employee creates a new account
    Given Employee types a description "<description>"
    And Employee types the balance as "<balance>"
    Then Employee selects an account type from dropdown "<accountType>"
    When Employee selects an accountStatusType "<accountStatusType>"
    Given Employee selects a current create date "<currentDate>" "<currentTime>"
    Given Employee selects a closed date "<closedDate>" "<currentTime>"
#    And Employee selects an employee
    Then Employee clicks on back button
    Then Employee confirm that he comes back to the manage account page
    And Employee close the browser
    Examples: all data
      |description|balance|accountType|accountStatusType|currentDate|currentTime|closedDate|
      |Instructor saving account|10000|CHECKING|ACTIVE  |            |          |           |
    # |Instructor checking account|2000|SAVING|ACTIVE|






