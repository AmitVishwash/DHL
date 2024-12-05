package com.dhl.stepdef;

import com.dhl.pageObjects.FreightTransitTimeCalculatorPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FreightTransitTimeCalculatorImpl {

    FreightTransitTimeCalculatorPage freightTransitTimeCalculatorPage = new FreightTransitTimeCalculatorPage(Hooks.driver);


    @Given("the user is on freight transit time calculator application")
    public void user_is_on_freight_transit_time_calculator_application() throws InterruptedException {
        freightTransitTimeCalculatorPage.launchApplication();

    }
    @Then("the user should be able to select origin country {string}")
    @When("the user selects the origin country code {string}")
    public void user_selects_the_origin_country_code(String originCountry) {
        freightTransitTimeCalculatorPage.selectOriginCountry(originCountry);
    }

    @Then("the user should be able to select the destination country {string}")
    @When("the user selects the destination country code {string}")
    public void user_selects_the_destination_country_code(String originCountry) {
        freightTransitTimeCalculatorPage.selectDestinationCountry(originCountry);
    }

    @When("the user provides origin post code {string}")
    public void user_provides_origin_post_code(String originPostCode) {
        freightTransitTimeCalculatorPage.enterOriginPostCode(originPostCode);
    }

    @Then("the user should be able to see the DHL Freight Transit time calculator page")
    public void the_user_should_be_able_to_see_the_dhl_freight_transit_time_calculator_page() {
        Assert.assertTrue(freightTransitTimeCalculatorPage.isFreightTransitTimeCalculatorPageDisplayed());

    }
    @When("the user provides destination post code {string}")
    public void user_provides_destination_post_code(String destinationPostCode) {
        freightTransitTimeCalculatorPage.enterDestinationPostCode(destinationPostCode);

    }
    @Then("User should see the profile name displayed as {string}")
    public void user_should_see_the_profile_name_displayed_as(String profileName) {

    }

    @And("the user clicks on Calculate button")
    public void user_clicks_on_calculate_button() {
        freightTransitTimeCalculatorPage.calculate();
    }

    @When("User Clicks on Sign-in link on Home Page of Ebay Application")
    public void userClicksOnSignInLinkOnHomePageOfEbayApplication() {

    }


    @Then("Create account button should be disabled")
    public void createAccountButtonShouldBeDisabled() {
        // Assert.assertFalse("Expected- Create account button should be disabled but the Actual state is: "+ebayUserRegistrationPage.getCreateAccountButtonStatus(),ebayUserRegistrationPage.getCreateAccountButtonStatus());
    }


    @And("the user selects pick up date")
    public void user_selects_pick_up_date() {
        freightTransitTimeCalculatorPage.selectPickUpDate();

    }

    @Then("the user should be able to see the transit time result")
    public void user_should_be_able_to_see_the_transit_time_result() {
        freightTransitTimeCalculatorPage.validateTransitTimeResult();
    }

    @Then("the user should be able to see the post code error message")
    public void user_should_be_able_to_see_the_post_code_error_message() {
        freightTransitTimeCalculatorPage.isOriginPostCodeErrorDisplayed();
        freightTransitTimeCalculatorPage.isDestinationPostCodeErrorDisplayed();
    }
}
