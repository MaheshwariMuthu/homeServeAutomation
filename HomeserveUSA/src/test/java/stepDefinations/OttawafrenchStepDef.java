package stepDefinations;

import io.cucumber.java.en.When;
import pageObjects.CommonPageActions;
import pageObjects.OttawaPageAction;
import pageObjects.SLWALandingPageActions;

public class OttawafrenchStepDef {
	CommonPageActions commonPageActions = new CommonPageActions();

	OttawaPageAction ottawaPageAction = new OttawaPageAction();


	@When("User change the language of the application")
	public void clicks_on_continue_to_payment_information()	throws Exception {
		ottawaPageAction.changeTheLanguageIntoEnglish();

	}
}