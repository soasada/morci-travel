package com.popokis.morci_travel_acceptance_tests.steps;

import com.popokis.morci_travel_acceptance_tests.common.ChromeTestRule;
import io.cucumber.java.en.Given;
import org.junit.Rule;

public class BookingSteps {

  @Rule
  public ChromeTestRule chromeTestRule = new ChromeTestRule();

  @Given("A client selects {string} as departure")
  public void a_client_selects_as_departure(String departure) {
    chromeTestRule.getChrome().get("https://google.es");
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }
}
