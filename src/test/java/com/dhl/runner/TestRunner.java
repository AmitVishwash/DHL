package com.dhl.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
               features = "src/test/resources/features/freightTimeCalculator.feature",
               glue="com.dhl.stepdef",
               tags = "@positive",
               monochrome = true,
               stepNotifications = true,
               plugin = {"pretty","json:target/cucumber.json","html:target/cucumber.html"}
              // publish = true
)
public class TestRunner {
}
