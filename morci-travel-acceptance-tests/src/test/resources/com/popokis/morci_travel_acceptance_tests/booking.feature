Feature: Booking
  How a client should make a booking through morcitravel.com

  Scenario: A client wants to travel from Malaga to Barcelona
    Given A client selects Malaga as departure
    And A client selects Barcelona as arrival
    And A client clicks on search
    Then The client see the results
    And The client selects the result that interest him most
    Then The client is redirected to personal data page
    And The client fill in the form with his personal data
    Then The client clicks on book button
    And The client is redirected to the checkout page
    Then The client fills in the form with his bank details
    And The client clicks on buy button
    Then The client is redirected to the thank you page

