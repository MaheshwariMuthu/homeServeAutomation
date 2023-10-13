# https://preprod.slwofc.ca/

Feature: SLWOFC feature file

  Background: User navigate to Service Line Warranties application
    Given User is on "slwofc" Home page

  @sale
  @sale-slwofc
  Scenario: Complete Monthly sale in slwofc with PaymetType using Credit or Debit Card
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | K7S 0A1 | LandingPage      |
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Monthly"
    When the user fills in the Contact details
    And the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @sale
  @sale-slwofc
  Scenario: Complete Annually sale in slwofc with PaymetType using Credit or Debit Card
    When the user enters a valid zipcode and clicks on View Plans
      | zipcode | EnterZipLocation |
      | K7S 0A1 | LandingPage      |
    Then add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Annually"
    When the user fills in the Contact details
    And the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received


