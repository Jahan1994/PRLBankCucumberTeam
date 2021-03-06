@US_005
Feature: US_005_Login page should not be accessible with invalid credentials

  @invalid
  Scenario Outline:
  TC_0501 User cannot login with invalid username validating the error message
  TC_0502 User cannot login with invalid password validating the error message
  TC_0503 User cannot login with invalid username and password validating the error message

    Given User on the home page "homepage_url"
    Then User click menu icon
    And User click signIn Option
    Then user provides username "<userName>"
    Then user provides password "<passWord>"
    And User click secondSignInButton
    And User see Failed Message
    Examples:
      | userName   | passWord    |
      | xxxxxx     | Team53user. |
      | team53user | yyyyyy      |
      | yyyyyy     | xxxxxx      |

  @didyouforget
  Scenario: TC_0504 User with invalid credentials should be given an option to reset their password
    Given User on the home page "homepage_url"
    Then User click menu icon
    And User click signIn Option
    Then user provides username and password
      | username | password |
      | xxxxxx   | yyyyyy   |
    And User click Did you forget your password ?
    And Enter email that suscribed
    And User click Reset password

  @didnotregister
  Scenario: TC_0505 User should be given the option to navigate to registration page if they did not register yet
    Given User on the home page "homepage_url"
    Then User click menu icon
    And User click signIn Option
    Then user provides username and password
      | username | password |
      | xxxxxx   | yyyyyy   |
    And User click register option if they do not yet registered (Register a new account)
    And User see registration page

