#URL: https://www.reghomeserve.com/sc/mail/wvwachoice

Feature: Complete an sale for wvwachoice


	Background: User navigate to wvwachoice application
		Given User is on Home page

@sale
Scenario: Complete an sale for wvwachoice
	Then add product to the cart and the user clicks on Proceed to Checkout
	Then the user fills up the Contact details with Zipcode as "22209" and City as "something"
	And Choose and Make the Payment and clicks on Complete Secure Checkout
	Then the user should see an order confirmation message

	
	
	
	
	
	



  
