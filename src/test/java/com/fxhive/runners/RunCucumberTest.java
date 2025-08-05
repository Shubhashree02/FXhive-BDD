package com.fxhive.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Executes all Cucumber scenarios found under src/test/resources/features.
 * Right-click this class ▸ Run to start the BDD suite.
 */
@CucumberOptions(
        features = "src/test/resources/features",      // path to .feature files
        glue      = "com.fxhive.stepdefinitions",      // package with step defs
        plugin    = {
                "pretty",                              // readable console log
                "html:target/cucumber-report.html",    // HTML report
                "summary"                              // one-line result per scenario
        },
        monochrome = true                              // clean console colours
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    // no extra code needed; TestNG handles execution
}
