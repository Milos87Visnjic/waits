Feature: Qa Training

  @qaAlerts
  Scenario: Ability to handle alerts
    Given User navigates to demoQa page
    When User clicks on first click me button
    Then User handles alerts
    When User clicks on second click me button
    Then User handles timer alerts
    When User clicks on third click me button
    Then User handles confirm alerts
    When User clicks on fourth click me button
    Then User handles prompt alerts
