@hotel-booking1
Feature: Acceptance testing to validate add customer is working. 
  In order to validate that 
  hotel booking page is working
  Doing the Acceptance Testing

  @hotel-booking-positive1
  Scenario Outline: Validate add customer of hotel booking Page
    Given I am on the Home Page "http://hotel-test.equalexperts.io/" of booking Website 
    When I enter "<firstname>" firstname of customer
    And enter  "<surname>" surname of customer
    And enter  "<price>" price of booking
    And select "<deposit>" deposit from selection dropdown 
    And enter "<checkin>" checkin date of booking
    And enter "<checkout>" checkout date of booking
    When click on Save button 
    Then I should see new booking on the booking list.  
    
	
Examples:
| firstname | surname	| price  | deposit | checkin     | checkout      |
| Sevcen	| Sokmen 	| 123	 |  false  | 2019-04-28  | 2019-05-01    |
| John	    | Sun 	    | 123	 |  true   | 2019-04-30  | 2019-05-05    |
