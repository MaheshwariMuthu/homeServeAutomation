package pageObjects;

import static automationFramework.Constant.Address;
import static automationFramework.Constant.ApartmentNumber;
import static automationFramework.Constant.Email;
import static automationFramework.Constant.PhoneNumber;
import static automationFramework.Constant.orderNumberText;
import static automationFramework.DynamicWebElements.getWebElementByID;
import static automationFramework.DynamicWebElements.getWebElementByText;
import static automationFramework.DynamicWebElements.getWebElementByValue;
import static automationFramework.PageActions.clickElement;
import static automationFramework.PageActions.log;
import static automationFramework.PageActions.scrollToElement;
import static automationFramework.PageActions.selectFromDropdownByValue;
import static automationFramework.PageActions.typeText;
import static automationFramework.StartDriver.driver;
import static automationFramework.Waits.*;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageLocators.SanjosePageLocators;


public class SanjosePageActions {
	SanjosePageLocators sanjosePageLocators = new SanjosePageLocators();

	public SanjosePageActions() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Description: Selecting Product to cart and then proceed to checkout
	 * 
	 * @param productCount
	 * @throws InterruptedException
	 */
	public void selectProductProceedToCheckout(String productCount) throws InterruptedException {
		int i = 0;
		scrollToElement(sanjosePageLocators.addToCart.get(0));
		clickElement(sanjosePageLocators.addToCart.get(0), "Add to cart");
		for (; i < Integer.parseInt(productCount); i++) {
			scrollToElement(sanjosePageLocators.addToCart.get(i));
			clickElement(sanjosePageLocators.addToCart.get(i), "Add to cart");
			Thread.sleep(2000);
		}
		clickElement(sanjosePageLocators.proceedToCheckout.get(i - 0), "Proceed to checkout");
	}

	/**
	 * Description:
	 * 
	 * @throws InterruptedException
	 */
	public void entercontactDetails(String Zipcode,String City) throws InterruptedException {
//		String generateRandomEmail = RandomStringUtils.randomNumeric(3);
//		String email = "aabislathia+" + generateRandomEmail + "@gmail.com";

       String generateRandomAddress=RandomStringUtils.randomNumeric(4);
		
		Email = "homeservertesting+" + RandomStringUtils.randomNumeric(3) + "@gmail.com";
		Address = generateRandomAddress+ " Chapmans Lane";
		PhoneNumber = "65070"+RandomStringUtils.randomNumeric(3)+"34";
		ApartmentNumber = RandomStringUtils.randomNumeric(4);
		
		System.out.println(PhoneNumber);
		waitTillPageLoad();
		typeText(getWebElementByID("email"), Email, "Email");
		typeText(getWebElementByID("email-confirm"), Email, "Conform Email");
		typeText(getWebElementByID("first-name"), "Zack", "First name");
		typeText(getWebElementByID("last-name"), "Ansley", "Last name");
		typeText(getWebElementByID("address-line-1"), Address, "Adress");
		typeText(getWebElementByID("address-line-2"), ApartmentNumber, "Adress Second");
		typeText(getWebElementByID("city"), City, "Adress");
		typeText(getWebElementByID("zip-code"), Zipcode, "Zip code");
		typeText(getWebElementByID("home-phone"), PhoneNumber, "Home phone");
		Thread.sleep(4000);
	}

	/**
	 * Description: Enter credit/ Debit card details
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void addPaymentMethodForCreditOrDebitCard(String accountType) throws InterruptedException {

		if (accountType.equals("Checking Account")) {

			clickElement(getWebElementByText("Checking Account"), "Checking Account");
			typeText(getWebElementByID("full-name"), "Dean Heandreson", "Full name");
			typeText(getWebElementByID("routing-number"), "021912915", "Routing number");
			typeText(getWebElementByID("checking-account"), "6011000000000000", "Account number");
			typeText(getWebElementByID("verify-checking-account"), "6011000000000000", "Checking account number");

		} else if (accountType.equals("Credit or Debit Card")) {
			clickElement(getWebElementByText("Credit or Debit Card"), "Credit or Debit Card");
			Thread.sleep(5000);
			driver.switchTo().frame(sanjosePageLocators.creditCardNumberFrame);
			sleep(5);
			clickElement(getWebElementByText("Visa"), "Visa");
			typeText(getWebElementByID("card_number"), "4024007168458700", "Conform Email");
			selectFromDropdownByValue(getWebElementByID("card_expiry_month"), "06");
			selectFromDropdownByValue(getWebElementByID("card_expiry_year"), "2026");
			clickElement(getWebElementByValue("Next"), "Next btn");
			driver.switchTo().defaultContent();
			sleep(10);
		} else {
			Assert.fail("Add payment failed");
		}
		clickElement(getWebElementByText("Complete Secure Checkout"), "Complete Secure Checkout");
	}

	/**
	 * Description: Selecting billing Frequency.
	 * @param billingFreq
	 * @throws InterruptedException
	 */
	public void selectBillingFrequency(String billingFreq) throws InterruptedException {
		if (billingFreq.equals("Monthly")) {
			clickElement(getWebElementByText("Monthly"), "Monthly");
			log.info("Mothly checkbox selected");
		} else if (billingFreq.equals("Quarterly")) {
			clickElement(getWebElementByText("Quarterly"), "Quarterly");
			log.info("Quarterly checkbox selected");
		} else if (billingFreq.equals("Annually")) {
			clickElement(getWebElementByText("Annually"), "Annually");
			log.info("Annually checkbox selected");
		}else {
			Assert.fail("Billing Frequency selection fail");
		}
	}

	/**
	 * Description: Verify the order completed successfully or not
	 * @throws InterruptedException 
	 * 
	 */
	public void completeTheSaleAndVerifyOrderConfermation() throws InterruptedException {
//		Order name and 
		
		waitTillPageLoad();
		clickElement(sanjosePageLocators.use_this_address_button, "Yes, use this address");
		Assert.assertTrue("Order Confirmation not present ",verifyWebElementPresent(sanjosePageLocators.orderConfirmationTitle));
		Assert.assertTrue("Order Confirmation not present ",verifyWebElementPresent(getWebElementByID("btn-create-new-account")));
		orderNumberText = sanjosePageLocators.orderNumber.getText();
		log.info("Order Number is: " +orderNumberText);
        String[] parts = orderNumberText.split("\\.");
        String extractedValue = parts[1];
        System.out.println("Extracted Value:" + extractedValue.trim());
		log.info("Homeserve sale completed.");	
	}

}
