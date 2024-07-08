Feature: Login

  @loginPositive
  Scenario: Successful login
    Given User is on HomePage
    When User clicks on User icon
    Then User verifies Login form
    When User enters valid data
    And User clicks on Anmelden button
    Then User verivies user name status
    When User clicks on User icon
    Then User verifies user name

  @loginNegativeWithDataTable
  Scenario Outline: Login with valid data
    Given User is on HomePage
    When User clicks on User icon
    Then User verifies Login form
    When User enters invalid data
      | email   | password   |
      | <email> | <password> |
    And User clicks on Anmelden button
    Then User verivies user name new status
    Examples:
      | email         | password    |
      | bob@gmail.com | Merkel30001 |
      | bob@gmail.com | merkel3000! |
      | bob@gmail.com | MERKEL3000! |
      | bob@gmail.com | Merkelllll! |

  @loginNegativeWithProperties
  Scenario: Successful login
    Given User is on HomePage
    When User clicks on User icon
    Then User verifies Login form
    When User enters invalid password from Property
    And User clicks on Anmelden button
    Then User verivies user name new status
    When User enters invalid password from Property1
    And User clicks on Anmelden button
    Then User verivies user name new status
    When User enters invalid password from Property2
    And User clicks on Anmelden button
    Then User verivies user name new status
    When User enters invalid password from Property3
    And User clicks on Anmelden button
    Then User verivies user name new status
