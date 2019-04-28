package com.github.sevcensokmen.eehotelbooking.steps;

import org.testng.Assert;

import com.github.sevcensokmen.eehotelbooking.pages.HotelBookingPage;
import com.github.sevcensokmen.eehotelbooking.utils.SeleniumDriver;

import cucumber.api.java.en.And;
//import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddCustomerSteps {

	HotelBookingPage hotelBookingPage = new HotelBookingPage();

	@Given("^I am on the Home Page \"([^\"]*)\" of booking Website$")
	public void i_am_on_the_Home_Page_of_booking_Website(String webSiteURL) throws Throwable {
		SeleniumDriver.openPage(webSiteURL);

	}

	@When("^I enter \"([^\"]*)\" firstname of customer$")
	public void i_enter_firstname_of_customer(String firstNameValue) throws Throwable {
		SeleniumDriver.getInstance().waitForPageToLoad();
		hotelBookingPage.enterFirstName(firstNameValue);

	}

	@And("^enter  \"([^\"]*)\" surname of customer$")
	public void enter_surname_of_customer(String lastnameValue) throws Throwable {
		hotelBookingPage.enterSurname(lastnameValue);
	}

	@And("^enter  \"([^\"]*)\" price of booking$")
	public void enter_price_of_booking(String totalpriceValue) throws Throwable {
		hotelBookingPage.enterTotalPrice(totalpriceValue);

	}

	@And("^select \"([^\"]*)\" deposit from selection dropdown$")
	public void select_deposit_from_selection_dropdown(String depositValue) throws Throwable {
		hotelBookingPage.enterDeposit(depositValue);

	}

	@And("^enter \"([^\"]*)\" checkin date of booking$")
	public void enter_checkin_date_of_booking(String checkinDate) throws Throwable {
		hotelBookingPage.enterCheckIn(checkinDate);

	}

	@And("^enter \"([^\"]*)\" checkout date of booking$")
	public void enter_checkout_date_of_booking(String checkoutDate) throws Throwable {
		hotelBookingPage.enterCheckOut(checkoutDate);

	}

	@When("^click on Save button$")
	public void click_on_Save_button() throws Throwable {
		hotelBookingPage.clickSaveBtn();
	}

	@Then("^I should see new booking on the booking list\\.$")
	public void i_should_see_new_booking_on_the_booking_list() throws Throwable {
		SeleniumDriver.getInstance().waitForPageToLoad();
		Assert.assertTrue(hotelBookingPage.waitUntilNewBookingPopulatesa());
	}

}
