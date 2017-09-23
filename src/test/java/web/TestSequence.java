package web;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"classpath:features/Login.feature"},glue={"web"},format={"pretty"})

public class TestSequence {

}
