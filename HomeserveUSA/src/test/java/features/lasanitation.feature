# https://preprod.slwofa.com/mail/lasanitation

Feature: HomeServe-lasanitation feature file

  Background: User navigate to lasanitation application
    Given User is on "lasanitation" Home page

  Scenario: Complete a sale in HomeServe-lasanitation
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills up the Contact details with Zipcode as "90001" and City as "something"
    And the user selects the PaymentType as "Checking Account" Makes the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message

