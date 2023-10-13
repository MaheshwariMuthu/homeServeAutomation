#Author: your.email@your.domain.com
# https://preprod.slwofc.ca/mail/ottawa-french

Feature: Complete an sale for Ottawa


  Background: User navigate to Ottawa page
    Given User is on "ottawa" Home page


  @sale
  @sale-ottawa
  @sale-ottawa1
  Scenario: Complete Monthly sale in Ottawa with PaymetType as Credit or Debit Card
    When the user selects the plan and add to cart add and Proceed To Checkout
    Then the user selects the Billing Frequency as "Monthly"
    Then the user fills up the Contact details with Zipcode as "K7S 0A2" and City as "something"
    Then the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @sale
  @sale-ottawa
  @sale-ottawa2
  Scenario: Complete Quarterly sale in Ottawa with PaymetType as Credit or Debit Card
    When the user selects the plan and add to cart add and Proceed To Checkout
    Then the user selects the Billing Frequency as "Quarterly"
    Then the user fills up the Contact details with Zipcode as "K7S 0A2" and City as "something"
    Then the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received


  @sale
  @sale-ottawa3
  Scenario: Complete Annually sale in Ottawa with PaymetType as Credit or Debit Card
    When the user selects the plan and add to cart add and Proceed To Checkout
    Then the user selects the Billing Frequency as "Annually"
    Then the user fills up the Contact details with Zipcode as "K7S 0A2" and City as "something"
    Then the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received


