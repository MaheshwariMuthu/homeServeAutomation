# https://www.reghomeserve.com/sc/mail/aepindianamichigan

Feature: aepindianamichigan feature file

  Background: User navigate to Homeserve-aepindianamichigan application
    Given User is on "aepindianamichigan" Home page

@saleaep
  Scenario: Complete a sale in HomeServe aepindianamichigan-Michigan
    When the user Selects the State as "Michigan"
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills up the Contact details with Zipcode as "48201" and City as "Detroit"
    Then the user Enters the AccountNumber as "10834561321" and Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received


  Scenario: Complete a sale in HomeServe aepindianamichigan-Indiana
    When the user Selects the State as "Indiana"
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills up the Contact details with Zipcode as "46001" and City as "something"
    Then the user Enters the AccountNumber as "10834561321" and Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

