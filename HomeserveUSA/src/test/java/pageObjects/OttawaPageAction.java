package pageObjects;

import static automationFramework.StartDriver.driver;
import static automationFramework.PageActions.*;
import static automationFramework.DynamicWebElements.*;

import org.openqa.selenium.support.PageFactory;

public class OttawaPageAction {
	
	public OttawaPageAction() {
		PageFactory.initElements(driver, this);
	}

	
	/**
	 * Description: Change the Language into English
	 * @throws InterruptedException 
	 */
	public void changeTheLanguageIntoEnglish() throws InterruptedException {
		clickElement(getWebElementByText("See plan details in English."), "See plan details in English.");
		switchWindow();
	}
	
	

}
