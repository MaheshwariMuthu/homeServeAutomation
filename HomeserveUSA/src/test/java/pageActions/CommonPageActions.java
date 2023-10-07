package pageActions;

import static automationFramework.Constant.*;
import static automationFramework.Constant.PhoneNumber;
import static automationFramework.DataReader.configProperties;
import static automationFramework.DataReader.geturl;
import static automationFramework.DynamicWebElements.*;
import static automationFramework.PageActions.*;
import static automationFramework.StartDriver.driver;
import static automationFramework.Waits.*;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import automationFramework.PageActions;
import pageLocators.CommonPageLocators;


public class CommonPageActions {
    CommonPageLocators commonPageLocators = new CommonPageLocators();
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
     */
    public void navigateToApplication()
            throws InterruptedException, IOException, ParseException {
        driver.get(geturl());
        waitTillPageLoad();
//		closeCookiesBottom();
    }

    public void handlePopups() throws Exception {
        System.out.println("handleing EnterCode Popups if any");   // //a[contains(text(),'Do Not Have Code')]
        waitTillPageLoad();
        if (configProperties.getProperty("server.site").equalsIgnoreCase("sanjose")) {

            WebElement entercodepopupClose = getWebElementByContainsText("Do Not Have Code");

            if (waitForElementavailblilityboolean(entercodepopupClose,"Water popup",30)) {
                clickElement(entercodepopupClose, "Water popup",false);
                waitTillPageLoad();
            }
        }


    }

    /**
     * Description: Entering Zip code and click on
     *
     * @throws InterruptedException
     */
    public void enterZipCodeAndSubmit(String zipCode, String EnterZipLocation) throws InterruptedException {
        if (EnterZipLocation.equalsIgnoreCase("header")) {
            clickElement(commonPageLocators.enterZipHeaderLink, "Enter Zip", false);
            typeText(getWebElementByID("zipcode"), zipCode, "ZipCode field");
            waitTillPageLoad();
            clickElement(commonPageLocators.viewPlans, "View Plans", false);
            waitTillPageLoad();
            waitTillPageLoad();
            clickElement(commonPageLocators.viewAvailablePlans, "View available plans", false);
        } else if (EnterZipLocation.equalsIgnoreCase("LandingPage")) {
//			same code with different locators
            System.out.println(EnterZipLocation);
            clickElement(commonPageLocators.txtZipCode, "Enter Your ZIP Code", false);
            Thread.sleep(2000);
            typeText(commonPageLocators.txtZipCode, zipCode, "Enter Your ZIP Code");
            waitTillPageLoad();
            if (configProperties.getProperty("server.site").equalsIgnoreCase("slwofa")) {
                clickElement(commonPageLocators.view_Plan, "Shop Now", false);
            }
            if (configProperties.getProperty("server.site").equalsIgnoreCase("slwofc")) {
                clickElement(commonPageLocators.view_Plan, "Get a quote", false);
            }
            waitTillPageLoad();
            waitTillPageLoad();
        } else {
            throw new IllegalArgumentException("Invalid EnterZipLocation: " + EnterZipLocation);
        }
    }

    public void enterUserDetails(String Zipcode, String City) throws InterruptedException {

        String generateRandomAddress = RandomStringUtils.randomNumeric(4);

        Email = "chandra.hstest+" + RandomStringUtils.randomNumeric(3) + "@gmail.com";
        Address = generateRandomAddress + " Chapmans Lane";
        PhoneNumber = "4409845223";
        ApartmentNumber = RandomStringUtils.randomNumeric(4);

        waitTillPageLoad();
        typeText(getWebElementByID("email"), Email, "Email");
        typeText(getWebElementByID("email-confirm"), Email, "Confirm Email");
        typeText(getWebElementByID("first-name"), "Zack", "First name");
        typeText(getWebElementByID("last-name"), "Ansley", "Last name");
        typeText(getWebElementByID("address-line-1"), Address, "Address");
        typeText(getWebElementByID("address-line-2"), ApartmentNumber, "Address Second");
        typeText(getWebElementByID("home-phone"), PhoneNumber, "Home Phone");

        if (configProperties.getProperty("server.site").equalsIgnoreCase("ottawa") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("aepindianamichigan") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("buffalowaternipcnew") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("firstenergy-fundle") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("kypower-tabs") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("lasanitation") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("sanjose") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("wvwachoice")) {
            typeText(getWebElementByID("city"), City, "City");
            typeText(getWebElementByID("zip-code"), Zipcode, "Zip code");
        }


        try {
            WebElement State = driver.findElement(By.xpath("//*[@id=\"state\"]"));

            String state = State.getAttribute("value");
            System.out.println(state);

            if (configProperties.getProperty("server.site").equalsIgnoreCase("aepindianamichigan")
                    && state.equalsIgnoreCase("IN")) {
                // (313) 793-4983
                String MobileNumber = "33131" + RandomStringUtils.randomNumeric(3) + "340";
                typeText(getWebElementByID("home-phone"), MobileNumber, "Home phone");
            }
            Thread.sleep(4000);

        } catch (Exception e) {

        }
    }

//	public void entercontactDetails(String FirstName, String LastName) throws InterruptedException, FileNotFoundException, IOException, ParseException {
//		String generateRandomEmail = RandomStringUtils.randomNumeric(3);
//		String generateRandomPhonenumber = RandomStringUtils.randomNumeric(3);
//		String generateRandomAddress = RandomStringUtils.randomNumeric(4);
//		// homeservertesting@gmail.com
//		Email = "chandra.hstest+" + generateRandomEmail + "@gmail.com";
//		Address = generateRandomAddress + " Chapmans Lane";
//		PhoneNumber = "45070" + generateRandomPhonenumber + "34";
//		ApartmentNumber = RandomStringUtils.randomNumeric(4);
//		verifyWebElementVisibleWebElementBoolean(getWebElementByID("email"));
//		waitForElement(getWebElementByID("email"), "Email", 120);
//		typeText(getWebElementByID("email"), Email, "Email");
//		typeText(getWebElementByID("email-confirm"), Email, "Confirm Email");
//		typeText(commonPageLocators.firstName, FirstName, "First name");
//		typeText(getWebElementByID("last-name"), LastName, "Last name");
//		typeText(commonPageLocators.addressLine, Address, "Adress");
//		typeText(getWebElementByID("address-line-2"), ApartmentNumber, "Address Second");
//		typeText(getWebElementByID("home-phone"), PhoneNumber, "Home phone");
//
//	}


    /**
     * Description: Closing cookies pop up.
     */
    public void closeCookiesBottom() throws InterruptedException {
        pageActions.clickElement(commonPageLocators.cookiesClose, "Close cookies", false);
    }


}
