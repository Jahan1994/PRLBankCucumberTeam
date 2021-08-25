
  @api_testing_ders_1
    Feature: Api testing ders 1

      @Customer_validation
      Scenario: Read and validate customer data
        Given real all customer data using with api endpoint "https://www.gmibank.com/api/tp-customers"
        #butun müşteri datalarını bu adresi kullanarak okutun dedik given la
        Then validate customer data
        #sonra gelen dataları doğrulayın