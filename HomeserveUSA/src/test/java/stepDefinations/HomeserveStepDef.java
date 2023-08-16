package stepDefinations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CommonPageActions;
import pageObjects.HSLandingPageActions;

import static automationFramework.DataReader.configProperties;
import static automationFramework.DynamicWebElements.*;

public class HomeserveStepDef {
	CommonPageActions commonPageActions = new CommonPageActions();
	HSLandingPageActions hslandingPage = new HSLandingPageActions();

	@Given("User is on Home page")
	public void user_is_on_Home_page() throws InterruptedException, IOException, ParseException {
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
	public void add_product_to_the_cart_and_the_user_clicks_on_proceed_to_checkout() throws InterruptedException {

		hslandingPage.addProductToCartAndProceedToCheckout();
	}

	@Then("the user fills in the Contact details")
	public void the_user_fills_in_the_contact_details()
			throws InterruptedException, FileNotFoundException, IOException, ParseException {
		hslandingPage.entercontactDetails();

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


	@When("the user selects the payment method, enters the payment details, and clicks on Complete Secure Checkout")
	public void the_user_selects_the_payment_method_enters_the_payment_details_and_clicks_on_complete_secure_checkout()
			throws InterruptedException {
		hslandingPage.enterPaymentDetails();
	}

	@Then("the user should see an order confirmation message")
	public void the_user_should_see_an_order_confirmation_message() throws InterruptedException {
		hslandingPage.verifyOrderConformedSuccessfully();

	}


	@Then("the user Selects the State as {string}")
	public void the_user_Should_Select_the_Required_State(String value) throws Exception {
			hslandingPage.select_State(value);
	}


	@Then("the user Enters the AccountNumber as {string} and Complete Secure Checkout")
	public void the_user_enters_the_account_number_as_and_complete_secure_checkout(String value) throws Exception {
		hslandingPage.enterAccountDetails(value);
	}

}
