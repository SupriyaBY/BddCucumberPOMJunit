package com.amazon.testrunners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features = {"E:\\SharadSirSeleniumBatch\\BasicPrograms\\CucumberPOMForPractice\\src\\test\\resources\\com.amazon.features\\products.feature"},
		features = {"src/test/resources/com/amazon/features"},
		glue = {"com/amazon/stepdefinitions", "com/amazon/apphooks"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/CucumberReports/CucumberReport.html",
				"timeline:test-output-thread/"
				
		}
		
		)

public class MyTestRunner {

}
