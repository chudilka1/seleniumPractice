package bdd.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//format отображение прохождения теста в консоли в предпочитаемом формате
@CucumberOptions(features = "src/test/java/bdd/features",
        format = {"pretty", "html:target/site/cucumber-pretty"})
public class RunFeatures extends AbstractTestNGCucumberTests {
}
