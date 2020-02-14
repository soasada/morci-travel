package com.popokis.morci_travel_acceptance_tests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WebPages {
  HOME("/"),
  RESULTS("/results"),
  BOOKING("/booking"),
  CHECKOUT("/checkout"),
  THANKS("/thanks");

  private final String path;
}
