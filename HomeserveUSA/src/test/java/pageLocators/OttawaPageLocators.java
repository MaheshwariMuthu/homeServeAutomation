package pageLocators;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinations.Hooks;


public class OttawaPageLocators  extends Hooks {
	
	public OttawaPageLocators() {
		PageFactory.initElements(driver, this);
	}
	
	/* Selected  Plans X-path */

	@FindAll({
//			@FindBy(xpath = "(//input[@type='checkbox'])[1]"),
			@FindBy(xpath = "//*[contains(text(),'Selected Plans')]/following::input[@type='checkbox'][1]/following-sibling::label/span[1]"),
	})
	public static WebElement SelectAPlanOttawa;

	@FindBy(xpath = "/html/body/main/div[2]/div/div/div/p[2]/span[2]/a")
	public static WebElement changeLanguageTOEnnglish;


}
