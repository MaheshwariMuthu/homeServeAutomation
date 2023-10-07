package pageActions;

import static automationFramework.Constant.*;
import static automationFramework.DataReader.configProperties;
import static automationFramework.DynamicWebElements.*;
import static automationFramework.PageActions.*;
import static automationFramework.PageActions.log;
import static automationFramework.PageActions.scrollToElement;
import static automationFramework.PageActions.selectFromDropdownByValue;
import static automationFramework.PageActions.typeText;
import static automationFramework.StartDriver.driver;
import static automationFramework.Waits.*;
import static pageActions.CommonPageActions.commonPageLocators;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	public void selectProductProceedToCheckout(String productCount) throws Exception {
		int i = 0;
		scrollToElement(sanjosePageLocators.addToCart);
		clickElement(sanjosePageLocators.addToCart, "Add to cart",false);
		for (; i < Integer.parseInt(productCount); i++) {
			scrollToElement(sanjosePageLocators.addToCart);
			clickElement(sanjosePageLocators.addToCart, "Add to cart",false);
			Thread.sleep(2000);
		}
		String messageText = driver.getTitle();
		System.out.println(messageText);

		if (messageText.contains("Checkout Empty Cart")) {
			System.out.println("Cart is empty.");
			throw new Exception("Checkout Cart is Empty");
		} else {
			System.out.println("Item added to cart.");
			waitForElement(sanjosePageLocators.proceedToCheckout, "Proceed to checkout",30);
			clickElement(sanjosePageLocators.proceedToCheckout, "Proceed to checkout",false);
		}

	}

	/**
	 * Description:
	 * 
	 * @throws InterruptedException
	 */


	/**
	 * Description: Enter credit/ Debit card details
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void choosePaymentType(String PaymentType) throws InterruptedException {

		if (PaymentType.equals("Checking Account")) {

			clickElement(getWebElementByText("Checking Account"), "Checking Account",false);
			typeText(getWebElementByID("full-name"), "Dean Heandreson", "Full name");
			typeText(getWebElementByID("routing-number"), "021912915", "Routing number");
			typeText(getWebElementByID("checking-account"), "6011000000000000", "Account number");
			typeText(getWebElementByID("verify-checking-account"), "6011000000000000", "Checking account number");

		} else if (PaymentType.equals("Credit or Debit Card")) {
			if(configProperties.getProperty("server.site").equalsIgnoreCase("Homeserve")){
				clickElement(getWebElementByID("select2-checkout-form__method-container"), "Payment options",false);
				clickElement(commonPageLocators.creditCardOption, "CreditCard",false);
				Thread.sleep(12000);
				waitTillPageLoad();
				driver.switchTo().frame(commonPageLocators.creditCardNumberFrame);
				System.out.println("Enter Card Number");
				Thread.sleep(5000);
				typeText(commonPageLocators.card_Number, "4024007168458700", "Card number");
				driver.switchTo().defaultContent();
				typeText(getWebElementByID("micro-exp-date"), "122027", "Expiratioin Date");
				clickElement(commonPageLocators.completeSecureCheckout, "Checkout",false);
				waitTillPageLoad();
				Thread.sleep(8000);
			}else{
			clickElement(getWebElementByText("Credit or Debit Card"), "Credit or Debit Card",false);
			Thread.sleep(5000);
			driver.switchTo().frame(commonPageLocators.creditCardNumberFrame);
			sleep(8);
			clickElement(getWebElementByText("Visa"), "Visa",false);
			typeText(getWebElementByID("card_number"), configProperties.getProperty("card.Number"), "Conform Email");
			selectFromDropdownByValue(getWebElementByID("card_expiry_month"), "06");
			selectFromDropdownByValue(getWebElementByID("card_expiry_year"), "2026");
			clickElement(getWebElementByValue("Next"), "Next btn",false);
			driver.switchTo().defaultContent();
			sleep(10);
		}

		}else {
			Assert.fail("Add payment failed");
		}
		clickElement(getWebElementByText("Complete Secure Checkout"), "Complete Secure Checkout",false);
	}

	/**
	 * Description: Selecting billing Frequency.
	 * @param billingFreq
	 * @throws InterruptedException
	 */
	public void selectBillingFrequency(String billingFreq) throws InterruptedException {
		Thread.sleep(5000);
		if(configProperties.getProperty("server.site").equalsIgnoreCase("Homeserve")){
			clickElement(getWebElementByClass("billing-frequency__dropdown"),"Bill Frequency",false);
			WebElement FreqDropdown = getWebElementByClass("billing-frequency__dropdown");
		//	FreqDropdown.click();
			if(billingFreq.equalsIgnoreCase("Monthly")) {
				selectFromDropdownByValue(FreqDropdown, "12");
			}
			if(billingFreq.equalsIgnoreCase("Quarterly")) {
				selectFromDropdownByValue(FreqDropdown, "4");
			}
			if(billingFreq.equalsIgnoreCase("Annually")) {
				selectFromDropdownByValue(FreqDropdown, "1");
			}
		}

		else if (billingFreq.equalsIgnoreCase("Monthly")) {
			clickElement(getWebElementByText("Monthly"), "Monthly",false);
			System.out.println("Monthly checkbox selected");
			log.info("Mothly checkbox selected");
		} else if (billingFreq.equalsIgnoreCase("Quarterly")) {
			clickElement(getWebElementByText("Quarterly"), "Quarterly",false);
			log.info("Quarterly checkbox selected");
			System.out.println("Quarterly checkbox selected");
		} else if (billingFreq.equalsIgnoreCase("Annually")) {
			clickElement(getWebElementByText("Annually"), "Annually",false);
			log.info("Annually checkbox selected");
			System.out.println("Annually checkbox selected");
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
		clickElement(sanjosePageLocators.use_this_address_button, "Yes, use this address",false);
		Assert.assertTrue("Order Confirmation not present ",verifyWebElementPresent(sanjosePageLocators.orderConfirmationTitle));
		Assert.assertTrue("Order Confirmation not present ",verifyWebElementPresent(getWebElementByID("btn-create-new-account")));
		BrowserorderNumberText = sanjosePageLocators.orderNumber.getText();
		log.info("Order Number is: " +BrowserorderNumberText);
        String[] parts = BrowserorderNumberText.split("\\.");
        String extractedValue = parts[1];
        System.out.println("Extracted Value:" + extractedValue.trim());
		log.info("Homeserve sale completed.");	
	}

}
