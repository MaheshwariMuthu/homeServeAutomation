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


	@When("Choose and Make the Payment and clicks on Complete Secure Checkout")
	public void clicks_on_continue_to_payment_information()	throws Exception {

		slwaLandingPageActions.chooseAndMakePayementType();

	}
}