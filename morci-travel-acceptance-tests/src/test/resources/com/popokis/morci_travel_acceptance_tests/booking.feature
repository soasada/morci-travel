Feature: Booking
  How a client should make a booking through morci-travel.com

  Scenario: A client wants to travel to Barcelona from Malaga
    Given The client does a search to travel from Malaga to Barcelona
    And The client selects the option that better fits his needs
    When The client fill in the form with his personal data
    And is redirected to the checkout page and fill in the data too
    Then is redirected to the thank you page

