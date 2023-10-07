package stepDefinations;

import io.cucumber.java.en.When;
import pageActions.CommonPageActions;
import pageActions.OttawaPageAction;

public class OttawaStepDef {
	CommonPageActions commonPageActions = new CommonPageActions();

	OttawaPageAction ottawaPageAction = new OttawaPageAction();


	@When("the user selects the plan and add to cart add and Proceed To Checkout")
	public void the_user_selects_the_plan_add_to_cart_and_Proceed_To_Checkout()	throws Exception {
//		ottawaPageAction.changeTheLanguageIntoEnglish();
		ottawaPageAction.selectThePlanAndAddToCartAndProceedToCheckout();
	}



}