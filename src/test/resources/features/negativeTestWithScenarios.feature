
#On this page, negative tests and tests have been made for manually selected car models without hsn, tsn information.
#Also tested without scenario outline model
 @NegativeTestWithScenario @Regression
Feature:Insurance Calculate Test with negative scenario types



  Scenario: The car is already insured
    Given the user is on the calculate page
    Then User should be able to choose insurer type "The car is already insured"
    Then User should be able to type "<01.05.2099>" with invalid date




  Scenario: The car will still be registered
    Given the user is on the calculate page
    Then User should be able to choose insurer type "The car will still be registered"
    Then User should be able to type "<01.05.1900>" with invalid date


  Scenario: Choose your car knowledge is typed with invalid value
    Given the user is on the calculate page
    Then User should be able to choose insurer type "The car is already insured"
    Then User should be able to type "<01.05.2022>" with valid date for insurance start day
    Then User owner of the car yes or no "yes"
    Then User's car was "used at purchase"
    Then User should be able to choose car with invalid credantial type "01.1982" , "5" , "A!?A"


  Scenario: Choose your car knowledge is typed with invalid value
    Given the user is on the calculate page
    Then User should be able to choose insurer type "The car is already insured"
    Then User should be able to type "<01.05.2022>" with valid date for insurance start day
    Then User owner of the car yes or no "yes"
    Then User's car was "used at purchase"
    Then User should be able to choose car with valid credantial type "01.2020" , "0005" , "156"
    Then User verify that with choosed car "Brand And Model"
    Then User should be able to type when was the car register to you "12.2010" with invalid date


  Scenario: Choose your car knowledge is typed with invalid value
    Given the user is on the calculate page
    Then User should be able to choose insurer type "The car is already insured"
    Then User should be able to type "<01.05.2022>" with valid date for insurance start day
    Then User owner of the car yes or no "yes"
    Then User's car was "used at purchase"
    Then User should be able to choose car with valid credantial type "01.2005" , "7605" , "314"
    Then User verify that with choosed car "Brand And Model"
    Then User should be able to "01.2005" with valid date for car register to owner
    Then User should be able to type birthday with number age is min18 max116 based on year "04.03.2009"
