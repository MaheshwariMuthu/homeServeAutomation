package stepDefinations;

import automationFramework.Waits;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import pageActions.CommonPageActions;
import pageActions.SanjosePageActions;
import pageLocators.SanjosePageLocators;

import static automationFramework.PageActions.clickElement;
import static automationFramework.PageActions.scrollToElement;
import static automationFramework.Waits.verifyWebElementVisibleWebElementBoolean;
import static automationFramework.Waits.waitTillPageLoad;

public class SanjoseStepDef {
	
	CommonPageActions commonPageActions = new CommonPageActions();
	SanjosePageActions sanjosePage = new SanjosePageActions();


	@When("User select product and proceed to checkout")
	public void user_select_product_and_proceed_to_checkout() throws Exception {
		commonPageActions.handleEnterCodePopups();
		sanjosePage.selectProductProceedToCheckout("0");

	}

//
	@Then("the user fills up the Contact details with Zipcode as {string} and City as {string}")
	public void the_user_fills_up_the_contact_details_with_Zipcode_as_and_City_as(String Zipcode, String City)
			throws Exception{
		commonPageActions.enterUserDetails(Zipcode,City);

	}
// the user selects the PaymentType as "Credit or Debit Card"
	@Then("the user selects the PaymentType as {string}")
	public void the_user_selects_the_payment_type_as(String PaymentType) throws Exception{

		sanjosePage.choosePaymentType(PaymentType);
	}



	@Then("the user selects the Billing Frequency as {string}")
	public void the_user_selects_the_Billing_Frequency_as(String BillingFrequency) throws Exception{
		sanjosePage.selectBillingFrequency(BillingFrequency);
	}

}
