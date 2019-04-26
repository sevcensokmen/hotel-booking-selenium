package com.github.sevcensokmen.eehotelbooking.steps;

import com.github.sevcensokmen.eehotelbooking.utils.SeleniumDriver;

import cucumber.api.java.Before;


public class BeforeActions  {

	@Before
    public static void setUp() {
		//ExtentCucumberFormatter.initiateExtentCucumberFormatter();
    	System.out.println("Before");
       SeleniumDriver.setUpDriver();
    }
}
