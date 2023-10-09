package pageActions;

import automationFramework.PageActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageLocators.CommonPageLocators;

import java.time.Duration;

import static automationFramework.DataReader.configProperties;
import static automationFramework.DynamicWebElements.*;
import static automationFramework.PageActions.*;
import static automationFramework.PageActions.clickElement;
import static automationFramework.StartDriver.driver;
import static automationFramework.Waits.*;
import static pageActions.HSLandingPageActions.getCurrentTime;

public class SLWALandingPageActions {

	public static Logger log = Logger.getLogger(PageActions.class);
	CommonPageLocators commonPageLocators = new CommonPageLocators();

	public SLWALandingPageActions() {
		PageFactory.initElements(driver, this);
	}

	public void chooseAndMakePayementType(String accountType)throws Exception {
		if (accountType.equalsIgnoreCase("Checking Account")) {

			if(configProperties.getProperty("server.site").equalsIgnoreCase("Homeserve")){
				WebElement Paymenttype = driver.findElement(By.className("select2-selection__rendered"));
				Paymenttype.click();
				sleep(2);
				clickElement(commonPageLocators.checkingAccountOption, "Checking Account",false);
//				commonPageLocators.checkingAccountOption.click();
				sleep(2);
				typeText(getWebElementByID("checking-full-name"), "Dean Heandreson", "Full name");
				typeText(getWebElementByID("checking-routing-number"), "021912915", "Routing number");
				typeText(getWebElementByID("checking-account-number"), "6011000000000000", "Account number");
				typeText(getWebElementByID("checking-account-number-confirm"), "6011000000000000", "Checking account number");
				scrollToBottomOfPage();
				sleep(5);
				WebElement checkout = driver.findElement(By.xpath("//*[@id=\"checking-form\"]/div[3]/button"));
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].click();", checkout);
				getCurrentTime();
				waitTillPageLoad();
			}else {

				clickElement(getWebElementByText("Checking Account"), "Checking Account",false);
				sleep(5);
				typeText(getWebElementByID("full-name"), "Dean Heandreson", "Full name");
				typeText(getWebElementByID("routing-number"), "021912915", "Routing number");
				typeText(getWebElementByID("checking-account"), "6011000000000000", "Account number");
				typeText(getWebElementByID("verify-checking-account"), "6011000000000000", "Checking account number");
				clickElement(commonPageLocators.completeSecureCheckout, "completeSecureCheckout",false);
				getCurrentTime();
				waitTillPageLoad();
			}
		}
		else if (accountType.equalsIgnoreCase("Credit or Debit Card")) {
			if (configProperties.getProperty("server.site").equalsIgnoreCase("slwofc") ||
					configProperties.getProperty("server.site").equalsIgnoreCase("ottawa")) {

				scrollToElement(commonPageLocators.select_Go_PaperLess);
				clickElement(commonPageLocators.select_Go_PaperLess, "select_Go_PaperLess",false);
				clickElement(commonPageLocators.choosePaymentTYpe, "Choose Payment Type",false);
				sleep(5);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(*//iframe)[1]")));
				driver.switchTo().frame(iframe);
				sleep(5);
				commonPageLocators.card_Number.sendKeys(configProperties.getProperty("card.Number"));
				commonPageLocators.month_Year.sendKeys("0527");
				clickElement(commonPageLocators.add_Card, "add card",false);
				sleep(5);
				//	PageActions.verify_text_on_page(commonPageLocators.success_Message, "success");
				//	sleep(2);
				driver.switchTo().defaultContent();
				clickElement(commonPageLocators.completeSecureCheckout, "completeSecureCheckout",false);
				getCurrentTime();
			} else if (configProperties.getProperty("server.site").equalsIgnoreCase("lasanitation")||
					configProperties.getProperty("server.site").equalsIgnoreCase("slwofa"))

					 {
				scrollToElement(commonPageLocators.choosePaymentTYpe);
				clickElement(commonPageLocators.choosePaymentTYpe, "Choose Payment Type",false);
				sleep(5);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(*//iframe)[1]")));
				driver.switchTo().frame(iframe);
				sleep(5);
				System.out.println(commonPageLocators.cardType.getAttribute("value"));
				clickElement(commonPageLocators.cardType, "cardtype",false);
				typeText(commonPageLocators.card_Number, configProperties.getProperty("card.Number"), "card number");
				clickElement(commonPageLocators.cardExpiryMonth, "cardtype",false);
				selectFromDropdownByValue(commonPageLocators.cardExpiryMonth, "05");
				clickElement(commonPageLocators.cardExpiryYear, "cardtype",false);
				selectFromDropdownByValue(commonPageLocators.cardExpiryYear, "2040");
				clickElement(commonPageLocators.nextButton, "Next Button",false);
				sleep(5);
				driver.switchTo().defaultContent();
				clickElement(getWebElementByClass("button js-post-message"), "Complete Secure Checkout",false);
				getCurrentTime();
				waitTillPageLoad();
				getCurrentTime();
			} else if(configProperties.getProperty("server.site").equalsIgnoreCase("Homeserve")){
				WebElement Paymenttype = driver.findElement(By.className("select2-selection__rendered"));
				Paymenttype.click();
				sleep(2);
				clickElement(commonPageLocators.creditCardOption, "creditCardOption",false);
				sleep(2);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(*//iframe)[2]")));
				driver.switchTo().frame(iframe);
				System.out.println("Enter Card Number");
				sleep(2);
				//typeText(commonPageLocators.card_Number, "4024007168458700", "Card number");
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].click();", commonPageLocators.card_Number);
				commonPageLocators.card_Number.sendKeys(configProperties.getProperty("card.Number"));
			//	WebElement textboxElement = driver.findElement(By.id("textboxId"));

				// Click on the textbox using JavaScript Executor

				driver.switchTo().defaultContent();
				typeText(getWebElementByID("micro-exp-date"), "122027", "Expiratioin Date");
				clickElement(commonPageLocators.completeSecureCheckout, "Checkout",false);
				getCurrentTime();
				waitTillPageLoad();
			}else {
				scrollToElement(commonPageLocators.select_Go_PaperLess);
				clickElement(commonPageLocators.select_Go_PaperLess, "select_Go_PaperLess",false);
				clickElement(commonPageLocators.choosePaymentTYpe, "Choose Payment Type",false);
				sleep(5);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(*//iframe)[2]")));
				driver.switchTo().frame(iframe);
				//driver.switchTo().frame(commonPageLocators.creditCardNumberFrame);
				sleep(5);
				System.out.println(commonPageLocators.cardType.getAttribute("value"));
				clickElement(commonPageLocators.cardType, "cardtype",false);
				typeText(commonPageLocators.card_Number, configProperties.getProperty("card.Number"), "card number");
				clickElement(commonPageLocators.cardExpiryMonth, "cardtype",false);
				selectFromDropdownByValue(commonPageLocators.cardExpiryMonth, "05");
				clickElement(commonPageLocators.cardExpiryYear, "cardtype",false);
				selectFromDropdownByValue(commonPageLocators.cardExpiryYear, "2040");
				clickElement(commonPageLocators.nextButton, "Next Button",false);
				sleep(5);
				driver.switchTo().defaultContent();
				clickElement(getWebElementByClass("button js-post-message"), "Complete Secure Checkout",false);
				getCurrentTime();
				waitTillPageLoad();
			}
		}else {
			System.err.println("PaymentType is provided incorrectly");
		}
	}
}





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

