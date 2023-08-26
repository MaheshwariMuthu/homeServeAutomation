package stepDefinations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import org.json.simple.parser.ParseException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CommonPageActions;
import pageObjects.HSLandingPageActions;
import pageObjects.SLWALandingPageActions;

public class SLWAStepDef {
	CommonPageActions commonPageActions = new CommonPageActions();

	SLWALandingPageActions slwaLandingPageActions = new SLWALandingPageActions();


	@Then("the user selects the PaymentType as {string} Makes the Payment and clicks on Complete Secure Checkout")
	public void the_user_selects_the_payment_type_as_makes_the_payment_and_clicks_on_complete_secure_checkout(String PaymentType) throws Exception {

		slwaLandingPageActions.chooseAndMakePayementType(PaymentType);

	}
}