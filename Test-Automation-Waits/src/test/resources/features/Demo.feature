Feature: Handle Tables

  @demo
  Scenario: Tables
    Given User navigates to Demo Page
    And User scroll down to Sortable Data Tables
    When User click on Sortable Data Tables
    Then User verifies Example One is displayed
    And User verifies first table
    And User verifies LastNames and FirstNames are in ascending order
    And User prints rows and column numbers
    And User prints second row and third column

  @outline
  Scenario Outline:
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    When User log in "<usernames>" and "<password>"
    Then User verify "<avatar>"
    Examples:
      | usernames                   | password   | avatar   |
      | testerqatester101@gmail.com | 654321\"qW | avatar   |
      | testerqatester@yopmail.com  | 654321\"qW | initials |


  @names
  Scenario Outline: Ability to Login with Parameters and use data tables
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    And User logs in with the parameters "testerqatester101@gmail.com " and "654321\"qW"
    And User clicks on the hamburger menu
    And User clicks on "<leaguesName>" button in Hamburger Menu
    And User verifies "<leaguesName>" in selectionBox
    Examples:
      | leaguesName               |
      | International             |
      | Occupational              |
      | Influencer - Placeholders |

  @dynamicLocators
  Scenario Outline: Ability to login with parameters and use data tables and parameters
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    And User logs in with the parameters "testerqatester101@gmail.com " and "654321\"qW"
    And User clicks on the hamburger menu
    And User clicks on "<leaguesName>" button in Hamburger Menu
    And User verifies "<leaguesName>" in selectionBox
    Examples:
      | leaguesName               |
      | International             |
      | Occupational              |
      | Influencer - Placeholders |


  @verifyTopRankingTiersClicked
  Scenario Outline: Ability to verify top ranking tiers are clicked
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    And User logs in with the parameters "testerqatester101@gmail.com " and "654321\"qW"
    And User clicks on the hamburger menu
    And User clicks on individual item on the menu
    And User clicks on region button
    And User clicks on top ranking button
    When User clicks on "<tiers>"
    Then verify that "<tiers>" are clicked
    Examples:
      | tiers    |
      | diamond  |
      | platinum |
      | gold     |
      | silver   |
      | bronze   |

  @Assignment_7
  Scenario Outline: Ability to login with parameters and validate top rankings tiers
    Given the user navigates to the login page
    And User accepts all cookies
    And User accepts age question
    And User logs in with the parameters "testerqatester101@gmail.com " and "654321\"qW"
    And User clicks on the hamburger menu
    And User clicks on Individuals button in dropdown menu
    And User clicks on Regions button
    And User clicks on TopRankings button
    When User clicks on "<tiers>"
    And User verifies that "<tiers>" is "<selected>"
    Examples:
      | tiers    | selected |
      | diamond  | true     |
      | platinum | true     |
      | gold     | true     |
      | silver   | true     |
      | bronze   | true     |

