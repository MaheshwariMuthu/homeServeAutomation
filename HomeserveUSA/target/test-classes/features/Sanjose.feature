#URL: https://www.reghomeserve.com/sc/mail/sanjose

Feature: Complete an sale for sanjose


  Background: User navigate to Sanjose page
    Given User is on "sanjose" Home page

  @sale-sanjose
  @sale-sanjose1
  Scenario: Complete Monthly sale in sanjose with PaymetType as Credit or Debit Card
    When User select product and proceed to checkout
    Then the user fills up the Contact details with Zipcode as "94088" and City as "something"
    Then the user selects the Billing Frequency as "Monthly"
    Then the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @sale-sanjose
  @sale-sanjose2
  Scenario: Complete Quarterly sale in sanjose with PaymetType as Credit or Debit Card
    When User select product and proceed to checkout
    Then the user fills up the Contact details with Zipcode as "94088" and City as "something"
    Then the user selects the Billing Frequency as "Quarterly"
    Then the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @sale-sanjose3
  Scenario: Complete Annually sale in sanjose with PaymetType as Credit or Debit Card
    When User select product and proceed to checkout
    Then the user fills up the Contact details with Zipcode as "94088" and City as "something"
    Then the user selects the Billing Frequency as "Annually"
    Then the user selects the PaymentType as "Credit or Debit Card" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @sale-sanjose4
  Scenario: Complete Monthly sale in sanjose with PaymetType as Checking Account
    When User select product and proceed to checkout
    Then the user fills up the Contact details with Zipcode as "94088" and City as "something"
    Then the user selects the Billing Frequency as "Monthly"
    Then the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received

  @sale-sanjose5
  Scenario: Complete Quarterly sale in sanjose with PaymetType as Checking Account
    When User select product and proceed to checkout
    Then the user fills up the Contact details with Zipcode as "94088" and City as "something"
    Then the user selects the Billing Frequency as "Quarterly"
    Then the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received


  @sale-sanjose6
  Scenario: Complete Annually sale in sanjose with PaymetType as Checking Account
    When User select product and proceed to checkout
    Then the user fills up the Contact details with Zipcode as "94088" and City as "something"
    Then the user selects the Billing Frequency as "Annually"
    Then the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received