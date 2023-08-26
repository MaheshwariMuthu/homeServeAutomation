#URL: https://www.reghomeserve.com/sc/mail/wvwachoice

Feature: Complete an sale for wvwachoice


	Background: User navigate to wvwachoice application
		Given User is on "wvwachoice" Home page

@sale
Scenario: Complete Monthly sale in wvwachoice with PaymetType as Checking Account
	Then add product to the cart and the user clicks on Proceed to Checkout
	Then the user selects the Billing Frequency as "Monthly"
	Then the user fills up the Contact details with Zipcode as "22209" and City as "something"
	Then the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
	Then the user should see an order confirmation message
	Then open Gmail and Validate order number in confirmation email is received


@sale
Scenario: Complete Monthly sale in wvwachoice with PaymetType as Checking Account
	Then add product to the cart and the user clicks on Proceed to Checkout
	Then the user selects the Billing Frequency as "Quarterly"
	Then the user fills up the Contact details with Zipcode as "22209" and City as "something"
	Then the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
	Then the user should see an order confirmation message
	Then open Gmail and Validate order number in confirmation email is received


@sale
Scenario: Complete Monthly sale in wvwachoice with PaymetType as Checking Account
	Then add product to the cart and the user clicks on Proceed to Checkout
	Then the user selects the Billing Frequency as "Annually"
	Then the user fills up the Contact details with Zipcode as "22209" and City as "something"
	Then the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
	Then the user should see an order confirmation message
	Then open Gmail and Validate order number in confirmation email is received
	
	
	



  
