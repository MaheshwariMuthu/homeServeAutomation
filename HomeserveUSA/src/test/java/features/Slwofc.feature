# https://preprod.slwofc.ca/

Feature: SLWOFC feature file

  Background: User navigate to Service Line Warranties application
    Given User is on Home page

  Scenario: Complete a sale in SLWOFC
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | K7S 0A1   | LandingPage      |
    Then add product to the cart and the user clicks on Proceed to Checkout
    When the user fills in the Contact details
    And Choose and Make the Payment and clicks on Complete Secure Checkout
     Then the user should see an order confirmation message

