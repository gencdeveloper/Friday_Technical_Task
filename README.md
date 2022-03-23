
# Friday Insurance Technical Task With selenium-cucumber-java-maven

selenium-cucumber : Automation Testing Using Java selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. It enables you to write and execute automated acceptance/unit tests. It is cross-platform, open source and free. 
Automate your test cases with minimal coding.

Selenium Framework with Cucumber
BDD framework for automation using Selenium Cucumber and TestNg

## The framework has following features

1.Modular Design

2.Maven based framework

3.Report Generation (cucumber-reporting)

4.Helper class to handle web component such as (Button,Link etc)

5.Centralized Configuration (Using Properties file) 

6.POM

7.Hooks for ScreenShot

8.Main Language is Java

## Running locally
To run locally and generate HTML reports, use this maven goal verify. 
HTML reports should be generated under target/cucumber-html-reports


```
mvn verify

```

## Tags
If you want to run the scenarios over the specified tags, apply the formula below.
In this way, you can run the scenarios you want more easily.

### Explanations for tags:             
1. @Regression --> You can run all available scenarios.
2. @Smoke --> You can run it for your important tests that must be checked every day.
3. @NegativeTestWithScenario --> You can run happy path scenarios consisting of negative tests.
4. @ManuelPathDifferentScenario --> You can run your tests with the search button without entering the Hsn and Tsn numbers.
5. @NotPass --> You can run your negative tests.


* You can run it by typing the tag you want to run in the code directory below in your Command section.
```
mvn test -Dcucumber.class.tags="@smoke"

```

## Folders Meaning

* Pages Package : The purpose of this page is to store existing web elements and frequently used methods here.
 
* Runners Package : This package acts as a trigger. Also Cukes Runner class just needs annotations to understand that cucumber features would be run through it and you can specify feature files to be picked up plus the steps package location.

* Step Definitions Package : It contains the java codes that lie behind the language of the body that we have created for the BDD approach, in the form of pages. It also acts as precondition and screenShoot with the Hooks class.

* Utilities Package : In this package, it is the place where the codes that help me in the testing processes are stored. Also here are the readers of the configuration.properties file where I store my Driver class and main information.

* Resources File : It is where my scripts are written and stored in text language.

## Cucumber File Meaning 

* DifferentPathScenariTypes.feature : Different scenarios and the selection and processes of the car to be insured manually are followed on this page.

* negativeTestWithScenarios.feature : It is expected to get positive results by entering with a negative value.

* NotPassTest.feature : It is aimed to get negative results on this page. Thus, there will be one screenshoot for each negative result. You can see it with html report.

* positiveTestWithScenarioOutline.feature : On this page, the scenario outline model has been tested for multiple variations. All values ​​will be tested one by one in order.





