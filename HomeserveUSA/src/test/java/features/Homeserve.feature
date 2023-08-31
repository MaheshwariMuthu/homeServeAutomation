#Author: aatish.slathia@homeserveusa.com
# https://www.homeserve.com/en-us/

Feature: Homeserve feature file

  Background: User navigate to Homeserve application
    Given User is on "Homeserve" Home page

  Scenario: Complete Monthly sale in Homeserve with PaymetType as Credit or Debit Card
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 08512   | header           |
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Monthly"
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received


  Scenario: Complete Quarterly sale in Homeserve with PaymetType as Credit or Debit Card
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 08512   | header           |
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Quarterly"
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received


  Scenario: Complete Annually sale in Homeserve with PaymetType as Credit or Debit Card
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 08512   | header           |
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Annually"
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received


  Scenario: Complete a Monthly sale in HomeServe with payment type as Checking Account
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 08512   | header           |
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Monthly"
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  Scenario: Complete a Quarterly sale in HomeServe with payment type as Checking Account
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 08512   | header           |
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Quarterly"
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  Scenario: Complete a Annually sale in HomeServe with payment type as Checking Account
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 08512   | header           |
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Annually"
    When the user fills in the Contact details
    When Clicks on Continue to Payment Information
    And the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received
