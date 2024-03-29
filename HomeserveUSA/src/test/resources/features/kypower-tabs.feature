# https://www.reghomeserve.com/sc/mail/kypower-tabs
@Test
Feature: kypower-tabs feature file

  Background: User navigate to Homeserve-kypower-tabs application
    Given User is on "kypower-tabs" Home page

  @sale
  @salekypower
  Scenario: Complete a sale in HomeServe kypower-tabs
    When add product to the cart and the user clicks on Proceed to Checkout
    Then the user fills up the Contact details with Zipcode as "40475" and City as "something"
    Then the user Enters the AccountNumber as "10834561321" and Complete Secure Checkout
    Then the user should see an order confirmation message
    Then open Gmail and Validate order number in confirmation email is received
