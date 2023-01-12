
Feature: deal data creation

  Scenario: create a new deal scenario
    Given user is on home Page
		When title of home page is Free CRM
		Then user will click login button
		Then user enters username and password to login
|gahad51483@cosaxu.com|     Parth@123   |
		Then user clicks on login button to login
		Then user is on user homepage
		Then user move to new deal page
		Then user enters deal details
|test|10000|40|
|deal|520|41|
