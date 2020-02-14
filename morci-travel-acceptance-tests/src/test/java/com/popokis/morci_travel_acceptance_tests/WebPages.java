package com.popokis.morci_travel_acceptance_tests;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum WebPages {
  HOME("/"),
  RESULTS("/results"),
  BOOKING("/booking"),
  CHECKOUT("/checkout"),
  THANKS("/thanks");

  private final String path;

  public String url() {
    return "http://localhost:8080" + path;
  }
}
