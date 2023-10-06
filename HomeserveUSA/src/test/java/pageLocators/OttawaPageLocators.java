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
	@FindBy(xpath = "//span[@class='checkmark']")
	public static List<WebElement> checkboxOttawa;

	@FindAll({
			@FindBy(xpath = "/html/body/main/div[3]/div/div/div[1]/div/div[2]/div[1]/div[1]/div/div/label/span[1]"),
			@FindBy(xpath = "//span[@class='checkmark']"),
			@FindBy(xpath = "//div[3]/div/div/div[1]/div/div[2]/div[1]/div[1]/div/div/label/span[1]"),

	})
	public static WebElement SelectAPlanOttawa;

	@FindBy(xpath = "/html/body/main/div[2]/div/div/div/p[2]/span[2]/a")
	public static WebElement changeLanguageTOEnnglish;


}
