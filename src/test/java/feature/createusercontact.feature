
@tag
Feature: Create new contact feature

  @tag1
  Scenario Outline: creating multiple contact test scenario
    Given user is on index Page
		When title of login page is Free CRM
		Then user should click login button
		Then user enters "<username>" and "<password>" in login page
		Then user clicks on login button
		#Then user check error
		Then user is on homepage
		Then user move to new contact page
		Then user enters contact details "<firstname>" and "<lastname>" and "<position>"
Examples:
|    username          |     password    |  firstname  |  lastname  |  position   |
|gahad51483@cosaxu.com|     Parth@123   |  abc      |  deg     |  Manager    |
|gahad51483@cosaxu.com|   Parth@123     |Tocasdam          |dsfdcz       | Director    |
|gahad51483@cosaxu.com|   Parth@123     |cwdc        |crdvs      |  Team Lead  |
