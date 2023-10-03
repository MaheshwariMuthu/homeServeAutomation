package pageActions;

import static automationFramework.DataReader.configProperties;
import static automationFramework.DataReader.geturl;
import static automationFramework.DynamicWebElements.getWebElementByID;
import static automationFramework.PageActions.clickElement;
import static automationFramework.PageActions.typeText;
import static automationFramework.StartDriver.driver;
import static automationFramework.Waits.waitTillPageLoad;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;

import automationFramework.PageActions;
import pageLocators.CommonPageLocators;


public class CommonPageActions {
	static CommonPageLocators commonPageLocators = new CommonPageLocators();
	PageActions pageActions = new PageActions();

	public CommonPageActions() {
		PageFactory.initElements(driver, this);
	}
	

	
	/**
	 * Description: Navigate to the Site URL.
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws IOException
	 * 
	 */
	public void navigateToApplication()
			throws InterruptedException, IOException, ParseException {
		driver.navigate().to(geturl());
		waitTillPageLoad();
//		closeCookiesBottom();
	}

	/**
	 * Description: Entering Zip code and click on
	 *
	 * @throws InterruptedException
	 */
	public static void enterZipCodeAndSubmit(String zipCode, String EnterZipLocation) throws InterruptedException {
		if (EnterZipLocation.equalsIgnoreCase("header") ) {
			clickElement(commonPageLocators.enterZipHeaderLink, "Enter Zip");
			typeText(getWebElementByID("zipcode"), zipCode, "ZipCode field");
			waitTillPageLoad();
			clickElement(commonPageLocators.viewPlans, "View Plans");
			waitTillPageLoad();
			waitTillPageLoad();
			clickElement(commonPageLocators.viewAvailablePlans, "View available plans");
		}else if(EnterZipLocation.equalsIgnoreCase("LandingPage")) {
//			same code with different locators
			System.out.println(EnterZipLocation);
			clickElement(commonPageLocators.txtZipCode, "Enter Your ZIP Code");
			Thread.sleep(2000);
			typeText(commonPageLocators.txtZipCode, zipCode, "Enter Your ZIP Code");
			waitTillPageLoad();
			if(configProperties.getProperty("server.site").equalsIgnoreCase("slwofa")) {
				clickElement(commonPageLocators.view_Plan, "Shop Now");
			}
			if(configProperties.getProperty("server.site").equalsIgnoreCase("slwofc")) {
				clickElement(commonPageLocators.view_Plan, "Get a quote");
			}
			waitTillPageLoad();
			waitTillPageLoad();
		}
		else {
			throw new IllegalArgumentException("Invalid EnterZipLocation: " + EnterZipLocation);
		}
	}



	/**
	 * Description: Closing cookies pop up.
	 */
	public void closeCookiesBottom() throws InterruptedException {
		pageActions.clickElement(commonPageLocators.cookiesClose,"Close cookies");
	}


}
