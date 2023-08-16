package pageLocators;

import static automationFramework.StartDriver.driver;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OttawaPageLocators {
	
	public OttawaPageLocators() {
		PageFactory.initElements(driver, this);
	}
	
	/* Selected  Plans X-path */
	@FindBy(xpath = "//span[@class='checkmark']")
	public List<WebElement> checkboxOttawa;
	
	/* Add To Cart button X-path */
	@FindBy(xpath = "//button[text()='Add To Cart']")
	public WebElement addToCart;
}
