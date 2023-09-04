package pageActions;

import automationFramework.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import automationFramework.PageActions;
import pageLocators.CommonPageLocators;

import static automationFramework.DataReader.*;
import static automationFramework.Constant.*;
import static automationFramework.DynamicWebElements.*;

import static automationFramework.PageActions.*;
import static automationFramework.Waits.*;
import static automationFramework.Waits.verifyWebElementVisibleWebElementBoolean;
import static automationFramework.Waits.waitTillPageLoad;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class HSLandingPageActions {

    public static String currentDateandTime;
    public static Logger log = Logger.getLogger(PageActions.class);
    CommonPageLocators commonPageLocators = new CommonPageLocators();
	Utils Utils = new Utils();


    CommonPageActions commonPageActions = new CommonPageActions();

    public static String BrowserorderNumberTexts;


    public HSLandingPageActions() {
        PageFactory.initElements(driver, this);
    }


    public void enterZipcode(String zipCode) throws InterruptedException {
        clickElement(commonPageLocators.txtZipCode, "Enter Zipcode textbox");

    }

    /**
     * Description: Adding Product inside the cart and click on proceed to checkout.
     *
     * @throws InterruptedException
     */
    public void addProductToCartAndProceedToCheckout() throws InterruptedException {
        int i = 0;
        scrollToElement(commonPageLocators.addToCart.get(0));
        clickElement(commonPageLocators.addToCart.get(0), "Add to cart");
        waitTillPageLoad();
        verifyWebElementVisibleWebElementBoolean(commonPageLocators.proceedToCheckout);
        clickElement(commonPageLocators.proceedToCheckout, "Proceed To Checkout");
        waitTillPageLoad();
        System.out.println(configProperties.getProperty("server.url"));
        if (configProperties.getProperty("server.url").equalsIgnoreCase("slwofc") ||
                configProperties.getProperty("server.url").equalsIgnoreCase("aepindianamichigan") ||
                configProperties.getProperty("server.url").equalsIgnoreCase("kypower-tabs") ||
                //	configProperties.getProperty("server.url").equalsIgnoreCase("firstenergy-fundle")||
                configProperties.getProperty("server.url").equalsIgnoreCase("lasanitation") ||
                configProperties.getProperty("server.url").equalsIgnoreCase("wvwachoice")
        ) {
            clickElement(getWebElementByText("Proceed To Checkout"), "Proceed To Checkout");
        }

        waitTillPageLoad();
    }


    /**
     * Description: Entering the Contact details inside the form.
     *
     * @throws InterruptedException
     * @throws ParseException
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void entercontactDetails() throws InterruptedException, FileNotFoundException, IOException, ParseException {
        String generateRandomEmail = RandomStringUtils.randomNumeric(3);
        String generateRandomPhonenumber = RandomStringUtils.randomNumeric(3);
        String generateRandomAddress = RandomStringUtils.randomNumeric(4);
        // homeservertesting@gmail.com
        Email = "chandra.hstest+" + generateRandomEmail + "@gmail.com";
        Address = generateRandomAddress + " Chapmans Lane";
        PhoneNumber = "65070" + generateRandomPhonenumber + "34";
        ApartmentNumber = RandomStringUtils.randomNumeric(4);
        verifyWebElementVisibleWebElementBoolean(getWebElementByID("email"));
        waitForElement(getWebElementByID("email"), "Email", 120);
        typeText(getWebElementByID("email"), Email, "Email");
        typeText(getWebElementByID("email-confirm"), Email, "Conform Email");
        typeText(commonPageLocators.firstName, getParameterString("FirstName", "contactDetails"), "First name");
        typeText(getWebElementByID("last-name"), getParameterString("LastName", "contactDetails"), "Last name");
        typeText(commonPageLocators.addressLine, Address, "Adress");
        typeText(getWebElementByID("address-line-2"), ApartmentNumber, "Adress Second");
        typeText(getWebElementByID("home-phone"), getParameterString("PhoneNumber", "contactDetails"), "Home phone");

    }

    public void enter_Zipcode_and_City_Details(String Zipcode, String City) {
        if (configProperties.getProperty("server.url").equalsIgnoreCase("aepindianamichigan")) {
            typeText(commonPageLocators.txtZipCode, Zipcode, "Zipcode");
            typeText(commonPageLocators.city_Details, City, "Zipcode");

        }

    }

    public void continueToPayment() throws Exception {
        clickElement(getWebElementByText("Continue to Payment Information"), "Continue to Payment Information");
        sleep(12);
        clickElement(getWebElementByText("Yes, use this address"), "Yes, use this address");
        sleep(10);
    }

    /**
     * Description:
     *
     * @throws InterruptedException
     */
    public void enterPaymentDetails() throws InterruptedException {
        clickElement(getWebElementByID("select2-checkout-form__method-container"), "Payment options");
        clickElement(commonPageLocators.creditCardOption, "CreditCard");
        Thread.sleep(12000);
        waitTillPageLoad();
        driver.switchTo().frame(commonPageLocators.creditCardNumberFrame);
        System.out.println("Enter Card Number");
        Thread.sleep(5000);
        typeText(commonPageLocators.creditCardNumberFrame, "4024007168458700", "Card number");
        typeText(getWebElementByID("micro-exp-date"), "122027", "Expiratioin Date");
        driver.switchTo().defaultContent();
        clickElement(commonPageLocators.completeSecureCheckout, "Checkout");
        waitTillPageLoad();
        Thread.sleep(8000);
    }

    public void enterAccountDetailsAndCompleteCheckout(String Value) throws Exception {

        typeText(commonPageLocators.enter_Account_Number, Value, "account number");
        clickElement(commonPageLocators.completeSecureCheckout, "complete secure checkout");
        waitTillPageLoad();

    }


    /**
     * Description: Verify order conformed successfully
     *
     * @throws InterruptedException
     */
    public void verifyOrderConformedSuccessfully() throws Exception {
        waitTillPageLoad();
        Thread.sleep(5000);
        try {
            if (commonPageLocators.AddressNotFound.getText().contains("Address not found!")
                //	commonPageLocators.AddressNotFound.getText().equalsIgnoreCase("Address not found!")
            ) {
                clickElement(commonPageLocators.use_This_Address, "use the address");
                waitTillPageLoad();
                Thread.sleep(5000);
				if (verifyWebElementPresent(commonPageLocators.PaymentnotprocessedDialog))
				{
					Assert.fail("ERROR : ------Payment Not Processed:--------");

				} else {
					Assert.assertTrue("Order Confirmation not present ", verifyWebElementPresent(commonPageLocators.orderConfirmationTitle));
					BrowserorderNumberText = commonPageLocators.orderNumber.getText();
					String[] parts = BrowserorderNumberText.split("\\.");
					String extractedValue = parts[1];
					System.out.println("Extracted Value:" + extractedValue.trim());

					BrowserorderNumberTexts = extractedValue.trim();
					System.out.println("Order Number is: " + BrowserorderNumberTexts);
					log.info("Order Number is: " + BrowserorderNumberTexts);

					log.info("Homeserve sale completed.");
				}
            } else {
                waitForElement(getWebElementByValue("TVStreaming"), "TVStreaming", 120);
                clickElement(getWebElementByValue("TVStreaming"), "TVStreaming");
                clickElement(getWebElementByText("Finish"), "Finish");
                waitTillPageLoad();
                String feedBackMessage = getWebElementByClass("survey__message survey__message--subtitle").getText();
                Thread.sleep(5000);
                if (feedBackMessage.equals("Your feedback has been submitted successfully.")) {

                    if (configProperties.getProperty("server.url").equalsIgnoreCase("Homeserve")) {
                        clickElement(commonPageLocators.feedbackPopUpCloseBtn, "Feedback close btn");
                        Assert.assertTrue("Order Confirmation not present ", verifyWebElementPresent(commonPageLocators.orderConfirmationTitle));
                        WebElement ordertext = driver.findElement(By.xpath("//*[@id=\"site-main\"]/div[2]/div/div/div/div/div[2]/div/span[1]"));
                        scrollToElement(ordertext);
                        System.out.println(ordertext.getText());
                        BrowserorderNumberTexts = ordertext.getText();
                        System.out.println(BrowserorderNumberTexts);
                        String[] parts = BrowserorderNumberTexts.split(" ");
                        if (parts.length >= 3) {
                            String extractedValue = parts[2];
                            System.out.println("Extracted Value: " + extractedValue);
                            BrowserorderNumberTexts = extractedValue;
                        } else {
                            System.out.println("Error: Unable to extract order number.");
                        }

                        System.out.println("Order Number is : " + BrowserorderNumberTexts);
                    } else {
                        clickElement(commonPageLocators.feedbackPopUpCloseBtn, "Feedback close btn");
                        Assert.assertTrue("Order Confirmation not present ", verifyWebElementPresent(commonPageLocators.orderConfirmationTitle));
                        BrowserorderNumberText = commonPageLocators.orderNumber.getText();
                        String[] parts = BrowserorderNumberText.split("\\.");
                        String extractedValue = parts[1];
                        System.out.println("Extracted Value:" + extractedValue.trim());
                        BrowserorderNumberTexts = extractedValue.trim();
                        System.out.println("Order Number is: " + BrowserorderNumberTexts);
                        log.info("Order Number is: " + BrowserorderNumberTexts);
                        Assert.assertTrue("Order Confirmation not present ", verifyWebElementPresent(getWebElementByText("Create Account")));
                        log.info("Homeserve sale completed.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Exception(e);
        }

    }

    public static void getCurrentTime() {
        // Create a SimpleDateFormat instance with the desired format
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

        // Set the time zone to IST (Indian Standard Time)
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));

        // Get the current date and time
        Date currentDate = new Date();

        // Format the current date and time
        currentDateandTime = sdf.format(currentDate);
        System.out.println("Current Date and Time : " + currentDateandTime);

        //return currentDateandTime;
    }


    /**
     * Description: Entering Zip code and click on
     *
     * @throws InterruptedException
     */
    public void enterZipCodeByLocationAndEnterZipCode(WebElement element, String zipCode) throws InterruptedException {
        // Check if element with XPath condition 1 exists
        if (verifyWebElementPresent(element)) {
            clickElement(commonPageLocators.enterZipHeaderLink, "Enter Zip");
            typeText(getWebElementByID("wrapout-zipcode"), zipCode, "ZipCode field");
            waitTillPageLoad();
            clickElement(getWebElementByClass("button button-blue zip-button"), "View Plans");
            waitTillPageLoad();
            verifyWebElementVisibleWebElementBoolean(getWebElementByText("View Plans On SLWA"));
        }
        // Check if element with XPath condition 2 exists
        else if (verifyWebElementPresent(element)) {
            typeText(getWebElementByID("home-zip-input"), zipCode, "Zipcode");
            clickElement(commonPageLocators.shopNowBannerBtn, "Shop now");
            waitTillPageLoad();
        } else {

        }
    }


    public void select_State(String StateValue) throws Exception {

        selectFromDropdownByVisibletext(commonPageLocators.select_States, StateValue);
        sleep(2);
        clickElement(commonPageLocators.state_Ok_Button, "OK");
        waitTillPageLoad();
        sleep(10);

    }


}
