package cucumberOptions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features"},
<<<<<<< Updated upstream
		//tags = "@saleaep or @saleslwofa or @sale",
=======
		//tags = "@saleaep or @saleslwofa or @sale",@
>>>>>>> Stashed changes
     tags = "@sale1",

		glue = "stepDefinations",
		dryRun = false,
		monochrome = true,
		stepNotifications = true,
		plugin = {"pretty",
				"json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		 )




public class TestRunner {

}
