# https://www.reghomeserve.com/sc/mail/homeserve-ce

Feature: HomeServe-CE feature file

  Background: User navigate to Service Line Warranties application
    Given User is on "HomeServe-CE" Home page

  @sale
  @saleHSCE
  Scenario: Complete Monthly sale in HomeServe-CE with PaymetType as Checking Account
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Monthly"
    Then the user fills up the Contact details with Zipcode as "22209" and City as "something"
    And the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message

  @sale
  @saleHSCE
  Scenario: Complete Quarterly sale in HomeServe-CE with PaymetType as Checking Account
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Quarterly"
    Then the user fills up the Contact details with Zipcode as "22209" and City as "something"
    And the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message

  @sale
  @saleHSCE
  Scenario: Complete Annually sale in HomeServe-CE with PaymetType as Checking Account
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user selects the Billing Frequency as "Annually"
    Then the user fills up the Contact details with Zipcode as "22209" and City as "something"
    And the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message

