#Author: aatish.slathia@homeserveusa.com
# https://www.homeserve.com/en-us/

Feature: Homeserve feature file

  Background: User navigate to Homeserve application
    Given User is on Home page

  Scenario: Complete a sale in HomeServe
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 08512   | header           |
    Then add product to the cart and the user clicks on Proceed to Checkout
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the payment method, enters the payment details, and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
