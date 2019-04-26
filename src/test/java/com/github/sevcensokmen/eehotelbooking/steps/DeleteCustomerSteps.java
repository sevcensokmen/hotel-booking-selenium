package com.github.sevcensokmen.eehotelbooking.steps;

import org.testng.Assert;

import com.github.sevcensokmen.eehotelbooking.pages.HotelBookingPage;
import com.github.sevcensokmen.eehotelbooking.utils.SeleniumDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteCustomerSteps {

	HotelBookingPage  hotelBookingPage= new HotelBookingPage();
	String deleteId;
	
	@Given("^I am on the Home Page \"([^\"]*)\" booking Website$")
	public void i_am_on_the_Home_Page_booking_Website(String webSiteURL) throws Throwable {
		  SeleniumDriver.openPage(webSiteURL);
	}

	@When("^click on last booking delete button$")
	public void click_on_last_booking_delete_button() throws Throwable {
		SeleniumDriver.waitForPageToLoad();
		 hotelBookingPage.deleteCustomer();
	}

	@Then("^I shouldn't see last booking of the list\\.$")
	public void i_shouldn_t_see_last_booking_of_the_list() throws Throwable {
		SeleniumDriver.waitForPageToLoad();
		Assert.assertTrue(hotelBookingPage.deleteCustomerAssert()); 
		SeleniumDriver.waitForPageToLoad();
	}

}
