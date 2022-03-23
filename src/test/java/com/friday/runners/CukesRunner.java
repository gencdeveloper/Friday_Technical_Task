package com.friday.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // run with cucumber
@CucumberOptions(

        features = "src/test/resources/features/", //feature file directory
        glue = "com/friday/step_definitions", //provide step defitinions
        dryRun = false,
        tags = "@Smoke", // what kind of tags we are running
        plugin = "json:target/cucumber.json"

        /**My Triggers with annotations -- you can type after the tags value
         * @Smoke
         * @NegativeTestWithScenario
         * @ManuelPathDifferentScenario
         * @NotPass
         * @Regression
         * */


)

public class CukesRunner {

}