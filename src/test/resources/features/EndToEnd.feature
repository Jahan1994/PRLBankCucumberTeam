@demo
Feature:

  @registrationwithconcretevalues
  Scenario: TC_001 Success registration with valid credentials
    Given User on the home page "homepage_url"
    Then User clicks menu icon
    And  User navigates to registration page
    Then User provides a valid SSN
    Then User provides a valid Firstname
    Then User provides a valid Lastname
    Then User provides a valid Address
    Then User provides a valid Mobile Phone Number
    Then User provides a valid Username
    Then User provides a valid Email
    Then User provides a valid Password
    Then User provides a valid Password to Password confirmation textbox
    Then User clicks on Register button


  @login_as_admin_to_active_an_user
  Scenario Outline: Active a new user as admin
    Given User on the home page "homepage_url"
    And User clicks menu icon
    Then User navigates to Login page
    Then enters valid <"admin_username"> as admin
    Then enters a valid <"admin_password">  as admin
    Then clicks the sing in button
    Then clicks on the Administration link from the active page
    Then clicks on the User Management link from the dropdown menu
    Then user clicks on the date
    Then user searches for "<userName>"
#   Then activates the user
#   Then clicks save button
#    Then asserts the updated message
#    And user close the browser
#    And user sing out from the page
    Examples:
      | userName   |
      | sibel      |


  @login_as_manager_and_account_create
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
    Given user types a description "<description1>"
    And user types the balance as "<balance>"
    Then user selects an account type from dropdown "<accountType1>"
    When user selects an accountStatusType "<accountStatusType>"
    Given user selects a current create date "<currentDate>" "<currentTime>"
    Given user selects a closed date "<closedDate>" "<currentTime>"
#      And user selects an employee
    And user clicks on save button
    Then user confirm that he saves the account with success
    Given user creates a new account
    Given user types a description "<description2>" for second account
    And user types the balance as "<balance>"
    Then user selects an account type from dropdown "<accountType2>" for second account
    When user selects an accountStatusType "<accountStatusType>"
    Given user selects a current create date "<currentDate>" "<currentTime>"
    Given user selects a closed date "<closedDate>" "<currentTime>"
    And user selects an employee
    And user clicks on save button
    Then user confirm that he saves the account with success for second account
#    And user close the browser
    Examples: all data
      |description1|description2|balance|accountType1|accountType2|accountType2|accountStatusType|currentDate|currentTime|closedDate|
      |checking account|saving account|100000|CHECKING|SAVING|ACTIVE  |            |          |           |                     |

  @login_as_an_employee_to_assign_account_to_a_customer
  Scenario:
    Given User on the home page "homepage_url"
    Then  User clicks menu icon
    And  User navigates to Login page
    And User enter valid "employee_username"
    And  User enters valid "employee_password"
    Then User cliks sign in button
    And User clicks My Opertions
    Then User select Manage Customers
    And User clicks Create a New Customer
    And User enter "ssn"
    And User cliks Search button
    And User enter MI "middle"
    And User enter MP "mobile"
    And User enter PH "phone"
    And User enter ZC "zipcode"
    And User enter Adress "adress"
    And User enter City "city"
    And User enter Country "country"
    And User enter State"state"
    And User sees entered today date and time
    And User sees correct order date
    And User choose valid account
    And User click zelle enrolled check box
    Then User click save button for customer create
         #User click save button to create customer


  @login_as_a_customer_to_send_money_between_two_created_accounts
  Scenario:
    Given User on the home page "homepage_url"
    Then User clicks menu icon
    Then User navigates to Login page
    And User enter valid "customer_username1"
    And  User enters valid "customer_password1"
    Then User cliks sign in button
    Then User clicks My Opertions
    Then User cliks My Accounts
    Then User clicks My Opertions
    Then User clicks Money Transfer
    And User selects account from dropdown menu
    And User selects account from the to drop-down menu
    And User enters "amountus15" in the balance text box
    And User enters "descriptionus15" in the description text box
    And User click Make Transfer icon
    Then User clicks My Opertions
    Then User cliks My Accounts


