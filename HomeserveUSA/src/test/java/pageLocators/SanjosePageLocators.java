package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinations.Hooks;


import java.util.List;


public class SanjosePageLocators extends Hooks {
	public SanjosePageLocators() {
		PageFactory.initElements(driver, this);
	}

//	/* Credit card number X-path */
//	@FindBy(xpath = "(//iframe)[2]")
//	public WebElement creditCardNumberFrame;

	/* Add to cart X-path */

	/* Add to cart X-path */
	@FindBy(xpath = "//a[@class='button js-add-to-cart']//span[@class='add']")
	public WebElement addToCart;

	/* Proceed to Checkout X-path */
	@FindBy(xpath = "//div[@class='wrapper-cta']//a//span[@class='co']")
	public WebElement proceedToCheckout;

	/* Title X-path */
	@FindBy(xpath = "//h1[contains(text(),'Order')]")
	public WebElement orderConfirmationTitle;

	/* Order number X-path */
	@FindBy(xpath = "//div[@class='component c402-order-summary']/p/strong")
	public WebElement orderNumber;

	/* Use this address X path */
	@FindBy(xpath = "//a[@class='button js-confirm-address']")
	public WebElement use_this_address_button;
}
