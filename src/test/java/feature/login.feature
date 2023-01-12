Feature: FreeCRM Login Page feature


@SmokeTest @RegressionTest
  Scenario Outline: FreeCRM Login Page test scenario
    Given User is alrady on login page
    When the title of the login page is Cogmento CRM
    Then user enters "<username>" and "<password>"
		Then user clicks on the login button
		Then user check username
		Examples:
|    username          |     password    |
|gahad51483@cosaxu.com|     Parth@123   |

		
