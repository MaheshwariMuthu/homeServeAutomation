#URL: https://www.reghomeserve.com/sc/mail/firstenergy-fundle

Feature: Complete an sale for firstenergy-fundle
 

Background: User navigate to Homeserve-firstenergy-fundle page
	Given User is on "firstenergy-fundle" Home page

@sale
Scenario: Complete an sale for firstenergy-fundle
	Then add product to the cart and the user clicks on Proceed to Checkout
	Then the user fills up the Contact details with Zipcode as "22209" and City as "something"
	And the user Enters the AccountNumber as "10834561321" and Complete Secure Checkout
	Then the user should see an order confirmation message
	Then open Gmail and Validate order number in confirmation email is received

	
	
	
	
	
	



  
