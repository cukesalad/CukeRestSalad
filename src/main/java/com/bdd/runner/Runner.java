package com.bdd.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"classpath:feature"}, glue={"classpath:com.bdd"}, plugin={"pretty", "html:target/cucumber", "json:target/cucumber.json", "junit:target/cucumber.xml"})
public class Runner {

}
