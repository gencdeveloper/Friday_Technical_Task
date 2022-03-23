@Regression @NotPass
Feature:Not pass this scenarios

  Background:
    Given the user is on the calculate page


 Scenario: The car is already insured but with MISS LETTER!
  Then User should be able to choose insurer type "The car is "
   Then User should be able to type "01.05.2022" with valid date for insurance start day


  Scenario: The car is already insured but OWNER'S CAR WAS NOT TYPED CORRECTLY

    Then User should be able to choose insurer type "The car is already insured"
    Then User should be able to type "01.05.2022" with valid date for insurance start day
    Then User owner of the car yes or no "234"
    Then User's car was "used at purchase"


  Scenario: The car is already insured but CHOOSE CAR VALID CREDENTIAL TYPE IS MISSED!
    When User should be able to choose insurer type "The car is already insured"
    Then User should be able to type "01.05.2022" with valid date for insurance start day
    Then User owner of the car yes or no "yes"
    Then User's car was "used at purchase"
    Then User should be able to choose car with valid credantial type " " , "0005" , "1"
    Then User verify that with choosed car "Brand And Model"
    Then User should be able to "12.2010" with valid date for car register to owner
