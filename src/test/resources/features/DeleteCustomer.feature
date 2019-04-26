@hotel-booking
Feature: Acceptance testing to validate delete customer is working. 
  In order to validate that 
  hotel booking page is working
  Doing the Acceptance Testing

  @hotel-booking-positive
  Scenario: Validate delete customer of hotel booking Page
    Given I am on the Home Page "http://hotel-test.equalexperts.io/" booking Website
    When click on last booking delete button
    Then I shouldn't see last booking of the list.