Feature: US_0019 System should allow Admin to create a new Account

  @accountcreatesave
  Scenario: Navigate login page
    Given User on the home page "homepage_url"
      Then User clicks menu icon
      Then User navigates to Login page
      Then user provides username and password for login
        |username|password|
        |admin|admin|
        |team53manager|Team53manager.|
      Then user logs in
    And user navigates to my operations
    When user clicks on manageAccount
    Then user creates a new account

  @accountcreatesave
    Scenario Outline: TC_1901_User should create a description for the new account and it cannot be blank
    Given user types a description "<description>"

      Examples: all data
        |description|balance|accountType|accountStatusType|
        |Instructor saving account|10000|CHECKING|ACTIVE  |
    # |Instructor checking account|2000|SAVING|ACTIVE|

  @accountcreatesave
    Scenario Outline: TC_1902	User should provide a balance for the first time account creation as Dollar
    And user types the balance as "<balance>"

    Examples: all data
    |description|balance|accountType|accountStatusType|
    |Instructor saving account|10000|CHECKING|ACTIVE  |
    # |Instructor checking account|2000|SAVING|ACTIVE|

  @accountcreatesave
   Scenario Outline: TC_1903	User can select an account type as CHECKING, SAVING, CREDIT_CARD or INVESTING
     Then user selects an account type from dropdown "<accountType>"

     Examples: all data
       |description|balance|accountType|accountStatusType|
       |Instructor saving account|10000|CHECKING|ACTIVE  |
    # |Instructor checking account|2000|SAVING|ACTIVE|

  @accountcreatesave
     Scenario Outline: TC_1904	Account status should be defined as ACTIVE, SUSPENDED or CLOSED
       When user selects an accountStatusType "<accountStatusType>"
       Examples: all data
         |description|balance|accountType|accountStatusType|
         |Instructor saving account|10000|CHECKING|ACTIVE  |
    # |Instructor checking account|2000|SAVING|ACTIVE|

  @accountcreatesave
       Scenario Outline: TC_1905	User can select an Create and Close Date
         Given user selects a current create date
         Given user selects a closed date

         Examples: all data
           |description|balance|accountType|accountStatusType|
           |Instructor saving account|10000|CHECKING|ACTIVE  |
    # |Instructor checking account|2000|SAVING|ACTIVE|

  @accountcreatesave
         Scenario Outline: TC_1906	User can select an employee from the drop-down
           And user selects an employee
           And user clicks on save button
          Then user confirm that he saves the account with success

           Examples: all data
             |description|balance|accountType|accountStatusType|
             |Instructor saving account|10000|CHECKING|ACTIVE  |
    # |Instructor checking account|2000|SAVING|ACTIVE|

  @accountcreateback
  Scenario Outline: TC_1907	There should be a back button on the page
    Given User on the home page "homepage_url"
    Then User clicks menu icon
    Then User navigates to Login page
    Then user provides username and password
      |username|password|
      |admin|admin|
      |team53admin|Team53admin.|
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
             And user selects an employee
             Then user clicks on back button
            Then user confirm that he comes back to the manage account page
             And user close the browser
             Examples: all data
               |description|balance|accountType|accountStatusType|currentDate|currentTime|closedDate|
               |Instructor saving account|10000|CHECKING|ACTIVE  |            |          |           |
    # |Instructor checking account|2000|SAVING|ACTIVE|









