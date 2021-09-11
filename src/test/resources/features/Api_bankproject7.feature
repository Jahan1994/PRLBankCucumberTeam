@Api_bankproject7
  Feature: Api testing ders 1

    @customer_validation
    Scenario: Read and validate customer data
      Given real all customer data using with api endpoint "https://gmibank-qa-environment.com/api/tp-customers"
      Then validate customer data