#Author: aatish.slathia@homeserveusa.com
# https://www.homeserve.com/en-us/

Feature: Homeserve feature file

  Background: User navigate to Homeserve application
    Given User is on "Homeserve" Home page

  Scenario: Complete a sale in HomeServe
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 08512   | header           |
    Then add product to the cart and the user clicks on Proceed to Checkout
#    Then the user selects the Billing Frequency as "Quarterly"
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the payment method as "Credit or Debit Card" enters the payment details, and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received