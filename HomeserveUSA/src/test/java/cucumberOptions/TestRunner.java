package cucumberOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import stepDefinations.Hooks;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/slwofa.feature"},
		glue = "stepDefinations",
		dryRun = false,
		monochrome = true,
		stepNotifications = true,
		plugin = {"pretty",
				"json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		 )




public class TestRunner extends Hooks {
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	//private static Logger log = LoggerHelper.getLogger(TestRunner.class);

	@BeforeClass
	public static void beforeClass() {
		String reportPath = "./ExtentReports/extent-report.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
	//	sparkReporter.config().setReportName("Cucumber Extent Report");
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
	}

	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", scenario.getName());
				extentTest.fail("Test Failed");
				extentTest.addScreenCaptureFromBase64String(new String(screenshot), scenario.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			extentTest.pass("Test Passed");
		}
		driver.quit();
	}
}
