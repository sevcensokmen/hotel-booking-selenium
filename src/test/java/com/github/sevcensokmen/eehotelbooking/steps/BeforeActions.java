package com.github.sevcensokmen.eehotelbooking.steps;

import com.cucumber.listener.ExtentCucumberFormatter;
import com.github.sevcensokmen.eehotelbooking.utils.SeleniumDriver;

import cucumber.api.java.Before;

public class BeforeActions {

	@Before
	public static void setUp() {
		ExtentCucumberFormatter.initiateExtentCucumberFormatter();
		SeleniumDriver.setUpDriver();
	}
}
