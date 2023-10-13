# https://www.slwofa.com/

Feature: SLWOFA feature file

  Background: User navigate to Service Line Warranties application
    Given User is on "slwofa" Home page

  @sale
  @sale-slwofa
  @sale-slwofa1
  Scenario: Complete Monthly sale in slwofa with PaymetType as Credit or Debit Card
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 64105   | LandingPage      |
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Monthly"
    When the user fills in the Contact details
    And the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @sale
  @sale-slwofa
  @sale-slwofa2
  Scenario: Complete Quarterly sale in slwofa with PaymetType as Credit or Debit Card
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 64105   | LandingPage      |
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Quarterly"
    When the user fills in the Contact details
    And the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @sale
  @sale-slwofa
  Scenario: Complete Annually sale in slwofa with PaymetType as Credit or Debit Card
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 64105   | LandingPage      |
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Annually"
    When the user fills in the Contact details
    And the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @sale
  @sale-slwofa
  Scenario: Complete Monthly sale in slwofa with PaymetType as Checking Account
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 64105   | LandingPage      |
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Monthly"
    When the user fills in the Contact details
    And the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @sale
  @sale-slwofa
  Scenario: Complete Quarterly sale in slwofa with PaymetType as Checking Account
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 64105   | LandingPage      |
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Quarterly"
    When the user fills in the Contact details
    And the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @sale
  @sale-slwofa
  Scenario: Complete Annually sale in slwofa with PaymetType as Checking Account
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | 64105   | LandingPage      |
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Annually"
    When the user fills in the Contact details
    And the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received
