package stepDefinations;

import automationFramework.DataReader;
import automationFramework.StartDriver;
import automationFramework.Utils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Hooks extends StartDriver {

	public static File extentFile =null;
	public static String strDate =null;
	public static String fileName;
	public static boolean flag=false;
	public static String start_date;
	public static Properties configProperties;

	
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException, ParseException, InterruptedException {

		System.out.println("Starting Scrtips");
		configProperties=new Properties();
		configProperties.load(new FileInputStream((new File(System.getProperty("user.dir")+"/src/test/resources/config.properties"))));
		String browser = configProperties.getProperty("browser");

		if ((browser.equalsIgnoreCase("chrome"))) {
		//	WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("-incognito");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("start-maximized");
			options.addArguments("--force-device-scale-factor=0.8");
//			options.setExperimentalOption("excludeSwitches",
//				    Arrays.asList("disable-popup-blocking"));
			options.addArguments("--disable-popup-blocking");
			options.setBrowserVersion("117");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setAcceptInsecureCerts(true);
			caps.acceptInsecureCerts();
		//	caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			driver = new ChromeDriver(options);
			Thread.sleep(2000);
			driver.manage().deleteAllCookies();

		}

		else if ((browser.equalsIgnoreCase("firefox"))) {
//			WebDriverManager.firefoxdriver().setup();
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setAcceptInsecureCerts(true);
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-maximized");
			driver = new FirefoxDriver(options);
		}
	}


	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			byte[] imageBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			//byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(imageBytes, "image/png", "image");
		}
	}
	
	/**
	 * Description: Taking screenshot for pass and failed scenario- -creating folder
	 * for both as well pass and failed scenario
	 * 
	 * @author aatish.slathia
	 * @param scenario
	 * @throws IOException
	 */
	@After
	public static void saveScreenShotForFailedAndPassScenario(Scenario scenario) throws IOException, InterruptedException {
		String ImagePath;
		Thread.sleep(10000);
		if (scenario.isFailed()) {
			try {
				((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				File screenshot_with_scenario_name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				ImagePath = "./Failed_Screenshots/" + Utils.getStringWithTimeStamp(scenario.getName()) + ".png";
				FileUtils.copyFile(screenshot_with_scenario_name,new File(ImagePath));
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

		driver.manage().deleteAllCookies();
		driver.close();

	}

	public static void takeScreenshot(String featurename){

		try {
			((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			File screenshot_with_scenario_name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot_with_scenario_name,
					new File("./Failed_Screenshots/" + Utils.getStringWithTimeStamp(featurename) + ".png"));
		} catch (WebDriverException | IOException somePlatformsDontSupportScreenshots) {
			System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		}
	}


}
