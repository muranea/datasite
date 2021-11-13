# Author: Ander Murane
# Date 11/13/21
# Description: Home coding challenge

@smoketest
Feature: Terms of use and supported languages
	  
   Scenario Outline: verify languages
    Given user opens the app url and arrives on the login page
    And user vists Terms of Use page
    And verifies supported language <lang>
    Examples:
    | lang |
    | Français |
    | Deutsch  |
    | 中文 | 
    | 日本語 |
    | Español  |
    | Italiano |
  
  # Fails because date on website is not updated 
  Scenario: verify terms of use date
    Given user opens the app url and lands arrives on the login page
    And user vists Terms of Use page
    Then verifies the date is correct
 