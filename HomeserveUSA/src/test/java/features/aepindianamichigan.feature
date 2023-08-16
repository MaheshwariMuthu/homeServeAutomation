# https://www.reghomeserve.com/sc/mail/aepindianamichigan

Feature: aepindianamichigan feature file

  Background: User navigate to Homeserve-aepindianamichigan application
    Given User is on Home page

  Scenario: Complete a sale in HomeServe aepindianamichigan
    When the user Selects the State as "Indiana"
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills up the Contact details with Zipcode as "46001" and City as "something"
    Then the user Enters the AccountNumber as "10834561321" and Complete Secure Checkout
    Then the user should see an order confirmation message
