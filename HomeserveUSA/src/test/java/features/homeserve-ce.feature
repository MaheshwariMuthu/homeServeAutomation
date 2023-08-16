# https://www.reghomeserve.com/sc/mail/homeserve-ce

Feature: HomeServe-CE feature file

  Background: User navigate to Service Line Warranties application
    Given User is on Home page

  Scenario: Complete a sale in HomeServe-CE
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills up the Contact details with Zipcode as "22209" and City as "something"
    And Choose and Make the Payment and clicks on Complete Secure Checkout
    Then the user should see an order confirmation message

