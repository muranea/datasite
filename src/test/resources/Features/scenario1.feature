# Author: Ander Murane
# Date 11/13/21
# Description: Home coding challenge

@smoketest
Feature: authentication error validation
	
  Scenario: verify error messaging when invalid credentials are entered
    Given user opens the app url and arrives on the login page
    When user enters invalid username "bad@wrong.com" and password "password" 
    And submits the form by clicking the login button
    Then the error: "recognize the username or password you entered. Please try again."
    