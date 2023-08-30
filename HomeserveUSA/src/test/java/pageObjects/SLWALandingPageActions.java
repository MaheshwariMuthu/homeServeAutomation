package pageObjects;

import automationFramework.PageActions;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageLocators.CommonPageLocators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static automationFramework.Constant.*;
import static automationFramework.DataReader.configProperties;
import static automationFramework.DataReader.getParameterString;
import static automationFramework.DynamicWebElements.*;
import static automationFramework.PageActions.*;
import static automationFramework.PageActions.clickElement;
import static automationFramework.StartDriver.driver;
import static automationFramework.Waits.*;
import static pageObjects.CommonPageActions.commonPageLocators;
import static pageObjects.HSLandingPageActions.getCurrentTime;

public class SLWALandingPageActions {

	public static Logger log = Logger.getLogger(PageActions.class);
	CommonPageLocators commonPageLocators = new CommonPageLocators();

	public SLWALandingPageActions() {
		PageFactory.initElements(driver, this);
	}

	public void chooseAndMakePayementType(String accountType)throws Exception {
		if (accountType.equals("Checking Account")) {

			if(configProperties.getProperty("server.url").equalsIgnoreCase("Homeserve")){
				clickElement(getWebElementByID("select2-checkout-form__method-container"), "Payment options");
			}

			clickElement(getWebElementByText("Checking Account"), "Checking Account");
			sleep(5);
			typeText(getWebElementByID("full-name"), "Dean Heandreson", "Full name");
			typeText(getWebElementByID("routing-number"), "021912915", "Routing number");
			typeText(getWebElementByID("checking-account"), "6011000000000000", "Account number");
			typeText(getWebElementByID("verify-checking-account"), "6011000000000000", "Checking account number");
			clickElement(commonPageLocators.completeSecureCheckout, "completeSecureCheckout");
			waitTillPageLoad();
		}
		if (accountType.equals("Credit or Debit Card")) {
			if (configProperties.getProperty("server.url").equalsIgnoreCase("slwofc") ||
					configProperties.getProperty("server.url").equalsIgnoreCase("ottawa-french")) {

				scrollToElement(commonPageLocators.select_Go_PaperLess);
				clickElement(commonPageLocators.select_Go_PaperLess, "select_Go_PaperLess");
				clickElement(commonPageLocators.choosePaymentTYpe, "Choose Payment Type");
				sleep(5);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(*//iframe)[1]")));
				driver.switchTo().frame(iframe);
				sleep(5);
				commonPageLocators.card_Number.sendKeys(configProperties.getProperty("card.Number"));
				commonPageLocators.month_Year.sendKeys("0527");
				clickElement(commonPageLocators.add_Card, "add card");
				sleep(5);
				//	PageActions.verify_text_on_page(commonPageLocators.success_Message, "success");
				//	sleep(2);
				driver.switchTo().defaultContent();
				clickElement(commonPageLocators.completeSecureCheckout, "completeSecureCheckout");
				getCurrentTime();
			} else if (configProperties.getProperty("server.url").equalsIgnoreCase("lasanitation") ||
					(configProperties.getProperty("server.url").equalsIgnoreCase("slwofa"))

			)
					 {
				scrollToElement(commonPageLocators.choosePaymentTYpe);
				clickElement(commonPageLocators.choosePaymentTYpe, "Choose Payment Type");
				sleep(5);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(*//iframe)[1]")));
				driver.switchTo().frame(iframe);
				sleep(5);
				System.out.println(commonPageLocators.cardType.getAttribute("value"));
				clickElement(commonPageLocators.cardType, "cardtype");
				typeText(commonPageLocators.card_Number, configProperties.getProperty("card.Number"), "card number");
				clickElement(commonPageLocators.cardExpiryMonth, "cardtype");
				selectFromDropdownByValue(commonPageLocators.cardExpiryMonth, "05");
				clickElement(commonPageLocators.cardExpiryYear, "cardtype");
				selectFromDropdownByValue(commonPageLocators.cardExpiryYear, "2040");
				clickElement(commonPageLocators.nextButton, "Next Button");
				sleep(5);
				driver.switchTo().defaultContent();
				clickElement(getWebElementByClass("button js-post-message"), "Complete Secure Checkout");
				getCurrentTime();
				waitTillPageLoad();
				getCurrentTime();
			} if(configProperties.getProperty("server.url").equalsIgnoreCase("Homeserve")){
				clickElement(getWebElementByID("select2-checkout-form__method-container"), "Payment options");
				clickElement(commonPageLocators.creditCardOption, "CreditCard");
				Thread.sleep(12000);
				waitTillPageLoad();
				driver.switchTo().frame(commonPageLocators.creditCardNumberFrame);
				System.out.println("Enter Card Number");
				Thread.sleep(5000);
				typeText(commonPageLocators.card_Number, "4024007168458700", "Card number");
				driver.switchTo().defaultContent();
				typeText(getWebElementByID("micro-exp-date"), "122027", "Expiratioin Date");
				clickElement(commonPageLocators.completeSecureCheckout, "Checkout");
				waitTillPageLoad();
				Thread.sleep(8000);
			}else {
				scrollToElement(commonPageLocators.select_Go_PaperLess);
				clickElement(commonPageLocators.select_Go_PaperLess, "select_Go_PaperLess");
				clickElement(commonPageLocators.choosePaymentTYpe, "Choose Payment Type");
				sleep(5);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(*//iframe)[2]")));
				driver.switchTo().frame(iframe);
				//driver.switchTo().frame(commonPageLocators.creditCardNumberFrame);
				sleep(5);
				System.out.println(commonPageLocators.cardType.getAttribute("value"));
				clickElement(commonPageLocators.cardType, "cardtype");
				typeText(commonPageLocators.card_Number, configProperties.getProperty("card.Number"), "card number");
				clickElement(commonPageLocators.cardExpiryMonth, "cardtype");
				selectFromDropdownByValue(commonPageLocators.cardExpiryMonth, "05");
				clickElement(commonPageLocators.cardExpiryYear, "cardtype");
				selectFromDropdownByValue(commonPageLocators.cardExpiryYear, "2040");
				clickElement(commonPageLocators.nextButton, "Next Button");
				sleep(5);
				driver.switchTo().defaultContent();
				clickElement(getWebElementByClass("button js-post-message"), "Complete Secure Checkout");
				getCurrentTime();
				waitTillPageLoad();
			}
		}
	}
}





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

