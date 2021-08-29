@registration
Feature: US_001 Pozitif Registration with valid credentials

  Scenario Outline: Register Page
    Given User on the home page "gmibank_url"
    Then User clicks menu icon
    And  User navigates to registration page
    Then User provides a valid ssn for password "<SSN>"
    Then User provides a valid firstname for password "<Firstname>"
    Then User provides a valid lastname for password "<Lastname>"
    Then User provides a valid address for password "<Address>"
    Then User provides a valid Mobile Phone Number for password "<Mobile Phone Number>"
    Then User provides a valid Username for password "<Username>"
    Then User provides a valid Email for password "<Email>"
    Then User provides a valid Password for password "<Password>"
    Then User controls stronger Password for password "<Password>"
    Then User provides a valid Password to Password confirmation textbox for password "<Password confirmation textbox>"
    Then User clicks on Register button for new register
    And  User validates that the registered succesfully for password



    Examples: valid datas
      | SSN | Firstname | Lastname     | Address    | Mobile Phone Number | Username  | Email                        | Password        | Password confirmation textbox |
      |     | Arnoldd   | Happy        | Canada     | 123-456-7990        | Arnoldd   | arnoldd@gmail.com            | aRNOLD1234.     | aRNOLD1234.                   |
      |     | Fernando  | Muslera      | Uruguay    | 234-566-5443        | Fernandoo | fernandoo@gmail.com          | Fernando1234?   | Fernando1234?                 |
      |     | Hüsnü     | Şenlendirici | Afganistan | 345-432-5678        | Husnuu    | husnusenlendiricii@gmail.com | Husnu1234.      | Husnu1234.                    |
      |     | Jardel    | Tutamaki     | Giresun    | 123-456-7654        | Jardell   | Jardel@gmaill.com            | Jardel.9876     | Jardel.9876                   |
      |     | Kamuran   | Akkor        | Trabzon    | 657-670-8799        | Kamurann  | kamuranAkkorr@gmail.com      | Kamuran1231979? | Kamuran1231979?               |


