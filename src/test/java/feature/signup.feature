
@tag
Feature: Free crm signup page feature

  @tag1
  Scenario: Signup page test scenario
    Given User is already on a signup page
    When title of the page is Cogmento CRM
    Then user check error
    Then user enters details
    And user clicks on signup button
