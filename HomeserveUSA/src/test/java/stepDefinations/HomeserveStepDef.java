package stepDefinations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import Config.update_Config_Properties;
import Email_Validator.Verify_Gmail;
import org.json.simple.parser.ParseException;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageActions.CommonPageActions;
import pageActions.HSLandingPageActions;
import pageActions.SanjosePageActions;

public class HomeserveStepDef {
	CommonPageActions commonPageActions = new CommonPageActions();
	HSLandingPageActions hslandingPage = new HSLandingPageActions();
	SanjosePageActions sanjosePageActions = new SanjosePageActions();
//
//	//
//	@Given("user is on {string} Home page")
//	public void user_is_on_home_page(String Application) throws InterruptedException, IOException, ParseException {
//		commonPageActions.navigateToApplication(Application);
//
//	}

	@Given("User is on {string} Home page")
	public void userIsOnHomePage(String Site) throws Exception {
		update_Config_Properties.Update_Config_Prop(Site);
		commonPageActions.navigateToApplication();

	}


	/**
	 * Description: End to end flow for sale Homeserve
	 * 
	 * @throws InterruptedException
	 */
	@When("the user enters a valid zipcode and clicks on View Plans")
	public void the_user_enters_a_valid_zipcode_and_clicks_on_view_plans(DataTable dataTable)
			throws InterruptedException {
		List<Map<String, String>> userDetailsList = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> userDetails : userDetailsList) {
			commonPageActions.enterZipCodeAndSubmit(userDetails.get("zipcode"), userDetails.get("EnterZipLocation"));
		}

	}

	@Then("add product to the cart and the user clicks on Proceed to Checkout")
	public void add_product_to_the_cart_and_the_user_clicks_on_proceed_to_checkout() throws Exception {
		commonPageActions.handlePopups();
		hslandingPage.addProductToCartAndProceedToCheckout();
	}

	@Then("the user fills in the Contact details")
	public void the_user_fills_in_the_contact_details()
			throws InterruptedException, FileNotFoundException, IOException, ParseException {
		commonPageActions.enterUserDetails("","");

	}


	@Then("the user fills in the Zipcode {string} and City {string} details")
	public void the_user_fills_in_the_Zipcode_and_City_details(String Zipcode,String City)
			throws InterruptedException, FileNotFoundException, IOException, ParseException {
		hslandingPage.enter_Zipcode_and_City_Details(Zipcode,City);

	}

	@When("Clicks on Continue to Payment Information")
	public void clicks_on_continue_to_payment_information()	throws Exception {
		hslandingPage.continueToPayment();
	}


	@When("the user selects the payment method as {string} enters the payment details, and clicks on Complete Secure Checkout")
	public void the_user_selects_the_payment_method_as_enters_the_payment_details_and_clicks_on_complete_secure_checkout(String PaymentType)
			throws InterruptedException {
		sanjosePageActions.choosePaymentType(PaymentType);
	}

	@Then("the user should see an order confirmation message")
	public void the_user_should_see_an_order_confirmation_message() throws Exception {
		hslandingPage.verifyOrderConformedSuccessfully();

	}


	@Then("the user Selects the State as {string}")
	public void the_user_Should_Select_the_Required_State(String value) throws Exception {
			hslandingPage.select_State(value);
	}


	@Then("the user Enters the AccountNumber as {string} and Complete Secure Checkout")
	public void the_user_enters_the_account_number_as_and_complete_secure_checkout(String value) throws Exception {
		hslandingPage.enterAccountDetailsAndCompleteCheckout(value);
	}


	@Then("open Gmail and Validate order number in confirmation email is received")
	public void open_Gmail_and_Verify_Order_number_in_confirmation_email_is_received() throws Exception {

		Verify_Gmail.Validate_Order_Confirmation_Email();
	}

}
