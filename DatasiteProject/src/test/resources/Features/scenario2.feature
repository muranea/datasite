# Author: Ander Murane
# Date 11/13/21
# Description: Home coding challenge

@smoketest
Feature: forgot password flow
	
  Scenario: Email validation: submitting password reset form without email 
    Given user opens the app url and lands arrives on the login page
    When user clicks forgot password link 
    And submits without a valid email address
    Then the error: "Error: Email address required"