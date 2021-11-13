# Author: Ander Murane
# Date 11/21
# Description: Home coding challenge

@smoketest
Feature: authentication error validation
	
  Scenario: verify error messaging when invalid credentials are entered
    Given user opens the app url and lands arrives on the login page
    When user enters invalid credentials 
    And submits the form by clicking the login button
    Then credentials error: "We didn't recognize the username or password you entered. Please try again."
    