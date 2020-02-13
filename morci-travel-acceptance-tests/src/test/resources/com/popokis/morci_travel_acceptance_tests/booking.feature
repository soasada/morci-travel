Feature: Booking
  How a client should make a booking through morcitravel.com

  Scenario: A client wants to travel from Malaga to Barcelona
    Given The client makes a search to travel from Malaga to Barcelona
    And The client chooses one of the options that interest him
    When The client fill in the form with his personal data
    And is redirected to the checkout page
    Then fills in the form with his bank details
    And is redirected to the thank you page
    Then The client receives an email

