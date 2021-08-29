@demo
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
#    And User clicks on Register button
   Then User clicks on Register button and validates that with a success message as "<message>"
#    And user close the browser

    Examples:
      | ssn | firstname | lastname | address | mobilephone | username | email | firstpassword | secondpassword | message |
      |     |           |           |         |            |          |       |               |                |         |

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
      Given user types a description "<description>"
      And user types the balance as "<balance>"
      Then user selects an account type from dropdown "<accountType>"
      When user selects an accountStatusType "<accountStatusType>"
      Given user selects a current create date "<currentDate>" "<currentTime>"
      Given user selects a closed date "<closedDate>" "<currentTime>"
#      And user selects an employee
      And user clicks on save button
      Then user confirm that he saves the account with success
    Given user creates a new account
    Given user types a description "<description>" for second account
    And user types the balance as "<balance>"
    Then user selects an account type from dropdown "<accountType>"
    When user selects an accountStatusType "<accountStatusType>"
    Given user selects a current create date "<currentDate>" "<currentTime>"
    Given user selects a closed date "<closedDate>" "<currentTime>"
    And user selects an employee
    And user clicks on save button
    Then user confirm that he saves the account with success for second account
      Examples: all data
        |description|balance|accountType|accountStatusType|currentDate|currentTime|closedDate|
        |saving account|10000|CHECKING|ACTIVE  |            |          |           |

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
    Then User sees success message
    And User sees firstname written
    And User sees lastname written
    And User sees Email written
    And User sees Adress written
    Then User sees SSN written
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
    And User choose valid user
    And User choose valid account
    And User click zelle enrolled check box
    Then User click save button to create customer
    And User sees success message2


  @login_as_a_customer_to_send_money_between_two_created_accounts
  Scenario:
    Given User on the home page "homepage_url"
    Then User clicks menu icon
    And User navigates to Login page
    And User enter a valid username and a valid password for customer
    Then user logs in




