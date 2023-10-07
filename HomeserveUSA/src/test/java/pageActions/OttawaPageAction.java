package pageActions;

import static automationFramework.PageActions.clickElement;
import static automationFramework.StartDriver.driver;
import static automationFramework.PageActions.*;
import static automationFramework.DynamicWebElements.*;
import static automationFramework.Waits.waitTillPageLoad;

import org.openqa.selenium.support.PageFactory;
import pageLocators.CommonPageLocators;
import pageLocators.OttawaPageLocators;

public class OttawaPageAction {
	
	public OttawaPageAction() {
		PageFactory.initElements(driver, this);
	}
	public CommonPageLocators commonPageLocators = new CommonPageLocators();

	public CommonPageActions commonPageActions = new CommonPageActions();

	public OttawaPageLocators ottawaPageLocators = new OttawaPageLocators();
	
	/**
	 * Description: Change the Language into English
	 * @throws InterruptedException 
	 */
	public void changeTheLanguageIntoEnglish() throws InterruptedException {
		Thread.sleep(3000);
		scrollToElement(getWebElementByText("See plan details in English."));
		clickElement(getWebElementByText("See plan details in English."),"Change Language",false);
		waitTillPageLoad();
		switchWindow();


//
	}
	/**
	 * Description: Change the Language into English
	 * @throws InterruptedException
	 */
	public void selectThePlanAndAddToCartAndProceedToCheckout() throws InterruptedException {
		waitTillPageLoad();
//		commonPageActions.closeCookiesBottom();
		scrollToElement(ottawaPageLocators.SelectAPlanOttawa);
		clickElement(ottawaPageLocators.SelectAPlanOttawa, "Select A Plan",false);
		clickElement(commonPageLocators.addToCart, "Add to cart",false);
		clickElement(commonPageLocators.proceedToCheckout, "Proceed to checkout",false);
		clickElement(commonPageLocators.proceedToCheckout, "Proceed to checkout",false);
		waitTillPageLoad();

	}

}
