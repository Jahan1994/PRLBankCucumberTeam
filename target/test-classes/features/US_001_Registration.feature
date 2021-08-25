@registration
Feature: US_001 Pozitif Registration with valid credentials

  Scenario Outline: Register Page
    Given User on the home page "gmibank_url"
    Then User clicks menu icon
    And  User clicks register button
    Then User provides a valid ssn "<SSN>"
    Then User provides a valid firstname "<Firstname>"
    Then User provides a valid lastname "<Lastname>"
    Then User provides a valid address "<Address>"
    Then User provides a valid Mobile Phone Number "<Mobile Phone Number>"
    Then User provides a valid Username "<Username>"
    Then User provides a valid Email "<Email>"
    Then User provides a valid Password "<Password>"
    Then User controls stronger Password "<Password>"
    Then User provides a valid Password to Password confirmation textbox "<Password confirmation textbox>"
    Then User clicks on Register button
    And  User validates that the registered succesfully



    Examples: valid datas
      | SSN | Firstname | Lastname     | Address    | Mobile Phone Number | Username | Email                       | Password        | Password confirmation textbox |
      |     | Arnold    | Happy        | Canada     | 123-456-7990        | Arnold   | arnold@gmail.com            | aRNOLD1234.     | aRNOLD1234.                   |
      |     | Fernando  | Muslera      | Uruguay    | 234-566-5443        | Fernando | fernando@gmail.com          | Fernando1234?   | Fernando1234?                 |
      |     | Hüsnü     | Şenlendirici | Afganistan | 345-432-5678        | Husnu    | husnusenlendirici@gmail.com | Husnu1234.      | Husnu1234.                    |
      |     | Jardel    | Tutamaki     | Giresun    | 123-456-7654        | Jardel   | Jardel@gmail.com            | Jardel.9876     | Jardel.9876                   |
      |     | Kamuran   | Akkor        | Trabzon    | 657-670-8799        | Kamuran  | kamuranAkkor@gmail.com      | Kamuran1231979? | Kamuran1231979?               |

  @logİn
  Scenario: Login Page
    Given User on the home page "gmibank_url"
    Then User clicks menu icon
    Then User clicks Sign in button
    Then User provides a valid username
    Then User provides a valid passWord
    Then User clicks Sign in
    Then User asserts new page

