# https://www.slwofa.com/

Feature: SLWOFA feature file

  Background: User navigate to Service Line Warranties application
    Given User is on Home page

  Scenario: Complete a sale in SLWOFA
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 64105   | LandingPage      |
    Then add product to the cart and the user clicks on Proceed to Checkout
    When the user fills in the Contact details
    And Choose and Make the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message

