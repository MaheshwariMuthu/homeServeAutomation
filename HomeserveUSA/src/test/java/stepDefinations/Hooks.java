package stepDefinations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import automationFramework.JvmReport;
import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import automationFramework.DataReader;
import automationFramework.StartDriver;
import automationFramework.Utils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

import static automationFramework.DataReader.geturl;


public class Hooks extends StartDriver {

	public static File extentFile =null;
	public static String strDate =null;
	public static String fileName;
	public static boolean flag=false;
	public static String start_date;
	
	
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException, ParseException {

		System.out.println("Starting Scrtips");
	//	initialize_ExtentReports();

		String browser = DataReader.getParameterString("browser", "environment");

		if ((browser.equalsIgnoreCase("chrome"))) {
			WebDriverManager.chromedriver().setup();
			
			
			ChromeOptions options = new ChromeOptions();

			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("-incognito");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("start-maximized");
			options.setExperimentalOption("excludeSwitches",
				    Arrays.asList("disable-popup-blocking"));
		
			
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setAcceptInsecureCerts(true);
			caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			driver = new ChromeDriver(options);
			
		}

		else if ((browser.equalsIgnoreCase("firefox"))) {
			WebDriverManager.firefoxdriver().setup();
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setAcceptInsecureCerts(true);
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-maximized");
			driver = new FirefoxDriver(options);
		}
//		driver.navigate().to(geturl());  -- this is not needed and we are using this in Navigation method
	}


//	@AfterStep
//	public void AddScreenshot(Scenario scenario) throws IOException {
//		if (scenario.isFailed()) {
//			// screenshot
//			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
//			scenario.attach(fileContent, "image/png", "image");
//		}
//
//	}
	
	/**
	 * Description: Taking screenshot for pass and failed scenario- -creating folder
	 * for both as well pass and failed scenario
	 * 
	 * @author aatish.slathia
	 * @param scenario
	 * @throws IOException
	 */
	@After(order = 1)
	public static void saveScreenShotForFailedAndPassScenario(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			try {
				((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				File screenshot_with_scenario_name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot_with_scenario_name,
						new File("./Failed_Screenshots/" + Utils.getStringWithTimeStamp(scenario.getName()) + ".png"));
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}
		} else {
			try {
				((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				File screenshot_with_scenario_name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot_with_scenario_name,
						new File("./Pass_Screenshots/" + Utils.getStringWithTimeStamp(scenario.getName()) + ".png"));
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}

		}
		System.out.println("After test");
		JvmReport.generateJVMReport(System.getProperty("user.dir")+"//src//test//resources//Reporting//cucumber.json");
		System.out.println("success JVM");


		//	driver.quit();
	}


	public static void initialize_ExtentReports()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HH:mm:ss");
		Date curDate = new Date();
		strDate = sdf.format(curDate);
		strDate=strDate.replaceAll(":", ".");
		fileName = System.getProperty("user.dir")+"\\target\\Extent_Reports\\"+"HomeserveDigital"+".html";
		File extentFile = new File(fileName);

	}


}
