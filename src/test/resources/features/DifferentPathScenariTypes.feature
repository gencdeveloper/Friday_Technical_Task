@ManuelPathDifferentScenario @Regression
Feature:Insurance Calculate Test with different path scenario types
Background:
  Given the user is on the calculate page

  Scenario: The car will still be registered and choosed car with manuel path

    When User should be able to choose insurer type "The car will still be registered"
    And  User should be able to type "25.04.2022" with valid date for insurance start day
    Then User owner of the car yes or no "yes"
    Then User's car was "when buying new"
    Then User should be able to click for find by make & model
    And  User should be able to type car brand, "Audi" and choose it
    Then User should be able to type car model, "A1" and choose it
    Then User should be able to choose which type of use fueling "Benzin"
    Then User should be able to choose how many hp does your car have "63 kW / 86 PS"
    Then User should be able to check and select which car inclued for him
    Then User should be able to type when was the first registration "12.2010"
    Then User should be able to type birthday with number age is min18 max116 based on year "04.03.1993"



  Scenario: The car is already and choosed car with manuel path

    When User should be able to choose insurer type "The car is already insured"
    And  User should be able to type "02.05.2022" with valid date for insurance start day
    Then User owner of the car yes or no "no"
    Then User's car was "used at purchase"
    Then User should be able to click for find by make & model
    And  User should be able to type car brand, "VW" and choose it
    Then User should be able to type car model, "polo" and choose it
    And  User should be able to chose what kind of shape is "coupe"
    Then User should be able to choose which type of use fueling "diesel"
    Then User should be able to choose how many hp does your car have "33 kW / 45 PS"
    Then User should be able to check and select which car inclued for him
    Then User should be able to type when was the first registration "12.2008"
    Then User should be able to "03.2010" with valid date for car register to owner
    Then User should be able to type birthday with number age is min18 max116 based on year "04.03.1993"

@Smoke
  Scenario: The car is already insured

    When User should be able to choose insurer type "The car is already insured"
    Then User should be able to type "<01.05.2022>" with valid date for insurance start day
    Then User owner of the car yes or no "yes"
    Then User's car was "used at purchase"
    Then User should be able to choose car with valid credantial type "01.1983" , "0005" , "155"
    Then User verify that with choosed car "Brand And Model"
    Then User should be able to "12.2010" with valid date for car register to owner
    Then User should be able to type birthday with number age is min18 max116 based on year "04.03.1993"

