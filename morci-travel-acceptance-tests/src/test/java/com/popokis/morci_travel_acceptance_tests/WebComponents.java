package com.popokis.morci_travel_acceptance_tests;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebComponents {

  public static String departureSearch() {
    return "mt-search-departure";
  }

  public static String arrivalSearch() {
    return "mt-search-arrival";
  }

  public static String departureDateSearch() {
    return "mt-search-departure-date";
  }

  public static String returnDateSearch() {
    return "mt-search-return-date";
  }
}
