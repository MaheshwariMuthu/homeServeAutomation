#URL: https://www.reghomeserve.com/sc/mail/buffalowaternipcnew

Feature: Complete an sale for buffalowaternipcnew


	Background: User navigate to buffalowaternipcnew application
		Given User is on "buffalowaternipcnew" Home page


@sale
Scenario: Complete Monthly sale in buffalowaternipcnew with PaymetType as Credit or Debit Card
	Then User select product and proceed to checkout
	Then the user selects the Billing Frequency as "Monthly"
	Then the user fills up the Contact details with Zipcode as "10001" and City as "something"
	And  the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
	Then the user should see an order confirmation message
	Then open Gmail and Validate order number in confirmation email is received


	@sale
	Scenario: Complete Quarterly sale in buffalowaternipcnew with PaymetType as Credit or Debit Card
		Then User select product and proceed to checkout
		Then the user selects the Billing Frequency as "Quarterly"
		Then the user fills up the Contact details with Zipcode as "10001" and City as "something"
		And  the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received


	@sale
	Scenario: Complete Annually sale in buffalowaternipcnew with PaymetType as Credit or Debit Card
		Then User select product and proceed to checkout
		Then the user selects the Billing Frequency as "Annually"
		Then the user fills up the Contact details with Zipcode as "10001" and City as "something"
		And  the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
		Then the user should see an order confirmation message
		Then open Gmail and Validate order number in confirmation email is received

@sale
Scenario: Complete Monthly sale in buffalowaternipcnew with PaymetType as Checking Account
	Then User select product and proceed to checkout
	Then the user selects the Billing Frequency as "Monthly"
	Then the user fills up the Contact details with Zipcode as "10001" and City as "something"
	And  the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
	Then the user should see an order confirmation message
	Then open Gmail and Validate order number in confirmation email is received


@sale
Scenario: Complete Quarterly sale in buffalowaternipcnew with PaymetType as Checking Account
	Then User select product and proceed to checkout
	Then the user selects the Billing Frequency as "Quarterly"
	Then the user fills up the Contact details with Zipcode as "10001" and City as "something"
	And  the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
	Then the user should see an order confirmation message
	Then open Gmail and Validate order number in confirmation email is received


@sale
Scenario: Complete Annually sale in buffalowaternipcnew with PaymetType as Checking Account
	Then User select product and proceed to checkout
	Then the user selects the Billing Frequency as "Annually"
	Then the user fills up the Contact details with Zipcode as "10001" and City as "something"
	And  the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
	Then the user should see an order confirmation message
	Then open Gmail and Validate order number in confirmation email is received
	
	
	
	



  
