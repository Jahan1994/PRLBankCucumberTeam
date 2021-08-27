@US_006
Feature: US_006_User info segment (User Settings) should be editable on Homepage

  @userinfo
  Scenario: TC_0601 There should be user info being populated when navigating to user info "firstname, lastname
  email and language"
    Given User on the home page "homepage_url"
    And User click menu icon
    Then User click signIn Option
    Then user provides username and password
      |username|password|
      |Khan|Khan1.team53|
    Then User click secondSignInButton
    Then User click userIcon
    Then User can see own info
    Then User is on the user settings page

    @languages
  Scenario: TC_0602 There should be 2 languages available "English and Turkish"
    Given User on the home page "homepage_url"
    And User click menu icon
    Then User click signIn Option
    Then user provides username and password
      |username|password|
      |Khan|Khan1.team53|
    Then User click secondSignInButton
    Then User click userIcon
    Then User select User Info
    Then User is on the user settings page
    Then User can see own info
    Then User can see two language option on the language dropdownmenu

  @updatefirstname
  Scenario: TC_0603 There should be an option to update firstname
    Given User on the home page "homepage_url"
    And User click menu icon
    Then User click signIn Option
    Then user provides username and password
      |username|password|
      |Khan|Khan1.team53|
    Then User click secondSignInButton
    Then User click userIcon
    Then User select User Info
    Then User is on the user settings page
    Then User can update firstname
    Then User click save button

  @updatelastname
  Scenario: TC_0604 There should be an option to update lastname
    Given User on the home page "homepage_url"
    And User click menu icon
    Then User click signIn Option
    Then user provides username and password
      |username|password|
      |Khan|Khan1.team53|
    Then User click secondSignInButton
    Then User click userIcon
    Then User select User Info
    Then User is on the user settings page
    Then User can update lastname
    Then User click save button

    @updateemail
  Scenario: TC_0605 There should be an option to update email id adding "@" sign and "." extension
    Given User on the home page "homepage_url"
    And User click menu icon
    Then User click signIn Option
    Then user provides username and password
      |username|password|
      |Khan|Khan1.team53|
    Then User click secondSignInButton
    Then User click userIcon
    Then User select User Info
    Then User is on the user settings page
    Then User can update email
    Then User click save button

