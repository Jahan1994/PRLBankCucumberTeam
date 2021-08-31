
@logİn
  Feature: US_004 Pozitif LogIn Test

    Scenario: Login Page
      Given User on the home page "gmibank_url"
      Then User clicks menu icon
      Then User clicks Sign in button
      Then User provides a valid username for pozitive login
      Then User provides a valid passWord for pozitive login
      Then User clicks Sign in
      Then User asserts new page

    @logİnCancel
    Scenario: Login Page
      Given User on the home page "gmibank_url"
      Then User clicks menu icon
      Then User clicks Sign in button
      Then User asserts cancel button