# https://preprod.slwofa.com/mail/lasanitation

Feature: HomeServe-lasanitation feature file

  Background: User navigate to lasanitation application
    Given User is on "lasanitation" Home page

  Scenario: Complete a Monthly sale in HomeServe-lasanitation with PaymentType as Credit or Debit Card
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills up the Contact details with Zipcode as "90001" and City as "something"
    Then the user selects the Billing Frequency as "Monthly"
    And the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received


  Scenario: Complete a Quarterly sale in HomeServe-lasanitation with PaymentType as Credit or Debit Card
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills up the Contact details with Zipcode as "90001" and City as "something"
    Then the user selects the Billing Frequency as "Quarterly"
    And the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received


  Scenario: Complete a Annually sale in HomeServe-lasanitation with PaymentType as Credit or Debit Card
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills up the Contact details with Zipcode as "90001" and City as "something"
    Then the user selects the Billing Frequency as "Annually"
    And the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received


  Scenario: Complete a Monthly sale in HomeServe-lasanitation with PaymentType as Checking Account
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills up the Contact details with Zipcode as "90001" and City as "something"
    Then the user selects the Billing Frequency as "Monthly"
    And the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received


  Scenario: Complete a Quarterly sale in HomeServe-lasanitation with PaymentType as Checking Account
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills up the Contact details with Zipcode as "90001" and City as "something"
    Then the user selects the Billing Frequency as "Quarterly"
    And the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received


  Scenario: Complete a Quarterly sale in HomeServe-lasanitation with PaymentType as Checking Account
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills up the Contact details with Zipcode as "90001" and City as "something"
    Then the user selects the Billing Frequency as "Quarterly"
    And the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

