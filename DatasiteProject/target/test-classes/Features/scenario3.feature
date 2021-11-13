#>Open app url.
#
#>Click on "TERMS OF USE" at the bottom of page.
#
#>Validate if it opens a page with url "https://www.datasite.com/us/en/legal/terms-of-use.html"
#
#>Validate if today's date is displayed next to "Effective as of".
#
#>Click on Language drop on top right corner.
#
#>Verify drop down has Français, Deutsch, 中文, 日本語, Español and Italiano.
#
#Write this scenario under src/featureFiles/scenario3.feature
#
#All the step definitions should be added in src/stepDefinitions/stepDefinitions.java
#
#**App url**: https://americas.datasite.com/
#
#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
#Feature: Title of your feature
  #I want to use this template for my feature file
#
  #@tag1
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes
#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
