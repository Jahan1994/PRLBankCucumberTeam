Feature: US_002	"System should not allow anyone to register with invalid credentials

Background: TC User cannot login with invalid SSN validating the error messa
    Given User on the home page "homepage_url"
    Then User clicks menu icon
    And  User navigates to registration page

  @allDataNull
  Scenario Outline: TC_0201	Any field on the registration page should not be left blank
    Then User provides a invalid SSN as "<ssn>"
    Then User provides a invalid Firstname as "<firstname>"
    Then User provides a invalid Lastname as "<lastname>"
    Then User provides a invalid Address as "<address>"
    Then User provides a invalid Mobile Phone Number as "<mobilephone>"
    Then User provides a invalid  Username as "<username>"
    Then User provides a invalid  Email as "<email>"
    Then User provides a invalid Password as "<firstpassword>"
    Then User provides a invalid  Password to Password confirmation textbox as "<secondpassword>"
    Then User clicks on Register button
    And  User validates that he registered succesfully with a success message as "<message>"
    Examples:
      |ssn|firstname|lastname|address|mobilephone|username|email|firstpassword|secondpassword|message|
    | | |     |       |       |         |  |           |           |  |

  @invalidSSN
  Scenario Outline: TC_0202	SSN number cannot be of any chars nor spec chars except "-" SSN can not begin with 000 or 999
    Given User provides a invalid SSN as "<ssn>" and validates invalid ssn with a fail message as "<message1>" or "<message2>"
    Examples:
      |ssn|message1|message2|
      |999-66-3352|translation-not-found[Your SSN is required]|Your SSN is invalid|
      |000-66-3352|translation-not-found[Your SSN is required]|Your SSN is invalid|
      |255-55-666-|translation-not-found[Your SSN is required]|Your SSN is invalid|
      |123-12-|translation-not-found[Your SSN is required]|Your SSN is invalid|
      |125-55-55880|translation-not-found[Your SSN is required]|Your SSN is invalid|
      |125/55-5580|translation-not-found[Your SSN is required]|Your SSN is invalid|
      |125-55-558a|translation-not-found[Your SSN is required]|Your SSN is invalid|
      |369871239|translation-not-found[Your SSN is required]|Your SSN is invalid|
      |255-55-6000''|translation-not-found[Your SSN is required]|Your SSN is invalid|
      |''125-12-1234|translation-not-found[Your SSN is required]|Your SSN is invalid|
      | |translation-not-found[Your SSN is required]|Your SSN is invalid|


@invalidMobilePhone
  Scenario Outline: TC_0203	Mobilephone number cannot be of any chars nor spec chars except "-"
    Given User provides a invalid Mobile Phone Number as "<mobilephone>" and validates invalid mobilephone with a fail message as "<message1>" or "<message2>"
    Examples:
      |mobilephone|message1|message2|
      |-55-555-6663|Your mobile phone number is invalid|translation-not-found[Your mobile phone number is required]|
      |255-555-666-|Your mobile phone number is invalid|translation-not-found[Your mobile phone number is required]|
      |123-152-|Your mobile phone number is invalid|translation-not-found[Your mobile phone number is required]|
      |125/555-5580|Your mobile phone number is invalid|translation-not-found[Your mobile phone number is required]|
      |125-555-558a|Your mobile phone number is invalid|translation-not-found[Your mobile phone number is required]|
      |3698712390|Your mobile phone number is invalid|translation-not-found[Your mobile phone number is required]|
      |125-555-55880|Your mobile phone number is invalid|translation-not-found[Your mobile phone number is required]|
      ||Your mobile phone number is invalid|translation-not-found[Your mobile phone number is required]|
      |255-555-6000''|Your mobile phone number is invalid|translation-not-found[Your mobile phone number is required]|
      |''125-152-1234|Your mobile phone number is invalid|translation-not-found[Your mobile phone number is required]|

  @invalidEmail
  Scenario Outline: TC_0204	email id cannot be created without "@" sign and "." extensions
    Given User provides a invalid Email as "<email>" and validates invalid mobilephone with a fail message as "<message1>" or "<message2>" or "<message3>"
    Examples:
      |email|message1|message2|message3|
      |fernando|Your email is required.|Your email is required to be at least 5 characters.|This field is invalid|
      |fernando@gmail|Your email is required.|Your email is required to be at least 5 characters.|This field is invalid|
      |fernando@gmailcom|Your email is required.|Your email is required to be at least 5 characters.|This field is invalid|
      |fernandogmail.com|Your email is required.|Your email is required to be at least 5 characters.|This field is invalid|
      |fernandogmail.com@|Your email is required.|Your email is required to be at least 5 characters.|This field is invalid|
      |@fernandogmail.com|Your email is required.|Your email is required to be at least 5 characters.|This field is invalid|
      |fernando@.gmailcom|Your email is required.|Your email is required to be at least 5 characters.|This field is invalid|
      |fern|Your email is required.|Your email is required to be at least 5 characters.|This field is invalid|
      |.fernando@gmail.com|Your email is required.|Your email is required to be at least 5 characters.|This field is invalid|
      |f|Your email is required.|Your email is required to be at least 5 characters.|This field is invalid|
      |1122@|Your email is required.|Your email is required to be at least 5 characters.|This field is invalid|
      ||Your email is required.|Your email is required to be at least 5 characters.|This field is invalid|
      |fernando@gmail.com.|Your email is required.|Your email is required to be at least 5 characters.|This field is invalid|
      |f@gmail.com@|Your email is required.|Your email is required to be at least 5 characters.|This field is invalid|

