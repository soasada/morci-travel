package com.popokis.morci_travel_acceptance_tests.steps;

import com.popokis.morci_travel_acceptance_tests.WebComponents;
import com.popokis.morci_travel_acceptance_tests.WebPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import static com.popokis.morci_travel_acceptance_tests.RunCucumberTest.chromeTestRule;

public class BookingSteps {

  @Given("A client selects {string} as departure")
  public void a_client_selects_as_departure(String departure) {
    chromeTestRule.getChrome().get(WebPages.HOME.url());
    WebElement departureSearch = chromeTestRule.getChrome().findElementByClassName(WebComponents.departureSearch());
    departureSearch.sendKeys(departure);
  }

  @Given("A client selects {string} as arrival")
  public void a_client_selects_as_arrival(String arrival) {
    chromeTestRule.getChrome().get("https://google.es");
  }

  @Given("A client selects the desired dates")
  public void a_client_selects_the_desired_dates() {
    chromeTestRule.getChrome().get("https://google.es");
  }

  @Given("A client clicks on search")
  public void a_client_clicks_on_search() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @Then("The client see the results")
  public void the_client_see_the_results() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @Then("The client selects the result that interest him most")
  public void the_client_selects_the_result_that_interest_him_most() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @Then("The client is redirected to personal data page")
  public void the_client_is_redirected_to_personal_data_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @Then("The client fill in the form with his personal data")
  public void the_client_fill_in_the_form_with_his_personal_data() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @Then("The client clicks on book button")
  public void the_client_clicks_on_book_button() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @Then("The client is redirected to the checkout page")
  public void the_client_is_redirected_to_the_checkout_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @Then("The client fills in the form with his bank details")
  public void the_client_fills_in_the_form_with_his_bank_details() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @Then("The client clicks on buy button")
  public void the_client_clicks_on_buy_button() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }

  @Then("The client is redirected to the thank you page")
  public void the_client_is_redirected_to_the_thank_you_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
  }
}
