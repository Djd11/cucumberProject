Feature: - Cucumber Tag
  Scenario Outline: - Login functionality for rediffmail site

    Given User navigates to rediff
    When I enter Username as "<username>" and Password as "<password>"
    Then Login should happen sucessfully
    Examples:
      | username  | password |
      | mango  | Passw0rd123 |
      | pickle  | Passw0rd124 |
