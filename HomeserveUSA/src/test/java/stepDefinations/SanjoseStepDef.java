package stepDefinations;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.CommonPageActions;
import pageObjects.SanjosePageActions;

public class SanjoseStepDef {
	
	CommonPageActions commonPageActions = new CommonPageActions();
	SanjosePageActions sanjosePage = new SanjosePageActions();
	
	@Given("User is on Sanjose page")
	public void user_is_on_sanjose_page() throws FileNotFoundException, InterruptedException, IOException, ParseException {
	   commonPageActions.navigateToApplication();
	}
	@When("User select product and proceed to checkout")
	public void user_select_product_and_proceed_to_checkout(String Zipcode, String City) throws InterruptedException {
	   sanjosePage.selectProductProceedToCheckout("0");
	   sanjosePage.entercontactDetails(Zipcode,City);
	   sanjosePage.selectBillingFrequency("Annually");
	   sanjosePage.addPaymentMethodForCreditOrDebitCard("Checking Account");
	   sanjosePage.completeTheSaleAndVerifyOrderConfermation();
	}

//
	@Then("the user fills up the Contact details with Zipcode as {string} and City as {string}")
	public void the_user_fills_up_the_contact_details_with_Zipcode_as_and_City_as(String Zipcode, String City)
			throws Exception{
		sanjosePage.entercontactDetails(Zipcode,City);

	}
// the user selects the PaymentType as "Credit or Debit Card"
	@Then("the user selects the PaymentType as {string}")
	public void the_user_selects_the_payment_type_as(String AccounType) throws Exception{

		sanjosePage.addPaymentMethodForCreditOrDebitCard(AccounType);
	}



	@Then("the user selects the Billing Frequency as {string}")
	public void the_user_selects_the_Billing_Frequency_as(String BillingType) throws Exception{
		sanjosePage.selectBillingFrequency("Annually");
	}

}
