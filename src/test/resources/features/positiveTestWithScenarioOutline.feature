#This scenario created for the positive testing variation with "The car is already insured" AND "The car will still be registered or re-registered"

@Regression @positiveTestWithScenarioOutline
Feature:Insurance Calculate Test with positive scenario outline model

Scenario Outline: The car is already insured
Given the user is on the calculate page
Then User should be able to choose insurer type "<INSURER TYPE>"
Then User should be able to type "<INSURANCE START DAY>" with valid date for insurance start day
Then User owner of the car yes or no "<ARE YOU OWNER OF THE CAR>"
Then User's car was "<THE CAR WAS>"
Then User should be able to choose car with valid credantial type "<FIRST REGISTRATION>" , "<HSN>" , "<TSN>"
Then User verify that with choosed car "Brand And Model"
Then User should be able to "<WHEN WAS THE CAR REGISTER>" with valid date for car register to owner
Then User should be able to type "<WHEN WERE YOU BORN>" with number

Examples:
#BMW BRAND AND HIS MODELS
|INSURER TYPE              |INSURANCE START DAY|ARE YOU OWNER OF THE CAR |THE CAR WAS     |FIRST REGISTRATION|HSN  |TSN|WHEN WAS THE CAR REGISTER|WHEN WERE YOU BORN |
|The car is already insured|01.11.2022         |Yes                      |used at purchase|06.2000            |0005|AAA|12.2021                  |04.03.1995         |
|The car is already insured|15.06.2022         |Yes                      |used at purchase|12.2010            |7909|ABO|12.2011                  |29.12.2000         |
|The car is already insured|01.04.2022         |No                       |used at purchase|01.1991            |0005|BBB|01.1991                  |29.12.1940         |
|The car is already insured|29.06.2022         |Yes                      |used at purchase|01.1983            |0005|CCC|01.1991                  |29.12.1906         |

#AUDI BRAND AND HIS MODELS
|The car is already insured|13.07.2022         |Yes                      |used at purchase|06.1983            |0037|301|06.1983                  |29.12.2003         |
|The car is already insured|21.05.2022         |No                       |used at purchase|03.2005            |0588|AAU|05.2022                  |02.12.1950         |
|The car is already insured|13.04.2022         |Yes                      |used at purchase|03.1984            |0591|330|03.2022                  |03.03.1984         |



@Smoke
Scenario Outline: The car will still be registered

Given the user is on the calculate page
Then User should be able to choose insurer type "<INSURER TYPE>"
Then User should be able to type "<INSURANCE START DAY>" with valid date for insurance start day
Then User owner of the car yes or no "<ARE YOU OWNER OF THE CAR>"
Then User's car was "<THE CAR WAS>"
Then User should be able to choose car with valid credantial type "<FIRST REGISTRATION>" , "<HSN>" , "<TSN>"
Then User verify that with choosed car "Brand And Model"
Then User should be able to type "<WHEN WERE YOU BORN>" with number

Examples:
#Mercedes Benz BRAND AND HIS MODELS
|INSURER TYPE                    |INSURANCE START DAY|ARE YOU OWNER OF THE CAR |THE CAR WAS      |FIRST REGISTRATION |HSN |TSN|WHEN WERE YOU BORN |
|The car will still be registered|25.05.2022         |No                       |when buying new  |01.2020            |0009|301|29.12.1975         |
|The car will still be registered|03.06.2022         |Yes                      |used at purchase |01.1983            |0999|AAJ|29.12.1906         |
|The car will still be registered|29.04.2022         |Yes                      |when buying new  |01.2005            |7605|314|08.09.1997         |