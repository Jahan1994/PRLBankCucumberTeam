@api
Feature: Api testing customer

  @Customer_validation
  Scenario: Read and validate customer data
    Given read all customer data using with api endpoint "https://www.gmibank.com/api/tp-customers"
    Then validate customer data

#  @US_20 @SmokeTest1
#  Feature: US_20 system should allow to read all customers info using api end point
#
#  Background: TC_2001 and TC_2002 background
#    Given use api end point  "https://www.gmibank.com/api/tp-customers"
#    And get all customers' information as De-Serialization
#
#  @TC_2001
#  Scenario: TC_2001 read all customers you created and validate them from your data set
#    And find out how many customers are and verify
#    And get all the information of the seventh customer
#    And verify seventh customers "ssn" and "state"
#
#
#  @TC_2002
#  Scenario: TC_2002 read all customers you created and validate them 1 by 1
#    And verify first customer's "firstName"
#    And verify second customer's "lastName"
#    And verify fifth customer's "country"
#    And get last customer's id and verify
#====================================================================================

#Feature: customer_olusturdugu_tum_verileri_okur_ve_validate_yapar
#  Scenario: TC_01_Verilerin_validate_edilmesi
#    Given kullanici api "https://www.gmibank.com/api/tp-customers" gider
#    Then kullanici tum customer bilgilerini okur
#    And kullanici okudugu customerlerin verilerini validate yapar

  #Scenario: TC_02_Verilerin_tek_tek_validate_edilmesi
   # Given kullanici api "endpointe" gider
    #Then kullanici tum customer bilgilerini okur
    #And kullanici
